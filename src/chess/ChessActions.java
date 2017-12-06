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

public class ChessActions extends JPanel {

	private ArrayList<JButton> button = new ArrayList<JButton>();

	private boolean detect = false;
	public boolean newGameB = true;
	public boolean newGameC = false;
	private int row = 8;
	private int col = 8;
	private int nRow = 0;
	private int nCol = 0;

	private static final long serialVersionUID = 1L;

	/** The text representation for the pieces **/
	/** For the black chess pieces **/
	String bBishop = "bBishop";
	String bKing = "bKing";
	String bKnight = "bKnight";
	String bPawn = "bPawn";
	String bQueen = "bQueen";
	String bRook = "bRook";
	ImageIcon BOARD = new ImageIcon("chessboard.jpg");

	/** For the white chess Pieces **/
	String wBishop = "wBishop";
	String wKing = "wKing";
	String wKnight = "wKnight";
	String wPawn = "wPawn";
	String wQueen = "wQueen";
	String wRook = "wRook";
	String blank = "";
	String oneclick = "1Click!";
	String twoclick = "2Click!";

	ImageIcon blankIcon = new ImageIcon("");

	private JButton[][] board;
	private ChessBoard model;
	private SquadBoard squadM;
	private KnightsBoard KnightsM;

	// declare other instance variables as needed
	private ButtonListener buttonListener = new ButtonListener();

	private JButton Quit;
	private JButton newGame;
	private JButton squadGame;
	private JButton KnightsGame;
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
		board = new JButton[this.row][this.col];
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				board[r][c] = new JButton();
			}
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
	}

	/*******************************************************************
	 * This method updates the board
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
							&& (model.pieceAt(r, c).player() == (Player.BLACK)))
						board[r][c].setText(bBishop);

					if ((model.pieceAt(r, c).type().equals("Bishop"))
							&& (model.pieceAt(r, c).player() == (Player.WHITE)))
						board[r][c].setText(wBishop);

					if ((model.pieceAt(r, c).type().equals("King")) && (model.pieceAt(r, c).player() == (Player.BLACK)))
						board[r][c].setText(bKing);

					if ((model.pieceAt(r, c).type().equals("King")) && (model.pieceAt(r, c).player() == (Player.WHITE)))
						board[r][c].setText(wKing);

					if ((model.pieceAt(r, c).type().equals("Queen"))
							&& (model.pieceAt(r, c).player() == (Player.BLACK)))
						board[r][c].setText(bQueen);

					if ((model.pieceAt(r, c).type().equals("Queen"))
							&& (model.pieceAt(r, c).player() == (Player.WHITE)))
						board[r][c].setText(wQueen);

					if ((model.pieceAt(r, c).type().equals("Pawn")) && (model.pieceAt(r, c).player() == (Player.BLACK)))
						board[r][c].setText(bPawn);
					if (r == 5 && c == 5) {
						// System.out.println(model.pieceAt(r, c).type());
						// System.out.println(model.pieceAt(r, c).player());
					}
					if ((model.pieceAt(r, c).type().equals("Pawn"))
							&& (model.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wPawn);
					}

					if ((model.pieceAt(r, c).type().equals("Knight"))
							&& (model.pieceAt(r, c).player() == (Player.BLACK)))
						board[r][c].setText(bKnight);

					if ((model.pieceAt(r, c).type().equals("Knight"))
							&& (model.pieceAt(r, c).player() == (Player.WHITE)))
						board[r][c].setText(wKnight);

					if ((model.pieceAt(r, c).type().equals("Rook")) && (model.pieceAt(r, c).player() == (Player.BLACK)))
						board[r][c].setText(bRook);

					if ((model.pieceAt(r, c).type().equals("Rook")) && (model.pieceAt(r, c).player() == (Player.WHITE)))
						board[r][c].setText(wRook);

				} else {
					board[r][c].setText(blank);
				}
			}
		}
	}

	private void NewGame() {
		removeAll();
		Center = new JPanel();
		Other = new JPanel();
		
		newGameB = true;
		newGameC = false;

		model = new ChessBoard();

		// Quit button
		Quit = new JButton("Quit Game");

		// Squad Game button
		squadGame = new JButton("Squad Game");

		// Knights Game button
		KnightsGame = new JButton("Knights Game");

		// New Game button
		newGame = new JButton("New Game");

		// Adding action listeners to the buttons
		Quit.addActionListener((ActionListener) buttonListener);
		squadGame.addActionListener((ActionListener) buttonListener);
		KnightsGame.addActionListener((ActionListener) buttonListener);
		newGame.addActionListener((ActionListener) buttonListener);

		newGame.setBackground(Color.WHITE);
		squadGame.setBackground(Color.WHITE);
		KnightsGame.setBackground(Color.WHITE);
		Quit.setBackground(Color.WHITE);

		Other.add(newGame);
		Other.add(squadGame);
		Other.add(KnightsGame);
		Other.add(Quit);
		Other.setLayout(new GridLayout(3, 2));
		Center.setLayout(new GridLayout(8, 8));

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

	private void squadGame() {
		removeAll();
		Center = new JPanel();
		Other = new JPanel();
		newGameB = false;
		newGameC = false;

		squadM = new SquadBoard();

		// Quit button
		Quit = new JButton("Quit Game");
		// Squad Game button
		squadGame = new JButton("Squad Game");
		// Knights Game button
		KnightsGame = new JButton("Knights Game");
		// New Game button
		newGame = new JButton("New Game");

		// Adding action listeners to the buttons
		Quit.addActionListener((ActionListener) buttonListener);
		squadGame.addActionListener((ActionListener) buttonListener);
		KnightsGame.addActionListener((ActionListener) buttonListener);
		newGame.addActionListener((ActionListener) buttonListener);

		newGame.setBackground(Color.WHITE);
		squadGame.setBackground(Color.WHITE);
		KnightsGame.setBackground(Color.WHITE);
		Quit.setBackground(Color.WHITE);

		Other.add(newGame);
		Other.add(squadGame);
		Other.add(KnightsGame);
		Other.add(Quit);
		Other.setLayout(new GridLayout(3, 2));
		Center.setLayout(new GridLayout(8, 8));

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

		displaySquadBoard();

		revalidate();
		repaint();

	}

	private void displaySquadBoard() {

		// Scanning each slot on the board
		for (int r = 0; r < squadM.numRows(); r++) {
			for (int c = 0; c < squadM.numColumns(); c++) {

				// If the slot is not empty, there must be a piece there,
				// if there is, search for the type and the color and
				// set the appropriate icon.
				if (squadM.pieceAt(r, c) != null) {

					if ((squadM.pieceAt(r, c).type().equals("King"))
							&& (squadM.pieceAt(r, c).player() == (Player.BLACK)))
						board[r][c].setText(bKing);

					if ((squadM.pieceAt(r, c).type().equals("King"))
							&& (squadM.pieceAt(r, c).player() == (Player.WHITE)))
						board[r][c].setText(wKing);

					if ((squadM.pieceAt(r, c).type().equals("Pawn"))
							&& (squadM.pieceAt(r, c).player() == (Player.BLACK)))
						board[r][c].setText(bPawn);
					if (r == 5 && c == 5) {
						// System.out.println(model.pieceAt(r, c).type());
						// System.out.println(model.pieceAt(r, c).player());
					}
					if ((squadM.pieceAt(r, c).type().equals("Pawn"))
							&& (squadM.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wPawn);
					}

					if ((squadM.pieceAt(r, c).type().equals("Knight"))
							&& (squadM.pieceAt(r, c).player() == (Player.BLACK)))
						board[r][c].setText(bKnight);

					if ((squadM.pieceAt(r, c).type().equals("Knight"))
							&& (squadM.pieceAt(r, c).player() == (Player.WHITE)))
						board[r][c].setText(wKnight);

					if ((squadM.pieceAt(r, c).type().equals("Rook"))
							&& (squadM.pieceAt(r, c).player() == (Player.BLACK)))
						board[r][c].setText(bRook);

					if ((squadM.pieceAt(r, c).type().equals("Rook"))
							&& (squadM.pieceAt(r, c).player() == (Player.WHITE)))
						board[r][c].setText(wRook);

				} else {
					board[r][c].setText(blank);
				}
			}
		}
	}

	private void KnightsGame() {
		removeAll();
		Center = new JPanel();
		Other = new JPanel();
		
		newGameB = false;
		newGameC = true;

		KnightsM = new KnightsBoard();

		// Quit button
		Quit = new JButton("Quit Game");
		// Squad Game button
		squadGame = new JButton("Squad Game");
		// Knights Game button
		KnightsGame = new JButton("Knights Game");
		// New Game button
		newGame = new JButton("New Game");

		// Adding action listeners to the buttons
		Quit.addActionListener((ActionListener) buttonListener);
		squadGame.addActionListener((ActionListener) buttonListener);
		KnightsGame.addActionListener((ActionListener) buttonListener);
		newGame.addActionListener((ActionListener) buttonListener);

		newGame.setBackground(Color.WHITE);
		squadGame.setBackground(Color.WHITE);
		KnightsGame.setBackground(Color.WHITE);
		Quit.setBackground(Color.WHITE);

		Other.add(newGame);
		Other.add(squadGame);
		Other.add(KnightsGame);
		Other.add(Quit);
		Other.setLayout(new GridLayout(3, 2));
		Center.setLayout(new GridLayout(8, 8));

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

		displayKnightsBoard();

		revalidate();
		repaint();

	}

	private void displayKnightsBoard() {

		// Scanning each slot on the board
		for (int r = 0; r < KnightsM.numRows(); r++) {
			for (int c = 0; c < KnightsM.numColumns(); c++) {

				// If the slot is not empty, there must be a piece there,
				// if there is, search for the type and the color and
				// set the appropriate icon.
				if (KnightsM.pieceAt(r, c) != null) {

					if ((KnightsM.pieceAt(r, c).type().equals("King"))
							&& (KnightsM.pieceAt(r, c).player() == (Player.BLACK)))
						board[r][c].setText(bKing);

					if ((KnightsM.pieceAt(r, c).type().equals("King"))
							&& (KnightsM.pieceAt(r, c).player() == (Player.WHITE)))
						board[r][c].setText(wKing);

					if ((KnightsM.pieceAt(r, c).type().equals("Pawn"))
							&& (KnightsM.pieceAt(r, c).player() == (Player.BLACK)))
						board[r][c].setText(bPawn);
					if (r == 5 && c == 5) {
						// System.out.println(model.pieceAt(r, c).type());
						// System.out.println(model.pieceAt(r, c).player());
					}
					if ((KnightsM.pieceAt(r, c).type().equals("Pawn"))
							&& (KnightsM.pieceAt(r, c).player() == (Player.WHITE))) {
						board[r][c].setText(wPawn);
					}

					if ((KnightsM.pieceAt(r, c).type().equals("Knight"))
							&& (KnightsM.pieceAt(r, c).player() == (Player.BLACK)))
						board[r][c].setText(bKnight);

					if ((KnightsM.pieceAt(r, c).type().equals("Knight"))
							&& (KnightsM.pieceAt(r, c).player() == (Player.WHITE)))
						board[r][c].setText(wKnight);

					if ((KnightsM.pieceAt(r, c).type().equals("Rook"))
							&& (KnightsM.pieceAt(r, c).player() == (Player.BLACK)))
						board[r][c].setText(bRook);

					if ((KnightsM.pieceAt(r, c).type().equals("Rook"))
							&& (KnightsM.pieceAt(r, c).player() == (Player.WHITE)))
						board[r][c].setText(wRook);

				} else {
					board[r][c].setText(blank);
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
		if (blackKing == whiteKing) {
			return true;
		} else {
			return false;
		}
	}
	
	
		

	/***********************************************************************
	 * The button listener makes sure that when a button is clicked, the appropriate
	 * methods are called.
	 **********************************************************************/
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			Move tempMove;
			Piece movePiece;
			// detect = false;

			// If the user clicks on the quit button, quit the game

			if (event.getSource() == Quit) {

				JOptionPane.showMessageDialog(null, "Goodbye, we are" + " sorry to see you go!", "Chess",
						JOptionPane.INFORMATION_MESSAGE, BOARD);

				System.exit(0);
			}

			if (event.getSource() == newGame) {
				// JOptionPane.showMessageDialog(null, "Welcome to the Game" + " of Chess",
				// "Chess",
				// JOptionPane.INFORMATION_MESSAGE, BOARD);

				NewGame();
			}
			if (event.getSource() == squadGame) {
				squadGame();
			}
			
			if (event.getSource() == KnightsGame) {
				KnightsGame();
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
											JOptionPane.INFORMATION_MESSAGE, BOARD);
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
												JOptionPane.INFORMATION_MESSAGE, BOARD);
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
												JOptionPane.INFORMATION_MESSAGE, BOARD);
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
							if (!detect && KnightsM.pieceAt(i, j) != null) {
								nRow = i;
								nCol = j;
								detect = true;
								displayKnightsBoard();
							} else if (detect) {
								tempMove = new Move(nRow, i, nCol, j);

								if (KnightsM.pieceAt(i, j) == null && KnightsM.isValidMove(tempMove)) {

									KnightsM.move(tempMove);
									detect = false;
									displayKnightsBoard();

								} else if (KnightsM.pieceAt(i, j) != null
										&& KnightsM.pieceAt(i, j).player() != KnightsM.pieceAt(nRow, nCol).player()
										&& KnightsM.isValidMove(tempMove)) {
									System.out.println("you hit a piece");
									KnightsM.move(tempMove);
									detect = false;
									displayKnightsBoard();

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
								displaySquadBoard();
							} else if (detect) {
								tempMove = new Move(nRow, i, nCol, j);

								if (squadM.pieceAt(i, j) == null && squadM.isValidMove(tempMove)) {

									squadM.move(tempMove);
									detect = false;
									displaySquadBoard();

								} else if (squadM.pieceAt(i, j) != null
										&& squadM.pieceAt(i, j).player() != squadM.pieceAt(nRow, nCol).player()
										&& squadM.isValidMove(tempMove)) {
									System.out.println("you hit a piece");
									squadM.move(tempMove);
									detect = false;
									displaySquadBoard();

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