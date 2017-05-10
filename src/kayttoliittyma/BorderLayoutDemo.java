package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BorderLayoutDemo extends JFrame {

	private JPanel paPisteet = new JPanel(new FlowLayout());
	private JLabel lbPisteet = new JLabel("Pisteet:");
	
	private JPanel paKortit = new JPanel(new GridLayout(5, 5));
	
	private ArrayList<JButton> kortit = new ArrayList<JButton>();
	private JButton btKortti;
	
	public BorderLayoutDemo() {
		
		setSize(500,500);

		for (int i = 0; i < 25; i++) {
			btKortti = new JButton();
//			TODO: Liitä nappulaan myös ActionListener
			kortit.add(btKortti);
		}
		
		asetteleKomponentit();

	}
		
	public void asetteleKomponentit() {
		
		Container sisalto = this.getContentPane();
		sisalto.setLayout(new BorderLayout());
		paPisteet.add(lbPisteet);
		sisalto.add(paPisteet, BorderLayout.NORTH);
//		TODO: Lisää painikkeet paKortit
		for(int i = 0; i < kortit.size(); i++)
		{
			paKortit.add(kortit.get(i));
		}
		sisalto.add(paKortit, BorderLayout.CENTER);
		
	}

	public static void main(String[] args) {

		BorderLayoutDemo ikkuna = new BorderLayoutDemo();
		ikkuna.setVisible(true);
		ikkuna.setResizable(false);
		
	}

}
