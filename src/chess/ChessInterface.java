package chess;

/**
 * Interface for the Board
 *
 * @author Tyler Solnikowski, Kanoa Ellis,  Kayla Davis
 * @version October 19th, 2017
 *
 */
public interface ChessInterface {
	
    /**
	 * Returns whether the game is complete.
	 *
	 * @return true if complete, false otherwise.
	 */
	boolean isComplete();

	/**
	 * Checks that user can move their piece to the desired location on the board.
	 * @param move A move on the board with a from and to location for both row and column
	 * @return true if move is possible, false otherwise
	 */
	 
	boolean isValidMove(Move move);

	/**
	 * Moves according to the provided data, Moves have a to and from location used to verify where they were
	 * and if they can move where the user wants them to.
	 * @param move A move on the board with a from and to location for both row and column
	 */
	void move(Move move);

	/**
	 * Method to determine if a player is in check
	 * @param p A player, Black or White
	 * @return true if the player's King is able to be captured in the next move, otherwise false.
	 */
	boolean inCheck(Player p);

	/**
	 * Returns which player's turn it is, used when trying to move pieces to prohibit landing on their own pieces,
	 * as well as when switching player's turns.
	 * @return either BLACK or WHITE from Player enum to determine which player's turn it is
	 */
	
	Player currentPlayer();

}


