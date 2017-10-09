package gameplay;

import java.util.ArrayList;
import java.util.Collections;

import items.Card;
import items.Player;

public class War implements WarInterface {
	protected final int maxRounds = 500;
	protected Player playerOne, playerTwo, winner;
	protected Card playerOneCard, playerTwoCard;
	protected WarReporter log;
	protected int downPilePoints = 2, numOfRounds = 1;
	protected ArrayList<Card> pile;
	
	public War(Player playerOne, Player playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		log = new WarReporter();
		pile = new ArrayList<Card>();
		
	}
	public int compareCards() {
		if (playerOneCard.getNumber() > playerTwoCard.getNumber()) {
			return PLAYER_ONE_WINS;
		} else if (playerOneCard.getNumber() < playerTwoCard.getNumber()) {
			return PLAYER_TWO_WINS;
		} else {
			return WAR;
		}
	}

	@Override
	public Player playRound() {
		log.draw(playerOne, playerTwo, numOfRounds);
		
		playerOneCard = playerOne.getDeck().getNextCard();
		playerTwoCard = playerTwo.getDeck().getNextCard();
		pile.add(playerOneCard);
		pile.add(playerTwoCard);
		switch(compareCards()) {
		case PLAYER_ONE_WINS:
			return playerOne;
		case PLAYER_TWO_WINS:
			return playerTwo;
		case WAR:
			return playWar();
		}
		return null;
		
	}

	@Override
	public Player playWar() {
		log.war();
		if (playerOne.getDeckSize() == 0 || playerTwo.getDeckSize() == 0) {
			log.tie();
			return null;
		}
		downPilePoints += 2;
		winner = playRound();
		return winner;
		
	}

	@Override
	public Player roundWinner(Player player) {
		player.addPoints(downPilePoints);
		Collections.shuffle(pile);
		for (Card card : pile) {
			player.getDeck().addCard(card);
		}
		pile.clear();
		downPilePoints = 2;
		return player;
	}

	@Override
	public void playGame() {
		while (playerOne.hasCards() && playerTwo.hasCards()) {
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
		log.getScores(playerOne, playerTwo);
		winner = gameWinner();
		if (winner == null) {
			log.gameTie();
			return;
		}
		log.gameFinish(winner);
		
	}
	
	@Override
	public Player gameWinner() {
		if (playerOne.getScore() > playerTwo.getScore()) {
			return playerOne;
		} else if (playerTwo.getScore() > playerOne.getScore()) {
			return playerTwo;
		} else {
			return null;
		}
	}
	
	public Player getWinner() {
		return this.winner;
	}
}
