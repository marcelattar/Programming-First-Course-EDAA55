import java.util.ArrayList;


public class TurtleRace {
	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		ArrayList<RaceTurtle> turtles = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> seplist = new ArrayList<RaceTurtle>();
		
		for (int i = 1; i<9;i++) {
			RaceTurtle r = new RaceTurtle(w, i);
			turtles.add(r);
		}
		while (turtles.size() != 0) {
			
			for (int i = 0; i<turtles.size(); i++) {
				//RaceTurtle r = turtles.get(i);
				turtles.get(i).raceStep();
				if (!(turtles.get(i).getX() < RaceWindow.X_END_POS)) {
					seplist.add(turtles.get(i));
					turtles.remove(i);
				}
			}
			RaceWindow.delay(10);
		}
		RaceTurtle plats1 = seplist.get(0);
		RaceTurtle plats2 = seplist.get(1);
		RaceTurtle plats3 = seplist.get(2);
		
		
		System.out.println("På plats 1: " + plats1.toString());
		System.out.println("På plats 2: " + plats2.toString());
		System.out.println("På plats 2: " + plats3.toString());
	}
	
}
