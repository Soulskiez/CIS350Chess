package chess;

public class Pawn extends Piece {
	private Player player;
	
	protected Pawn(Player player){
		super(player);
	}
	@Override
	public Player player(){
		return player;
	}

	@Override
	public String type() {
		return "Pawn";
	}

	
	public boolean isValidMove(Move move, Piece[][] board) {
		boolean valid = false;
		//Check if player is WHITE
		if(board[move.fromColumn][move.fromRow].player() == Player.WHITE){
		//Check if you moved to the same spot
			if(board[move.fromColumn][move.fromRow] == board[move.toColumn][move.toRow]){
				valid = valid;
			}
		//Check if you moved up 1 space
			if(board[move.fromColumn][move.fromRow + 1] == board[move.toColumn][move.toRow]){
				valid = true;
			}
		//Check if you are in the WHITE Pawn starting row (6)
			if(board[move.fromColumn][move.fromRow] == board[move.fromColumn][6]){
		//Check if you moved up 2 spaces
				if(board[move.fromColumn][move.fromRow + 2] == board[move.toColumn][move.toRow]){
					valid = true;
				}
				valid = valid;
			}
		//Check to see if you moved up diagonal left or right
			if(board[move.fromColumn - 1][move.fromRow + 1] == board[move.fromColumn][move.fromRow] ||
			   board[move.fromColumn + 1][move.fromRow + 1] == board[move.fromColumn][move.fromRow]){
				valid = true;
			}
		}
		
		
		//Check if player is BLACK
		if(board[move.fromColumn][move.fromRow].player() == Player.BLACK){
			//Check if you moved to the same spot
			if(board[move.fromColumn][move.fromRow] == board[move.toColumn][move.toRow]){
				valid = valid;
			}
		//Check if you moved down 1 space
			if(board[move.fromColumn][move.fromRow - 1] == board[move.toColumn][move.toRow]){
				valid = true;
			}
		//Check if you are in the WHITE Pawn starting row (1)
			if(board[move.fromColumn][move.fromRow] == board[move.fromColumn][1]){
		//Check if you moved down 2 spaces
				if(board[move.fromColumn][move.fromRow - 2] == board[move.toColumn][move.toRow]){
					valid = true;
				}
				valid = valid;
			}
		//Check to see if you moved down diagonal left or right
			if(board[move.fromColumn - 1][move.fromRow - 1] == board[move.fromColumn][move.fromRow] ||
			   board[move.fromColumn + 1][move.fromRow - 1] == board[move.fromColumn][move.fromRow]){
				valid = true;
			}	
		}
	return valid;
	}
}
