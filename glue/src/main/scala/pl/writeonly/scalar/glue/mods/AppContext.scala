package pl.writeonly.scalar.glue.mods

import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import pl.writeonly.scalar.glue.apps.AppWindow
import pl.writeonly.scalar.glue.apps.MainLoop
import com.typesafe.scalalogging.slf4j.StrictLogging


object AppContext extends App with StrictLogging {
  val xml = "applicationContext.xml"
  val context: ApplicationContext = new ClassPathXmlApplicationContext(xml)
  def appWindow = context.getBean("appWindow").asInstanceOf[AppWindow]
  def mainLoop = context.getBean("mainLoop").asInstanceOf[MainLoop]
}



