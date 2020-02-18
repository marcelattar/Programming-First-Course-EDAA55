import java.util.Random;


public class RaceTurtle extends Turtle {
	private int nbr;
	
/** Skapar en sköldpadda som ska springa i fönstret w och som har startnummer nbr.
	 Sköldpaddan startar med pennan nere och nosen vänd åt höger. */
public RaceTurtle(RaceWindow w, int nbr) {
	super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
	left(270);
	penDown();
	this.nbr = nbr;
	
}
/** Låter sköldpaddan gå framåt ett slumpmässigt antal steg. Ett steg motsvarar tärningskast (1-6). */
public void raceStep() {
	Random rand = new Random();
	forward(rand.nextInt(6)+1);
	
}
/** Returnerar en läsbar representation av denna RaceTurtle, på formen "Nummer x" där x är
 * sköldpaddans startnummer. */
public String toString() {
	return "Nummer " + nbr;
}
}
