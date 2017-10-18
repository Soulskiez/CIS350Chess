package chess;

public class Rook extends Piece {
	private Player player;

	protected Rook(Player player) {
		super(player);
	}

	@Override
	public Player player() {
		return player;
	}

	@Override
	public String type() {
		return "Rook";
	}

	public boolean isValidMove(Move move, Piece board[][]) {
		boolean valid = false;

		// Move up or down
		if (move.fromColumn == move.toColumn) {
			// Move up
			if (move.fromRow > move.toRow) {
				for (int i = move.fromRow - 1; i >= move.toRow; i--) {
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
				}
			} // end of move up

			// Move down
			if (move.fromRow < move.toRow) {
				for (int i = move.fromRow + 1; i <= move.toRow; i++) {
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
				}
			} // end of move down
		}
		// Move left or right
		if (move.fromRow == move.toRow) {
			// Move left
			if (move.fromColumn > move.toColumn) {
				for (int j = move.fromColumn - 1; j >= move.toColumn; j--) {
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
				}

			} // end of move left

			// Move right
			if (move.fromColumn > move.toColumn) {
				for (int j = move.fromColumn + 1; j <= move.toColumn; j++) {
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
				}
			} // end of move right
		}
		return valid;
	}
}
