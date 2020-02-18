
import se.lth.cs.pt.window.SimpleWindow;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleWindow w = new SimpleWindow(600,600, "New window");
		int gamlaX = 250;
		int gamlaY = 250;
		int side = 50;
		Square sq = new Square(gamlaX, gamlaY, side);
		Square sq1 = new Square(250,250,100);
		sq1.draw(w);
		sq.draw(w);
		while (true) {
			w.waitForMouseClick();
			int nyaX = w.getMouseX();
			int nyaY = w.getMouseY();
			int dx = (nyaX - gamlaX);
			int dy = (nyaY - gamlaY);
			sq.move(dx,dy);
			sq.draw(w);
			gamlaX = nyaX;
			gamlaY = nyaY;
			if (sq1.contains(sq)) {
				System.out.println("Den är inuti.");
			}
			

	}
	}
}
