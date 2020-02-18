import java.util.ArrayList;
import java.util.Random;


public class TurtleRace {
	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		ArrayList<RaceTurtle> turtles = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> seplist = new ArrayList<RaceTurtle>();
		
		for (int i = 1; i<9;i++) {
			Random rand = new Random();
			Random rand2 = new Random();
			int slump = rand.nextInt(3);
			if (slump == 0) {
				DrunkTurtle r = new DrunkTurtle(w, i, rand2.nextInt(5)+1);
				turtles.add(r);
			}
			if (slump == 1) {
				AbsentMindedTurtle r  = new AbsentMindedTurtle(w, i);
				turtles.add(r);
			}
			if (slump == 2) {
				MoleTurtle r = new MoleTurtle(w, i);
				turtles.add(r);
			}
		}
		while (turtles.size() != 0) {
			
			for (int i = 0; i<turtles.size(); i++) {
				turtles.get(i).raceStep();
				if (!(turtles.get(i).getX() < RaceWindow.X_END_POS)) {
					seplist.add(turtles.get(i));
					turtles.remove(i);
				}
			}
			RaceWindow.delay(20);
		}
		RaceTurtle plats1 = seplist.get(0);
		RaceTurtle plats2 = seplist.get(1);
		RaceTurtle plats3 = seplist.get(2);
		
		
		System.out.println("På plats 1: " + plats1.toString());
		System.out.println("På plats 2: " + plats2.toString());
		System.out.println("På plats 2: " + plats3.toString());
	}
	
}
