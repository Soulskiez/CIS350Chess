package chess;

public class Move {
	public int fromRow;
	public int toRow;
	public int fromColumn;
	public int toColumn;
	
	public Move(){
	}
	public Move(int fromRow,int toRow,int fromCol, int toCol){
		this.fromRow = fromRow;
		this.toRow = toRow;
		this.fromColumn = fromCol;
		this.toColumn = toCol;
	}
	
}