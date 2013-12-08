package models.objects;

public class Iteration {
	
	private Point lower;
	private Point upper;
	private Point mid;
	
	public Iteration() {
		lower = null;
		upper = null;
		mid = null;
	}
	
	public void setLower(double x, double y) {
		lower = new Point(x, y);
	}
	
	public void setUpper(double x, double y) {
		upper = new Point(x, y);
	}
	
	public void setMid(double x, double y) {
		mid = new Point(x, y);
	}
	
	public Point getLower() {
		return lower;
	}
	
	public void setLower(Point lower) {
		this.lower = lower;
	}
	
	public Point getUpper() {
		return upper;
	}
	
	public void setUpper(Point upper) {
		this.upper = upper;
	}
	
	public Point getMid() {
		return mid;
	}
	
	public void setMid(Point mid) {
		this.mid = mid;
	}
	
}
