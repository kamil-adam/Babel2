package pl.writeonly.babel.swt.cards

import pl.writeonly.xscalawt.XScalaWT.Assignments._
import pl.writeonly.xscalawt.ProviderImplicits
import pl.writeonly.xscalawt.XJFace.tableViewerBuilder
import pl.writeonly.xscalawt.XScalaWT.composite
import pl.writeonly.xscalawt.XScalaWT.fillLayout
import pl.writeonly.xscalawt.XScalaWT.string2setText
import pl.writeonly.xscalawt.XScalaWT.tabItem
import pl.writeonly.xscalawt.XScalaWT._
import pl.writeonly.xscalawt.viewers.TableViewerBuilder
import pl.writeonly.babel.entities.Relation
import pl.writeonly.babel.swt.faces.RelationFace
import pl.writeonly.xscalawt.YScalaWT._
import pl.writeonly.scala.swt.layout.BorderData
import com.weiglewilczek.slf4s.Logging
import org.eclipse.jface.viewers.TableViewer
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.events.SelectionEvent

object RelationCard extends Logging {
  def apply(face: RelationFace) = {
    composite(
      tabItem("Relation"),
      borderLayoutScalars(),
      tableViewerBuilderCheck[Relation](
        face.builder = _,
        _.createColumn((r: Relation) => { "" }, "Check").sortable.build(),
        _.createColumn("" + _.key, "Key").sortable.build(),
        _.createColumn("" + _.value, "Value").sortable.build())(
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
        button("toJson",
          //layoutData = BorderData.SOUTH,
          { e: SelectionEvent => face.toJson }
        ),
        button("deen",
          //layoutData = BorderData.SOUTH,
          { e: SelectionEvent => face.deen }
        ),
        fillLayout(horizontal),
        layoutData = BorderData.SOUTH
      )
    )
  }
}