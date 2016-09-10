package pl.writeonly.scalar.view.faces

import org.eclipse.swt.widgets.Display
import pl.writeonly.xscalawt.viewers.TableViewerBuilder
import javax.annotation.Resource
import pl.writeonly.babel.beans.ValueBean
import pl.writeonly.babel.entities.Lang
import pl.writeonly.scalar.view.Face
import pl.writeonly.scalar.view.FaceBuilder
import pl.writeonly.scalar.view.cards.LangCard
import pl.writeonly.scalar.view.providers.LangTableProvider
import pl.writeonly.scala.util.SingleAbstractMethod._
import org.eclipse.swt.widgets.Text
import pl.writeonly.babel.entities.Lang.stringToLang

import pl.writeonly.scala.util.SingleAbstractMethod._

@org.springframework.stereotype.Controller
class LangFace extends FaceBuilder[Lang] {
  @Resource var langService: ValueBean = _
  @Resource var tableProvider: LangTableProvider = _

  var insertText: Text = _
  var findText: Text = _

  def apply() = LangCard(this)

  def insert = add(insertText.getText())
  def delete = { val checked = check(); langService.deleteLangs (checked); removeAll(checked) }

  def find = clear.addAll(langService.langs)

  protected def clear() = { builder.table.clearAll(); this }

  protected def addAll(list: List[Lang]) = {
    val filtred = list.filter(!tableProvider.array.contains(_))
    tableProvider.add(list.toArray)
    Display.getDefault.syncExec { list.foreach(builder.viewer.add(_)) }
    this
  }
  protected def add(lang: Lang) {
    if (!tableProvider.array.contains(lang)) {
      tableProvider.array ++= Array[Lang](lang)
      Display.getDefault.syncExec { builder.viewer.add(lang) }
      langService.persistLang(lang)
    }

  }
  protected def removeAll(list: List[Lang]) {
    //logger debug "removeAll list => " + list
  }
}