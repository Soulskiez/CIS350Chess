package chess;

public abstract class Piece implements PieceInterface {
	// A variable to determine which side a given piece is.
	private Player player;

	/**
	 * A method that sets the player to the correct player.
	 * 
	 * @param player
	 *            Variable to determine which side the piece belongs to.
	 */
	protected Piece(final Player player) {
		this.player = player;
	}

	/**
	 * Method to return the player.
	 * 
	 * @return player Variable to determine which side the piece belongs to.
	 */
	public Player player() {
		return player;
	}

	/**
	 * Abstract method for returning the String of the pieces type.
	 * 
	 */
	public abstract String type();

	/**
	 * Method that returns whether the movement of a given piece is allowed
	 * for that piece.
	 * 
	 * @param move
	 *            A specific move entered by the user.
	 * @param board
	 *            A 2D array of pieces.
	 * @return If the given move was a valid move.
	 */
	public boolean isValidMove(final Move move, final Piece[][] board) {
		boolean valid = false;

		if ((move.toRow != move.fromRow) || (move.fromColumn != move.toColumn)) {
			if (board[move.fromRow][move.fromColumn] == this) {
				if (board[move.toRow][move.toColumn] != null) {
					if (board[move.fromRow][move.fromColumn].player() != board[move.toRow][move.toColumn].player()) {
						valid = true;
					}
				} else {
					valid = false;
				}
			}
		}
		return valid;
	}

	public static PieceInterface createPieceByType(final String type, final Player player) throws Exception {
		switch (type) {
		case "Pawn":
			return new Pawn(player);
		case "Rook":
			return new Rook(player);
		case "Queen":
			return new Queen(player);
		case "Knight":
			return new Knight(player);
		case "King":
			return new King(player);
		case "Bishop":
			return new Bishop(player);
		default:
			break;

		}
		throw new Exception("Invalid Piece Type");

	}

}