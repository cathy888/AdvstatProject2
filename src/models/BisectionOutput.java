package models;
import java.util.ArrayList;


public class BisectionOutput {
	private ArrayList<BisectionIteration> outputs;
	
	public BisectionOutput(){
		this.outputs = new ArrayList<BisectionIteration>();
	}
	
	public void insertIteration(Point a, Point b, Point mid){
		outputs.add(new BisectionIteration(a,b,mid));
	}
	
	public ArrayList<BisectionIteration> getList(){
		return outputs;
	}
	
	public void displayBisectionOutput(){
		System.out.println("<<<<<<<<<<START-OF-BISECTION-OUTPUT>>>>>>>>>> \nITERATIONCOUNT: "+outputs.size());
		for(BisectionIteration i : outputs){
			System.out.printf("iteration[%d]\t: a= %.4f \t mid= %.4f \t b= %.4f \t f(a)= %.4f \t f(mid)= %.4f \t f(b)= %.4f \t e = %.4f\n"
					,outputs.indexOf(i)+1,
					i.getA().getX(),i.getMid().getX(),i.getB().getX(),
					i.getA().getY(),i.getMid().getY(),i.getB().getY(),
					i.getRelativeError());
			
		}
		System.out.println("<<<<<<<<<<END-OF-BISECTION-OUTPUT>>>>>>>>>>");
	}
	
	public void computeRelativeError(){
		double error;
		for(BisectionIteration currentIteration : outputs){
			//skip first iteration
			if(outputs.indexOf(currentIteration)!=0){
				BisectionIteration previousIteration = outputs.get(outputs.indexOf(currentIteration)-1);
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
