import java.util.Random;


public class AbsentMindedTurtle extends RaceTurtle {
	private int abs; /** Ett slumptal mellan 0-100. */
	
public AbsentMindedTurtle(RaceWindow w, int nbr) {
	super(w, nbr);
	Random rand = new Random();
	abs = rand.nextInt(101);
}
public void raceStep() {
	Random rand = new Random();
	int a = rand.nextInt(101);
	if (abs >= a) {
		super.raceStep();
	}
}
public String toString() {
	return super.toString() + " - AbsentMindedTurtle"; 
}

}
