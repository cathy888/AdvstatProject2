package models;

public class Nomial {
	
	private double coefficient;
	private double exponent;
	
	public Nomial() {
		coefficient = 0;
		exponent = 0;
	}
	
	public double getCoefficient() {
		return coefficient;
	}
	
	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	
	public double getExponent() {
		return exponent;
	}
	
	public void setExponent(double exponent) {
		this.exponent = exponent;
	}
	
}