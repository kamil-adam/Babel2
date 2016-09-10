package pl.writeonly.scalar.glue.mods

import com.google.inject.AbstractModule
import pl.writeonly.scalar.glue.apps._
import com.typesafe.scalalogging.slf4j.StrictLogging
import com.google.inject.Guice

object AppModule extends App with StrictLogging {
  val injector = Guice.createInjector(new AppModule());
  def appWindow = injector.getInstance(classOf[AppWindow])
  def mainLoop = injector.getInstance(classOf[MainLoop])
}

class AppModule extends AbstractModule {
  @Override 
  protected def configure() {
    bind(classOf[AppWindow])
    bind(classOf[MainLoop])
  }
}
