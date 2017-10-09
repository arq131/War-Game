package gameplay;

import items.Player;

public class WarReporter {
	
	public void log(String log) {
		System.out.println(log);
	}
	
	public void draw(Player playerOne, Player playerTwo, int round) {
		System.out.println("---------Round " + round + "-----------");
		System.out.println(playerOne.getName() + " plays " + playerOne.getDeck().getTopCard() );
		System.out.println(playerTwo.getName() + " plays " + playerTwo.getDeck().getTopCard() );
	}
	
	public void draw(Player playerOne, Player playerTwo, Player playerThree, int round) {
		System.out.println("---------Round " + round + "-----------");
		System.out.println(playerOne.getName() + " plays " + playerOne.getDeck().getTopCard() );
		System.out.println(playerTwo.getName() + " plays " + playerTwo.getDeck().getTopCard() );
		System.out.println(playerThree.getName() + " plays " + playerThree.getDeck().getTopCard() );
	}
	
	public void maxRoundsReached(int rounds) {
		System.out.println("Reached the max number of rounds: " + rounds);
	}
	
	public void getScores(Player playerOne, Player playerTwo) {
		System.out.println("--------------------");
		System.out.println("Score of " + playerOne.getName() + ": " + playerOne.getScore());
		System.out.println("Score of " + playerTwo.getName() + ": " + playerTwo.getScore());
	}
	
	public void getScores(Player playerOne, Player playerTwo, Player playerThree) {
		System.out.println("--------------------");
		System.out.println("Score of " + playerOne.getName() + ": " + playerOne.getScore());
		System.out.println("Score of " + playerTwo.getName() + ": " + playerTwo.getScore());
		System.out.println("Score of " + playerThree.getName() + ": " + playerThree.getScore());
	}
	public void gameFinish(Player player) {
		System.out.println("Game over! " + player.getName() + " won the game! Congratulations.");
	}
	
	public void winner(Player player) {
		System.out.println("The winner is " + player.getName() + "!");
	}
	
	public void tie() {
		System.out.println("All players are out of cards. Tie!");
	}
	
	public void war() {
		System.out.println("War!");
	}
	
	public void gameTie() {
		System.out.println("Both players have the same score. Tie game!");
	}
}
