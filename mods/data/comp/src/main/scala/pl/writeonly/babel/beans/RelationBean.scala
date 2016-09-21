package pl.writeonly.babel.beans

import javax.inject.Inject
import pl.writeonly.babel.daos.DaoCrud
import pl.writeonly.babel.entities.Relation
import javax.annotation.Resource
@org.springframework.stereotype.Service
class RelationBean @Inject()(@Resource(name = "daoImpl") val dao: DaoCrud){
  val clazz = classOf[Relation]
	def persist (relation:Relation) = dao.persist(relation)
	def persistAll(relations :List[Relation]) = dao.persistAll(relations)
	def find() = dao.find(clazz);
	def merge(relation:Relation) = dao.merge(relation);
	def delete(relation:Relation) = dao.delete(relation)
	//def readSort(comparator:Comparator[Relation])
	

}