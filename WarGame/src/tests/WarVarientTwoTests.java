package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import gameplay.War;
import gameplay.WarVarientTwo;
import items.Card;
import items.Deck;
import items.Player;

public class WarVarientTwoTests {

	/**
	 * five cards in each deck
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
		Player player1 = new Player("Volibear", playerOneDeck);
		Player player2 = new Player("Fiora", playerTwoDeck);
		
		War game = new War(player1, player2);
		game.playGame();
		
		assertEquals(player1.getName(), game.getWinner().getName());
		
	}
	
	/**
	 * ten cards in each deck
	 */
	@Test
	public void tenCardDeck() {
		Deck playerOneDeck = new Deck();
		Deck playerTwoDeck = new Deck();
		int[] playerOneCards = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int[] playerTwoCards = {5, 6, 7, 8, 9, 10, 11, 12, 1, 2};
		for (int num : playerOneCards) {
			playerOneDeck.addCard(new Card(num, "SPADES"));
		}
		for (int num : playerTwoCards) {
			playerTwoDeck.addCard(new Card(num, "HEARTS"));
		}
		Player player1 = new Player("Draven", playerOneDeck);
		Player player2 = new Player("Vayne", playerTwoDeck);
		
		War game = new WarVarientTwo(player1, player2);
		game.playGame();
		
		assertEquals(player2.getName(), game.getWinner().getName());
		
	}
	
	/**
	 * both players have same amount of points
	 */
	@Test
	public void draw() {
		Deck playerOneDeck = new Deck();
		Deck playerTwoDeck = new Deck();
		int[] playerOneCards = {5, 6, 8, 9};
		int[] playerTwoCards = {8, 7, 5, 5};
		for (int num : playerOneCards) {
			playerOneDeck.addCard(new Card(num, "SPADES"));
		}
		for (int num : playerTwoCards) {
			playerTwoDeck.addCard(new Card(num, "HEARTS"));
		}
		Player player1 = new Player("Shaco", playerOneDeck);
		Player player2 = new Player("Lee Sin", playerTwoDeck);
		
		War game = new WarVarientTwo(player1, player2);
		game.playGame();
		
		assertEquals(null, game.getWinner());
	}
	
	/**
	 * empty deck for each player
	 */
	@Test
	public void emptyDeck() {
		Deck playerOneDeck = new Deck();
		Deck playerTwoDeck = new Deck();

		Player player1 = new Player("Kha'zix", playerOneDeck);
		Player player2 = new Player("Rengar", playerTwoDeck);
		
		War game = new WarVarientTwo(player1, player2);
		game.playGame();
		
		assertEquals(null, game.getWinner());
	}

}
