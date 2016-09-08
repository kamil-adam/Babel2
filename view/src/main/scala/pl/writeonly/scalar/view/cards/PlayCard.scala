package pl.writeonly.scalar.view.cards

import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.widgets.Label

import pl.writeonly.xscalawt.XScalaWT.Assignments._
import pl.writeonly.xscalawt.XScalaWT.button
import pl.writeonly.xscalawt.XScalaWT.composite
import pl.writeonly.xscalawt.XScalaWT.label
import pl.writeonly.xscalawt.XScalaWT.list
import pl.writeonly.xscalawt.XScalaWT.onSelectionImplicit
import pl.writeonly.xscalawt.XScalaWT.string2setText
import pl.writeonly.xscalawt.XScalaWT.tabItem

import pl.writeonly.babel.beans.FacadeBean
import pl.writeonly.babel.swt.faces.PlayFace
import pl.writeonly.scala.swt.layout.BorderData
import pl.writeonly.xscalawt.YScalaWT.borderLayoutScalars

object PlayCard {
  def apply(playFace : PlayFace) = {
    var facade: FacadeBean = null
    //play
    var key: Label = null
    var values: org.eclipse.swt.widgets.List = null
    composite(
      tabItem("Play"),
      borderLayoutScalars(),
      label(key = _, layoutData = BorderData.NORTH),
      list(values = _, { e: SelectionEvent => { facade.checkValue(values.getSelectionIndex) } }),
      composite(
        borderLayoutScalars(),
        button("Next", layoutData = BorderData.EAST, { e: SelectionEvent => { facade.next; key.setText(facade.viewKey.toString) } }),
        button("Esc", layoutData = BorderData.WEST, { e: SelectionEvent => {} }),
        layoutData = BorderData.SOUTH))

  }
}