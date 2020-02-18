public class LifeBoard {
	private boolean[][] matrix;
	private int generation;

	/**
	 * Skapar en spelplan med rows rader och cols kolonner. Spelplanen är från
	 * början tom, dvs alla rutorna är tomma och generationsräknaren är 1.
	 */
	public LifeBoard(int rows, int cols) {
		matrix = new boolean[rows][cols];
		generation = 1;

	}

	/**
	 * Undersöker om det finns en individ i rutan med index row,col, Om index
	 * row,col hamnar utanför spelplanen returneras false.
	 */
	public boolean get(int row, int col) {
		if ((row >= getRows() || row < 0 || col >= getCols() || col < 0)) {
			return false;
		}
		return matrix[row][col];
	}

	/** Lagrar värdet val i rutan med index row,col. */
	public void put(int row, int col, boolean val) {
		if ((row >= getRows() || row < 0 || col >= getCols() || col < 0)) {
		} else {
			matrix[row][col] = val;
		}
	}

	/** Tar reda på antalet rader. */
	public int getRows() {
		return matrix[0].length;
	}

	/** Tar reda på antalet kolonner. */
	public int getCols() {
		return matrix.length;
	}

	/** Tar reda på aktuellt generationsnummer. */
	public int getGeneration() {
		return generation;
	}

	/** Ökar generationsnumret med ett. */
	public void increaseGeneration() {
		generation++;
	}
}
