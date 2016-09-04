package pl.writeonly.scalar.view
import scala.collection.mutable.ListBuffer
import pl.writeonly.babel.swt.Face

trait FaceBuilder[T] extends Face {
  var builder: TableViewerBuilder[T] = _
  //  def insert(): Unit
  //  def find(): Unit
  def check() = builder.tableimport pl.writeonly.scalar.view.Face
.getItems.filter(_.getChecked()).map(_.getData().asInstanceOf[T]).toList
  def checkInt() = {
    val items = builder.table.getItems
    val buffer = new ListBuffer[Int]
    for (i <- 0 until items.length) {
      if (items(i).getChecked)
        buffer += i
    }
    buffer
  }
  def clearAll() = { builder.table.clearAll(); this }

  //  def addAll(list: List[T]) {
  //    tableProvider.add(list.toArray)
  //    Display.getDefault.syncExec { relationAll.foreach(builder.viewer.add(_)) }
  //  }
}