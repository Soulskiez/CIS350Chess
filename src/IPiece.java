package chess;

public interface IPiece {
	Player player();
	
	String type();
	
	boolean isValidMove(Move move, IPiece[][] board);
	
}
