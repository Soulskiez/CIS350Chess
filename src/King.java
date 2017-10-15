package chess;

public class King extends Piece {
private Player player;
	
	protected King(Player player){
		super(player);
	}
	@Override
	public Player player(){
		return player;
	}

	@Override
	public String type() {
		return "King";
	}

	
	public boolean isValidMove(Move move, Piece[][] board) {
		boolean valid = false;
		
		//Move to the same spot check
		if(board[move.fromColumn][move.fromRow] == board[move.toColumn][move.toRow]){
			valid = valid;
		}
		//Move up check
		else if(board[move.fromColumn][move.fromRow + 1] == board[move.toColumn][move.toRow]){
			valid = true;
		}
		//Move diagonal up right check
		else if(board[move.fromColumn + 1][move.fromRow + 1] == board[move.toColumn][move.toRow]){
			valid = true;
		}
		//Move right check
		else if(board[move.fromColumn + 1][move.fromRow] == board[move.toColumn][move.toRow]){
			valid = true;
		}
		//Move diagonal down right check
		else if(board[move.fromColumn + 1][move.fromRow - 1] == board[move.toColumn][move.toRow]){
			valid = true;
		}
		//Move down check
		else if(board[move.fromColumn][move.fromRow - 1] == board[move.toColumn][move.toRow]){
			valid = true;
		}
		//Move diagonal down left check
		else if(board[move.fromColumn - 1][move.fromRow - 1] == board[move.toColumn][move.toRow]){
			valid = true;
		}
		//Move left check
		else if(board[move.fromColumn - 1][move.fromRow] == board[move.toColumn][move.toRow]){
			valid = true;
		}
		//Move diagonal up left check
		else if(board[move.fromColumn - 1][move.fromRow + 1] == board[move.toColumn][move.toRow]){
			valid = true;
		}
		
		return valid;
	}
	
}
