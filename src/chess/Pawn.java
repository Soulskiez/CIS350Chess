package chess;

public class Pawn extends Piece {
	// A variable to determine which side a given piece is.
	private Player player;

	/**
	 * A method that sets the player to the correct player.
	 * 
	 * @param player Variable to determine which side the piece belongs to.
	 */
	protected Pawn(final Player player) {
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
		return "Pawn";
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
	@Override
	public boolean isValidMove(final Move move, final PieceInterface[][] board) {
		boolean valid = false;
		// Check if player is WHITE
		if (board[move.fromRow][move.fromColumn].player() == Player.WHITE) {
			int i = 0;
			int j = 0;
			// Check if you moved to the same spot
			if (board[move.fromRow][move.fromColumn] == board[move.toRow][move.toColumn]) {
				valid = false;
			}

			// Check if you moved up 1 space
			if (board[move.fromRow + 1][move.fromColumn] == board[move.toRow][move.toColumn]) {

				i = move.fromColumn;
				j = move.fromRow + 1;
				if (board[j][i] == null) {
					valid = true;
				} else if (board[j][i].player() != board[move.fromRow][move.fromColumn].player()) {
					valid = false;

				} else if (board[j][i].player() == board[move.fromRow][move.fromColumn].player()) {
					valid = false;
				}

			}

			// Check if you are in the WHITE Pawn starting row (6)
			if (board[move.fromRow][move.fromColumn] == board[6][move.toColumn]) {
				// Check if you moved up 2 spaces
				if (board[move.fromRow + 2][move.fromColumn] == board[move.toRow][move.toColumn]) {
					i = move.fromColumn;
					j = move.fromRow + 1;

					while (j <= move.toRow) {
						if (board[j][i] == null) {
							valid = true;
						} else if (board[j][i].player() != board[move.fromRow][move.fromColumn].player()) {
							valid = false;
							break;
						} else if (board[j][i].player() == board[move.fromRow][move.fromColumn].player()) {
							valid = false;
							break;
						}
						j++;
					}
				}
				// Check to see if you moved up diagonal left or right
				if (board[move.fromRow + 1][move.fromColumn - 1] == board[move.fromRow][move.fromColumn]
						|| board[move.fromRow + 1][move.fromColumn + 1] == board[move.fromRow][move.fromColumn]) {
					i = move.fromColumn;
					j = move.fromRow + 1;
					if (board[j][i + 1] == null || board[j][i - 1] == null) {
						valid = false;
					} else if (board[j][i].player() != board[move.fromRow][move.fromColumn].player()) {
						valid = true;

					} else if (board[j][i].player() == board[move.fromRow][move.fromColumn].player()) {
						valid = false;
					}

				}
			}
		}

		// Check if player is BLACK
		if (board[move.fromRow][move.fromColumn].player() == Player.BLACK) {

			int i = 0;
			int j = 0;
			// Check if you moved to the same spot
			if (board[move.fromRow][move.fromColumn] == board[move.toRow][move.toColumn]) {
				valid = false;
			}
			// Check if you moved down 1 space
			if (board[move.fromRow - 1][move.fromColumn] == board[move.toRow][move.toColumn]) {
				i = move.fromColumn;
				j = move.fromRow - 1;
				if (board[j][i] == null) {
					valid = true;
				} else if (board[j][i].player() != board[move.fromRow][move.fromColumn].player()) {
					valid = false;

				} else if (board[j][i].player() == board[move.fromRow][move.fromColumn].player()) {
					valid = false;
				}

			}
			// Check if you are in the WHITE Pawn starting row (1)
			if (board[move.fromRow][move.fromColumn] == board[1][move.toRow]) {
				// Check if you moved down 2 spaces
				if (board[move.fromRow - 2][move.fromColumn] == board[move.toRow][move.toColumn]) {
					i = move.fromColumn;
					j = move.fromRow - 1;

					while (j >= move.toRow) {
						if (board[j][i] == null) {
							valid = true;
						} else if (board[j][i].player() != board[move.fromRow][move.fromColumn].player()) {
							valid = false;
							break;
						} else if (board[j][i].player() == board[move.fromRow][move.fromColumn].player()) {
							valid = false;
							break;
						}
						j--;
					}
				}
			}
			// Check to see if you moved down diagonal left or right
			if (board[move.fromRow - 1][move.fromColumn + 1] == board[move.fromRow][move.fromColumn]
					|| board[move.fromRow - 1][move.fromColumn - 1] == board[move.fromRow][move.fromColumn]) {
				i = move.fromColumn;
				j = move.fromRow - 1;
				if (board[j][i + 1] == null || board[j][i - 1] == null) {
					valid = false;
				} else if (board[j][i].player() != board[move.fromRow][move.fromColumn].player()) {
					valid = true;
				} else if (board[j][i].player() == board[move.fromRow][move.fromColumn].player()) {
					valid = false;
				}
			}

		}

		return valid;

	}
}
