package gameplay;

import items.Player;

public interface WarInterface {
	public final int PLAYER_ONE_WINS = 1;
	public final int PLAYER_TWO_WINS = 2;
	public final int PLAYER_THREE_WINS = 3;
	public final int WAR = 4;
	
	public Player playRound();
	public Player playWar();
	public Player roundWinner(Player player);
	public void playGame();
	public Player gameWinner();
}
