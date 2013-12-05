
import static java.lang.Math.pow;

import java.util.ArrayList;

import models.BisectionComputation;
import models.BisectionIteration;
import models.BisectionOutput;
import models.Point;
import models.SecantComputation;
import models.Term;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SecantComputation sec = new SecantComputation();
		
		ArrayList<Term> Poly = new ArrayList<Term>();
		ArrayList<Point> pair = new ArrayList<Point>();
		
		Poly.add(new Term(1,2));
		Poly.add(new Term(-6,0));
		//pair = sec.secantIteration(Poly, 3, 2, 4);
		//pair = sec.secantThreshold(Poly, 6, 12, 0.0000001);
		//pair = sec.secantThreshold(Poly, 3, 2, 0.000001);
		pair = sec.secantBoth(Poly, 3, 2, 0.000001, 5);
		
		
		for (Point pairAns : pair) {
			System.out.print(pairAns.getX());
			System.out.print("                        " + pairAns.getY() +"\n");
			
		}
		
		{//Bisection-method Testing
			ArrayList<Term> givenPolynomial = new ArrayList<Term>();
			ArrayList<BisectionOutput> testCases = new ArrayList<BisectionOutput>();
			
			givenPolynomial.clear();
			//GIVEN x^2 -78.8 [6,12] round-off to 4 decimal places
			givenPolynomial.add(new Term(1,2));
			givenPolynomial.add(new Term(-78.8,0));
			testCases.add(BisectionComputation.computeBisectionOutput(givenPolynomial, 6, 12, -1,5));
			
			givenPolynomial.clear();
			givenPolynomial.add(new Term(1,2));
			givenPolynomial.add(new Term(-3,0));
			testCases.add(BisectionComputation.computeBisectionOutput(givenPolynomial, 1, 2, 4,-1));
			
			//GIVEN x^3 -x^2 -2 [1,2] round-off to 4 decimal places
			givenPolynomial.clear();
			givenPolynomial.add(new Term(1,3));
			givenPolynomial.add(new Term(-1,1));
			givenPolynomial.add(new Term(-2,0));
			testCases.add(BisectionComputation.computeBisectionOutput(givenPolynomial, 1, 2, 4,20));
			
			
			
			for(BisectionOutput bo : testCases){
				bo.displayBisectionOutput();
			}
		}
		
		
	}
	
	

}
