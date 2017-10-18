package chess;

public class Board {
	
	private String[][] board;
	
	private Board () {
		board = new int[8][8];
		
	}
	
	private void setUpBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = "*";
			}
		}
	}
	
	private void renderBoard() {
		for (int)
	}
	
	
	private void playLoop() {
		
	}
	
	public static void main(String[] arg) {
		System.out.println("Test");
		Board board = new Board();
		board.renderBoard();
	}
	

}
