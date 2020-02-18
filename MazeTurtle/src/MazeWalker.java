import java.util.Scanner;
import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;


public class MazeWalker {
	private Turtle turtle;
	
	public MazeWalker(Turtle turtle) {
		this.turtle = turtle;
	}
	/** Låter sköldpaddan vandra genom labyrinten maze, från ingången till utgången. */
	public void walk(Maze maze) {
		turtle.penDown();
		turtle.jumpTo(maze.getXEntry(),maze.getYEntry());
		while (!(maze.atExit(turtle.getX(),turtle.getY()))) {
			
			if (maze.wallAtLeft(turtle.getDirection(), turtle.getX(), turtle.getY()) && maze.wallInFront(turtle.getDirection(), turtle.getX(), turtle.getY()) == false ) {
				turtle.forward(1);
			}
			else if (maze.wallAtLeft(turtle.getDirection(), turtle.getX(), turtle.getY()) == false && maze.wallInFront(turtle.getDirection(), turtle.getX(), turtle.getY()) == false ) {
				turtle.left(90);
				turtle.forward(1);
			}
			else if (maze.wallAtLeft(turtle.getDirection(), turtle.getX(), turtle.getY()) && maze.wallInFront(turtle.getDirection(), turtle.getX(), turtle.getY()) && maze.wallAtLeft(turtle.getDirection() + 90, turtle.getX(), turtle.getY()) == false ) {
				turtle.left(270);
				turtle.forward(1);
			}
			else if (maze.wallAtLeft(turtle.getDirection(), turtle.getX(), turtle.getY()) == false && maze.wallInFront(turtle.getDirection(), turtle.getX(), turtle.getY())) {
				turtle.left(90);
				turtle.forward(1);
			}
			else if (maze.wallAtLeft(turtle.getDirection(), turtle.getX(), turtle.getY()) && maze.wallInFront(turtle.getDirection(), turtle.getX(), turtle.getY()) && maze.wallAtLeft(turtle.getDirection() + 90, turtle.getX(), turtle.getY())) {
				turtle.left(180);
				turtle.forward(1);
			}
			maze.delay(5);
		}
	}
	
	
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(400,400, "hej");
		Turtle turtle = new Turtle(w, 0,0);
		Scanner scan = new Scanner(System.in);
		boolean test = false;
		int siffra = 0;
		System.out.println("Skriv en siffra mellan 1-5 för att bestämma vilken nivå labyrinten ska vara:");
		while (test == false) {
			int i = scan.nextInt();
			if (i < 6 && i > 0) {
				test = true;
				siffra = i;
			} else {
				System.out.println("Du är ej inom intervallet... försök igen.");
			}
		}
		Maze labyrint = new Maze(siffra);
		MazeWalker walker = new MazeWalker(turtle);
		
		labyrint.draw(w);
		walker.walk(labyrint);
		System.out.println("Grattis du klarade det!");
	}
}
