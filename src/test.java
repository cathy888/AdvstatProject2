import java.util.ArrayList;

import models.BisectionComputation;
import models.BisectionOutput;
import models.SecantComputation;
import models.objects.Iteration;
import models.objects.Point;
import models.objects.Term;

public class test {
	public static void main(String[] args) {
		ArrayList<Term> Poly = new ArrayList<Term>();
		ArrayList<Iteration> pair = new ArrayList<Iteration>();
		
		Poly.add(new Term(1, 2));
		Poly.add(new Term(-6, 0));
		 //pair = SecantComputation.secantIteration(Poly, 3, 2, 4);
		// pair = sec.secantThreshold(Poly, 6, 12, 0.0000001);
		 pair = SecantComputation.secantThreshold(Poly, 3, 2, 0.000001);
		//pair = SecantComputation.secantBoth(Poly, 3, 2, 0.000001, 5);
		
		for (Iteration pairAns : pair) {
			System.out.print(pairAns.getMid().getX());
			System.out.print("       " + pairAns.getMid().getY());
			System.out.print("       " + pairAns.getRelativeError() + "\n");
		}
		
		/*{
			// Bisection-method Testing
			ArrayList<Term> givenPolynomial = new ArrayList<Term>();
			ArrayList<BisectionOutput> testCases = new ArrayList<BisectionOutput>();
			
			givenPolynomial.clear();
			// GIVEN x^2 -78.8 [6,12] round-off to 4 decimal places
			givenPolynomial.add(new Term(1, 2));
			givenPolynomial.add(new Term(-78.8, 0));
			testCases.add(BisectionComputation.computeBisectionOutput(givenPolynomial, 6, 12, -1, 5));
			
			givenPolynomial.clear();
			givenPolynomial.add(new Term(1, 2));
			givenPolynomial.add(new Term(-3, 0));
			testCases.add(BisectionComputation.computeBisectionOutput(givenPolynomial, 1, 2, 4, -1));
			
			// GIVEN x^3 -x^2 -2 [1,2] round-off to 4 decimal places
			givenPolynomial.clear();
			givenPolynomial.add(new Term(1, 3));
			givenPolynomial.add(new Term(-1, 1));
			givenPolynomial.add(new Term(-2, 0));
			testCases.add(BisectionComputation.computeBisectionOutput(givenPolynomial, 1, 2, 4, 20));
			
			for (BisectionOutput bo : testCases) {
				bo.displayBisectionOutput();
			}
		}*/
	}
}