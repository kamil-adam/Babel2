package pl.writeonly.scalar.view
import javax.annotation.Resource
import com.typesafe.scalalogging.slf4j.StrictLogging

import javax.annotation.Resource
import javax.jms.BytesMessage
import javax.jms.MapMessage
import javax.jms.Message
import javax.jms.MessageListener
import javax.jms.ObjectMessage
import javax.jms.StreamMessage
import javax.jms.TextMessage

import pl.writeonly.babel.entities.Relation
import pl.writeonly.scalar.view.faces.RelationFace
import pl.writeonly.scala.util.ToBoolean

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