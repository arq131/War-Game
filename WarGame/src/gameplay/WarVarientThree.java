package gameplay;

import items.Card;
import items.Player;

public class WarVarientThree extends War {
	protected Player playerThree;
	protected Card playerThreeCard;
	
	public WarVarientThree(Player playerOne, Player playerTwo, Player playerThree) {
		super(playerOne, playerTwo);
		this.playerThree = playerThree;

	}
	
	@Override
	public Player roundWinner(Player player) {
		player.addPoints(downPilePoints);
		downPilePoints = 2;
		return player;
	}
	
	@Override
	public int compareCards() {
		if (playerOneCard.getNumber() > playerTwoCard.getNumber() && playerOneCard.getNumber() > playerThreeCard.getNumber()) {
			return PLAYER_ONE_WINS;
		} else if (playerTwoCard.getNumber() > playerOneCard.getNumber() && playerTwoCard.getNumber() > playerThreeCard.getNumber()) {
			return PLAYER_TWO_WINS;
		} else if (playerThreeCard.getNumber() > playerOneCard.getNumber() && playerThreeCard.getNumber() > playerTwoCard.getNumber()) {
			return PLAYER_THREE_WINS;
		} else {
			return WAR;
		}
	}
	
	@Override
	public Player playWar() {
		log.war();
		if (playerOne.getDeckSize() == 0 || playerTwo.getDeckSize() == 0 || playerThree.getDeckSize() == 0) {
			log.tie();
			return null;
		}
		downPilePoints += 2;
		winner = playRound();
		return winner;
	}
	
	@Override
	public void playGame() {
		// display players
		
		while (playerOne.hasCards() && playerTwo.hasCards() && playerThree.hasCards()) {
			if (numOfRounds > maxRounds) {
				log.maxRoundsReached(numOfRounds);
				break;
			}
			
			winner = playRound();
			
			if (winner == null) // if last card being played is war, can't continue
				break;
			
			roundWinner(winner);
			log.winner(winner);
			numOfRounds++;
			
		}
		log.getScores(playerOne, playerTwo, playerThree);
		winner = gameWinner();
		if (winner == null) {
			log.gameTie();
			return;
		}
		log.gameFinish(winner);
		
	}
	@Override
	public Player playRound() {
		log.draw(playerOne, playerTwo, playerThree, numOfRounds);
		
		playerOneCard = playerOne.getDeck().getNextCard();
		playerTwoCard = playerTwo.getDeck().getNextCard();
		playerThreeCard = playerThree.getDeck().getNextCard();
		
		pile.add(playerOneCard);
		pile.add(playerTwoCard);
		pile.add(playerThreeCard);
		
		switch(compareCards()) {
		case PLAYER_ONE_WINS:
			return playerOne;
		case PLAYER_TWO_WINS:
			return playerTwo;
		case PLAYER_THREE_WINS:
			return playerThree;
		case WAR:
			return playWar();
		}
		return null;
	}
	
	@Override
	public Player gameWinner() {
		if (playerOne.getScore() > playerTwo.getScore() && playerOne.getScore() > playerThree.getScore()) {
			return playerOne;
		} else if (playerTwo.getScore() > playerOne.getScore() && playerTwo.getScore() > playerThree.getScore()) {
			return playerTwo;
		} else if (playerThree.getScore() > playerOne.getScore() && playerThree.getScore() > playerTwo.getScore()) {
			return playerThree;
		} else {
			return null;
		}
	}
}
