package chess;

public enum Player {
	BLACK, WHITE;

	public Player next() {
		return this == BLACK ? WHITE : BLACK;
	}
}