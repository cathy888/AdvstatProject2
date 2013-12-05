package models;

import java.util.ArrayList;

public class ProjectInput {
	
	private ArrayList<PolynomialItem> polynomial;
	
	public ProjectInput() {
		polynomial = null;
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
	
}
