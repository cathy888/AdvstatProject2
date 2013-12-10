package models;

import static java.lang.Math.pow;

import java.util.ArrayList;

import models.objects.Iteration;
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
	
	public static void computeRelativeError(ArrayList<Iteration> iterations){
		double error;
		for(Iteration currentIteration : iterations){
			//skip first iteration
			if(iterations.indexOf(currentIteration)!=0){
				Iteration previousIteration = iterations.get(iterations.indexOf(currentIteration)-1);
				error = currentIteration.getMid().getX() - previousIteration.getMid().getX();
				if(error<0){
					error *=-1;
				}
				currentIteration.setRelativeError(error);
			}else{
				currentIteration.setRelativeError(0);
			}
		}
	}
	
}
