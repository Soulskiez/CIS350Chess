package chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;
import javax.swing.*;
//import java.awt.image.BufferedImage;

public class ChessActions extends JPanel {

	// private ArrayList<JButton> button = new ArrayList<JButton>();

	private boolean detect = false;
	public boolean newGameB = true;
	public boolean newGameC = false;
	private int row = 8;
	private int col = 8;
	private int nRow = 0;
	private int nCol = 0;

	private static final long serialVersionUID = 1L;

	/** The text representation for the pieces. **/
	/** For the black chess pieces. **/
	String bBishop = "Bishop";
	String bKing = "King";
	String bKnight = "Knight";
	String bPawn = "Pawn";
	String bQueen = "Queen";
	String bRook = "Rook";
	ImageIcon bOARD = new ImageIcon("chessboard.jpg");

	/** For the white chess Pieces. **/
	String wBishop = "Bishop";
	String wKing = "King";
	String wKnight = "Knight";
	String wPawn = "Pawn";
	String wQueen = "Queen";
	String wRook = "Rook";
	String blank = "";
	String oneclick = "1Click!";
	String twoclick = "2Click!";

	ImageIcon blankIcon = new ImageIcon("");

	private JButton[][] board;
	private ChessBoard model;
	private SquadBoard squadM;
	private KnightsBoard knightsM;

	// declare other instance variables as needed
	private ButtonListener buttonListener = new ButtonListener();

	private JButton quit;
	private JButton newGame;
	private JButton squadGame;
	private JButton knightsGame;
	// private JButton Undo;
	private JPanel center;
	private JPanel other;

	public ChessActions() {

		center = new JPanel();
		other = new JPanel();

		model = new ChessBoard();

		// quit button
		quit = new JButton("quit Game");
		// Squad Game button
		squadGame = new JButton("Squad Game");
		// Knights Game button
		knightsGame = new JButton("Knights Game");
		// New Game button
		newGame = new JButton("New Game");

		// Adding action listeners to the buttons
		quit.addActionListener((ActionListener) buttonListener);
		squadGame.addActionListener((ActionListener) buttonListener);
		knightsGame.addActionListener((ActionListener) buttonListener);
		newGame.addActionListener((ActionListener) buttonListener);

		newGame.setBackground(Color.WHITE);
		squadGame.setBackground(Color.WHITE);
		knightsGame.setBackground(Color.WHITE);
		quit.setBackground(Color.WHITE);

		other.add(newGame);
		other.add(squadGame);
		other.add(knightsGame);
		other.add(quit);
		other.setLayout(new GridLayout(3, 2));
		center.setLayout(new GridLayout(8, 8));

		// Instantiating the JButtons
		board = new JButton[this.row][this.col];
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				board[r][c] = new JButton();
			}
		}

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {

				// Adding colors for the design of the board
				if ((col % 2 != 0 && row % 2 != 0) || (col % 2 == 0 && row % 2 == 0)) {
					board[row][col].setBackground(Color.WHITE);
				} else {
					board[row][col].setBackground(Color.BLACK);
				}

				board[row][col].setPreferredSize(new Dimension(60, 60));
				board[row][col].setMargin(new Insets(0, 0, 0, 0));
				board[row][col].setBorder(null);
				board[row][col].addActionListener(buttonListener);
				center.add(board[row][col]);
				board[row][col].setFocusPainted(false);
			}
		}
		add(center, BorderLayout.CENTER);
		add(other, BorderLayout.SOUTH);

		displayBoard();
	}

	/*******************************************************************
	 * This method updates the board.
	 ******************************************************************/
	private void displayBoard() {

		// Scanning each slot on the board
		for (int r = 0; r < model.numRows(); r++) {
			for (int c = 0; c < model.numColumns(); c++) {

				// If the slot is not empty, there must be a piece there,
				// if there is, search for the type and the color and
				// set the appropriate icon.
				if (model.pieceAt(r, c) != null) {
					if ((model.pieceAt(r, c).type().equals("Bishop"))
							&& (model.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bBishop);
						board[r][c].setForeground(Color.DARK_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 6));
					}

					if ((model.pieceAt(r, c).type().equals("Bishop"))
							&& (model.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wBishop);
						board[r][c].setForeground(Color.LIGHT_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 6));
					}

					if ((model.pieceAt(r, c).type().equals("King"))
							&& (model.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bKing);
						board[r][c].setForeground(Color.DARK_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 6));
					}

					if ((model.pieceAt(r, c).type().equals("King"))
							&& (model.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wKing);
						board[r][c].setForeground(Color.LIGHT_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 6));
					}

					if ((model.pieceAt(r, c).type().equals("Queen"))
							&& (model.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bQueen);
						board[r][c].setForeground(Color.DARK_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 6));
					}

					if ((model.pieceAt(r, c).type().equals("Queen"))
							&& (model.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wQueen);
						board[r][c].setForeground(Color.LIGHT_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 6));
					}

					if ((model.pieceAt(r, c).type().equals("Pawn"))
							&& (model.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bPawn);
						board[r][c].setForeground(Color.DARK_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 6));
					}

					if ((model.pieceAt(r, c).type().equals("Pawn"))
							&& (model.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wPawn);
						board[r][c].setForeground(Color.LIGHT_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 6));
					}

					if ((model.pieceAt(r, c).type().equals("Knight"))
							&& (model.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bKnight);
						board[r][c].setForeground(Color.DARK_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 6));
					}

					if ((model.pieceAt(r, c).type().equals("Knight"))
							&& (model.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wKnight);
						board[r][c].setForeground(Color.LIGHT_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 6));
					}

					if ((model.pieceAt(r, c).type().equals("Rook"))
							&& (model.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bRook);
						board[r][c].setForeground(Color.DARK_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 6));
					}

					if ((model.pieceAt(r, c).type().equals("Rook"))
							&& (model.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wRook);
						board[r][c].setForeground(Color.LIGHT_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 6));
					}

				} else {
					board[r][c].setText(blank);
					board[r][c].setBorder(BorderFactory.createBevelBorder(0));
				}
			}
		}
	}

	private void newGame() {
		removeAll();
		center = new JPanel();
		other = new JPanel();

		newGameB = true;
		newGameC = false;

		model = new ChessBoard();

		// quit button
		quit = new JButton("quit Game");

		// Squad Game button
		squadGame = new JButton("Squad Game");

		// Knights Game button
		knightsGame = new JButton("Knights Game");

		// New Game button
		newGame = new JButton("New Game");

		// Adding action listeners to the buttons
		quit.addActionListener((ActionListener) buttonListener);
		squadGame.addActionListener((ActionListener) buttonListener);
		knightsGame.addActionListener((ActionListener) buttonListener);
		newGame.addActionListener((ActionListener) buttonListener);

		newGame.setBackground(Color.WHITE);
		squadGame.setBackground(Color.WHITE);
		knightsGame.setBackground(Color.WHITE);
		quit.setBackground(Color.WHITE);

		other.add(newGame);
		other.add(squadGame);
		other.add(knightsGame);
		other.add(quit);
		other.setLayout(new GridLayout(3, 2));
		center.setLayout(new GridLayout(8, 8));

		// Instantiating the JButtons
		board = new JButton[row][col];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				board[r][c] = new JButton();
			}
		}

		// Black Pieces
		board[0][0].setText(bRook);
		board[0][1].setText(bKnight);
		board[0][2].setText(bRook);
		board[0][3].setText(bQueen);
		board[0][4].setText(bKing);
		board[0][5].setText(bRook);
		board[0][6].setText(bKnight);
		board[0][7].setText(bRook);
		for (int i = 0; i < 8; i++) {
			board[1][i].setText(bPawn);
		}

		// White Pieces
		board[7][0].setText(wRook);
		board[7][1].setText(wKnight);
		board[7][2].setText(wBishop);
		board[7][3].setText(wQueen);
		board[7][4].setText(wKing);
		board[7][5].setText(wBishop);
		board[7][6].setText(wKnight);
		board[7][7].setText(wRook);
		for (int i = 0; i < 8; i++) {
			board[6][i].setText(wPawn);
		}

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {

				// Adding colors for the design of the board
				if ((col % 2 != 0 && row % 2 != 0) || (col % 2 == 0 && row % 2 == 0)) {
					board[row][col].setBackground(Color.WHITE);
				} else {
					board[row][col].setBackground(Color.BLACK);
				}

				board[row][col].setPreferredSize(new Dimension(60, 60));
				board[row][col].setMargin(new Insets(0, 0, 0, 0));
				board[row][col].setBorder(null);
				board[row][col].addActionListener(buttonListener);
				center.add(board[row][col]);
				board[row][col].setFocusPainted(false);
			}

		}
		add(center, BorderLayout.CENTER);
		add(other, BorderLayout.SOUTH);

		displayBoard();

		revalidate();
		repaint();

	}

	private void squadGame() {
		removeAll();
		center = new JPanel();
		other = new JPanel();
		newGameB = false;
		newGameC = false;

		squadM = new SquadBoard();

		// quit button
		quit = new JButton("quit Game");
		// Squad Game button
		squadGame = new JButton("Squad Game");
		// Knights Game button
		knightsGame = new JButton("Knights Game");
		// New Game button
		newGame = new JButton("New Game");

		// Adding action listeners to the buttons
		quit.addActionListener((ActionListener) buttonListener);
		squadGame.addActionListener((ActionListener) buttonListener);
		knightsGame.addActionListener((ActionListener) buttonListener);
		newGame.addActionListener((ActionListener) buttonListener);

		newGame.setBackground(Color.WHITE);
		squadGame.setBackground(Color.WHITE);
		knightsGame.setBackground(Color.WHITE);
		quit.setBackground(Color.WHITE);

		other.add(newGame);
		other.add(squadGame);
		other.add(knightsGame);
		other.add(quit);
		other.setLayout(new GridLayout(3, 2));
		center.setLayout(new GridLayout(8, 8));

		// Instantiating the JButtons
		board = new JButton[row][col];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				board[r][c] = new JButton();
			}
		}

		// Black Pieces
		board[0][3].setText(bRook);
		board[0][4].setText(bKing);
		board[1][3].setText(bKnight);
		board[1][4].setText(bKnight);
		board[2][3].setText(bPawn);
		board[2][4].setText(bPawn);

		// White Pieces
		board[7][3].setText(wRook);
		board[7][4].setText(wKing);
		board[6][3].setText(wKnight);
		board[6][4].setText(wKnight);
		board[5][3].setText(wPawn);
		board[5][4].setText(wPawn);

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {

				// Adding colors for the design of the board
				if ((col % 2 != 0 && row % 2 != 0) || (col % 2 == 0 && row % 2 == 0)) {
					board[row][col].setBackground(Color.WHITE);
				} else {
					board[row][col].setBackground(Color.BLACK);
				}

				board[row][col].setPreferredSize(new Dimension(60, 60));
				board[row][col].setMargin(new Insets(0, 0, 0, 0));
				board[row][col].setBorder(null);
				board[row][col].addActionListener(buttonListener);
				center.add(board[row][col]);
				board[row][col].setFocusPainted(false);
			}

		}
		add(center, BorderLayout.CENTER);
		add(other, BorderLayout.SOUTH);

		displaySquadBoard();

		revalidate();
		repaint();

	}

	private void displaySquadBoard() {

		// Scanning each slot on the board
		for (int r = 0; r < squadM.numRows(); r++) {
			for (int c = 0; c < squadM.numColumns(); c++) {

				// If the slot is not empty, there must be a
				// piece there, if there is, search for the type
				// and the color and set the appropriate icon.
				if (squadM.pieceAt(r, c) != null) {

					if ((squadM.pieceAt(r, c).type().equals("King"))
							&& (squadM.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bKing);
						board[r][c].setForeground(Color.DARK_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 6));
					}

					if ((squadM.pieceAt(r, c).type().equals("King"))
							&& (squadM.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wKing);
						board[r][c].setForeground(Color.LIGHT_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 6));
					}

					if ((squadM.pieceAt(r, c).type().equals("Pawn"))
							&& (squadM.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bPawn);
						board[r][c].setForeground(Color.DARK_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 6));
					}

					if ((squadM.pieceAt(r, c).type().equals("Pawn"))
							&& (squadM.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wPawn);
						board[r][c].setForeground(Color.LIGHT_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 6));
					}

					if ((squadM.pieceAt(r, c).type().equals("Knight"))
							&& (squadM.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bKnight);
						board[r][c].setForeground(Color.DARK_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 6));
					}

					if ((squadM.pieceAt(r, c).type().equals("Knight"))
							&& (squadM.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wKnight);
						board[r][c].setForeground(Color.LIGHT_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 6));
					}

					if ((squadM.pieceAt(r, c).type().equals("Rook"))
							&& (squadM.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bRook);
						board[r][c].setForeground(Color.DARK_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 6));
					}

					if ((squadM.pieceAt(r, c).type().equals("Rook"))
							&& (squadM.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wRook);
						board[r][c].setForeground(Color.LIGHT_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 6));
					}

				} else {
					board[r][c].setText(blank);
					board[r][c].setText(blank);
					board[r][c].setBorder(BorderFactory.createBevelBorder(0));
				}
			}
		}
	}

	private void knightsGame() {
		removeAll();
		center = new JPanel();
		other = new JPanel();

		newGameB = false;
		newGameC = true;

		knightsM = new KnightsBoard();

		// quit button
		quit = new JButton("quit Game");
		// Squad Game button
		squadGame = new JButton("Squad Game");
		// Knights Game button
		knightsGame = new JButton("Knights Game");
		// New Game button
		newGame = new JButton("New Game");

		// Adding action listeners to the buttons
		quit.addActionListener((ActionListener) buttonListener);
		squadGame.addActionListener((ActionListener) buttonListener);
		knightsGame.addActionListener((ActionListener) buttonListener);
		newGame.addActionListener((ActionListener) buttonListener);

		newGame.setBackground(Color.WHITE);
		squadGame.setBackground(Color.WHITE);
		knightsGame.setBackground(Color.WHITE);
		quit.setBackground(Color.WHITE);

		other.add(newGame);
		other.add(squadGame);
		other.add(knightsGame);
		other.add(quit);
		other.setLayout(new GridLayout(3, 2));
		center.setLayout(new GridLayout(8, 8));

		// Instantiating the JButtons
		board = new JButton[row][col];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				board[r][c] = new JButton();
			}
		}

		// Black Pieces
		board[0][3].setText(bRook);
		board[0][4].setText(bKing);
		board[1][3].setText(bKnight);
		board[1][4].setText(bKnight);
		board[2][3].setText(bPawn);
		board[2][4].setText(bPawn);

		// White Pieces
		board[7][3].setText(wRook);
		board[7][4].setText(wKing);
		board[6][3].setText(wKnight);
		board[6][4].setText(wKnight);
		board[5][3].setText(wPawn);
		board[5][4].setText(wPawn);

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {

				// Adding colors for the design of the board
				if ((col % 2 != 0 && row % 2 != 0) || (col % 2 == 0 && row % 2 == 0)) {
					board[row][col].setBackground(Color.WHITE);
				} else {
					board[row][col].setBackground(Color.BLACK);
				}

				board[row][col].setPreferredSize(new Dimension(60, 60));
				board[row][col].setMargin(new Insets(0, 0, 0, 0));
				board[row][col].setBorder(null);
				board[row][col].addActionListener(buttonListener);
				center.add(board[row][col]);
				board[row][col].setFocusPainted(false);
			}

		}
		add(center, BorderLayout.CENTER);
		add(other, BorderLayout.SOUTH);

		displayKnightsBoard();

		revalidate();
		repaint();

	}

	private void displayKnightsBoard() {

		// Scanning each slot on the board
		for (int r = 0; r < knightsM.numRows(); r++) {
			for (int c = 0; c < knightsM.numColumns(); c++) {

				// If the slot is not empty, there must be a piece
				// there, if there is, search for the type and the
				// color and set the appropriate icon.
				if (knightsM.pieceAt(r, c) != null) {

					if ((knightsM.pieceAt(r, c).type().equals("King"))
							&& (knightsM.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bKing);
					}

					if ((knightsM.pieceAt(r, c).type().equals("King"))
							&& (knightsM.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wKing);
					}

					if ((knightsM.pieceAt(r, c).type().equals("Pawn"))
							&& (knightsM.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bPawn);
					}
					
					if ((knightsM.pieceAt(r, c).type().equals("Pawn"))
							&& (knightsM.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wPawn);
					}

					if ((knightsM.pieceAt(r, c).type().equals("Knight"))
							&& (knightsM.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bKnight);
						board[r][c].setForeground(Color.DARK_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 6));
					}

					if ((knightsM.pieceAt(r, c).type().equals("Knight"))
							&& (knightsM.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wKnight);
						board[r][c].setForeground(Color.LIGHT_GRAY);
						board[r][c].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 6));
					}

					if ((knightsM.pieceAt(r, c).type().equals("Rook"))
							&& (knightsM.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bRook);
					}

					if ((knightsM.pieceAt(r, c).type().equals("Rook"))
							&& (knightsM.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wRook);
					}

				} else {
					board[r][c].setText(blank);
					board[r][c].setText(blank);
					board[r][c].setBorder(BorderFactory.createBevelBorder(0));
				}
			}
		}
	}

	public boolean gameOver() {
		boolean whiteKing = false;
		boolean blackKing = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (model.pieceAt(i, j) != null) {
					if (model.pieceAt(i, j).type() == "King" && model.pieceAt(i, j).player() == Player.WHITE) {
						whiteKing = true;
					} else if (model.pieceAt(i, j).type() == "King" && model.pieceAt(i, j).player() == Player.BLACK) {
						blackKing = true;
					}
				}
			}
		}
		return blackKing == whiteKing;
	}

	public boolean gameOverS() {
		boolean whiteKing = false;
		boolean blackKing = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (squadM.pieceAt(i, j) != null) {
					if (squadM.pieceAt(i, j).type() == "King" && squadM.pieceAt(i, j).player() == Player.WHITE) {
						whiteKing = true;
					} else if (squadM.pieceAt(i, j).type() == "King" && squadM.pieceAt(i, j).player() == Player.BLACK) {
						blackKing = true;
					}
				}
			}
		}
		return blackKing == whiteKing;
	}

	public boolean gameOverK() {
		boolean whiteKing = false;
		boolean blackKing = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (knightsM.pieceAt(i, j) != null) {
					if (knightsM.pieceAt(i, j).type() == "Knight" && knightsM.pieceAt(i, j).player() == Player.WHITE) {
						whiteKing = true;
					} else if (knightsM.pieceAt(i, j).type() == "Knight"
							&& knightsM.pieceAt(i, j).player() == Player.BLACK) {
						blackKing = true;
					}
				}
			}
		}
		return blackKing == whiteKing;
	}

	/**********************************************************************
	 * The button listener makes sure that when a button is clicked, the appropriate
	 * methods are called.
	 *********************************************************************/
	private class ButtonListener implements ActionListener {

		public void actionPerformed(final ActionEvent event) {
			Move tempMove;
			// If the user clicks on the quit button, quit the game
			if (event.getSource() == quit) {
				JOptionPane.showMessageDialog(null, "Goodbye, we are" + " sorry to see you go!", "Chess",
						JOptionPane.INFORMATION_MESSAGE, bOARD);
				System.exit(0);
			}
			if (event.getSource() == newGame) {
				newGame();
			}
			if (event.getSource() == squadGame) {
				squadGame();
			}

			if (event.getSource() == knightsGame) {
				knightsGame();
			}

			if (newGameB) {
				for (int i = 0; i < board.length; i++) {
					for (int j = 0; j < board[i].length; j++) {
						if (event.getSource() == board[i][j]) {
							if (!detect && model.pieceAt(i, j) != null) {
								nRow = i;
								nCol = j;
								detect = true;
								model.pawnUpgrade();
								displayBoard();
								if (!gameOver()) {
									JOptionPane.showMessageDialog(null, "Game Over" + " Goodbye", "Chess",
											JOptionPane.INFORMATION_MESSAGE, bOARD);
								}
							} else if (detect) {
								tempMove = new Move(nRow, i, nCol, j);
								if (model.pieceAt(i, j) == null && model.isValidMove(tempMove)) {
									model.move(tempMove);
									detect = false;
									model.pawnUpgrade();
									displayBoard();
									if (!gameOver()) {
										JOptionPane.showMessageDialog(null, "Game Over" + " Goodbye", "Chess",
												JOptionPane.INFORMATION_MESSAGE, bOARD);
									}
								} else if (model.pieceAt(i, j) != null
										&& model.pieceAt(i, j).player() != model.pieceAt(nRow, nCol).player()
										&& model.isValidMove(tempMove)) {
									System.out.println("you hit a piece");
									model.move(tempMove);
									detect = false;
									model.pawnUpgrade();
									displayBoard();
									if (!gameOver()) {
										JOptionPane.showMessageDialog(null, "Game Over" + " Goodbye", "Chess",
												JOptionPane.INFORMATION_MESSAGE, bOARD);
									}
								} else {
									detect = false;
								}
							}
						}
					}
				}
			} else if (newGameC) {
				for (int i = 0; i < board.length; i++) {
					for (int j = 0; j < board[i].length; j++) {
						if (event.getSource() == board[i][j]) {
							if (!detect && knightsM.pieceAt(i, j) != null) {
								nRow = i;
								nCol = j;
								detect = true;
								displayKnightsBoard();
								if (!gameOver()) {
									JOptionPane.showMessageDialog(null, "Game Over" + " Goodbye", "Chess",
											JOptionPane.INFORMATION_MESSAGE, bOARD);
								}
							} else if (detect) {
								tempMove = new Move(nRow, i, nCol, j);
								if (knightsM.pieceAt(i, j) == null && knightsM.isValidMove(tempMove)) {
									knightsM.move(tempMove);
									detect = false;
									displayKnightsBoard();
									if (!gameOver()) {
										JOptionPane.showMessageDialog(null, "Game Over" + " Goodbye", "Chess",
												JOptionPane.INFORMATION_MESSAGE, bOARD);
									}
								} else if (knightsM.pieceAt(i, j) != null
										&& knightsM.pieceAt(i, j).player() != knightsM.pieceAt(nRow, nCol).player()
										&& knightsM.isValidMove(tempMove)) {
									System.out.println("you hit a piece");
									knightsM.move(tempMove);
									detect = false;
									displayKnightsBoard();
									if (!gameOver()) {
										JOptionPane.showMessageDialog(null, "Game Over" + " Goodbye", "Chess",
												JOptionPane.INFORMATION_MESSAGE, bOARD);
									}
								} else {
									detect = false;
								}
							}
						}
					}
				}
			} else {
				for (int i = 0; i < board.length; i++) {
					for (int j = 0; j < board[i].length; j++) {
						if (event.getSource() == board[i][j]) {
							if (!detect && squadM.pieceAt(i, j) != null) {
								nRow = i;
								nCol = j;
								detect = true;
								squadM.pawnUpgrade();
								displaySquadBoard();
								if (!gameOverS()) {
									JOptionPane.showMessageDialog(null, "Game Over" + " Goodbye", "Chess",
											JOptionPane.INFORMATION_MESSAGE, bOARD);
								}
							} else if (detect) {
								tempMove = new Move(nRow, i, nCol, j);
								if (squadM.pieceAt(i, j) == null && squadM.isValidMove(tempMove)) {
									squadM.move(tempMove);
									detect = false;
									squadM.pawnUpgrade();
									displaySquadBoard();
									if (!gameOverS()) {
										JOptionPane.showMessageDialog(null, "Game Over" + " Goodbye", "Chess",
												JOptionPane.INFORMATION_MESSAGE, bOARD);
									}
								} else if (squadM.pieceAt(i, j) != null
										&& squadM.pieceAt(i, j).player() != squadM.pieceAt(nRow, nCol).player()
										&& squadM.isValidMove(tempMove)) {
									System.out.println("you hit a piece");
									squadM.move(tempMove);
									detect = false;
									squadM.pawnUpgrade();
									displaySquadBoard();
									if (!gameOverS()) {
										JOptionPane.showMessageDialog(null, "Game Over" + " Goodbye", "Chess",
												JOptionPane.INFORMATION_MESSAGE, bOARD);
									}
								} else {
									detect = false;
								}
							}
						}
					}
				}
			}
		}
	}
}
