package chess;

public enum GameStatus {
	IN_MENU, // Player is currently in the menu
	IN_PROGRESS, // Game is in progress. No player has won
	BLACK_WON, // Black won the match
	WHITE_WON // White won the match
}