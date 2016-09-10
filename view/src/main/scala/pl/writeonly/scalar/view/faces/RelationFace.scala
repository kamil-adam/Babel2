package pl.writeonly.scalar.view.faces

import org.eclipse.jface.viewers.TableViewer
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Table
import pl.writeonly.xscalawt.viewers.TableViewerBuilder
import com.typesafe.scalalogging.slf4j.StrictLogging
import javax.annotation.Resource
import pl.writeonly.babel.beans.RecordBean
import pl.writeonly.babel.beans.ParseBean
import pl.writeonly.babel.beans.RelationBean
import pl.writeonly.babel.beans.WordBean
import pl.writeonly.babel.entities.Relation
import pl.writeonly.scalar.view.Face
import pl.writeonly.scalar.view.FaceBuilder
import pl.writeonly.scalar.view.cards.RelationCard
import pl.writeonly.scalar.view.providers.RelationTableProvider
import pl.writeonly.scala.util.SingleAbstractMethod._
import com.google.gson.Gson
import java.util.Arrays
import pl.writeonly.scalar.view.Facade

@org.springframework.stereotype.Controller
class RelationFace extends FaceBuilder[Relation] {
  @Resource var relationService: RelationBean = _
  @Resource var tableProvider: RelationTableProvider = _
  @Resource var recordService: RecordBean = _
  @Resource var parseService: ParseBean = _
  @Resource var facade: Facade = _

  def apply() = RelationCard(this)

  def insert = relationService.persistAll (check())
  //  def find = try { addAll(relationService.find) } catch { case e: RuntimeException => runtime(e)}
  def recordAll = recordService.toRecordAll(check())
  def find = clear.addAll(relationService.find)
  def toJson = logger debug new Gson().toJson(Arrays.asList(tableProvider.array))
  def deen = parseService.deen (facade.open.getFileName())

  protected def clear() = { builder.table.clearAll(); this }
  def addAll(list: List[Relation]) {
    logger debug "addAll list => " + list
    tableProvider.add(list.toArray)
    Display.getDefault.syncExec { list.foreach(builder.viewer.add(_)) }
  }
}