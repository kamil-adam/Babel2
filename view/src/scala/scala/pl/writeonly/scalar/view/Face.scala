package pl.writeonly.scalar.view
import javax.annotation.Resource

trait Face extends Logging {
  @Resource var jmsDestination: JmsDestination = _
  def apply(): Composite => Composite
  def runtime(e: RuntimeException) {
    logger debug "runtime"
    logger error (e.getMessage, e);
    logger debug "runtime jmsDestination " + jmsDestination
    jmsDestination ! e.getMessage
  }
}