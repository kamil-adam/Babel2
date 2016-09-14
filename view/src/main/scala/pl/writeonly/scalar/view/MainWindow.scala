package pl.writeonly.scalar.view

import org.eclipse.swt.widgets.Shell

import com.typesafe.scalalogging.slf4j.StrictLogging

import javax.inject.Inject
import pl.writeonly.scalar.view.faces.BrowserFace
import pl.writeonly.scalar.view.faces.ConfigurationFace
import pl.writeonly.scalar.view.faces.LangFace
import pl.writeonly.scalar.view.faces.PlayFace
import pl.writeonly.scalar.view.faces.RecordFace
import pl.writeonly.scalar.view.faces.RelationFace
import pl.writeonly.scalar.view.faces.TranslateFace
import pl.writeonly.scalar.view.faces.UseFace
import pl.writeonly.scalar.view.faces.WordFace
import pl.writeonly.xscalawt.XScalaWT.string2setText
import pl.writeonly.xscalawt.XScalaWT.tabFolder
import pl.writeonly.xscalawt.XScalarWT.contentDefault
import pl.writeonly.xscalawt.XScalarWT.fileDialogOpen
import pl.writeonly.xscalawt.XScalarWT.fileDialogSave


trait MainWindow extends Runnable with StrictLogging {

  @Inject var browserFace: BrowserFace = _
  @Inject var configurationFace: ConfigurationFace = _
  @Inject var langFace : LangFace = _
  @Inject var playFace: PlayFace = _
  @Inject var recordFace: RecordFace = _
  @Inject var relationFace: RelationFace = _
  @Inject var translateFace: TranslateFace = _
  @Inject var useFace: UseFace = _
  @Inject var wordFace: WordFace = _

  @Inject var mainFace: Facade = _
  @Inject var consumer: JmsConsumer = _

  def run() = {
    consumer.start
  }

  var string = "MainWindow"

  def apply(parent: Shell) = {
    contentDefault(
            fileDialogOpen(mainFace.open = _),
            fileDialogSave(mainFace.save = _),
      string,
      tabFolder(
        configurationFace(),
        translateFace(),
        relationFace(),
        recordFace(),
        playFace(),
        useFace(),
        langFace(),
        wordFace(),
        browserFace()
      ))(parent)
  }

}

  /* potrzebne będzie menu, toolbar, stack/card, pasek stanu,
   * karty logowanie/rejstracja, edycja słów, edycja, edycja relacji/tworzenie 
   * 
   * 
   */