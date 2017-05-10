package kayttoliittyma;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class FrIkkuna extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton btLeftUpmost = new JButton("");
	private JButton btCenterUpmost = new JButton("");
	private JButton btRightUpmost = new JButton("");
	private JButton btLeftCenter = new JButton("");
	private JButton btCenterCenter = new JButton("");
	private JButton btRightCenter = new JButton("");
	private JButton btLeftBottom = new JButton("");
	private JButton btCenterBottom = new JButton("");
	private JButton btRightBottom = new JButton("");
	private JButton btNewGame = new JButton("New game");
	
	private ArrayList<JButton> btNappulat = new ArrayList<JButton>();
	
	private int[][] matrix = new int[3][3];
	private int numberOfChoicesMade = 0;
	
	public FrIkkuna() {
		
//		Asetetaan ikkunalle otsikko
		setTitle("Esimerkki-ikkuna");
//		Asetetaan ikkunan koko
		setSize(360, 400);
//		Asetetaan ikkuna kohtaan 100,100
		setLocation(100,100);
		
//		Luodaan ikoniolio ja annetaan tiedoksi ikonitiedoston sijainti
		ImageIcon img = new ImageIcon("images/icon.png");
		setIconImage(img.getImage());
		
//		Luodaan nappulat, jotta ne voidaan sijoittaa layoutiin
//		for(int i=0; i<9; i++)
//		{
//			JButton btNappula = new JButton();
//			btNappulat.add(btNappula);
//		}
		
		btNappulat.add(btLeftUpmost);
		btNappulat.add(btCenterUpmost);
		btNappulat.add(btRightUpmost);
		btNappulat.add(btLeftCenter);
		btNappulat.add(btCenterCenter);
		btNappulat.add(btRightCenter);
		btNappulat.add(btLeftBottom);
		btNappulat.add(btCenterBottom);
		btNappulat.add(btRightBottom);
		
//		Kutsutaan komponenttien asettelijaa
		setComponents();
		
//		Asetetaan ikkunan sulkemiselle oletusfunktio
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setComponents() {
		
		Container sisalto = this.getContentPane();
		sisalto.setLayout(null);

		btLeftUpmost.setBounds(0, 0, 100, 100);
		btCenterUpmost.setBounds(100, 0, 100, 100);
		btRightUpmost.setBounds(200, 0, 100, 100);
		btLeftCenter.setBounds(0, 100, 100, 100);
		btCenterCenter.setBounds(100, 100, 100, 100);
		btRightCenter.setBounds(200, 100, 100, 100);
		btLeftBottom.setBounds(0, 200, 100, 100);
		btCenterBottom.setBounds(100, 200, 100, 100);
		btRightBottom.setBounds(200, 200, 100, 100);
		
//		for(int i=0; i<btNappulat.size(); i++)
//		{
//			JButton nappula = btNappulat.get(i);
//			nappula.setBounds(i%3*100, i/3*100, 100, 100);
//			nappula.addActionListener(new AlsUpperCenter());
//			nappula.setName(i+"");
//			sisalto.add(nappula);
//		}
		
		btLeftUpmost.addActionListener(new AlsUpperLeft());
		btCenterUpmost.addActionListener(new AlsUpperCenter());
		btRightUpmost.addActionListener(new AlsUpperRight());
		btLeftCenter.addActionListener(new AlsCenterLeft());
		btCenterCenter.addActionListener(new AlsCenterCenter());
		btRightCenter.addActionListener(new AlsCenterRight());
		btLeftBottom.addActionListener(new AlsBottomLeft());
		btCenterBottom.addActionListener(new AlsBottomCenter());
		btRightBottom.addActionListener(new AlsBottomRight());
		
		btNewGame.addActionListener(new AlsNewGame());
		
		sisalto.add(btLeftUpmost);
		sisalto.add(btCenterUpmost);
		sisalto.add(btRightUpmost);
		sisalto.add(btLeftCenter);
		sisalto.add(btCenterCenter);
		sisalto.add(btRightCenter);
		sisalto.add(btLeftBottom);
		sisalto.add(btCenterBottom);
		sisalto.add(btRightBottom);
		
		btNewGame.setBounds(0, 300, 300, 50);
		sisalto.add(btNewGame);
	}
	
	public void teeTietokoneenValinta() {
//		Käy matriisi läpi
		int matriisi[][] = new int[3][3];
		Random random = new Random();
		int vaaka = 0;
		int pysty = 0;
		do {
			vaaka = random.nextInt(3);
			pysty = random.nextInt(3);
		} while(matrix[vaaka][pysty] == 1 || matrix[vaaka][pysty] == 2);
		
		
		matrix[vaaka][pysty]=2;
		
		if(vaaka == 0 && pysty == 0) {
			btLeftUpmost.setText("0");
		} else if(vaaka == 1 && pysty == 0)
		{
			btCenterUpmost.setText("0");
		} else if(vaaka == 2 && pysty == 0)
		{
			btRightUpmost.setText("0");
		} else if(vaaka == 0 && pysty == 1)
		{
			btLeftCenter.setText("0");
		} else if(vaaka == 1 && pysty == 1)
		{
			btCenterCenter.setText("0");
		} else if(vaaka == 2 && pysty == 1)
		{
			btRightCenter.setText("0");
		} else if(vaaka == 0 && pysty == 2)
		{
			btLeftBottom.setText("0");
		} else if(vaaka == 1 && pysty == 2)
		{
			btCenterBottom.setText("0");
		} else if(vaaka == 2 && pysty == 2)
		{
			btRightBottom.setText("0");
		} else {
			System.out.println("Tietokone teki valinnan, jota ei voi tehdä: "+vaaka+", "+pysty);
		}
		
	}
	
	private void AloitaUusiPeli() {
		numberOfChoicesMade = 0;
		for (int i = 0; i < btNappulat.size(); i++) {
			btNappulat.get(i).setText("");
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j]=0;
			}
		}
	}
	
	class AlsUpperLeft implements ActionListener {
				
		@Override
		public void actionPerformed(ActionEvent e) {
			if(numberOfChoicesMade < 3)
			{
				matrix[0][0]=1;
				btLeftUpmost.setText("X");
				numberOfChoicesMade++;
				teeTietokoneenValinta();
			}
			System.out.println("TicTacToeGame.AlsUpperLeft.actionPerformed()");
		}
	}
	
	class AlsUpperCenter implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(numberOfChoicesMade < 3)
			{
				matrix[1][0]=1;
				btCenterUpmost.setText("X");
				numberOfChoicesMade++;
				teeTietokoneenValinta();
			}
			System.out.println("TicTacToeGame.AlsUpperCenter.actionPerformed()");
		}
	}

	class AlsUpperRight implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(numberOfChoicesMade < 3)
			{
				matrix[2][0]=1;
				btRightUpmost.setText("X");
				numberOfChoicesMade++;
				teeTietokoneenValinta();
			}
			System.out.println("TicTacToeGame.AlsUpperRight.actionPerformed()");
		}
	}
	
	class AlsCenterLeft implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(numberOfChoicesMade < 3)
			{
				matrix[0][1]=1;
				btLeftCenter.setText("X");
				numberOfChoicesMade++;
				teeTietokoneenValinta();
			}
			System.out.println("TicTacToeGame.AlsCenterLeft.actionPerformed()");
		}
	}
	
	class AlsCenterCenter implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(numberOfChoicesMade < 3)
			{
				matrix[1][1]=1;
				btCenterCenter.setText("X");
				numberOfChoicesMade++;
				teeTietokoneenValinta();
			}
			System.out.println("TicTacToeGame.AlCenterCenter.actionPerformed()");
		}
	}

	class AlsCenterRight implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(numberOfChoicesMade < 3)
			{
				matrix[2][1]=1;
				btRightCenter.setText("X");
				numberOfChoicesMade++;
				teeTietokoneenValinta();
			}
			System.out.println("TicTacToeGame.AlsRightCenter.actionPerformed()");
		}
	}
	
	class AlsBottomLeft implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(numberOfChoicesMade < 3)
			{
				matrix[0][2]=1;
				btLeftBottom.setText("X");
				numberOfChoicesMade++;
				teeTietokoneenValinta();
			}
			System.out.println("TicTacToeGame.AslBottomLeft.actionPerformed()");
		}
	}
	
	class AlsBottomCenter implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(numberOfChoicesMade < 3)
			{
				matrix[1][2]=1;
				btCenterBottom.setText("X");
				numberOfChoicesMade++;
				teeTietokoneenValinta();
			}
			System.out.println("TicTacToeGame.AlsBottomCenter.actionPerformed()");
		}
	}

	class AlsBottomRight implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(numberOfChoicesMade < 3)
			{
				matrix[2][2]=1;
				btRightBottom.setText("X");
				numberOfChoicesMade++;
				teeTietokoneenValinta();
			}
			System.out.println("TicTacToeGame.AlsBottomRight.actionPerformed()");
		}
	}
	
	class AlsNewGame implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			AloitaUusiPeli();
		}
	}
	
}


