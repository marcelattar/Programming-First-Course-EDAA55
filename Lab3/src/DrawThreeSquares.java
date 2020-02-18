import se.lth.cs.pt.window.SimpleWindow;

public class DrawThreeSquares {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");
		Square sq1 = new Square(400, 400, 100);
		sq1.draw(w);
		sq1.move(25,25);
		sq1.draw(w);
		sq1.move(-75,-50);
		sq1.draw(w);
	}
}
