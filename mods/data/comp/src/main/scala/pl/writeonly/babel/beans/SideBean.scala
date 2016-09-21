package pl.writeonly.babel.beans

import scala.collection.mutable.MutableList
import javax.inject.Inject
import pl.writeonly.babel.daos.DaoCrud
import pl.writeonly.babel.entities.Side
import javax.annotation.Resource

@org.springframework.stereotype.Service
class SideBean @Inject() (@Resource(name = "daoImpl") val dao: DaoCrud) {
  def find() = dao.find(classOf[Side])
  def findName = find().foldLeft(new MutableList[String]())((l: MutableList[String], s: Side) => { l += s.name })
}