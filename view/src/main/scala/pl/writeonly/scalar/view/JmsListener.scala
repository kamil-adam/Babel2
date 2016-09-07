package pl.writeonly.scalar.view
import javax.annotation.Resource

@org.springframework.stereotype.Controller
class JmsListener extends MessageListener with StrictLogging with ToBoolean {

  @Resource var relationFace: RelationFace = _
  var textResiver: TextMessage => Unit = _
  
  logger debug "init"

  override def onMessage(message: Message) {
    message match {
      case bytes: BytesMessage   => logger info "bytes => " + bytes
      case map: MapMessage       => logger info "map => " + map
      case stream: StreamMessage => logger info "stream => " + stream
      case text: TextMessage     => if (textResiver) textResiver(text) else logger error "onMessage text => " + text
      case serializable: ObjectMessage => {
        logger debug "onMessage serializable => " + serializable
        serializable.getObject() match {
          //case ralations: List[Relation] => relationFace.viewer.add(ralations); logger debug "ralations => " + ralations
          case relations: List[Relation] => relationFace.addAll(relations)
        }
      }
    }

    message.acknowledge ();
  }

}