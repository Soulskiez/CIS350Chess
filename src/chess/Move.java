package chess;

public class Move {
	public int fromRow;
	public int toRow;
	public int fromColumn;
	public int toColumn;

	public Move(final int fromRow, final int toRow, final int fromCol, final int toCol) {
		this.fromRow = fromRow;
		this.toRow = toRow;
		this.fromColumn = fromCol;
		this.toColumn = toCol;
	}

}
