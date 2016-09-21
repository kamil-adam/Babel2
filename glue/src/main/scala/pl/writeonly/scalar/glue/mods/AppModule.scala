package pl.writeonly.scalar.glue.mods

import com.google.inject.AbstractModule
import pl.writeonly.scalar.glue.apps._
import com.typesafe.scalalogging.slf4j.StrictLogging
import com.google.inject.Guice
import pl.writeonly.scalar.view.faces.ConfigurationFace
import pl.writeonly.scalar.view.faces.BrowserFace
import pl.writeonly.scalar.view.faces.PlayFace
import pl.writeonly.scalar.view.faces.LangFace
import pl.writeonly.scalar.view.faces.RecordFace
import pl.writeonly.scalar.view.faces.TranslateFace
import pl.writeonly.scalar.view.faces.UseFace
import pl.writeonly.scalar.view.faces.RelationFace
import pl.writeonly.scalar.view.faces.WordFace
import pl.writeonly.babel.daos.DaoCrud
import pl.writeonly.babel.daos.DaoJdo

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
    bind(classOf[BrowserFace])
    bind(classOf[ConfigurationFace])
    bind(classOf[LangFace])
    bind(classOf[PlayFace])
    bind(classOf[RecordFace])
    bind(classOf[RelationFace])
    bind(classOf[TranslateFace])
    bind(classOf[UseFace])
    bind(classOf[WordFace])
    
    bind(classOf[DaoCrud]).to(classOf[DaoJdo])
  }
}
