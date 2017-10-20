package chess;

/**
 * Constructor for Move class
 *
 * @author Tyler Solnikowski, Kanoa Ellis,  Kayla Davis
 * @version October 19th, 2017
 *
 */

public class Move {
	public int fromRow;
	public int toRow;
	public int fromColumn;
	public int toColumn;
	
	public Move(){
	}
	
	/**
	 * Takes provided location and stores it in order to later move the piece to that location.
	 * 
	 * @param fromRow row where the piece being moved is located
	 * @param toRow row where the piece being moved is going
	 * @param fromCol column where the piece being moved is located
	 * @param toCol column where the piece being moved is going
	 */
	public Move(int fromRow,int toRow,int fromCol, int toCol){
		this.fromRow = fromRow;
		this.toRow = toRow;
		this.fromColumn = fromCol;
		this.toColumn = toCol;
	}
	
}
