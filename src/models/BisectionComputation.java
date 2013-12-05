package models;
import java.util.ArrayList;


public class BisectionComputation {
	/*
	 * returns null if invalid input
	 */
	public static BisectionOutput computeBisectionOutput(ArrayList<Term> polynomial, double aX, double bX, int tolerance){
		Point a = new Point(aX,SecantComputation.findY(polynomial, aX));
		Point b = new Point(bX,SecantComputation.findY(polynomial, bX));
		
		if(!(a.getY()>0 && b.getY()<0 || a.getY()<0 && b.getY()>0) && tolerance>0){
			return null;
		}
		if(a.getY()>0 && b.getY()<0){
			Point temp = a;
			a = b;
			b = temp;
		}
		
		BisectionOutput result = new BisectionOutput(tolerance);
		
		double midX = (a.getX()+b.getX())/2;
		Point mid = new Point(midX,SecantComputation.findY(polynomial, midX));
		
		result.insertIteration(a, b, mid);
		
		if(mid.getY()==0){
			return result;
		}
		
		double tol = Math.pow(10,tolerance);
		do{
			if(mid.getY()>0){
				b = mid;
			}else if(mid.getY()<0){
				a = mid;
			}
			
			midX = (a.getX()+b.getX())/2;
			mid = new Point(midX,SecantComputation.findY(polynomial, midX));
			
			result.insertIteration(a, b, mid);
		}while(mid.getY()!=0 && (Math.round(a.getX()*tol)/tol!=Math.round(b.getX()*tol)/tol));
		
		return result;
	}
	
}
