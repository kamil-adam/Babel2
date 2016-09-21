package pl.writeonly.scalar.view.faces

import com.typesafe.scalalogging.slf4j.StrictLogging
import javax.annotation.Resource
import org.springframework.stereotype.Controller
import pl.writeonly.babel.beans._
import pl.writeonly.babel.daos.DaoCsv
import pl.writeonly.babel.dtos.LernuQuery
import pl.writeonly.scalar.view.providers.DefaultTableProvider
import javax.annotation.PostConstruct
import pl.writeonly.xscalawt.viewers.TableViewerBuilder
import org.eclipse.jface.viewers.TableViewer
import pl.writeonly.scalar.view.cards.UseCard
import pl.writeonly.scalar.view.Face
import pl.writeonly.scalar.view.Facade
import javax.inject.Inject

@org.springframework.stereotype.Controller
class UseFace extends Face {
  @Inject var dialogFace: Facade = _
  @Inject var sideService: SideBean = _
  @Inject var csvService: CsvBean = _
  @Inject var daoCsv: DaoCsv = _
  @Inject var lernuQueryTP: DefaultTableProvider[LernuQuery] = _

  @Inject
  @PostConstruct
  def init() {
    val query = new LernuQuery("UseFace", "UseFace", "UseFace")
    val array = Array[LernuQuery](query)
    lernuQueryTP.array = array
  }

  def apply() = UseCard(this)

  def viewSideItem = sideService.findName.toArray
  def open() = {
    logger.debug("open");
    val fileName = dialogFace.open.open();
    val readed = csvService.readFile(fileName)
    logger.debug("fileName " + fileName);
    lernuQueryTP.array = daoCsv.read(classOf[LernuQuery], fileName).toArray[LernuQuery]
  }

  def addLernuQueries(viewer: TableViewer) = {
    val list = open[LernuQuery](classOf[LernuQuery])
    list.foreach((query: LernuQuery) => {
      viewer.add(query)
    })
  }

  /**
   * wczytuje plik cvs, konwertuje na klasy i wyświetla
   */
  def open[T](clazz: Class[T]) = {
    val fileName = dialogFace.open.open();
    daoCsv.read(clazz, fileName)
  }
  def use() = {
    logger.debug("use")
    //sideService.

  }
}