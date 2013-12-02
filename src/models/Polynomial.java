package models;

import java.util.ArrayList;

public class Polynomial {
	
	private ArrayList<Nomial> polynomial;
	
	public Polynomial() {
		polynomial = null;
	}
	
	public void setPolynomial(ArrayList<Nomial> polynomial) {
		this.polynomial = polynomial;
	}
	
	public ArrayList<Nomial> getPolynomial() {
		return polynomial;
	}
	
	public void initializePolynomial() {
		polynomial = new ArrayList<>();
	}
	
	public void add(Nomial nomial) {
		polynomial.add(nomial);
	}
	
	public Nomial get(int index) {
		return polynomial.get(index);
	}
	
}
