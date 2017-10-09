package items;

public class Player {
	private String name;
	private Deck deck;
	private int score;
	
	public Player(String name) {
		this.name = name;
		this.score = 0;
	}
	
	public Player(String name, Deck deck) {
		this.name = name;
		this.deck = deck;
		this.score = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Deck getDeck() {
		return this.deck;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	public boolean hasCards() {
		if (this.deck.getDeckSize() > 0) 
			return true;
		else
			return false;
	}
	
	public void addPoints(int points) {
		this.score += points;
	}
	
	public int getDeckSize() {
		return this.getDeck().getDeckSize();
	}
	
}
