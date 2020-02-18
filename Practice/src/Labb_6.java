
public class Labb_6 {

	
	/** Skapar en kortlek. */
	public CardDeck() {
		cards = new Card[52];
		for (int suit = Card.SPADES; suit <= Card.CLUBS; suit++) {
			current = -1;
				for (int i = 1; i <= 13; i++) {
					cards[current + suit] = new Card(suit, i);
					current = current + 5;
}
