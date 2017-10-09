package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import gameplay.War;
import gameplay.WarVarientThree;
import items.Card;
import items.Deck;
import items.Player;

public class WarVarientThreeTests {

	/**
	 * Test five cards in each player's deck
	 */
	@Test
	public void fiveCardDeck() {
		Deck playerOneDeck = new Deck();
		Deck playerTwoDeck = new Deck();
		Deck playerThreeDeck = new Deck();
		int[] playerOneCards = {3, 4, 5, 6, 7};
		int[] playerTwoCards = {1, 2, 3, 4, 5};
		int[] playerThreeCards = {4, 5, 6, 7, 8};
		for (int num : playerOneCards) {
			playerOneDeck.addCard(new Card(num, "SPADES"));
		}
		for (int num : playerTwoCards) {
			playerTwoDeck.addCard(new Card(num, "HEARTS"));
		}
		for (int num : playerThreeCards) {
			playerThreeDeck.addCard(new Card(num, "DIAMONDS"));
		}
		Player player1 = new Player("Twitch", playerOneDeck);
		Player player2 = new Player("Rakan", playerTwoDeck);
		Player player3 = new Player("Xayah", playerThreeDeck);
		War game = new WarVarientThree(player1, player2, player3);
		game.playGame();
		
		assertEquals(player3.getName(), game.getWinner().getName());
		
	}
	
	/**
	 * Test two cards in each player's deck
	 */
	@Test
	public void twoCardDeck() {
		Deck playerOneDeck = new Deck();
		Deck playerTwoDeck = new Deck();
		Deck playerThreeDeck = new Deck();
		int[] playerOneCards = {5, 6};
		int[] playerTwoCards = {1, 2};
		int[] playerThreeCards = {3, 4};
		for (int num : playerOneCards) {
			playerOneDeck.addCard(new Card(num, "SPADES"));
		}
		for (int num : playerTwoCards) {
			playerTwoDeck.addCard(new Card(num, "HEARTS"));
		}
		for (int num : playerThreeCards) {
			playerThreeDeck.addCard(new Card(num, "DIAMONDS"));
		}
		Player player1 = new Player("Soraka", playerOneDeck);
		Player player2 = new Player("Janna", playerTwoDeck);
		Player player3 = new Player("Lulu", playerThreeDeck);
		War game = new WarVarientThree(player1, player2, player3);
		game.playGame();
		
		assertEquals(player1.getName(), game.getWinner().getName());
		
	}
	
	/**
	 * Draw between two players from constant war.
	 */
	@Test
	public void draw() {
		Deck playerOneDeck = new Deck();
		Deck playerTwoDeck = new Deck();
		Deck playerThreeDeck = new Deck();
		int[] playerOneCards = {4, 5, 6, 7, 8};
		int[] playerTwoCards = {4, 5, 6, 7, 8};
		int[] playerThreeCards = {1, 2, 3, 4, 5};
		for (int num : playerOneCards) {
			playerOneDeck.addCard(new Card(num, "SPADES"));
		}
		for (int num : playerTwoCards) {
			playerTwoDeck.addCard(new Card(num, "HEARTS"));
		}
		for (int num : playerThreeCards) {
			playerThreeDeck.addCard(new Card(num, "DIAMONDS"));
		}
		Player player1 = new Player("Gnar", playerOneDeck);
		Player player2 = new Player("Fiora", playerTwoDeck);
		Player player3 = new Player("Renekton", playerThreeDeck);
		War game = new WarVarientThree(player1, player2, player3);
		game.playGame();
		
		assertEquals(null, game.getWinner());
		
	}
	
	/**
	 * Player three winning
	 */
	public void playerThreeWin() {
		Deck playerOneDeck = new Deck();
		Deck playerTwoDeck = new Deck();
		Deck playerThreeDeck = new Deck();
		int[] playerOneCards = {4, 5, 6, 7, 6};
		int[] playerTwoCards = {1, 3, 8, 2, 7};
		int[] playerThreeCards = {5, 6, 7, 8, 9};
		for (int num : playerOneCards) {
			playerOneDeck.addCard(new Card(num, "SPADES"));
		}
		for (int num : playerTwoCards) {
			playerTwoDeck.addCard(new Card(num, "HEARTS"));
		}
		for (int num : playerThreeCards) {
			playerThreeDeck.addCard(new Card(num, "DIAMONDS"));
		}
		Player player1 = new Player("Braum", playerOneDeck);
		Player player2 = new Player("Thresh", playerTwoDeck);
		Player player3 = new Player("Blitzcrank", playerThreeDeck);
		War game = new WarVarientThree(player1, player2, player3);
		game.playGame();
		
		assertEquals(player3, game.getWinner());
	}
	
	/**
	 * Player one winning, ignoring war from other two players since
	 * player one has highest card.
	 */
	@Test
	public void PlayerThreeWinAboveWar() {
		Deck playerOneDeck = new Deck();
		Deck playerTwoDeck = new Deck();
		Deck playerThreeDeck = new Deck();
		int[] playerOneCards = {4, 5, 6, 7, 8};
		int[] playerTwoCards = {1, 2, 3, 4, 5};
		int[] playerThreeCards = {1, 2, 3, 4, 5};
		for (int num : playerOneCards) {
			playerOneDeck.addCard(new Card(num, "SPADES"));
		}
		for (int num : playerTwoCards) {
			playerTwoDeck.addCard(new Card(num, "HEARTS"));
		}
		for (int num : playerThreeCards) {
			playerThreeDeck.addCard(new Card(num, "DIAMONDS"));
		}
		Player player1 = new Player("Lucian", playerOneDeck);
		Player player2 = new Player("Nidalee", playerTwoDeck);
		Player player3 = new Player("Kayn", playerThreeDeck);
		War game = new WarVarientThree(player1, player2, player3);
		game.playGame();
		
		assertEquals(player1, game.getWinner());
	}
}
