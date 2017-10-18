package chess;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChessTest {

	@Test
	public void KnightTest2Up1RightCapture() {
		boolean valid = false;
		Move move = new Move(3, 1, 3, 4);
		int board[][] = new int[8][8];
		board[3][3] = 1;// player 1
		board[1][4] = 2;// player 2

		if (move.toColumn == move.fromColumn + 1 && move.toRow == move.fromRow - 2)
			if (board[move.toRow][move.toColumn] == 0)
				valid = true;
			else {
				if (board[move.toRow][move.toColumn] != board[move.fromRow][move.fromColumn])
					valid = true;
				else
					valid = false;
			}
		assertTrue(valid);
	}

	@Test
	public void KnightTest2Down1LeftEmpty() {
		boolean valid = false;
		Move move = new Move(2, 4, 2, 1);
		int board[][] = new int[8][8];
		board[2][2] = 1;// player 1
		board[4][1] = 2;// player 2

		if (move.toColumn == move.fromColumn - 1 && move.toRow == move.fromRow + 2)
			if (board[move.toRow][move.toColumn] == 0)
				valid = true;
			else {
				if (board[move.toRow][move.toColumn] != board[move.fromRow][move.fromColumn])
					valid = true;
				else
					valid = false;
			}
		assertTrue(valid);
	}

	@Test
	public void RookTestShouldNotHopOverPieces() {
		boolean valid = false;
		Move move = new Move(2, 6, 2, 2);// Down 4
		int board[][] = new int[8][8];
		board[2][2] = 1;// player 1
		board[4][2] = 1;// player 1 in the way

		if (move.fromRow < move.toRow) {
			for (int i = move.fromRow + 1; i <= move.toRow; i++) {
				if (board[i][move.toColumn] == 0)
					valid = true;
				else {
					if (board[i][move.fromColumn] != board[move.fromRow][move.fromColumn]) {
						if (i == move.toRow)
							valid = true;
						else {
							valid = false;
							break;
						}
					}
					if (board[i][move.fromColumn] == board[move.fromRow][move.fromColumn]) {
						valid = false;
						break;
					}
				}
			}
		}
		assertFalse(valid);
	}

	@Test
	public void RookTestMove4LeftCapture() {
		boolean valid = false;
		Move move = new Move(6, 6, 6, 2);
		int board[][] = new int[8][8];
		board[6][6] = 1;// player 1
		board[6][2] = 2;// player 2

		if (move.fromColumn > move.toColumn) {
			for (int j = move.fromColumn - 1; j >= move.toColumn; j--) {
				if (board[move.fromRow][j] == 0)
					valid = true;
				else {
					if (board[move.fromRow][j] != board[move.fromRow][move.fromColumn]) {
						if (j == move.toColumn)
							valid = true;
						else {
							valid = false;
							break;
						}
					}
					if (board[move.fromRow][j] == board[move.fromRow][move.fromColumn]) {
						valid = false;
						break;
					}
				}
			}
		}
		assertTrue(valid);
	}

}
