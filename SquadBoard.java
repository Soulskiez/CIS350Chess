package chess;

/*ChessBoard class */
public class SquadBoard implements ChessInterface {

	public int fromRow;
	public int toRow;
	public int fromCol;
	public int toCol;

	/* The chess board */
	private PieceInterface[][] board;

	/* The player which holds the piece */
	private Player player = Player.WHITE;

	public boolean valid = false;

	/* Instantiates the board and all the different pieces */
	public SquadBoard() {

		board = new PieceInterface[8][8];
		board[0][3] = new Rook(Player.BLACK);
		board[0][4] = new King(Player.BLACK);
		board[1][3] = new Knight(Player.BLACK);
		board[1][4] = new Knight(Player.BLACK);
		board[2][3] = new Pawn(Player.BLACK);
		board[2][4] = new Pawn(Player.BLACK);

		board[7][3] = new Rook(Player.WHITE);
		board[7][4] = new King(Player.WHITE);
		board[6][3] = new Knight(Player.WHITE);
		board[6][4] = new Knight(Player.WHITE);
		board[5][3] = new Pawn(Player.WHITE);
		board[5][4] = new Pawn(Player.WHITE);

	}

	/*******************************************************************
	 * This method determines if the game is over by checking if the
	 * King is in check on every side.
	 * 
	 * @return true if the game is complete and false otherwise
	 ******************************************************************/
	public boolean isComplete() {
		boolean complete = false;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j].type() == "King" && inCheck(board[i][j].player())) {
					complete = true;
				}
			}
		}
		return complete;
	}

	public boolean isValidMove(final Move move) {
		boolean valid = false;
		if (board[move.fromRow][move.fromColumn].isValidMove(move, board)) {
			valid = true;
		}

		return valid;

	}

	public void pawnUpgrade() {
		// boolean whitePawn = false;
		// boolean blackPawn = false;
		for (int i = 0; i < 7; i++) {
			if (board[0][i] != null) {
				if (board[0][i].type() == "Pawn") {
					board[0][i] = null;
					board[0][i] = new Queen(Player.WHITE);
				}
			}
			if (board[7][i] != null) {
				if (board[7][i].type() == "Pawn") {
					board[7][i] = null;
					board[7][i] = new Queen(Player.BLACK);
				}
			}
		}
	}

	/*******************************************************************
	 * This method moves the piece and updates it. 
	 * @param move which holds the
	 * position values for each button @throws
	 ******************************************************************/
	public void move(final Move move) {
		PieceInterface currentPiece = this.pieceAt(move.fromRow, move.fromColumn);
		try {
			PieceInterface newPiece = Piece.createPieceByType(currentPiece.type(), currentPiece.player());
			board[move.toRow][move.toColumn] = null;
			board[move.toRow][move.toColumn] = newPiece;
			// System.out.println("move");
			// System.out.println(newPiece.player());
			// System.out.println(newPiece.type());
			// System.out.println(currentPiece.player());
		} catch (Exception e) {
			System.out.println(e);
		}

		board[move.fromRow][move.fromColumn] = null;

		// else if(valid == false)
		// valid = true;
	}

	public void setNextPlayer() {
		player = player.next();
	}

	/*******************************************************************
	 * This method determines whether or not the King piece is in check
	 * by checking if the other pieces can capture it.
	 * 
	 * @param p the player which needs to verifies if it's in check
	 * @return if the player is in check
	 ******************************************************************/
	public boolean inCheck(final Player p) {

		// Important variables

		int tempRow = 0;
		int tempCol = 0;
		boolean inCheck = false;

		// Checks where the King is located on the board

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j].player() == p && board[i][j].type().equals("King")) {
					// Once the positions are found, stores
					// them in the two temporary variables!

					tempRow = i;
					tempCol = j;
				}
			}
		}

		// Looks for the other pieces around the board!
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				if (board[r][c].type() != null && r != tempRow && c != tempCol
						&& board[r][c].player() != board[tempRow][tempRow].player()) {
					// Called isValidMove for the piece and
					// determines if it can have access to p
					if (board[r][c].isValidMove(new Move(r, c, tempRow, tempCol), board)) {
						inCheck = true;
					}
				}
			}
		}

		return inCheck;
	}

	/*******************************************************************
	 * returns the current player.
	 * 
	 * @return the player which holds the piece
	 ******************************************************************/
	public Player currentPlayer() {
		return this.player;
	}

	/*******************************************************************
	 * returns the number of rows.
	 * 
	 * @return the number of rows
	 ******************************************************************/
	public int numRows() {
		return 8;
	}

	/*******************************************************************
	 * returns the number of columns.
	 * 
	 * @return the number of columns
	 ******************************************************************/
	public int numColumns() {
		return 8;
	}

	public PieceInterface pieceAt(final int row, final int column) {
		return board[row][column];
	}

}
