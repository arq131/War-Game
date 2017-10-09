package items;

public class Card {
	private int number;
	private String suit;

	public Card(int number, String suit) {
		this.number = number;
		this.suit = suit;
	}

	public int getNumber() {
		return this.number;
	}

	public String getSuit() {
		return this.suit;
	}

	public String toString() {
		String value;

		switch (number) {
		case 11:
			value = "Jack";
			break;
		case 12:
			value = "Queen";
			break;
		case 13:
			value = "King";
			break;
		default:
			value = Integer.toString(this.number);
		}

		return value + " of " + this.suit;
	}
}
