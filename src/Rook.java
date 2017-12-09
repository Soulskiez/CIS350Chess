package chess;

public class Rook extends Piece {
	// A variable to determine which side a given piece is.
	// private Player player;

	/**
	 * A method that sets the player to the correct player.
	 * 
	 * @param player
	 *            Variable to determine which side the piece belongs to.
	 */
	protected Rook(final Player player) {
		super(player);
	}

	/**
	 * Method to return the player.
	 * 
	 * @return player Variable to determine which side the piece belongs to.
	 */

	/**
	 * Method that returns the type of the piece as a string.
	 * 
	 * @return The type of the piece as a string
	 */
	@Override
	public String type() {
		return "Rook";
	}

	/**
	 * Method that will return whether the movement of a given piece is
	 * allowed for that piece.
	 * 
	 * @param move
	 *            A specific move entered by the user.
	 * @param board
	 *            A 2D array of pieces.
	 * @return If the given move was a valid move.
	 */
	
	public boolean isValidMove(final Move move, final PieceInterface[][] board) {
		boolean valid = false;
		// Move up or down
		if (move.fromColumn == move.toColumn) {
			// Move up
			if (move.fromRow > move.toRow) {
				for (int i = move.fromRow - 1; i >= move.toRow; i--) {
					if (board[i][move.toColumn] == null) {
						valid = true;
					} else {
						if (board[i][move.fromColumn].player() != board[move.fromRow][move.fromColumn].player()) {
							if (i == move.toRow) {
								valid = true;
							} else {
								valid = false;
								break;
							}
						}
						if (board[i][move.fromColumn].player() == board[move.fromRow][move.fromColumn].player()) {
							valid = false;
							break;
						}
					}
				}
			} // end of move up
				// Move down
			if (move.fromRow < move.toRow) {
				for (int i = move.fromRow + 1; i <= move.toRow; i++) {
					if (board[i][move.toColumn] == null) {
						valid = true;
					} else {
						if (board[i][move.fromColumn].player() != board[move.fromRow][move.fromColumn].player()) {
							if (i == move.toRow) {
								valid = true;
							} else {
								valid = false;
								break;
							}
						}
						if (board[i][move.fromColumn].player() == board[move.fromRow][move.fromColumn].player()) {
							valid = false;
							break;
						}
					}
				}
			} // end of move down
		}
		// Move left or right
		if (move.fromRow == move.toRow) {
			// Move left
			if (move.fromColumn > move.toColumn) {
				for (int j = move.fromColumn - 1; j >= move.toColumn; j--) {
					if (board[move.fromRow][j] == null) {
						valid = true;
					} else {
						if (board[move.fromRow][j].player() != board[move.fromRow][move.fromColumn].player()) {
							if (j == move.toColumn) {
								valid = true;
							} else {
								valid = false;
								break;
							}
						}
						if (board[move.fromRow][j].player() == board[move.fromRow][move.fromColumn].player()) {
							valid = false;
							break;
						}
					}
				}
			} // end of move left
				// Move right
			if (move.fromColumn < move.toColumn) {
				for (int j = move.fromColumn + 1; j <= move.toColumn; j++) {
					if (board[move.fromRow][j] == null) {
						valid = true;
					} else {
						if (board[move.fromRow][j].player() != board[move.fromRow][move.fromColumn].player()) {
							if (j == move.toColumn) {
								valid = true;
							} else {
								valid = false;
								break;
							}
						}
						if (board[move.fromRow][j].player() == board[move.fromRow][move.fromColumn].player()) {
							valid = false;
							break;
						}
					}
				}
			} // end of move right
		}
		return valid;
	}
}
