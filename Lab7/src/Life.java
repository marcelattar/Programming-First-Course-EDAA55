public class Life {
	private LifeBoard board;

	/** Skapar ett Life-spel med spelplanen board. */
	public Life(LifeBoard board) {
		this.board = board;
	}

	/** Skapar en ny generation. */
	public void newGeneration() {
		board.increaseGeneration();
		LifeBoard altboard = new LifeBoard(board.getRows(), board.getCols());

		for (int kolonn = 0; kolonn < board.getCols(); kolonn++) {
			for (int rad = 0; rad < board.getRows(); rad++) {
				int n = Grannar(rad, kolonn);
				if (board.get(rad, kolonn)) {
					if (n > 3 || n < 2) {
						altboard.put(rad, kolonn, false); /** Här dör individen. */
					} else if (n == 2 || n == 3) { /** Här lever individen vidare. */
						altboard.put(rad, kolonn, true); /** Skulle kunna skita i att skriva detta tror jag. */
					}
				} else if(board.get(rad, kolonn) == false) {
					if (n==3) {
						altboard.put(rad, kolonn, true); /** Här föds en individ. */
					}
				}

			}
		}
		for (int l=0; l < board.getCols(); l++) {
			for(int i=0; i < board.getRows(); i++) {
				board.put(i,l, altboard.get(i,l));
		}
	}
	}

	/**
	 * Ändrar innehållet i rutan med index row, col från individ till tom eller
	 * tvärtom.
	 */
	public void flip(int row, int col) {
		if (board.get(row, col)) {
			board.put(row, col, false);
		} else {
			board.put(row, col, true);
		}
	}

	private int Grannar(int row, int col) {
		int n = 0;
		if (board.get(row, col + 1)) {
			n++;
		}
		if (board.get(row + 1, col + 1)) {
			n++;
		}
		if (board.get(row + 1, col)) {
			n++;
		}
		if (board.get(row + 1, col - 1)) {
			n++;
		}
		if (board.get(row, col - 1)) {
			n++;
		}
		if (board.get(row - 1, col - 1)) {
			n++;
		}
		if (board.get(row - 1, col)) {
			n++;
		}
		if (board.get(row - 1, col + 1)) {
			n++;
		}
		return n;
	}

}
