package models;

public class BisectionIteration {
	Point a;
	Point b;
	Point mid;

	public BisectionIteration(Point a, Point b, Point mid) {
		this.a = a;
		this.b = b;
		this.mid = mid;
	}

	public Point getA() {
		return a;
	}

	public Point getB() {
		return b;
	}

	public Point getMid() {
		return mid;
	}

}