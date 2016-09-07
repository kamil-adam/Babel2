package pl.writeonly.scalar.glue.apps

import org.eclipse.swt.widgets.Text

//import com.weiglewilczek.slf4s.Logging

import pl.writeonly.xscalawt.XScalarWT._

object MainLoop extends App with StrictLogging {

  val context = AppContext
  context.main(args)
  context.mainLoop.run
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

