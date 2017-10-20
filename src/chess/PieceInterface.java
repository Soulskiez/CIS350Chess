package chess;

/**
 * Interface for all of the pieces.
 *
 * @author Tyler Solnikowski, Kanoa Ellis,  Kayla Davis
 * @version October 19th, 2017
 *
 */
public interface PieceInterface {

	/**
	 * Return the player that owns this piece.
	 *
	 * @return the player that owns this piece.
	 */
	Player player();


	/**
	 * Return the type of this piece ("King", "Queen", "Rook", etc.).
	 *
	 * @return the type of this piece
	 */
	String type();



	/**
	 * Determines if the move is valid given a move and the 2D array of pieces from the chess board.
	 * 
	 * @param move a move with a to and from location 
	 * @param board a 2D array of pieces
	 * @return true if move is allowed, false otherwise
	 */
	boolean isValidMove(Move move, PieceInterface[][] board);
}
