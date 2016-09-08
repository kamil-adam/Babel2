package pl.writeonly.scalar.view.cards

import org.eclipse.jface.viewers.IStructuredContentProvider
import org.eclipse.jface.viewers.Viewer
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.widgets.Text

import pl.writeonly.xscalawt
import pl.writeonly.xscalawt._
import pl.writeonly.xscalawt.XJFace._
import pl.writeonly.xscalawt.XScalaWT._
import pl.writeonly.xscalawt.XScalaWT.Assignments._
import pl.writeonly.xscalawt.XScalaWTForms._

import pl.writeonly.babel.entities._
import pl.writeonly.babel.entities.Part._
import pl.writeonly.babel.entities.Value._
import pl.writeonly.babel.entities.Word
import pl.writeonly.scalar.view.Facade._
import pl.writeonly.scalar.view.faces.WordFace
import pl.writeonly.scala.swt.layout.BorderData
import pl.writeonly.xscalawt.XScalarWT.borderLayoutScalars
import pl.writeonly.xscalawt.XScalarWT.checkbox
import pl.writeonly.xscalawt.XScalarWT.textToString

object WordModel {
  object TableProvider extends IStructuredContentProvider with ProviderImplicits[Word] {
    def getElements(i: Object) = Array[Word]()
    def inputChanged(v: Viewer, oldInput: Object, newInput: Object) {}
    def dispose() {}
  }
}

object WordCard {

  def apply(wordFace:WordFace) = {
    //var facade: Facade = null
    //word
    var pre: Text = null
    var core: Text = null
    var suf: Text = null
    var part: Text = null
    var lang: Text = null
    var find: Text = null
    composite(
      tabItem("Word"),
      borderLayoutScalars(),
      tableViewerBuilder[Word](
        _.createColumn(_.pre, "Prefix").sortable.sortable.build(),
        _.createColumn(_.core, "Core").sortable.useAsDefaultSortColumn.build(),
        _.createColumn(_.suf, "Suffix").sortable.sortable.build(),
        _.createColumn(_.part.value, "Part").sortable.sortable.build(),
        _.createColumn(_.lang.value, "Language").sortable.build())(
          _.setContentProvider(WordModel.TableProvider),
          _.setInput()),
      composite(
        layoutData = BorderData.SOUTH,

        fillLayout(vertical),
        composite(
          fillLayout(horizontal),
          label(""),
          label("Prefix"),
          label("Core"),
          label("Suffix"),
          label("Part"),
          label("Language")),
        composite(
          fillLayout(horizontal),
          checkbox(),
          text(pre = _),
          text(core = _),
          text(suf = _),
          text(part = _),
          text(lang = _)),
        composite(
          fillLayout(horizontal),
          button("insert", { e: SelectionEvent => wordFace.add(new Word(pre, core, suf, part, lang)) }),
          button("delete")
        ),
        composite(
          fillLayout(horizontal),
          text(find = _),
          button("find", { e: SelectionEvent => wordFace.find })
        ),
        composite(
          fillLayout(horizontal),
          comboViewer(),
          label("Side"),
          combo(),
          label("Language"),
          combo(),
          button("Translate", { e: SelectionEvent => wordFace.add(new Word(pre, core, suf, part, lang)) })
        )
      )
    )

  }
}