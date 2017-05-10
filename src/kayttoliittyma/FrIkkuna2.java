package kayttoliittyma;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;

public class FrIkkuna2 extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrIkkuna2()
	{
		
		setTitle("Esimerkki-ikkuna");
		setSize(200, 150);
		setLocation(100,100);
		
		addWindowListener(new WlsIkkuna());
	}
}

class WlsIkkuna extends WindowAdapter {
	
	public void WindowClosing(WindowEvent e) {
		
		System.exit(0);
	}
}