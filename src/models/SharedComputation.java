package models;

import static java.lang.Math.pow;

import java.util.ArrayList;

import models.objects.Term;

public class SharedComputation {
	
	public SharedComputation() {}
	
	public static double findY(ArrayList<Term> polynomial, double x) {
		double y = 0;
		
		for (Term poly : polynomial) {
			y += poly.getNumber() * pow(x, poly.getPower());
		}
		
		return y;
	}
	
}
