
package pl.writeonly.swt;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

public class HelloWorld extends ApplicationWindow {

	public HelloWorld () {
		super (null);
	}

	public void run () {
		setBlockOnOpen (true);
		open ();
		Display.getCurrent ().dispose ();
	}

	protected Control createContents (Composite parent) {
		System.out.println (parent.getClass());
		Label label = new Label (parent, SWT.CENTER);
		label.setText ("" + parent.getClass());
		return label;
	}

	public static void main (String [] args) {
		new HelloWorld ().run ();
	}
}