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

	
	public boolean isValidMove(Move move, Piece[][] board) {
		boolean valid = false;
		return valid;
	}
}
