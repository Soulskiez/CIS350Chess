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

	@Override
	public boolean isValidMove(Move move, Piece[][] board) {
		boolean valid = false;
		//Check if player is WHITE
		if(board[move.fromRow][move.fromColumn].player() == Player.WHITE){
			int i = 0;
			int j = 0;
		//Check if you moved to the same spot
			if(board[move.fromRow][move.fromColumn] == board[move.toRow][move.toColumn]){
				valid = valid;
			}
			
		//Check if you moved up 1 space
			if(board[move.fromRow + 1][move.fromColumn] == board[move.toRow][move.toColumn]){
				
				i = move.fromColumn;
				j = move.fromRow + 1;
				if(board[j][i] == null){
					valid = true;
				}
				else if(board[j][i].player() != board[move.fromRow][move.fromColumn].player()){
					valid = valid;
					
				}
				else if(board[j][i].player() == board[move.fromRow][move.fromColumn].player()){
					valid = valid;	
				}
				
			}
			
		//Check if you are in the WHITE Pawn starting row (6)
			if(board[move.fromRow][move.fromColumn] == board[6][move.toColumn]){
		//Check if you moved up 2 spaces
				if(board[move.fromRow + 2][move.fromColumn] == board[move.toRow][move.toColumn]){
					i = move.fromColumn;
					j = move.fromRow + 1;
					
					while(j <= move.toRow){
						if(board[j][i] == null){
							valid = true;
						}
						else if(board[j][i].player() != board[move.fromRow][move.fromColumn].player()){
							valid = valid;
							break;
						}
						else if(board[j][i].player() == board[move.fromRow][move.fromColumn].player()){
							valid = valid;
							break;
						}
						j++;
					}
			}
		//Check to see if you moved up diagonal left or right
			if(board[move.fromRow + 1][move.fromColumn - 1] == board[move.fromRow][move.fromColumn] ||
			   board[move.fromRow + 1][move.fromColumn - 1] == board[move.fromRow][move.fromColumn]){
				i = move.fromColumn;
				j = move.fromRow + 1;
				if(board[j][i + 1] == null || board[j][i - 1] == null){
					valid = valid;
				}
				else if(board[j][i].player() != board[move.fromRow][move.fromColumn].player()){
					valid = true;
					
				}
				else if(board[j][i].player() == board[move.fromRow][move.fromColumn].player()){
					valid = valid;	
				}
				
				
			}
		}
		}
		
		//Check if player is BLACK
		if(board[move.fromRow][move.fromColumn].player() == Player.BLACK){
			
			int i=0;
			int j=0;
			//Check if you moved to the same spot
			if(board[move.fromRow][move.fromColumn] == board[move.toRow][move.toColumn]){
				valid = valid;
			}
		//Check if you moved down 1 space
			if(board[move.fromRow - 1][move.fromColumn] == board[move.toRow][move.toColumn]){
				i = move.fromColumn;
				j = move.fromRow - 1;
				if(board[j][i] == null){
					valid = true;
				}
				else if(board[j][i].player() != board[move.fromRow][move.fromColumn].player()){
					valid = valid;
					
				}
				else if(board[j][i].player() == board[move.fromRow][move.fromColumn].player()){
					valid = valid;	
				}
				
				
			}
		//Check if you are in the WHITE Pawn starting row (1)
			if(board[move.fromRow][move.fromColumn] == board[1][move.toRow]){
		//Check if you moved down 2 spaces
				if(board[move.fromRow - 2][move.fromColumn] == board[move.toRow][move.toColumn]){
					i = move.fromColumn;
					j = move.fromRow - 1;
					
					while(j >= move.toRow){
						if(board[j][i] == null){
							valid = true;
						}
						else if(board[j][i].player() != board[move.fromRow][move.fromColumn].player()){
							valid = valid;
							break;
						}
						else if(board[j][i].player() == board[move.fromRow][move.fromColumn].player()){
							valid = valid;
							break;
						}
						j--;
					}
				}
			}
		//Check to see if you moved down diagonal left or right
			if(board[move.fromRow - 1][move.fromColumn + 1] == board[move.fromRow][move.fromColumn] ||
			   board[move.fromRow - 1][move.fromColumn - 1] == board[move.fromRow][move.fromColumn]){
				i = move.fromColumn;
				j = move.fromRow - 1;
				if(board[j][i + 1] == null || board[j][i - 1] == null){
					valid = valid;
				}
				else if(board[j][i].player() != board[move.fromRow][move.fromColumn].player()){
					valid = true;	
				}
				else if(board[j][i].player() == board[move.fromRow][move.fromColumn].player()){
					valid = valid;	
				}
			}
			
		}
	
		return valid;
		
	}
}
