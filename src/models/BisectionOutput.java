package models;

import java.util.ArrayList;

import models.objects.Iteration;
import models.objects.Point;

public class BisectionOutput {
	private ArrayList<Iteration> outputs;
	
	public BisectionOutput(){
		this.outputs = new ArrayList<Iteration>();
	}

	public void insertIteration(Point a, Point b, Point mid) {
		Iteration iteration = new Iteration();
		iteration.setLower(a);
		iteration.setUpper(b);
		iteration.setMid(mid);
		outputs.add(iteration);
	}

	public ArrayList<Iteration> getList() {
		return outputs;
	}
	
	public void displayBisectionOutput(){
		System.out.println("<<<<<<<<<<START-OF-BISECTION-OUTPUT>>>>>>>>>> \nITERATIONCOUNT: "+outputs.size());
		for(Iteration i : outputs){
			System.out.printf("iteration[%d]\t: a= %.4f \t mid= %.4f \t b= %.4f \t f(a)= %.4f \t f(mid)= %.4f \t f(b)= %.4f \t e = %.4f\n"
					,outputs.indexOf(i)+1,
					i.getLower().getX(),i.getMid().getX(),i.getUpper().getX(),
					i.getLower().getY(),i.getMid().getY(),i.getUpper().getY(),
					i.getRelativeError());
		
		}
		System.out.println("<<<<<<<<<<END-OF-BISECTION-OUTPUT>>>>>>>>>>");
	}
	
}
