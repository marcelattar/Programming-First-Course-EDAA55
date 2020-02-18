import se.lth.cs.pt.window.SimpleWindow;

public class Square {
	private Point p;
	private int side; // sidlängd

	/**
	 * Skapar en kvadrat med övre, vänstra hörnet i x,y och med sidlängden side.
	 */
	public Square(int x, int y, int side) {
		p = new Point(x, y);
		this.side = side;
	}

	/** Ritar kvadraten i fönstret w. */
	public void draw(SimpleWindow w) {
		int x = p.getX();
		int y = p.getY();
		w.moveTo(x, y);
		w.lineTo(x, y + side);
		w.lineTo(x + side, y + side);
		w.lineTo(x + side, y);
		w.lineTo(x, y);
	}

	/** Raderar bilden av kvadraten i fönstret w. */
	public void erase(SimpleWindow w) {
		w.setLineColor(java.awt.Color.white);
		draw(w);
		w.setLineColor(java.awt.Color.black);
	}

	/** Flyttar kvadraten avståndet dx i x-led, dy i y-led. */
	public void move(int dx, int dy) {
		p.move(dx, dy);
	}

	/** Tar reda på x-koordinaten för kvadratens läge. */
	public int getX() {
		return p.getX();
	}

	/** Tar reda på y-koordinaten för kvadratens läge. */
	public int getY() {
		return p.getY();
	}

	/** Ändra kvadratens sida till side. */
	public void setSide(int side) {
		this.side = side;
	}

	/** Tar reda på kvadratens sida. */
	public int getSide() {
		return side;
	}

	/** Tar reda på kvadratens area. */
	public int getArea() {
		return side * side;
	}

	/** Returerar true om denna kvadrat innesluter punkten (x,y). */
	public boolean contains(int x,int y) {
		return ((x >= p.getX()) && (x <= (p.getX() + side)) && (y >= p.getY()) && (y <= (p.getY() + side))); 
	}
	/** Returerar true om denna kvadrat inneslutar punkten p. */
	public boolean contains(Point c) {
		return contains(c.getX(),c.getY());
		//return ((x >= p.getX()) && (x <= (p.getX() + side)) && (y >= p.getY()) && (y <= (p.getY() + side)));	
	}
	/** Returerar true om denna kvadrat inneslutar alla punkter i kvadraten sq. */
	boolean contains(Square sq) {
		return ((p.getX() <= sq.getX()) && ((p.getX() + side) >= (sq.getX() + sq.getSide())) && (p.getY() <= sq.getY()) && ((p.getY() + side) >= (sq.getY() + sq.getSide())));
	}

}
