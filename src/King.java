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

	@Override
	public boolean isValidMove(Move move, PieceInterface[][] board) {
		boolean valid = false;
		int i = 0;
		int j = 0;
		//Move to the same spot check
		if(board[move.fromRow][move.fromColumn] == board[move.toRow][move.toColumn]){
			valid = valid;
		}
		
		//Move up check
		else if(board[move.fromRow + 1][move.fromColumn] == board[move.toRow][move.toColumn]){
			i = move.fromColumn;
			j = move.fromRow + 1;
			if(board[j][i] == null){
				valid = true;
			}
			else if(board[j][i].player() != board[move.fromRow][move.fromColumn].player()){
				valid = true;
				
			}
			else if(board[j][i].player() == board[move.fromRow][move.fromColumn].player()){
				valid = valid;	
			}
			
		}
		
		//Move diagonal up right check
		else if(board[move.fromRow + 1][move.fromColumn + 1] == board[move.toRow][move.toColumn]){
			i = move.fromColumn + 1;
			j = move.fromRow + 1;
			if(board[j][i] == null){
				valid = true;
			}
			else if(board[j][i].player() != board[move.fromRow][move.fromColumn].player()){
				valid = true;
				
			}
			else if(board[j][i].player() == board[move.fromRow][move.fromColumn].player()){
				valid = valid;	
			}
			
		}
		
		//Move right check
		else if(board[move.fromRow][move.fromColumn + 1] == board[move.toRow][move.toColumn]){
			i = move.fromColumn + 1;
			j = move.fromRow;
			if(board[j][i] == null){
				valid = true;
			}
			else if(board[j][i].player() != board[move.fromRow][move.fromColumn].player()){
				valid = true;
				
			}
			else if(board[j][i].player() == board[move.fromRow][move.fromColumn].player()){
				valid = valid;	
			}
			
		}
		
		//Move diagonal down right check
		else if(board[move.fromRow - 1][move.fromColumn + 1] == board[move.toRow][move.toColumn]){
			i = move.fromColumn + 1;
			j = move.fromRow - 1;
			if(board[j][i] == null){
				valid = true;
			}
			else if(board[j][i].player() != board[move.fromRow][move.fromColumn].player()){
				valid = true;
				
			}
			else if(board[j][i].player() == board[move.fromRow][move.fromColumn].player()){
				valid = valid;	
			}
			
		}
		
		//Move down check
		else if(board[move.fromRow - 1][move.fromColumn] == board[move.toRow][move.toColumn]){
			i = move.fromColumn;
			j = move.fromRow - 1;
			if(board[j][i] == null){
				valid = true;
			}
			else if(board[j][i].player() != board[move.fromRow][move.fromColumn].player()){
				valid = true;
				
			}
			else if(board[j][i].player() == board[move.fromRow][move.fromColumn].player()){
				valid = valid;	
			}
			
		}
		
		//Move diagonal down left check
		else if(board[move.fromRow - 1][move.fromColumn - 1] == board[move.toRow][move.toColumn]){
			i = move.fromColumn - 1;
			j = move.fromRow - 1;
			if(board[j][i] == null){
				valid = true;
			}
			else if(board[j][i].player() != board[move.fromRow][move.fromColumn].player()){
				valid = true;
				
			}
			else if(board[j][i].player() == board[move.fromRow][move.fromColumn].player()){
				valid = valid;	
			}
			
		}
		
		//Move left check
		else if(board[move.fromRow][move.fromColumn - 1] == board[move.toRow][move.toColumn]){
			i = move.fromColumn - 1;
			j = move.fromRow;
			if(board[j][i] == null){
				valid = true;
			}
			else if(board[j][i].player() != board[move.fromRow][move.fromColumn].player()){
				valid = true;
				
			}
			else if(board[j][i].player() == board[move.fromRow][move.fromColumn].player()){
				valid = valid;	
			}
		}
		
		//Move diagonal up left check
		else if(board[move.fromRow + 1][move.fromColumn - 1] == board[move.toRow][move.toColumn]){
			i = move.fromColumn - 1;
			j = move.fromRow + 1;
			if(board[j][i] == null){
				valid = true;
			}
			else if(board[j][i].player() != board[move.fromRow][move.fromColumn].player()){
				valid = true;
				
			}
			else if(board[j][i].player() == board[move.fromRow][move.fromColumn].player()){
				valid = valid;	
			}
			
		}
		
		return valid;
	}
	
}