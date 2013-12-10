package models;


public class BisectionIteration{
	private Point a;
	private Point b;
	private Point mid;
	private double relativeError;
	
	public BisectionIteration(Point a, Point b, Point mid){
		this.a = a;
		this.b = b;
		this.mid = mid;
	}
	
	public Point getA(){
		return a;
	}
	public Point getB(){
		return b;
	}
	public Point getMid(){
		return mid;
	}
	
	public void setRelativeError(double relativeError){
		this.relativeError = relativeError;
	}
	public double getRelativeError(){
		return relativeError;
	}
	
	
		
}