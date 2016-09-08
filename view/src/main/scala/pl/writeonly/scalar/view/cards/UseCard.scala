package pl.writeonly.scalar.view.cards

import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.widgets.Composite

import pl.writeonly.xscalawt.XJFace.tableViewerBuilder
import pl.writeonly.xscalawt.XScalaWT.Assignments._
import pl.writeonly.xscalawt.XScalaWT.button
import pl.writeonly.xscalawt.XScalaWT.combo
import pl.writeonly.xscalawt.XScalaWT.composite
import pl.writeonly.xscalawt.XScalaWT.fillLayout
import pl.writeonly.xscalawt.XScalaWT.horizontal
import pl.writeonly.xscalawt.XScalaWT.onSelectionImplicit
import pl.writeonly.xscalawt.XScalaWT.string2setText
import pl.writeonly.xscalawt.XScalaWT.tabItem
import pl.writeonly.xscalawt.viewers.TableViewerBuilder
import com.typesafe.scalalogging.slf4j.StrictLogging

import pl.writeonly.babel.dtos.LernuQuery
import pl.writeonly.scalar.view.faces.UseFace
import pl.writeonly.xscalarwt.swt.layout.BorderData
import pl.writeonly.xscalawt.XScalarWT.borderLayoutScalars

object UseCard extends StrictLogging {
  def apply(use: UseFace) = {
    use.lernuQueryTP.array = Array[LernuQuery](new LernuQuery("UseCard", "UseCard", "UseCard"))
    var self: Composite = null
    var lernuQueries: TableViewerBuilder[LernuQuery] = null

    try {
      composite(
        self = _,
        tabItem("Import"),
        borderLayoutScalars(),
        tableViewerBuilder[LernuQuery](
          lernuQueries = _,
          _.createColumn(_.modelo.toString, "modelo").sortable.useAsDefaultSortColumn.build(),
          _.createColumn(_.delingvo.toString, "delingvo").sortable.sortable.build(),
          _.createColumn(_.allingvo.toString, "allingvo").sortable.sortable.build())(
            _.setContentProvider(use.lernuQueryTP),
            _.setInput()
          ),
        composite (
          fillLayout(horizontal),
          layoutData = BorderData.SOUTH,
          fillLayout(horizontal),
          button("Open", { e: SelectionEvent => { use.open } }),
          button("Open", { e: SelectionEvent =>  use.addLernuQueries(lernuQueries.viewer) }),
          //combo(_.setItems(use.viewSideItem)),
          combo(),
          button("Import", { e: SelectionEvent => { use.use } })
        )
      )
    }
    catch {
      case e: Exception => {
        logger.error(e.getMessage, e)
        composite(tabItem("Import"))
      }
    }
  }
}