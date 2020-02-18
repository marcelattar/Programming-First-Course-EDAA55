import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
	private double x;
	private double y;
	private double direction;
	private boolean pen;
	private SimpleWindow w;

	/** Skapar en sköldpadda som ritar i ritfönstret w. Från början 
	    befinner sig sköldpaddan i punkten x, y med pennan lyft och 
	    huvudet pekande rakt uppåt i fönstret (i negativ y-riktning). */
	public Turtle(SimpleWindow w, int x, int y) {
		this.x = x;
		this.y = y;
		pen = false;
		direction = Math.PI/2;
		this.w = w;

	}

	/** Sänker pennan. */
	public void penDown() {
		pen = true;

	}
	
	/** Lyfter pennan. */
	public void penUp() {
		pen = false;

	}
	
	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		if(pen) {
			w.moveTo((int) Math.round(x),(int) Math.round(y));
			x = x + (n * Math.cos(direction));
			y = y - (n * Math.sin(direction));
			w.lineTo((int) Math.round(x),(int) Math.round(y));
		} else {
			x = x + n*Math.cos(direction);
			y = y - n*Math.sin(direction);
			w.moveTo((int) Math.round(x),(int) Math.round(y));
		}
	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		direction = direction + 2*Math.PI*beta/360;

	}

	/** Går till punkten newX, newY utan att rita. Pennans läge (sänkt
	    eller lyft) och huvudets riktning påverkas inte. */
	public void jumpTo(int newX, int newY) {
		w.moveTo(newX, newY);
		x = newX;
		y = newY;
	
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		direction = Math.PI/2;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) Math.round(x);
	}

 	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) Math.round(y);
	}
  
	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
 	public int getDirection() {
 		return (int) Math.round(360*direction/(2*Math.PI));
	}
}
