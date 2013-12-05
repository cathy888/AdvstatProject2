package models;
import java.util.ArrayList;


public class BisectionComputation {
	/*
	 * returns null if invalid input
	 */
	public static BisectionOutput computeBisectionOutput(ArrayList<Term> polynomial, double aX, double bX, int tolerance, int iterationLimit){
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
		int iteration =0;
		double tol = Math.pow(10,tolerance);
		
		do{
			//choose new side of the binary split
			iteration++;
			if(mid.getY()>0){
				b = mid;
			}else if(mid.getY()<0){
				a = mid;
			}
			
			//get new iteration midpoint
			midX = (a.getX()+b.getX())/2;
			mid = new Point(midX,SecantComputation.findY(polynomial, midX));
			
			result.insertIteration(a, b, mid);
		}while( !isMidPointExactRoot(mid) && !arePointsEqualWithinDecimalTolerance(a,b,tol,tolerance) && !isIterationLimitReached(iterationLimit,iteration));
		
		return result;
	}
	
	public static boolean isMidPointExactRoot(Point mid){
		if(mid.getY()==0){
			System.out.println("t1");
			return true;
		}
		return false;
	}
	
	public static boolean arePointsEqualWithinDecimalTolerance(Point a,Point b,double tol,int tolerance){
		System.out.println("tol: " + tol);
		if(tolerance==-1){
			return false;
		}
		else if(Math.round(a.getX()*tol)/tol==Math.round(b.getX()*tol)/tol){
			System.out.println("t2");
			return true;
		}
		return false;
	}
	
	public static boolean isIterationLimitReached(int limit, int i){
		if(limit==-1){
			return false;
		}else if(limit==i+1){
			System.out.println("t3");
			return true;
		}
		
		return false;
	}
	
}
