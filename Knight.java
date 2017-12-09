package chess;

public class Knight extends Piece {
	// A variable to determine which side a given piece is.
	// private Player player;

	/**
	 * A method that sets the player to the correct player.
	 * 
	 * @param player
	 *            Variable to determine which side the piece belongs to.
	 */
	protected Knight(final Player player) {
		super(player);
	}

	/**
	 * Method to return the player.
	 * 
	 * @return player Variable to determine which side the piece belongs to.
	 */
	// @Override
	// public Player player() {
	// return player;
	// }

	/**
	 * Method that returns the type of the piece as a string.
	 * 
	 * @return The type of the piece as a string
	 */
	@Override
	public String type() {
		return "Knight";
	}

	/**
	 * Method that will return whether the movement of a given piece
	 * is allowed for that piece.
	 * 
	 * @param move
	 *            A specific move entered by the user.
	 * @param board
	 *            A 2D array of pieces.
	 * @return If the given move was a valid move.
	 */
	public boolean isValidMove(final Move move, final PieceInterface[][] board) {
		boolean valid = false;
		// Right 2 up 1
		if (move.toColumn == move.fromColumn + 2 && move.toRow == move.fromRow - 1) {
			if (board[move.toRow][move.toColumn] == null) {
				valid = true;
			} else {
				if (board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player()) {
					valid = true;
				} else {
					valid = false;
				}
			}
		}
		// Right 2 down 1
		if (move.toColumn == move.fromColumn + 2 && move.toRow == move.fromRow + 1) {
			if (board[move.toRow][move.toColumn] == null) {
				valid = true;
			} else {
				if (board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player()) {
					valid = true;
				} else {
					valid = false;
				}
			}
		}
		// Up 2 right 1
		if (move.toRow == move.fromRow - 2 && move.toColumn == move.fromColumn + 1) {
			if (board[move.toRow][move.toColumn] == null) {
				valid = true;
			} else {
				if (board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player()) {
					valid = true;
				} else {
					valid = false;
				}
			}
		}
		// Up 2 left 1
		if (move.toRow == move.fromRow - 2 && move.toColumn == move.fromColumn - 1) {
			if (board[move.toRow][move.toColumn] == null) {
				valid = true;
			} else {
				if (board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player()) {
					valid = true;
				} else {
					valid = false;
				}
			}
		}
		// Left 2 up 1
		if (move.toColumn == move.fromColumn - 2 && move.toRow == move.fromRow - 1) {
			if (board[move.toRow][move.toColumn] == null) {
				valid = true;
			} else {
				if (board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player()) {
					valid = true;
				} else {
					valid = false;
				}
			}
		}
		// Left 2 down 1
		if (move.toColumn == move.fromColumn - 2 && move.toRow == move.fromRow + 1) {
			if (board[move.toRow][move.toColumn] == null) {
				valid = true;
			} else {
				if (board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player()) {
					valid = true;
				} else {
					valid = false;
				}
			}
		}
		// Down 2 left 1
		if (move.toRow == move.fromRow + 2 && move.toColumn == move.fromColumn - 1) {
			if (board[move.toRow][move.toColumn] == null) {
				valid = true;
			} else {
				if (board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player()) {
					valid = true;
				} else {
					valid = false;
				}
			}
		}
		// Down 2 right 1
		if (move.toRow - 2 == move.fromRow && move.toColumn - 1 == move.fromColumn) {
			if (board[move.toRow][move.toColumn] == null) {
				valid = true;
			} else {
				if (board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player()) {
					valid = true;
				} else {
					valid = false;
				}
			}
		}
		return valid;
	}
}
