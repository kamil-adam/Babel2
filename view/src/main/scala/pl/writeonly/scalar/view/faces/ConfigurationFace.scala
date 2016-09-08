package pl.writeonly.scalar.view.faces

import javax.annotation.Resource
import pl.writeonly.babel.beans.ConfigurationBean
import pl.writeonly.babel.beans.UserBean
import pl.writeonly.scalar.view.Face
import pl.writeonly.scalar.view.cards.ConfigurationCard
import pl.writeonly.scalar.view.Facade

@org.springframework.stereotype.Controller
class ConfigurationFace extends Face {
  @Resource var configurationService: ConfigurationBean = _
  @Resource var userService: UserBean = _
  @Resource var facade: Facade = _
  
  def apply() = ConfigurationCard(this) 
  
  //metody dostępu do pojedynczych danych
  def register(username: String, password: String, confirm: String) = {
    logger info "Facade register begin"
    facade.user = userService.persist(username, password, confirm)
    logger info "Facade register end"
    facade.user
  }
  def login(username: String, password: String) = {
    logger info "Facade login begin"
    facade.user = userService.find(username, password)
    logger info "Facade login end"
    facade.user
  }
  def logout = {
    facade.user = null
  }

  def merge = try { configurationService.merge } catch { case e: Exception => logger error (e.getMessage, e) }

}