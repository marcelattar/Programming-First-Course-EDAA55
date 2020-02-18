	import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class AnimatedSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleWindow w = new SimpleWindow(600, 600, "Hi");
		int gamlaX = 250;
		int gamlaY = 250;
		int side = 100;
		Square sq = new Square(gamlaX, gamlaY, side);
		sq.draw(w);
		while (true) {
			w.waitForMouseClick();
			int nyaX = w.getMouseX();
			int nyaY = w.getMouseY();
			int dx = (nyaX - gamlaX);
			int dy = (nyaY - gamlaY);
			for (int i = 1; i <= 10; i = i + 1) {
				sq.erase(w);
				sq.move(dx / 10, dy / 10);
				sq.draw(w);
				SimpleWindow.delay(10);
				sq.erase(w);
				sq.draw(w);
			}
			gamlaX = nyaX;
			gamlaY = nyaY;
		}

	}
}
