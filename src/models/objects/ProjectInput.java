package models.objects;

import java.util.ArrayList;

public class ProjectInput {
	
	private ArrayList<Term> polynomial;
	private double x0;
	private double x1;
	private Limit iteration;
	private Limit threshold;
	
	public ProjectInput() {
		polynomial = null;
		iteration = null;
		threshold = null;
	}
	
	public void setPolynomial(ArrayList<Term> polynomial) {
		this.polynomial = polynomial;
	}
	
	public ArrayList<Term> getPolynomial() {
		return polynomial;
	}
	
	public void initializePolynomial() {
		polynomial = new ArrayList<>();
	}
	
	public void add(Term term) {
		polynomial.add(term);
	}
	
	public Term get(int index) {
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
