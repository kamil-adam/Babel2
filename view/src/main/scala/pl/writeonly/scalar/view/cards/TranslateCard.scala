package pl.writeonly.scalar.view.cards

import org.eclipse.jface.viewers.CellEditor
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.widgets.Text

import pl.writeonly.xscalawt.XScalaWT.Assignments._
import pl.writeonly.xscalawt.XScalaWT.button
import pl.writeonly.xscalawt.XScalaWT.combo
import pl.writeonly.xscalawt.XScalaWT.composite
import pl.writeonly.xscalawt.XScalaWT.fillLayout
import pl.writeonly.xscalawt.XScalaWT.onSelectionImplicit
import pl.writeonly.xscalawt.XScalaWT.string2setText
import pl.writeonly.xscalawt.XScalaWT.tabItem
import pl.writeonly.xscalawt.XScalaWT.vertical
import pl.writeonly.xscalawt.viewers.TableViewerBuilder
import com.typesafe.scalalogging.slf4j.StrictLogging

import pl.writeonly.babel.entities.Lang
import pl.writeonly.scalar.view.faces.TranslateFace
import pl.writeonly.xscalarwt.swt.layout.BorderData
import pl.writeonly.xscalawt.XScalarWT.borderLayoutScalars
import pl.writeonly.xscalawt.XScalarWT.sashHorizontal
import pl.writeonly.xscalawt.XScalarWT.tableViewerBuilderCheck
import pl.writeonly.xscalawt.XScalarWT.textArea
import pl.writeonly.xscalawt.XScalarWT.textToString

object TranslateCard extends StrictLogging {
  def apply(face: TranslateFace) = {
    var words: Text = null
    var lang: Combo = null
    var langs: TableViewerBuilder[Lang] = null
    logger debug "translate => " + face
    //logger debug "langs => " + langs
    var radioCellEditor: CellEditor = null
    var checkboxIt: Button = null
    var any: Any = null
    val result = composite(
      tabItem("Translate"),
      fillLayout(vertical),
      sashHorizontal(
        textArea(words = _),
        composite (
          borderLayoutScalars(),
          //          tableViewerBuilderCheuck[Lang](
          tableViewerBuilderCheck[Lang](
            langs = _,
            _.createColumn(_.value, "Langs").
              sortable.build())(
              _.setContentProvider(face.langTableProvider),
              _.setInput()
            ),
          combo(
            lang = _,
            layoutData = BorderData.NORTH,
            _.setItems(face.langs.map(_.value).toArray)
          ),
          button ("Translate", layoutData = BorderData.SOUTH,
            { e: SelectionEvent => face.translate(words, lang, langs.table) }
          )
        )
      )
    )

    result
  }
}