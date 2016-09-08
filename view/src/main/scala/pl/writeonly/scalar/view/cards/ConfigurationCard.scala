package pl.writeonly.scalar.view.cards

import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Text

import pl.writeonly.xscalawt.XScalaWT.button
import pl.writeonly.xscalawt.XScalaWT.composite
import pl.writeonly.xscalawt.XScalaWT.fillLayout
import pl.writeonly.xscalawt.XScalaWT.label
import pl.writeonly.xscalawt.XScalaWT.onSelectionImplicit
import pl.writeonly.xscalawt.XScalaWT.string2setText
import pl.writeonly.xscalawt.XScalaWT.tabItem
import pl.writeonly.xscalawt.XScalaWT.text
import pl.writeonly.xscalawt.XScalaWT.textPasswd
import pl.writeonly.xscalawt.XScalaWT.vertical

import pl.writeonly.babel.swt.faces.ConfigurationFace
import pl.writeonly.xscalawt.YScalaWT.textToString

object ConfigurationCard {
  def apply(configuration: ConfigurationFace) = {

    //config
    var username: Text = null
    var password: Text = null
    var confirm: Text = null
    var state: Label = null

    composite(
      tabItem("Configuration"),
      composite(
        fillLayout(vertical),
        composite(
          fillLayout(),
          label("username"),
          text(username = _),
          label("password"),
          textPasswd(password = _),
          label("confirm"),
          textPasswd(confirm = _)),
        composite(
          fillLayout(),
          button("register", { e: SelectionEvent => configuration.register(username, password, confirm) }),
          button("login", { e: SelectionEvent => configuration.login(username, password) }),
          button("logout", { e: SelectionEvent => configuration.logout }),
          button("update", { e: SelectionEvent => configuration.merge })),
        composite(label(state = _))))

  }
}