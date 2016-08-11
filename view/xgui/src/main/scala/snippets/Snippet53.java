package org.eclipse.swt.snippets;

/*
 * Table example snippet: remove selected items (using popup menu)
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class Snippet53 {

	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		final Table table = new Table(shell, SWT.BORDER | SWT.MULTI);
		final Rectangle clientArea = shell.getClientArea();
		table.setBounds(clientArea.x, clientArea.y, 200, 200);
		for (int i = 0; i < 128; i++) {
			final TableItem item = new TableItem(table, SWT.NONE);
			item.setText("Item " + i);
		}
		final Menu menu = new Menu(shell, SWT.POP_UP);
		table.setMenu(menu);
		final MenuItem item = new MenuItem(menu, SWT.PUSH);
		item.setText("Delete Selection");
		item.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				table.remove(table.getSelectionIndices());
			}
		});
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
