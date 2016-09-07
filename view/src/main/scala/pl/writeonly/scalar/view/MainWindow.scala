package pl.writeonly.scalar.view


import com.typesafe.scalalogging.slf4j.StrictLogging

import javax.annotation.Resource


import pl.writeonly.xscalawt.YScalaWT._
import pl.writeonly.xscalawt.XScalaWT._
import pl.writeonly.xscalawt.XScalaWT.Assignments._
import pl.writeonly.scalar.view.JmsConsumer

import pl.writeonly.scalar.view.JmsConsumer
import pl.writeonly.scalar.view.Facade

trait MainWindow extends Runnable with StrictLogging {

  @Resource var browserFace: BrowserFace = _
  @Resource var configurationFace: ConfigurationFace = _
  @Resource var langFace : LangFace = _
  @Resource var playFace: PlayFace = _
  @Resource var recordFace: RecordFace = _
  @Resource var relationFace: RelationFace = _
  @Resource var translateFace: TranslateFace = _
  @Resource var useFace: UseFace = _
  @Resource var wordFace: WordFace = _

  @Resource var mainFace: Facade = _
  @Resource var consumer: JmsConsumer = _

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