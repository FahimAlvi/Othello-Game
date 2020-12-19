// TODO: Add Javadoc comments for this class and all its methods. (Task 3)
/**
 * An OthelloControllerHumanVSHuman class consisting of an Othello game and sets two players
 * to play the game.It calls Othello.java and OthelloBoard.java methods to play the game
 * It starts the game,takes input from each player for their turn and provides a report of each move after the turn.
 * at the end if the game is finished it prints the result of the game.
 */
public class OthelloControllerHumanVSHuman {

	protected Othello othello;
	PlayerHuman player1, player2;

	/**
	 * Constructs a new OthelloController with a new Othello game, ready to play
	 * with two users at the console.
	 */
	public OthelloControllerHumanVSHuman() {
		
		this.othello = new Othello();
		this.player1 = new PlayerHuman(this.othello, OthelloBoard.P1);
		this.player2 = new PlayerHuman(this.othello, OthelloBoard.P2);
	}

	/**
	 * This method continues the game until the board is full and puts the player move accordingly at each turn of the player.
	 */
	public void play() {
		
		while (!othello.isGameOver()) {
			this.report();

			Move move = null;
			char whosTurn = othello.getWhoseTurn();

			if (whosTurn == OthelloBoard.P1)
				move = player1.getMove();
			if (whosTurn == OthelloBoard.P2)
				move = player2.getMove();

			this.reportMove(whosTurn, move);
			othello.move(move.getRow(), move.getCol());
		}
		this.reportFinal();
	}
	/**
	 * Prints the number of tokens each player has on the board after the last move and prints which player next
	 * made the move and at which co-rdinate on the board
	 */

	private void reportMove(char whosTurn, Move move) {
		System.out.println(whosTurn + " makes move " + move + "\n");
	}

	private void report() {
		
		String s = othello.getBoardString() + OthelloBoard.P1 + ":" 
				+ othello.getCount(OthelloBoard.P1) + " "
				+ OthelloBoard.P2 + ":" + othello.getCount(OthelloBoard.P2) + "  " 
				+ othello.getWhoseTurn() + " moves next";
		System.out.println(s);
	}
	/**
	 * At the end of the game,it prints the number of token each player has on the board and prints the token
	 * that won the game and Empty if the game is a draw.
	 */
	private void reportFinal() {
		
		String s = othello.getBoardString() + OthelloBoard.P1 + ":" 
				+ othello.getCount(OthelloBoard.P1) + " "
				+ OthelloBoard.P2 + ":" + othello.getCount(OthelloBoard.P2) 
				+ "  " + othello.getWinner() + " won\n";
		System.out.println(s);
	}
	
	/**
	 * Run main to play two Humans against each other at the console.
	 * @param args
	 */
	public static void main(String[] args) {
		
		OthelloControllerHumanVSHuman oc = new OthelloControllerHumanVSHuman();
		oc.play();
	}

}
