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

	private ArrayList <JButton> button = new ArrayList<JButton>();
	
	private boolean detect;
	private int row = 8;
	private int col = 8;

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

	// declare other instance variables as needed
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

					if ((model.pieceAt(r, c).type().equals("Pawn")) && (model.pieceAt(r, c).player() == (Player.WHITE)))
						board[r][c].setText(wPawn);

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

	/***********************************************************************
	 * The button listener makes sure that when a button is clicked, the
	 * appropriate methods are called.
	 **********************************************************************/
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Move tempMove = null;
			Piece movePiece;
			detect = false;
			int nRow = 0;
			int nCol = 0;
			
			
			// If the user clicks on the quit button, quit the game

			if (event.getSource() == Quit) {

				JOptionPane.showMessageDialog(null, "Goodbye, we are" + " sorry to see you go!", "Chess",
						JOptionPane.INFORMATION_MESSAGE, BOARD);

				System.exit(0);
			}

			if (event.getSource() == newGame) {
				JOptionPane.showMessageDialog(null, "Welcome to the Game" + " of Chess", "Chess",
						JOptionPane.INFORMATION_MESSAGE, BOARD);

				NewGame();
			}
			
			for(int i = 0; i < board.length; i++) {
				for(int j = 0; j < board[i].length; j++) {
					if(event.getSource() == board[i][j]) {
						tempMove = new Move(i, 0, j, 0);
						if(!detect && model.pieceAt(i, j) != null) {
							nRow = i;
							nCol = j;
							model.move(tempMove);
							detect = true;
							displayBoard();
						}
						if(detect) {
							tempMove = new Move(row, i, col, j);
							
							if(model.pieceAt(i, j) == null) {
								model.move(tempMove);
								detect = false;
								displayBoard();
							}
							else {
								detect = false;
							}
						}
						
					}	
				}
			}
			
			
			
			
		}
	}
}