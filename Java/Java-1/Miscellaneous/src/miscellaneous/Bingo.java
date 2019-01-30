package miscellaneous;
/* Final Project
   Name: John A Chrin
   Date: 2015/04/23
   Purpose: BEE EYE END GEE OH
   This program is a GUI of the following:
   A simple game of BINGO.
*/

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bingo extends JFrame {
    private JMenuBar menuBar;						// MENU BAR
    private JMenu menu;
    private JMenuItem newGame, quitGame;
    private JPanel mainPanel; 						// Panel contains every other panel
    private JPanel playerPanel; 					// Panel contains your bingo card
    private JButton btnGenerate; 					// User clicks this to generate a coordinate
    private JTextField txtGenerate; 					// Contains results of user button push
    private JButton[][] btnBingo = new JButton[5][5];
    private JButton[][] btnBingoTwo = new JButton[5][5];
    private Integer[] bingoNum = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
	    24 };
    Random randomGen = new Random();
    int[] pastNum = new int[24];
    int random;	// Counter FOR RANDOM NUMBER GENERATED ARRAY STORED LOCATION
    static int temp = 0;
    boolean isPossibleWin;

    // DRIVER / TESTER
    public static void main(String[] args) {
	new Bingo();							// Drafts up a game of bingo
    }

    // Default Constructor
    public Bingo() {
	// JFRAME VALUES (OUTSIDE BORDER WINDOW)
	setTitle("BINGO");
	setSize(1200, 200);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	menu = new JMenu("File");
	menuBar.add(menu);
	newGame = new JMenuItem("New Game");
	quitGame = new JMenuItem("Quit");
	menu.add(newGame);
	newGame.addActionListener(ae -> {
	    Bingo.this.dispose();
	    new Bingo();
	});

	menu.add(quitGame);
	quitGame.addActionListener(ae -> System.exit(0));

	// A METHOD THAT IS AN IMPORTED PANEL
	mainPanel = new JPanel();
	mainPanel.setLayout(new FlowLayout(1, 2, 3));
	buildPanel(btnBingo);
	generateButton();
	buildPanel(btnBingoTwo);
	add(mainPanel);
	menuBar.setVisible(true);
	setVisible(true);
    }

    // BUILD ALL YOUR JPANELS AND SETUP GAME
    public void buildPanel(JButton player[][]) {
	playerPanel = new JPanel(new GridLayout(5, 5)); 		// Makes a grid of buttons for a player.
	for (int i = 0; i < 5; i++) {					// For loop that goes through 5x5 Bingo card.
	    for (int j = 0; j < 5; j++) {
		player[i][j] = new JButton();				// Generates a button for current index position.
		if (player == btnBingo) {
		    player[i][j].addActionListener(e -> {			// Button presses change color of buttons when corresponding to generated number.
			for (int row = 0; row < 5; row++) {
			    for (int col = 0; col < 5; col++) {
				// IF THE NUMBER ON THE BUTTON = NUMBER IN TEXT GENERATION FIELD, CHANGE COLOR TO RED "GG NO RE"
				if (player[row][col].getText().equals(txtGenerate.getText())) {
				    player[row][col].setBackground(Color.RED);
				    checkWin(btnBingo);
				}
				if (btnBingoTwo[row][col].getText().equals(txtGenerate.getText())) {
				    btnBingoTwo[row][col].setBackground(Color.RED);
				    btnBingoTwo[row][col].doClick();
				    checkWin(btnBingoTwo);
				}
			    }
			}
		    });
		}
		playerPanel.add(player[i][j]);
		if (player == btnBingoTwo)
		    btnBingoTwo[i][j].setEnabled(false);
	    }
	}

	fillcard(player);
	mainPanel.add(playerPanel);
    }

    private void generateButton() {
	// Add the generate button
	btnGenerate = new JButton();
	btnGenerate.setText("Generate");
	// Add actionlistener for the generate button
	btnGenerate.addActionListener(e -> {

	    boolean repeatfound = false;			// Initializes a boolean to track if the Generate button is attempting to display a duplicate.
	    do {						// Checks if generated number is the same as any previous number.
		repeatfound = false;
		random = randomGen.nextInt(bingoNum.length) + 1;	// Stores a random number between 1-24.
		for (int i = 0; i < pastNum.length; i++) {
		    if (random == pastNum[i]) {		// If random number equals any number in pastNum, return true.
			repeatfound = true;
		    }
		}
		System.out.println("");
	    } while (repeatfound);
	    // STORE NUMBER IN NEXT INDEX OF STORED "PASTNUMBERS"
	    pastNum[temp] = random;
	    temp++;
	    txtGenerate.setText(Integer.toString(random));
	});

	// Add the generate textfield
	txtGenerate = new JTextField(4);
	txtGenerate.setEnabled(false);

	mainPanel.add(btnGenerate);
	mainPanel.add(txtGenerate);
    }

    private void checkWin(JButton player[][]) {
	// CHECK ALL THE HORIZONTAL ROWS!
	for (int i = 0; i < 5; i++) {
	    for (int j = 0; j < 5; j++) {
		if (player[i][j].getBackground() != Color.RED)
		    break;
		if (j == 4) {
		    if (player == btnBingo)
			victory();
		    if (player == btnBingoTwo)
			lose();
		}
	    }

	}
	// CHECK ALL THE VERTICAL ROWS!
	for (int i = 0; i < 5; i++) {
	    for (int j = 0; j < 5; j++) {
		if (player[j][i].getBackground() != Color.RED)
		    break;
		if (j == 4) {
		    if (player == btnBingo)
			victory();
		    if (player == btnBingoTwo)
			lose();
		}
	    }

	}
	// CHECK DIAGNAL!
	if (player[0][0].getBackground() == Color.RED && player[1][1].getBackground() == Color.RED
		&& player[2][2].getBackground() == Color.RED && player[3][3].getBackground() == Color.RED
		&& player[4][4].getBackground() == Color.RED) {
	    if (player == btnBingo)
		victory();
	    if (player == btnBingoTwo)
		lose();
	}
	if (player[0][4].getBackground() == Color.RED && player[1][3].getBackground() == Color.RED
		&& player[2][2].getBackground() == Color.RED && player[3][1].getBackground() == Color.RED
		&& player[4][0].getBackground() == Color.RED) {
	    if (player == btnBingo)
		victory();
	    if (player == btnBingoTwo)
		lose();
	}

    }

    // FILLS IN NEW BINGO CARDS WHEN GAME IS MADE!
    public void fillcard(JButton player[][]) {
	// YOUR BINGO CARD: SHUFFLE NUMBERS FROM BINGO NUMBERS
	for (int i = 0; i < bingoNum.length; i++) {			// Switches 2 values in the Bingo card's array randomly, 24 times.
	    int randomPosition = randomGen.nextInt(bingoNum.length);	// Generates a random index 0-23.
	    int temp = bingoNum[i];					// Temporarily stores output of the current index output of BingoNum[] array.
	    bingoNum[i] = bingoNum[randomPosition];			// Assigns the current index output to the randomPosition index output.
	    bingoNum[randomPosition] = temp;				// Assigns the randomPosition index output to the temp stored output.
	}
	// YOUR BINGO CARD: ASSIGNS BINGO NUMBERS TO BUTTONS
	int counter = 0;						// Local variable that iterates linearly through the random BingoNum[].
	for (int i = 0; i < 5; i++) {					// For loop that goes through 5x5 Bingo card.
	    for (int j = 0; j < 5; j++) {
		if ((i == 2) && (j == 2)) {
		    player[2][2].setText("FREE SPACE");			// Assigns FREE SPACE when appropriate.
		    player[2][2].setBackground(Color.RED);		// Assigns an already completed value to the FREE SPACE.
		    j++;
		}
		player[i][j].setText(bingoNum[counter].toString());	// Assigns the current index of the for loop a value from BingoNum[].
		counter++;						// Increments the counter to go through all 24 indexes.
	    }
	}
    }

    // THIS JFRAME POPS UP IF YOU win!
    private void victory() {
	JFrame win = new JFrame();
	JPanel panel = new JPanel();

	win.setTitle("WINNER");
	win.setSize(250, 170);
	win.setLocationRelativeTo(null);
	win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	panel.setLayout(new FlowLayout(1, 2, 3));
	JButton btnLose = new JButton("Feeling Lucky?");
	panel.add(btnLose);
	btnLose.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent ae) {
		// NEW GAME
		Bingo.this.dispose();
		new Bingo();
		win.dispose();
	    }
	});
	win.add(panel);
	win.setVisible(true);
    }

    // THIS JFRAME POPS UP IF YOU lose.
    private void lose() {
	JFrame lose = new JFrame();
	JPanel panel = new JPanel();

	lose.setTitle("LOSER");
	lose.setSize(250, 170);
	lose.setLocationRelativeTo(null);
	lose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	panel.setLayout(new FlowLayout(1, 2, 3));
	JButton btnLose = new JButton("Try Again?");
	panel.add(btnLose);
	btnLose.addActionListener(ae -> {
	    // NEW GAME
	    Bingo.this.dispose();
	    new Bingo();
	    lose.dispose();
	});
	lose.add(panel);
	lose.setVisible(true);
    }
}
