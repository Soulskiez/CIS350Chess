package chess;

public class Bishop extends Piece {
	private Player player;
	
	protected Bishop(Player player){
		super(player);
	}
	@Override
	public Player player(){
		return player;
	}

	@Override
	public String type() {
		return "Bishop";
	}

	@Override
	public boolean isValidMove(Move move, Piece[][] board) {
		
		boolean valid = false;
		int diffC = Math.abs(move.fromColumn - move.toColumn);
		int diffR = Math.abs(move.fromRow - move.toRow);
		int i = 0;
		int j = 0;

		if(diffR == diffC){
			//Move left up
			if(move.fromColumn > move.toColumn && move.fromRow < move.toRow){
				
				i = move.fromColumn - 1;
				j = move.fromRow - 1;
				
				while(i >= move.toColumn && j >= move.toRow){
					if(board[j][i] == null){
						valid = true;
					}
					else if(board[j][i].player() != board[move.fromRow][move.fromColumn].player()){
						valid = true;
						break;
					}
					else if(board[j][i].player() == board[move.fromRow][move.fromColumn].player()){
						valid = valid;
						break;
					}
					i--;
					j--;
				}
			}
			//Move left down
			if(move.fromColumn > move.toColumn && move.fromRow > move.toRow){
				
				i = move.fromColumn - 1;
				j = move.fromRow + 1;
				
				while(i >= move.toColumn && j <= move.toRow){
					if(board[j][i] == null){
						valid = true;
					}
					else if(board[j][i].player() != board[move.fromRow][move.fromColumn].player()){
						valid = true;
						break;
					}
					else if(board[j][i].player() == board[move.fromRow][move.fromColumn].player()){
						valid = valid;
						break;
					}
					i--;
					j++;
				}
			}
			//Move right up
			if(move.fromColumn < move.toColumn && move.fromRow < move.toRow){
				
				i = move.fromColumn + 1;
				j = move.fromRow - 1;
				
				while(i <= move.toColumn && j >= move.toRow){
					if(board[j][i] == null){
						valid = true;
					}
					else if(board[j][i].player() != board[move.fromRow][move.fromColumn].player()){
						valid = true;
						break;
					}
					else if(board[j][i].player() == board[move.fromRow][move.fromColumn].player()){
						valid = valid;
						break;
					}
					i++;
					j--;
				}
			}
			//Move right down
			if(move.fromColumn < move.toColumn && move.fromRow > move.toRow){
				
				i = move.fromColumn + 1;
				j = move.fromRow + 1;
				
				while(i <= move.toColumn && j <= move.toRow){
					if(board[j][i] == null){
						valid = true;
					}
					else if(board[j][i].player() != board[move.fromRow][move.fromColumn].player()){
						valid = true;
						break;
					}
					else if(board[j][i].player() == board[move.fromRow][move.fromColumn].player()){
						valid = valid;
						break;
					}
					i++;
					j++;
				}
			}
		}	
		return valid;
	}
}
