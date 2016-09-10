package pl.writeonly.scalar.glue.apps

import org.eclipse.swt.widgets.Text
import com.typesafe.scalalogging.slf4j.StrictLogging
import pl.writeonly.xscalawt.XScalarWT._
import pl.writeonly.scalar.view.MainWindow
import pl.writeonly.scalar.glue.mods.AppModule



object MainLoop extends App with StrictLogging {
//  val app = AppContext
  val app = AppModule
  app.main(args)
  val loop = app.mainLoop
  loop.run
}

@org.springframework.stereotype.Controller
class MainLoop extends MainWindow {
  string = "MainLoop"
  implicit def textToString(text: Text) = text.getText
  override def run {
    val window = apply(shellDefault)
    borderLayoutScalars()(window)
    super.run
    mainLoop(window)
  }

}

