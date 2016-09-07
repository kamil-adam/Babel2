package pl.writeonly.scalar.view

import org.springframework.jms.core.JmsTemplate

import javax.annotation.Resource

import com.typesafe.scalalogging.slf4j.StrictLogging
import javax.annotation.Resource
import javax.jms.Connection
import javax.jms.Destination
import javax.jms.MessageConsumer
import javax.jms.Session
import pl.writeonly.scala.util.ToBoolean
import pl.writeonly.scalar.view.JmsListener

@org.springframework.stereotype.Controller
class JmsConsumer extends StrictLogging with ToBoolean {
  @Resource var listener: JmsListener = _
  @Resource(name = "consumerJmsTemplate") var template: JmsTemplate = _
  @Resource var destination: Destination = _
  var connection: Connection = _
  var session: Session = _
  var consumer: MessageConsumer = _
  var myId = "foo"

  def start() {
    //logger debug "start"
    val selector = "next = '" + myId + "'";
    connection = template.getConnectionFactory().createConnection ();
    synchronized { if (connection.getClientID ()) connection.setClientID (myId) }
    connection.start ();
    session = connection.createSession (true, Session.CLIENT_ACKNOWLEDGE);
    consumer = session.createConsumer (destination, selector, false);
    consumer.setMessageListener (listener);
  }

  def stop() {
    if (consumer) consumer.close ();
    if (session) session.close ();
    if (connection) connection.close ();
  }
}