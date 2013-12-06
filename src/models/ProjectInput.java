package models;

import java.util.ArrayList;

public class ProjectInput {
	
	private ArrayList<PolynomialItem> polynomial;
	private double x0;
	private double x1;
	private Limit iteration;
	private Limit threshold;
	
	public ProjectInput() {
		polynomial = null;
		iteration = null;
		threshold = null;
	}
	
	public void setPolynomial(ArrayList<PolynomialItem> polynomial) {
		this.polynomial = polynomial;
	}
	
	public ArrayList<PolynomialItem> getPolynomial() {
		return polynomial;
	}
	
	public void initializePolynomial() {
		polynomial = new ArrayList<>();
	}
	
	public void add(PolynomialItem nomial) {
		polynomial.add(nomial);
	}
	
	public PolynomialItem get(int index) {
		return polynomial.get(index);
	}
	
	public double getX0() {
		return x0;
	}
	
	public void setX0(double x0) {
		this.x0 = x0;
	}
	
	public double getX1() {
		return x1;
	}
	
	public void setX1(double x1) {
		this.x1 = x1;
	}
	
	public void setIteration(Limit iteration) {
		this.iteration = iteration;
	}
	
	public Limit getIteration() {
		return iteration;
	}
	
	public void setThreshold(Limit threshold) {
		this.threshold = threshold;
	}
	
	public Limit getThreshold() {
		return threshold;
	}
	
}
