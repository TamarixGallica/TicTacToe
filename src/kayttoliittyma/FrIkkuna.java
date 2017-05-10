package kayttoliittyma;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class FrIkkuna extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton btNewGame = new JButton("New game");
	
//	private ArrayList<JButton> btNappulat = new ArrayList<JButton>();

//	Contains information on where markers have been placed
//	0 == empty, 1 == player, 2 == CPU
	private int[][] pieces = new int[3][3];

//	Contains buttons used to place markers
	private JButton[][] btSquareButtons = new JButton[3][3];

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
		

//		Initialize array containing data about pieces to zeroes (no piece set)
		for(int i = 0; i < pieces.length; i++)
		{
			for(int j = 0; j < pieces.length; j++)
			{
				pieces[i][j]=0;
			}
		}


//		Kutsutaan komponenttien asettelijaa
		setComponents();
		
//		Asetetaan ikkunan sulkemiselle oletusfunktio
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setComponents() {
		
		Container sisalto = this.getContentPane();
		sisalto.setLayout(null);

		sisalto.setVisible(true);

		for( int i = 0; i < btSquareButtons.length; i++)
		{
			for( int j = 0; j < btSquareButtons.length; j++)
			{
				JButton button = new JButton("");
				button.setBounds(i%3*100, j*100, 100, 100);
				btSquareButtons[i][j] = button;
				button.addActionListener(new AlsSquare(i, j));
				sisalto.add(button);
			}
		}



		btNewGame.addActionListener(new AlsNewGame());
		

		btNewGame.setBounds(0, 300, 300, 50);
		sisalto.add(btNewGame);
	}
	
	public void teeTietokoneenValinta() {

//		Initialize random number generator and variables for horizontal and vertical positions for CPU
		Random random = new Random();
		int horizontal = 0;
		int vertical = 0;

//		Randomly choose a square and continue until a free square is chosen (value == 0)
		do {
			horizontal = random.nextInt(3);
			vertical = random.nextInt(3);
		} while(pieces[horizontal][vertical] != 0);
		
//		Place CPU's piece on square found
		pieces[horizontal][vertical]=2;

		btSquareButtons[horizontal][vertical].setText("0");
		
	}
	
	private void AloitaUusiPeli() {

		numberOfChoicesMade = 0;

		for (int i = 0; i < btSquareButtons.length; i++) {
			for(int j = 0; j < btSquareButtons.length; j++) {
				btSquareButtons[i][j].setText("");
			}
		}

		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces.length; j++) {
				pieces[i][j]=0;
			}
		}
	}

	class AlsSquare implements ActionListener {

//		Position of this square is stored in these variables
		private int horizontal;
		private int vertical;

		public AlsSquare(int horizontal, int vertical) {

			this.horizontal = horizontal;
			this.vertical = vertical;

		}


		@Override
		public void actionPerformed(ActionEvent e) {
			if(numberOfChoicesMade < 3)
			{
				pieces[horizontal][vertical]=1;
				btSquareButtons[horizontal][vertical].setText("X");
				numberOfChoicesMade++;
				teeTietokoneenValinta();
			}
			System.out.println("Generic ActionListener triggered and placed a market at "+horizontal+" "+vertical);
		}
	}


	class AlsNewGame implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			AloitaUusiPeli();
		}
	}
	
}


