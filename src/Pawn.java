package chess;

public class Pawn extends Piece {
	
	protected Pawn(Player player){
		super(player);
	}

	@Override
	public String type() {
		return "Pawn";
	}

	@Override
	public boolean isValidMove(Move move, IPiece[][] board) {
		boolean valid = false;
		
		
		
		return valid;
	}

	@Override
	public boolean firstMove() {
		
		return false;
	}
}
