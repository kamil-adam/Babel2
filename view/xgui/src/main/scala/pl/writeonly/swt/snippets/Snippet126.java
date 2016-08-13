
package pl.writeonly.swt.snippets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class Snippet126 {
	public static void main (String [] args) {
		final Display display = new Display ();
		final Shell shell = new Shell (display);
		shell.setLayout (new FillLayout ());
		final Table table = new Table (shell, SWT.BORDER | SWT.MULTI);
		table.setLinesVisible (true);
		for (int i = 0; i < 3; i++) {
			final TableColumn column = new TableColumn (table, SWT.NONE);
			column.setWidth (100);
		}
		for (int i = 0; i < 12; i++) {
			new TableItem (table, SWT.NONE);
		}
		final TableItem [] items = table.getItems ();
		for (int i = 0; i < items.length; i++) {
			final TableEditor comboEditor = new TableEditor (table);
			final CCombo combo = new CCombo (table, SWT.NONE);
			comboEditor.grabHorizontal = true;
			comboEditor.setEditor (combo, items [i], 0);
			final TableEditor textEditor = new TableEditor (table);
			final Text text = new Text (table, SWT.NONE);
			textEditor.grabHorizontal = true;
			textEditor.setEditor (text, items [i], 1);
			final TableEditor buttonEditor = new TableEditor (table);
			System.out.println ("print buttonEditor => " + buttonEditor);
			final Button button = new Button (table, SWT.CHECK);
			button.pack ();
			buttonEditor.minimumWidth = button.getSize ().x;
			buttonEditor.horizontalAlignment = SWT.LEFT;
			buttonEditor.setEditor (button, items [i], 2);
		}
		shell.pack ();
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}
}
