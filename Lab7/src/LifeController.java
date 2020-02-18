public class LifeController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LifeBoard board = new LifeBoard(9,9);
		LifeView view = new LifeView(board);
		Life life = new Life(board);

		while (true) {
			int tryck = view.getCommand();
			
			if (tryck == 3) { /** Klick på quit-knappen. */
				System.exit(0);
			} else if (tryck == 1) { /** Klick i ruta på spelplanen.*/
				life.flip(view.getRow(), view.getCol());
			} else {
				life.newGeneration();
				view.update();
			}
			view.update();
		}

	}

}
