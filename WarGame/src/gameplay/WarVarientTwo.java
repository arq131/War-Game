package gameplay;

import java.util.Collections;

import items.Card;
import items.Player;

public class WarVarientTwo extends War {

	public WarVarientTwo(Player playerOne, Player playerTwo) {
		super(playerOne, playerTwo);
	}
	
	@Override
	public Player roundWinner(Player player) {
		player.addPoints(downPilePoints);
		downPilePoints = 2;
		return player;
	}

}
