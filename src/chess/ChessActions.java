package chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * Constructor for the ChessActions class, establishes the
 * 
 * @author Tyler Solnikowski, Kanoa Ellis, Kayla Davis
 * @version October 19th, 2017
 * 
 */

public class ChessActions extends JPanel {
	// ArrayList to store the button types for the board
	private ArrayList<JButton> button = new ArrayList<JButton>();

	private boolean detect;
	private int row = 0;
	private int col = 0;

	// For the black chess pieces
	private String bBishop = "bBishop";
	private String bKing = "bKing";
	private String bKnight = "bKnight";
	private String bPawn = "bPawn";
	private String bQueen = "bQueen";
	private String bRook = "bRook";
	private ImageIcon BOARD = new ImageIcon("chessboard.jpg");

	// For the white chess Pieces
	private String wBishop = "wBishop";
	private String wKing = "wKing";
	private String wKnight = "wKnight";
	private String wPawn = "wPawn";
	private String wQueen = "wQueen";
	private String wRook = "wRook";
	private String blank = "";

	private JButton[][] board;
	private ChessBoard model;

	private ButtonListener buttonListener = new ButtonListener();

	private JButton Quit;
	private JButton newGame;
	private JButton Undo;
	private JPanel Center;
	private JPanel Other;

	public ChessActions() {

		Center = new JPanel();
		Other = new JPanel();

		model = new ChessBoard();

		// Quit button
		Quit = new JButton("Quit Game");

		// New Game button
		newGame = new JButton("New Game");

		// Adding action listeners to the buttons
		Quit.addActionListener((ActionListener) buttonListener);
		newGame.addActionListener((ActionListener) buttonListener);

		newGame.setBackground(Color.WHITE);
		Quit.setBackground(Color.WHITE);

		Other.add(newGame);
		Other.add(Quit);
		Other.setLayout(new GridLayout(3, 2));
		Center.setLayout(new GridLayout(8, 8));

		// Instantiating the JButtons
		board = new JButton[8][8];
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
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
		// Set white pawns
		for (int i = 0; i < 8; i++) {
			board[6][i].setText(wPawn);
		}
		// Set black pawns
		for (int i = 0; i < 8; i++) {
			board[1][i].setText(bPawn);
		}

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {

				// Adding colors for the design of the board
				if ((col % 2 == 1 && row % 2 == 1) || (col % 2 == 0 && row % 2 == 0)) {
					board[row][col].setBackground(Color.WHITE);
				} else {
					board[row][col].setBackground(Color.BLACK);
				}
				// setting the display size
				board[row][col].setPreferredSize(new Dimension(60, 60));
				board[row][col].setMargin(new Insets(0, 0, 0, 0));
				board[row][col].setBorder(null);
				board[row][col].addActionListener(buttonListener);
				Center.add(board[row][col]);
				board[row][col].setFocusPainted(false);
			}

		}
		add(Center, BorderLayout.CENTER);
		add(Other, BorderLayout.SOUTH);

		displayBoard();
	}

	/**
	 * A method that updates the chess board to display pieces, called after actions
	 * to reflect moved pieces and other actions so they are displayed for the user.
	 */
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
					}

					if ((model.pieceAt(r, c).type().equals("Bishop"))
							&& (model.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wBishop);
					}

					if ((model.pieceAt(r, c).type().equals("King"))
							&& (model.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bKing);
					}

					if ((model.pieceAt(r, c).type().equals("King"))
							&& (model.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wKing);
					}

					if ((model.pieceAt(r, c).type().equals("Queen"))
							&& (model.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bQueen);
					}

					if ((model.pieceAt(r, c).type().equals("Queen"))
							&& (model.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wQueen);
					}

					if ((model.pieceAt(r, c).type().equals("Pawn"))
							&& (model.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bPawn);
					}

					if ((model.pieceAt(r, c).type().equals("Pawn"))
							&& (model.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wPawn);
					}

					if ((model.pieceAt(r, c).type().equals("Knight"))
							&& (model.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bKnight);
					}

					if ((model.pieceAt(r, c).type().equals("Knight"))
							&& (model.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wKnight);
					}

					if ((model.pieceAt(r, c).type().equals("Rook"))
							&& (model.pieceAt(r, c).player() == (Player.BLACK))) {
						board[r][c].setText(bRook);
					}

					if ((model.pieceAt(r, c).type().equals("Rook"))
							&& (model.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wRook);
					}

				} else {
					board[r][c].setText(blank);
				}
			}
		}
	}

	/**
	 * Method to instantiate a New Game, resets the board back to the original piece
	 * layout.
	 *
	 */
	private void NewGame() {
		removeAll();
		Center = new JPanel();
		Other = new JPanel();

		model = new ChessBoard();

		// Quit button
		Quit = new JButton("Quit Game");

		// New Game button
		newGame = new JButton("New Game");

		// Adding action listeners to the buttons
		Quit.addActionListener((ActionListener) buttonListener);
		newGame.addActionListener((ActionListener) buttonListener);

		newGame.setBackground(Color.WHITE);
		Quit.setBackground(Color.WHITE);

		Other.add(newGame);
		Other.add(Quit);
		Other.setLayout(new GridLayout(3, 2));
		Center.setLayout(new GridLayout(8, 8));

		// Instantiating the JButtons
		board = new JButton[8][8];
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
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
				if ((col % 2 == 1 && row % 2 == 1) || (col % 2 == 0 && row % 2 == 0)) {
					board[row][col].setBackground(Color.WHITE);
				} else {
					board[row][col].setBackground(Color.BLACK);
				}

				board[row][col].setPreferredSize(new Dimension(60, 60));
				board[row][col].setMargin(new Insets(0, 0, 0, 0));
				board[row][col].setBorder(null);
				board[row][col].addActionListener(buttonListener);
				Center.add(board[row][col]);
				board[row][col].setFocusPainted(false);
			}

		}
		add(Center, BorderLayout.CENTER);
		add(Other, BorderLayout.SOUTH);

		displayBoard();

		revalidate();
		repaint();

	}

	/**
	 * ButtonListener reads in actions from click events by implementing
	 * ActionListener. Method contains the various actions taken depending on what
	 * button has been clicked, such as moving pieces, quitting, creating a new
	 * game, ect.
	 **/
	private class ButtonListener implements ActionListener {
		/**
		 * Method to find actions and their sources in order to read it in for
		 * appropriate methods to be called.
		 * 
		 * @param event
		 *            A button click on the GUI read in to determine actions.
		 **/
		public void actionPerformed(final ActionEvent event) {

			// Creating temporary variables to help.
			Move tempMove;
			Piece movePiece;

			// If the user clicks on the quit button, quit the game
			if (event.getSource() == Quit) {

				JOptionPane.showMessageDialog(null, "Goodbye", "Chess", JOptionPane.INFORMATION_MESSAGE, BOARD);

				System.exit(0);
			}
			// Resets a new game when clicked
			if (event.getSource() == newGame) {
				JOptionPane.showMessageDialog(null, "Welcome", "Chess", JOptionPane.INFORMATION_MESSAGE, BOARD);

				NewGame();
			}

			// trying to move pieces, needs work still. Pieces aren't moving.
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {

					// If the button is pressed, determine if it's still the same
					// player.
					if (event.getSource() == board[i][j]) {
						if (!detect && model.pieceAt(i, j) != null
								&& model.pieceAt(i, j).player() == model.currentPlayer()) {

							// Saves the from row and from column
							row = i;
							col = j;

							// Sets the boolean to true for the second
							// click
							detect = true;

						}

						// If detect is true, the player is trying to move a piece
						if (detect) {
							tempMove = new Move(row, col, i, j);

							// If there is not a piece there, make sure that the move is valid before moving
							// the piece to the desired location.

							if (model.pieceAt(i, j) == null) {
								if (model.isValidMove(tempMove)) {
									model.move(tempMove);
									model.setNextPlayer();
									detect = false;
									displayBoard();
								} else {
									JOptionPane.showMessageDialog(null, "Wrong move", "Chess",
											JOptionPane.INFORMATION_MESSAGE, BOARD);
									detect = false;
								}
							}
							// If there is a piece there, make sure that the move is valid before moving the
							// piece to the desired location, and most importantly, make sure that the
							// players are different.
							else {
								if (model.pieceAt(row, col).player() != model.pieceAt(i, j).player()) {
									if (model.isValidMove(tempMove)) {
										model.move(tempMove);
										model.setNextPlayer();
										detect = false;
										displayBoard();
									} else {
										JOptionPane.showMessageDialog(null, "Wrong move", "Chess",
												JOptionPane.INFORMATION_MESSAGE, BOARD);
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
}
