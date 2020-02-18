import java.util.Random;
import se.lth.cs.pt.window.SimpleWindow;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleWindow w = new SimpleWindow(600, 600, "hej");
		Turtle t1 = new Turtle(w, 350, 350);
		Turtle t2 = new Turtle(w, 250, 250);
		Random rand = new Random();
		t1.penDown();
		t2.penDown();
		while ((Math.hypot(t1.getX() - t2.getX(), t1.getY() - t2.getY()) >= 50)) {
			t1.left(rand.nextInt(361) - 180);
			t2.left(rand.nextInt(361) - 180);
			t1.forward(rand.nextInt(10) + 1);
			t2.forward(rand.nextInt(10) + 1);
			SimpleWindow.delay(2);
			if ((t1.getX() >= 599)) {
				t1.jumpTo(1, t1.getY());
			}
			if (t1.getX() <= 1) {
				t1.jumpTo(599, t1.getY());
			}
			if ((t2.getX() >= 599)) {
				t2.jumpTo(1, t2.getY());
			}
			if (t2.getX() <= 1) {
				t2.jumpTo(599, t2.getY());
			}
			if ((t1.getY() >= 599)) {
				t1.jumpTo(t1.getX(), 1);
			}
			if (t1.getY() <= 1) {
				t1.jumpTo(t1.getX(), 599);
			}
			if ((t2.getY() >= 599)) {
				t2.jumpTo(t2.getX(), 1);
			}
			if (t2.getY() <= 1) {
				t2.jumpTo(t2.getX(), 599);

			}
		}
	}
}