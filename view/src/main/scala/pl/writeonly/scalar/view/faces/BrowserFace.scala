package pl.writeonly.scalar.view.faces

import pl.writeonly.scalar.view.Face
import pl.writeonly.babel.swt.cards.BrowserCard

@org.springframework.stereotype.Controller
class BrowserFace extends Face {
	def apply() = BrowserCard(this)
}