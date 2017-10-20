package chess;

public class King extends Piece {
	// A variable to determine which side a given piece is.
	private Player player;

	/**
	 * A method that sets the player to the correct player.
	 * 
	 * @param player Variable to determine which side the piece belongs to.
	 */
	protected King(Player player) {
		super(player);
	}

	/**
	 * Method to return the player
	 * 
	 * @return player Variable to determine which side the piece belongs to.
	 */
	@Override
	public Player player() {
		return player;
	}

	/**
	 * Method that returns the type of the piece as a string.
	 * 
	 * @return The type of the piece as a string
	 */
	@Override
	public String type() {
		return "King";
	}

	/**
	 * Method that will return whether the movement of a given piece is allowed
	 * for that piece.
	 * 
	 * @param move
	 *            A specific move entered by the user.
	 * @param board
	 *            A 2D array of pieces.
	 * @return If the given move was a valid move.
	 */
	@Override
	public boolean isValidMove(Move move, PieceInterface[][] board) {
		boolean valid = false;
		int i = 0;
		int j = 0;
		// Move to the same spot check
		if (board[move.fromRow][move.fromColumn] == board[move.toRow][move.toColumn]) {
			valid = valid;
		}

		// Move up check
		else if (board[move.fromRow + 1][move.fromColumn] == board[move.toRow][move.toColumn]) {
			i = move.fromColumn;
			j = move.fromRow + 1;
			if (board[j][i] == null) {
				valid = true;
			} else if (board[j][i].player() != board[move.fromRow][move.fromColumn].player()) {
				valid = true;

			} else if (board[j][i].player() == board[move.fromRow][move.fromColumn].player()) {
				valid = valid;
			}

		}

		// Move diagonal up right check
		else if (board[move.fromRow + 1][move.fromColumn + 1] == board[move.toRow][move.toColumn]) {
			i = move.fromColumn + 1;
			j = move.fromRow + 1;
			if (board[j][i] == null) {
				valid = true;
			} else if (board[j][i].player() != board[move.fromRow][move.fromColumn].player()) {
				valid = true;

			} else if (board[j][i].player() == board[move.fromRow][move.fromColumn].player()) {
				valid = valid;
			}

		}

		// Move right check
		else if (board[move.fromRow][move.fromColumn + 1] == board[move.toRow][move.toColumn]) {
			i = move.fromColumn + 1;
			j = move.fromRow;
			if (board[j][i] == null) {
				valid = true;
			} else if (board[j][i].player() != board[move.fromRow][move.fromColumn].player()) {
				valid = true;

			} else if (board[j][i].player() == board[move.fromRow][move.fromColumn].player()) {
				valid = valid;
			}

		}

		// Move diagonal down right check
		else if (board[move.fromRow - 1][move.fromColumn + 1] == board[move.toRow][move.toColumn]) {
			i = move.fromColumn + 1;
			j = move.fromRow - 1;
			if (board[j][i] == null) {
				valid = true;
			} else if (board[j][i].player() != board[move.fromRow][move.fromColumn].player()) {
				valid = true;

			} else if (board[j][i].player() == board[move.fromRow][move.fromColumn].player()) {
				valid = valid;
			}

		}

		// Move down check
		else if (board[move.fromRow - 1][move.fromColumn] == board[move.toRow][move.toColumn]) {
			i = move.fromColumn;
			j = move.fromRow - 1;
			if (board[j][i] == null) {
				valid = true;
			} else if (board[j][i].player() != board[move.fromRow][move.fromColumn].player()) {
				valid = true;

			} else if (board[j][i].player() == board[move.fromRow][move.fromColumn].player()) {
				valid = valid;
			}

		}

		// Move diagonal down left check
		else if (board[move.fromRow - 1][move.fromColumn - 1] == board[move.toRow][move.toColumn]) {
			i = move.fromColumn - 1;
			j = move.fromRow - 1;
			if (board[j][i] == null) {
				valid = true;
			} else if (board[j][i].player() != board[move.fromRow][move.fromColumn].player()) {
				valid = true;

			} else if (board[j][i].player() == board[move.fromRow][move.fromColumn].player()) {
				valid = valid;
			}

		}

		// Move left check
		else if (board[move.fromRow][move.fromColumn - 1] == board[move.toRow][move.toColumn]) {
			i = move.fromColumn - 1;
			j = move.fromRow;
			if (board[j][i] == null) {
				valid = true;
			} else if (board[j][i].player() != board[move.fromRow][move.fromColumn].player()) {
				valid = true;

			} else if (board[j][i].player() == board[move.fromRow][move.fromColumn].player()) {
				valid = valid;
			}
		}

		// Move diagonal up left check
		else if (board[move.fromRow + 1][move.fromColumn - 1] == board[move.toRow][move.toColumn]) {
			i = move.fromColumn - 1;
			j = move.fromRow + 1;
			if (board[j][i] == null) {
				valid = true;
			} else if (board[j][i].player() != board[move.fromRow][move.fromColumn].player()) {
				valid = true;

			} else if (board[j][i].player() == board[move.fromRow][move.fromColumn].player()) {
				valid = valid;
			}

		}

		return valid;
	}

}
