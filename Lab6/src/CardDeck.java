import java.util.Random;

public class CardDeck {
	private Card[] cards;
	private int current; // index för "nästa" kort.
	private static Random rand = new Random();

	/** Skapar en kortlek. */
	public CardDeck() {
		cards = new Card[52];
		current = 0;
		for (int suit = Card.SPADES; suit <= Card.CLUBS; suit++) {
			for (int i = 1; i <= 13; i++) {
				cards[current] = new Card(suit, i);
				current++;
			}

		}

	}

	/** Blandar kortleken. */
	public void shuffle() {
		for (int i = 0; i < cards.length; i++) {
			int nbr = rand.nextInt(cards.length -1);
			Card temp = cards[i];
			cards[i] = cards[nbr];
			cards[nbr] = temp;
			
			
		}
		current = 52;
	}

	/** Tar reda på om det finns fler kort i kortleken. */
	public boolean moreCards() {
		return ( (current > 0) );
	}

	/** Drar det översta kortet i leken. */
	public Card getCard() {
		current = current - 1;
		return cards[current];
	}
}
