
package pl.writeonly.swt.snippets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class Snippet113 {

	public static void main (String [] args) {
		final Display display = new Display ();
		final Shell shell = new Shell (display);
		final Table table = new Table (shell, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		for (int i = 0; i < 12; i++) {
			final TableItem item = new TableItem (table, SWT.NONE);
			item.setText ("Item " + i);
		}
		final Rectangle clientArea = shell.getClientArea ();
		table.setBounds (clientArea.x, clientArea.y, 100, 100);
		table.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event event) {
				final String string = event.detail == SWT.CHECK ? "Checked" : "Selected";
				System.out.println (event.item + " " + string);
				final TableItem item = (TableItem)event.item;
				System.out.println ("checked" + item.getChecked ());
				//item.
			}
		});
		shell.setSize (200, 200);
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}
}