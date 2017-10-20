package chess;

public class Queen extends Piece {
	// A variable to determine which side a given piece is.
	private Player player;

	/**
	 * A method that sets the player to the correct player.
	 * 
	 * @param player Variable to determine which side the piece belongs to.
	 */
	protected Queen(Player player) {
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
		return "Queen";
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
		int diffC = Math.abs(move.fromColumn - move.toColumn);
		int diffR = Math.abs(move.fromRow - move.toRow);
		int i = 0;
		int j = 0;

		if (diffR == diffC) {
			// Move left up
			if (move.fromColumn > move.toColumn && move.fromRow < move.toRow) {

				i = move.fromColumn - 1;
				j = move.fromRow - 1;

				while (i >= move.toColumn && j >= move.toRow) {
					if (board[j][i] == null) {
						valid = true;
					} else if (board[j][i].player() != board[move.fromRow][move.fromColumn].player()) {
						valid = true;
						break;
					} else if (board[j][i].player() == board[move.fromRow][move.fromColumn].player()) {
						valid = false;
						break;
					}
					i--;
					j--;
				}
			}
			// Move left down
			if (move.fromColumn > move.toColumn && move.fromRow > move.toRow) {

				i = move.fromColumn - 1;
				j = move.fromRow + 1;

				while (i >= move.toColumn && j <= move.toRow) {
					if (board[j][i] == null) {
						valid = true;
					} else if (board[j][i].player() != board[move.fromRow][move.fromColumn].player()) {
						if (board[j][i] == board[move.toRow][move.toColumn]) {
							valid = true;
						} else {
							valid = false;
						}
						break;
					} else if (board[j][i].player() == board[move.fromRow][move.fromColumn].player()) {
						valid = false;
						break;
					}
					i--;
					j++;
				}
			}
			// Move right up
			if (move.fromColumn < move.toColumn && move.fromRow < move.toRow) {

				i = move.fromColumn + 1;
				j = move.fromRow - 1;

				while (i <= move.toColumn && j >= move.toRow) {
					if (board[j][i] == null) {
						valid = true;
					} else if (board[j][i].player() != board[move.fromRow][move.fromColumn].player()) {
						if (board[j][i] == board[move.toRow][move.toColumn]) {
							valid = true;
						} else {
							valid = false;
						}
						break;
					} else if (board[j][i].player() == board[move.fromRow][move.fromColumn].player()) {
						valid = false;
						break;
					}
					i++;
					j--;
				}
			}
			// Move right down
			if (move.fromColumn < move.toColumn && move.fromRow > move.toRow) {

				i = move.fromColumn + 1;
				j = move.fromRow + 1;

				while (i <= move.toColumn && j <= move.toRow) {
					if (board[j][i] == null) {
						valid = true;
					} else if (board[j][i].player() != board[move.fromRow][move.fromColumn].player()) {
						if (board[j][i] == board[move.toRow][move.toColumn]) {
							valid = true;
						} else {
							valid = false;
						}
						break;
					} else if (board[j][i].player() == board[move.fromRow][move.fromColumn].player()) {
						valid = false;
						break;
					}
					i++;
					j++;
				}
			}
			// Move up or down
			if (move.fromColumn == move.toColumn) {
				// Move up
				if (move.fromRow > move.toRow) {
					i = move.fromRow - 1;
					while (i >= move.toRow) {
						if (board[i][move.toColumn] == null)
							valid = true;
						else {
							if (board[i][move.fromColumn].player() != board[move.fromRow][move.fromColumn].player()) {
								if (i == move.toRow)
									valid = true;
								else {
									valid = false;
									break;
								}
							}
							if (board[i][move.fromColumn].player() == board[move.fromRow][move.fromColumn].player()) {
								valid = false;
								break;
							}
						}
						i--;
					}
				} // end of move up

				// Move down
				if (move.fromRow < move.toRow) {
					i = move.fromRow + 1;
					while (i <= move.toRow) {
						if (board[i][move.toColumn] == null)
							valid = true;
						else {
							if (board[i][move.fromColumn].player() != board[move.fromRow][move.fromColumn].player()) {
								if (i == move.toRow)
									valid = true;
								else {
									valid = false;
									break;
								}
							}
							if (board[i][move.fromColumn].player() == board[move.fromRow][move.fromColumn].player()) {
								valid = false;
								break;
							}
						}
						i++;
					}
				} // end of move down
			}
			// Move left or right
			if (move.fromRow == move.toRow) {
				// Move left
				if (move.fromColumn > move.toColumn) {
					j = move.fromColumn - 1;
					while (j >= move.toColumn) {
						if (board[move.fromRow][j] == null)
							valid = true;
						else {
							if (board[move.fromRow][j].player() != board[move.fromRow][move.fromColumn].player()) {
								if (j == move.toColumn)
									valid = true;
								else {
									valid = false;
									break;
								}
							}
							if (board[move.fromRow][j].player() == board[move.fromRow][move.fromColumn].player()) {
								valid = false;
								break;
							}
						}
						j--;
					}

				} // end of move left

				// Move right
				if (move.fromColumn > move.toColumn) {
					j = move.fromColumn + 1;
					while (j <= move.toColumn) {
						if (board[move.fromRow][j] == null)
							valid = true;
						else {
							if (board[move.fromRow][j].player() != board[move.fromRow][move.fromColumn].player()) {
								if (j == move.toColumn)
									valid = true;
								else {
									valid = false;
									break;
								}
							}
							if (board[move.fromRow][j].player() == board[move.fromRow][move.fromColumn].player()) {
								valid = false;
								break;
							}
						}
						j++;
					}
				} // end of move right
			}

		}

		return valid;
	}
}