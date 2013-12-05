package models;

public class Term {
	
	/* Data Variables */
	private double number;
	private int power;
	
	/** Constructors **/
	
	public Term() {
		number = 0;
		power = 0;
	}
	
	public Term(double x, int y) {
		this.number = x;
		this.power = y;
	}
	
	/** Getters and Setters **/
	
	public void setNumber(double x) {
		this.number = x;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	public double getNumber() {
		return number;
	}
	
	public int getPower() {
		return power;
	}
	
}
