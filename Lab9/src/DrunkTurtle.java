import java.util.Random;


public class DrunkTurtle extends RaceTurtle {
	private int promille; /** Något mellan 0,1-2,5. Varje steg är 4 %, det finns tot 25 steg. */
	
	public DrunkTurtle(RaceWindow w, int nbr, int promille) {
		super(w, nbr);
		this.promille = promille;
	}
	public void raceStep() {
		int a = promille * 6;  
		Random rand = new Random();
		int degree = rand.nextInt(a);
		if (rand.nextInt(2) == 1) { /** Slumpar om den ska vrida sig till höger eller vänster. */
			degree = -degree;
		}
		left(degree);
		super.raceStep();
		left(-degree);
		super.raceStep();
	}
	public String toString() {
		return super.toString() + " - DrunkTurtle";
	}
}
