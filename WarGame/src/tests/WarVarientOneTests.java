package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import gameplay.War;
import items.Card;
import items.Deck;
import items.Player;

public class WarVarientOneTests {

	/**
	 * Five card in each player's deck
	 */
	@Test
	public void fiveCardDeck() {
		Deck playerOneDeck = new Deck();
		Deck playerTwoDeck = new Deck();
		int[] playerOneCards = {3, 4, 5, 6, 7};
		int[] playerTwoCards = {1, 2, 3, 4, 5};
		for (int num : playerOneCards) {
			playerOneDeck.addCard(new Card(num, "SPADES"));
		}
		for (int num : playerTwoCards) {
			playerTwoDeck.addCard(new Card(num, "HEARTS"));
		}
		Player player1 = new Player("Dr. Mundo", playerOneDeck);
		Player player2 = new Player("Maokai", playerTwoDeck);
		
		War game = new War(player1, player2);
		game.playGame();
		
		assertEquals(player1.getName(), game.getWinner().getName());
		
	}
	
	/**
	 * Two cards in each player's deck
	 */
	@Test
	public void twoCardDeck() {
		Deck playerOneDeck = new Deck();
		Deck playerTwoDeck = new Deck();
		int[] playerOneCards = {3, 4};
		int[] playerTwoCards = {5, 6};
		for (int num : playerOneCards) {
			playerOneDeck.addCard(new Card(num, "SPADES"));
		}
		for (int num : playerTwoCards) {
			playerTwoDeck.addCard(new Card(num, "HEARTS"));
		}
		Player player1 = new Player("Veigar", playerOneDeck);
		Player player2 = new Player("Jinx", playerTwoDeck);
		
		War game = new War(player1, player2);
		game.playGame();
		
		assertEquals(player2.getName(), game.getWinner().getName());
		
	}
	
	/**
	 * Both players have same amount of points 
	 */
	@Test
	public void draw() {
		Deck playerOneDeck = new Deck();
		Deck playerTwoDeck = new Deck();
		int[] playerOneCards = {5, 6, 5, 5};
		int[] playerTwoCards = {5, 6, 5, 5};
		for (int num : playerOneCards) {
			playerOneDeck.addCard(new Card(num, "SPADES"));
		}
		for (int num : playerTwoCards) {
			playerTwoDeck.addCard(new Card(num, "HEARTS"));
		}
		Player player1 = new Player("Anivia", playerOneDeck);
		Player player2 = new Player("Syndra", playerTwoDeck);
		
		War game = new War(player1, player2);
		game.playGame();
		
		assertEquals(null, game.getWinner());
	}
	
	/**
	 * player one winning
	 */
	public void playerOneWin() {
		Deck playerOneDeck = new Deck();
		Deck playerTwoDeck = new Deck();
		int[] playerOneCards = {8, 11, 12, 13};
		int[] playerTwoCards = {1, 3, 13, 4};
		for (int num : playerOneCards) {
			playerOneDeck.addCard(new Card(num, "SPADES"));
		}
		for (int num : playerTwoCards) {
			playerTwoDeck.addCard(new Card(num, "HEARTS"));
		}
		Player player1 = new Player("Twisted Fate", playerOneDeck);
		Player player2 = new Player("Yasuo", playerTwoDeck);
		
		War game = new War(player1, player2);
		game.playGame();
		
		assertEquals(player1, game.getWinner());
	}

}
