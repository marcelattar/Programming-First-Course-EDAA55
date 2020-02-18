import java.util.Scanner;

import se.lth.cs.pt.window.SimpleWindow;

public class SquareDrawer {
	private Scanner scan;
	private SimpleWindow w;

	public SquareDrawer() {
		scan = new Scanner(System.in);
		w = new SimpleWindow(600, 200, "Kvadratritarfönster");
	}
	
	public void runApplication(){
		System.out.println("*** Välkommen till ett textbaserat ritprogram ***");

		while (true) {
			System.out.println("Skriv in kvadratens sidlängd: ");
			int side = scan.nextInt();
			System.out.println("Skriv in kvadratens x-position: ");
			int x = scan.nextInt();
			System.out.println("Skriv in kvadratens y-position: ");
			int y = scan.nextInt();
			
			// Kolla om hela kvadraten ligger innanför fönstret
			if(x+side < w.getWidth() && x > 0 && y+side < w.getHeight() && y > 0 && side > 0){ /** Man var tvungen att ändra Width med Height och dessutom la jag till x,y,side >0.
			Det här var ett kompileringsfel innan. */
				Square sq = new Square(x, y, side); /** Side var skrivet på x:s plats. Det här var ett exekveringsfel. */
				sq.draw(w);
				System.out.println("Kvadraten är nu uppritad.");
			} else {
				System.out.println("Kvadraten får inte plats i fönstret. Försök rita upp en ny.");
			}
		}
	}
	
	public static void main(String[] args) {
		SquareDrawer rita = new SquareDrawer(); /** Var tvungen att skapa ett SquareDrawer objekt. */
		rita.runApplication(); /** runApp ska användas på SquareDrawer objektet som jag skapade ovan. Här var det ett kompileringsfel innan. */
	}
}
