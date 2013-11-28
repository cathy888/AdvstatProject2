
public class Polynomial {
	
	/* Data Variables */
	private double number;
	private int power;
	
	/** Constructors **/
	
	public Polynomial() {
		number = 0;
		power = 0;
	}
	
	public Polynomial(double x, int y) {
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
