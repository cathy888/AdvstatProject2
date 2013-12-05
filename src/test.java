
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
		
		//GIVEN x^2 -78.8 [6,12] round-off to 4 decimal places
				ArrayList<Term> givenPolynomial = new ArrayList<Term>();
				givenPolynomial.add(new Term(1,2));
				givenPolynomial.add(new Term(-78.8,0));
				
				BisectionOutput test1 = BisectionComputation.computeBisectionOutput(givenPolynomial, 6, 12, -1,5);
				
				//Display test1
				{
					ArrayList<BisectionIteration> a = test1.getList();
					System.out.println("<<<<<<<<<<START-OF-BISECTION-TESTING>>>>>>>>>> \n \titerationCount: "+a.size());
					for(BisectionIteration i : a){
						System.out.printf("iteration[%d]: a= %.4f  mid= %.4f  b= %.4f |f(a)= %.4f f(mid)= %.4f f(b)= %.4f\n"
								,a.indexOf(i)+1,
								i.getA().getX(),i.getMid().getX(),i.getB().getX(),
								i.getA().getY(),i.getMid().getY(),i.getB().getY());
						
					}
					System.out.println("<<<<<<<<<<END-OF-BISECTION-TESTING>>>>>>>>>>");
				}
	}

}
