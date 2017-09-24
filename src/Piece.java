package chess;

public abstract class Piece implements IPiece {

	private Player player;
	private boolean valid = false;
	
	protected Piece(Player player){
		this.player = player;
	}
	public Player player(){
		return player;
	}
	public boolean isValidMove(Move move, IPiece[][] board){
		
				boolean valid = false;

				if((move.toRow != move.fromRow) || (move.fromColumn != move.toColumn)){
					if(board[move.fromRow][move.fromColumn] == this){
						if(board[move.toRow][move.toColumn] != null){
							if(board[move.fromRow][move.fromColumn].player() != 
									board[move.toRow][move.toColumn].player()){
								valid = true; 
							}
						}else{
							valid = false;
						}
					}
				}
				return valid; 
	}
	
	public abstract boolean firstMove();
}
