package models;
import java.util.ArrayList;


public class BisectionOutput {
	private ArrayList<BisectionIteration> outputs;
	private double tolerance;
	
	public BisectionOutput(int tolerance){
		this.outputs = new ArrayList<BisectionIteration>();
		this.tolerance = tolerance;
	}
	
	public void insertIteration(Point a, Point b, Point mid){
		outputs.add(new BisectionIteration(a,b,mid));
	}
	
	public ArrayList<BisectionIteration> getList(){
		return outputs;
	}
	
	public double getRoot(){
		BisectionIteration lastIteration = outputs.get(outputs.size()-1);
		Point a = lastIteration.getA();
		double tol =  Math.pow(10,this.tolerance);
		return Math.round(a.getX()*tol)/tol;
	}
	
}
