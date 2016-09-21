package pl.writeonly.babel.beans

import javax.annotation.Resource
import javax.inject.Inject
import pl.writeonly.babel.daos.DaoCrud
import pl.writeonly.babel.entities.Word

@org.springframework.stereotype.Service
class WordBean @Inject()(@Resource(name = "daoImpl") val dao: DaoCrud) {
  val clazz = classOf[Word]
  def persist(word: Word) = dao.persist(word)
  def persistAll(words: List[Word]) = dao.persist(words)
  def find = dao.find(clazz);
  def update(word: Word) = dao.merge(word);
}