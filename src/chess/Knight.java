package chess;

public class Knight extends Piece {
	private Player player;

	protected Knight(Player player) {
		super(player);
	}

	@Override
	public Player player() {
		return player;
	}

	@Override
	public String type() {
		return "Knight";
	}

	@Override
	public boolean isValidMove(Move move, PieceInterface[][] board) {
		boolean valid = false;

		// Right 2 up 1
		if (move.toColumn == move.fromColumn + 2 && move.toRow == move.fromRow - 1)
			if (board[move.toRow][move.toColumn] == null)
				valid = true;
			else {
				if (board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player())
					valid = true;
				else
					valid = false;
			}

		// Right 2 down 1
		if (move.toColumn == move.fromColumn + 2 && move.toRow == move.fromRow + 1)
			if (board[move.toRow][move.toColumn] == null)
				valid = true;
			else {
				if (board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player())
					valid = true;
				else
					valid = false;
			}

		// Up 2 right 1
		if (move.toRow == move.fromRow - 2 && move.toColumn == move.fromColumn + 1)
			if (board[move.toRow][move.toColumn] == null)
				valid = true;
			else {
				if (board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player())
					valid = true;
				else
					valid = false;
			}

		// Up 2 left 1
		if (move.toRow == move.fromRow - 2 && move.toColumn == move.fromColumn + 1)
			if (board[move.toRow][move.toColumn] == null)
				valid = true;
			else {
				if (board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player())
					valid = true;
				else
					valid = false;
			}

		// Left 2 up 1
		if (move.toColumn == move.fromColumn - 2 && move.toRow == move.fromRow - 1)
			if (board[move.toRow][move.toColumn] == null)
				valid = true;
			else {
				if (board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player())
					valid = true;
				else
					valid = false;
			}

		// Left 2 down 1
		if (move.toColumn == move.fromColumn - 2 && move.toRow == move.fromRow + 1)
			if (board[move.toRow][move.toColumn] == null)
				valid = true;
			else {
				if (board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player())
					valid = true;
				else
					valid = false;
			}

		// Down 2 left 1
		if (move.toRow == move.fromRow + 2 && move.toColumn == move.fromColumn - 1)
			if (board[move.toRow][move.toColumn] == null)
				valid = true;
			else {
				if (board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player())
					valid = true;
				else
					valid = false;
			}

		// Down 2 right 1
		if (move.toRow == move.fromRow + 2 && move.toColumn == move.fromColumn - 1)
			if (board[move.toRow][move.toColumn] == null)
				valid = true;
			else {
				if (board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player())
					valid = true;
				else
					valid = false;
			}

		return valid;
	}


}
