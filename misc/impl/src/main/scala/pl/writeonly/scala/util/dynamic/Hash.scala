//package pl.writeonly.scala.util.dynamic
//
//import scala.collection.mutable._
//import java.util.Properties
//
//class DynamicMap[V](_map: Map[String, V]) {
//  val map = _map
//  def selectDynamic(key: String): Option[V] = map.get(key)
//  def updateDynamic(key: String)(value: V) = map.put(key, value)
//}
//
//class DynamicProperties {
//  val prop = new Properties
//  def selectDynamic(key: String): String = prop.getProperty(key)
//  def updateDynamic(key: String)(value: String) = prop.setProperty(key, value)
//}
//
//class DynamicDebug[V] extends DynamicMap[V](new LinkedHashMap[String, V]) {
//  override def toString = {
//    //map.foldLeft(new StringBuilder)((sb,it )=> {sb.append (it._1 + " => ")} ).toString
//    val keys = map.keys
//    val it = keys.iterator
//    val sb = new StringBuilder
//    while (it.hasNext) {
//      val t = it.next
//      sb.append(t + " => " + map.get(t).get)
//      if (it.hasNext) sb.append(", ")
//    }
//    "{" + sb.toString + "}"
//  }
//}
//
