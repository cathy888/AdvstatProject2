import static java.lang.Math.pow;

import java.util.ArrayList;


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
		Poly.add(new Term(-78.8,0));
		pair = sec.secant(Poly, 6, 12, 4);
		
		for (Point pairAns : pair) {
			System.out.println(pairAns.getX());
			System.out.println(pairAns.getY());
		}
	}

}
