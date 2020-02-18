import java.util.Random;

public class MoleTurtle extends RaceTurtle {
	
public MoleTurtle(RaceWindow w, int nbr) {
	super(w,nbr);
}
public void raceStep() {
	Random rand = new Random();
	int a = rand.nextInt(10) + 1;
	if (a <= 3) {
		penUp();
	}
	else {
		penDown();
	}
	super.raceStep();
}
public String toString() {
	return super.toString() + " - MoleTurtle";
}
}
