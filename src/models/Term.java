package models;

public class Term {
	
	/* Data Variables */
	private double number;
	private double power;
	
	/** Constructors **/
	
	public Term() {
		number = 0;
		power = 0;
	}
	
	public Term(double x, double y) {
		this.number = x;
		this.power = y;
	}
	
	/** Getters and Setters **/
	
	public void setNumber(double x) {
		this.number = x;
	}
	
	public void setPower(double power) {
		this.power = power;
	}
	
	public double getNumber() {
		return number;
	}
	
	public double getPower() {
		return power;
	}
	
}
