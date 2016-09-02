package pl.writeonly.babel.swt.composite

import pl.writeonly.xscalawt.XScalaWT.button
import pl.writeonly.xscalawt.XScalaWT.composite
import pl.writeonly.xscalawt.XScalaWT.fillLayout
import pl.writeonly.xscalawt.XScalaWT.string2setText
import pl.writeonly.xscalawt.XScalaWT.vertical

object EscapeComposite {
  
  def apply() = {
    
    composite(
        fillLayout(vertical),
        button("Insert" ),
        button("Delete"),
        button("Paste"),
        button("Find"),
        button("")
        )
  }
}