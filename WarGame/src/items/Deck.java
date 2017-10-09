package items;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> deck;
	private static final String[] suits = {"CLUBS", "DIAMONDS", "SPADES", "HEARTS"};
	
	public Deck() {
		this.deck = new ArrayList<Card>(52);
	}
	
	public void newDeck() {
		for (String suit : suits) {
			for (int i = 1; i < 14; i++)
				this.deck.add(new Card(i, suit));
		}
		
	}
	
	public void setDeck(ArrayList<Card> newDeck) {
		this.deck = newDeck;
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public int getDeckSize() {
		return deck.size();
	}
	
	public void clearDeck() {
		deck.clear();
	}
	
	public Card getTopCard() {
		if (getDeckSize() != 0) 
			return deck.get(0);
		else
			return null;
	}
	
	public void addCard(Card newCard) {
		deck.add(newCard);
	}
	
	public Card getNextCard() {
		return this.deck.remove(0);
	}
	
	public void printDeck() {
		for (Card card : deck) {
			System.out.println(card);
		}
	}
	
}
