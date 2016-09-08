package pl.writeonly.scalar.view

import javax.annotation.Resource

import org.eclipse.swt.widgets.Composite
import com.typesafe.scalalogging.slf4j.StrictLogging

import pl.writeonly.babel.remote.JmsDestination

trait Face extends StrictLogging {
  @Resource var jmsDestination: JmsDestination = _
  def apply(): Composite => Composite
  def runtime(e: RuntimeException) {
    logger debug "runtime"
    logger error (e.getMessage, e);
    logger debug "runtime jmsDestination " + jmsDestination
    jmsDestination ! e.getMessage
  }
}