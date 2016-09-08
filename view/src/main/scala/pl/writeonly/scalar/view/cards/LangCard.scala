package pl.writeonly.scalar.view.cards

import pl.writeonly.scalar.view.faces.LangFace
import pl.writeonly.xscalawt.viewers.TableViewerBuilder
import org.eclipse.jface.viewers.TableViewer
import pl.writeonly.babel.entities.Lang
import pl.writeonly.xscalawt.XScalaWT._
import pl.writeonly.xscalawt.XScalaWT.Assignments._
import pl.writeonly.xscalawt.XScalarWT._
import org.eclipse.swt.events.SelectionEvent
import pl.writeonly.xscalarwt.swt.layout.BorderData
//import pl.writeonly.xscalawt.XScalaWT._
//import pl.writeonly.xscalawt.XScalaWT.Assignments._
//import pl.writeonly.xscalawt.XScalarWT._

object LangCard {
  def apply(face: LangFace) = {
    val result = composite(
      tabItem("Lang"),
      tableViewerBuilderCheck[Lang](
        face.builder = _,
        _.createColumn(_.value, "Value").sortable.useAsDefaultSortColumn.build())(
          _.setContentProvider(face.tableProvider),
          _.setInput()
        ),
      composite (
        composite(
          text(face.findText = _),
          button("Find", { e: SelectionEvent => face.find }),
          fillLayout(horizontal)
        ),
        composite(
          text(face.insertText = _),
          button("Insert", { e: SelectionEvent => face.insert }),
          fillLayout(horizontal)
        ),
        composite(
          button("Delete", { e: SelectionEvent => face.delete }),
          fillLayout(vertical)
        ),
        layoutData = BorderData.SOUTH,
        fillLayout(vertical)
      ),
      borderLayoutScalars()
    )
    result
  }
}