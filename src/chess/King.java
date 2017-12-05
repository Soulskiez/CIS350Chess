package chess;

public class King extends Piece {
	// A variable to determine which side a given piece is.
//	private Player player;

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
//	@Override
//	public Player player() {
//		return player;
//	}

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
			valid = false;
		}
		//Fixing error where index out of bounds occurs with moving to the top of the board.
		else if(move.toRow == 0) {
			if(board[move.toRow][move.toColumn] == null) {
				valid = true;
			}
			else if (board[move.fromRow][move.fromColumn].player() != board[move.toRow][move.toColumn].player()) {
				valid = true;

			} else if (board[move.fromRow][move.fromColumn].player() == board[move.toRow][move.toColumn].player()) {
				valid = false;
			}
		}
		//Fixing error where index out of bounds occurs with moving to the bottom of the board.
		else if(move.toRow == 7) {
			if(board[move.toRow][move.toColumn] == null) {
				valid = true;
			}
			else if (board[move.fromRow][move.fromColumn].player() != board[move.toRow][move.toColumn].player()) {
				valid = true;

			} else if (board[move.fromRow][move.fromColumn].player() == board[move.toRow][move.toColumn].player()) {
				valid = false;
			}
		}
		// Move up check
		else if (board[move.fromRow][move.fromColumn] == board[move.toRow + 1][move.toColumn]) {
			i = move.fromColumn;
			j = move.fromRow + 1;
			if (board[move.toRow][move.toColumn] == null) {
				valid = true;
			} 
			else if (board[move.fromRow][move.fromColumn].player() != board[move.toRow][move.toColumn].player()) {
				valid = true;

			} else if (board[move.fromRow][move.fromColumn].player() == board[move.toRow][move.toColumn].player()) {
				valid = false;
			}

		}
		//Fixing error where index out of bounds occurs with moving to the left of the board
		
		else if(move.toColumn == 0) {
			System.out.println(board[move.toRow][move.toColumn]);
			System.out.println(board[move.toRow][0]);
			if(board[move.toRow][move.toColumn] == null) {
				valid = true;
			}
			else if (board[move.fromRow][move.fromColumn].player() != board[move.toRow][move.toColumn].player()) {
				valid = true;

			} else if (board[move.fromRow][move.fromColumn].player() == board[move.toRow][move.toColumn].player()) {
				valid = false;
			}
		}
		// Move diagonal up right check
		else if (board[move.fromRow][move.fromColumn] == board[move.toRow + 1][move.toColumn - 1]) {
			i = move.fromColumn + 1;
			j = move.fromRow + 1;
			if (board[move.toRow][move.toColumn] == null) {
				valid = true;
			} 
			else if (board[move.fromRow][move.fromColumn].player() != board[move.toRow][move.toColumn].player()) {
				valid = true;

			} else if (board[move.fromRow][move.fromColumn].player() == board[move.toRow][move.toColumn].player()) {
				valid = false;
			}

		}

		// Move right check
		else if (board[move.fromRow][move.fromColumn] == board[move.toRow][move.toColumn - 1]) {
			i = move.fromColumn + 1;
			j = move.fromRow;
			if (board[move.toRow][move.toColumn] == null) {
				valid = true;
			} 
			else if (board[move.fromRow][move.fromColumn].player() != board[move.toRow][move.toColumn].player()) {
				valid = true;

			} else if (board[move.fromRow][move.fromColumn].player() == board[move.toRow][move.toColumn].player()) {
				valid = false;
			}

		}

		// Move diagonal down right check
		else if (board[move.fromRow][move.fromColumn] == board[move.toRow - 1][move.toColumn - 1]) {
			i = move.fromColumn + 1;
			j = move.fromRow - 1;
			if (board[move.toRow][move.toColumn] == null) {
				valid = true;
			} 
			else if (board[move.fromRow][move.fromColumn].player() != board[move.toRow][move.toColumn].player()) {
				valid = true;

			} else if (board[move.fromRow][move.fromColumn].player() == board[move.toRow][move.toColumn].player()) {
				valid = false;
			}

		}
		
		// Move down check
		else if (board[move.fromRow][move.fromColumn] == board[move.toRow - 1][move.toColumn]) {
			i = move.fromColumn;
			j = move.fromRow - 1;
			if (board[move.toRow][move.toColumn] == null) {
				valid = true;
			} 
			else if (board[move.fromRow][move.fromColumn].player() != board[move.toRow][move.toColumn].player()) {
				valid = true;

			} else if (board[move.fromRow][move.fromColumn].player() == board[move.toRow][move.toColumn].player()) {
				valid = false;
			}

		}

		// Move diagonal down left check
		else if (board[move.fromRow][move.fromColumn] == board[move.toRow - 1][move.toColumn + 1]) {
			i = move.fromColumn - 1;
			j = move.fromRow - 1;
			if (board[move.toRow][move.toColumn] == null) {
				valid = true;
			} 
			else if (board[move.fromRow][move.fromColumn].player() != board[move.toRow][move.toColumn].player()) {
				valid = true;

			} else if (board[move.fromRow][move.fromColumn].player() == board[move.toRow][move.toColumn].player()) {
				valid = false;
			}
		}

		// Move left check
		else if (board[move.fromRow][move.fromColumn] == board[move.toRow][move.toColumn + 1]) {
			i = move.fromColumn - 1;
			j = move.fromRow;
			if (board[move.toRow][move.toColumn] == null) {
				valid = true;
			} 
			else if (board[move.fromRow][move.fromColumn].player() != board[move.toRow][move.toColumn].player()) {
				valid = true;

			} else if (board[move.fromRow][move.fromColumn].player() == board[move.toRow][move.toColumn].player()) {
				valid = false;
			}
		}

		// Move diagonal up left check
		else if (board[move.fromRow][move.fromColumn] == board[move.toRow + 1][move.toColumn + 1]) {
			i = move.fromColumn - 1;
			j = move.fromRow + 1;
			if (board[move.toRow][move.toColumn] == null) {
				valid = true;
			} 
			else if (board[move.fromRow][move.fromColumn].player() != board[move.toRow][move.toColumn].player()) {
				valid = true;

			} else if (board[move.fromRow][move.fromColumn].player() == board[move.toRow][move.toColumn].player()) {
				valid = false;
			}

		}
		
		

		return valid;
	}

}
