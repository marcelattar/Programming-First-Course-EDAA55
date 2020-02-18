public class patiens {
	private static final Card[] Card = null;

	public static void main(String[] args) {
		CardDeck kortlek = new CardDeck();
		int patiens = 0;
		double l = 10000000.0;
		int counter = 1;
		Card c = new Card(1, 1);
		boolean success = false;
		
		for (int k = 0; k < l; k++) {
			kortlek.shuffle();
			counter = 1;
			success = false;

			while (kortlek.moreCards() && (success == false)) {
				c = kortlek.getCard();
				if (c.getRank() == counter) {
					patiens++;
					success = true;
				}
				counter++;
				if (counter > 3) {
					counter = 1;
				}
			}
		}
		System.out.println(1 - (patiens / l));
	}

}
