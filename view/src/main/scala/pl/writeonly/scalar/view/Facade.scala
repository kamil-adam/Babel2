package pl.writeonly.scalar.view

object Facade {
  implicit def textToPart(text: Text): Part = text.getText
  implicit def textToLang(text: Text): Lang = text.getText
}

@org.springframework.stereotype.Controller
class Facade {
  var open: FileDialog = _
  var save: FileDialog = _
  var user: User = _
}