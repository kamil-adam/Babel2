package pl.writeonly.scalar.view.cards

import pl.writeonly.xscalawt.XScalaWT.Assignments._
import pl.writeonly.xscalawt.XScalaWT._
import pl.writeonly.xscalawt.XJFace.tableViewerBuilder
import pl.writeonly.xscalawt.XScalaWT.composite
import pl.writeonly.xscalawt.XScalaWT.fillLayout
import pl.writeonly.xscalawt.XScalaWT.string2setText
import pl.writeonly.xscalawt.XScalaWT.tabItem
import pl.writeonly.xscalawt.XScalaWT.vertical
import pl.writeonly.xscalawt.ProviderImplicits
import org.eclipse.jface.viewers.IStructuredContentProvider
import org.eclipse.jface.viewers.Viewer
import pl.writeonly.babel.entities._
import pl.writeonly.scalar.view.faces.RecordFace
import pl.writeonly.scala.swt.layout.BorderData
import pl.writeonly.xscalawt.XScalarWT._
import org.eclipse.swt.events.SelectionEvent


object RecordCard {
  def apply(face: RecordFace) = {
    composite(
      tabItem("Record"),
      borderLayoutScalars(),
      tableViewerBuilder[Record](
        _.createColumn(_.relation.key.toString, "Key").sortable.useAsDefaultSortColumn.build(),
        _.createColumn(_.relation.value.toString, "Value").sortable.sortable.build(),
        _.createColumn(_.corect, "Corect").sortable.sortable.build(),
        _.createColumn(_.wrong, "Wrong").sortable.sortable.build())(
          _.setContentProvider(face.tableProvider),
          _.setInput()
        ),
      composite (
        button("Persist",
          //layoutData = BorderData.SOUTH,
          { e: SelectionEvent => face.insert }
        ),
        button("Find",
          //layoutData = BorderData.SOUTH,
          { e: SelectionEvent => face.find }
        ),
        fillLayout(horizontal),
        layoutData = BorderData.SOUTH
      )
    )
  }
}