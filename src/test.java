import static java.lang.Math.pow;

import java.util.ArrayList;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SecantComputation sec = new SecantComputation();
		
		ArrayList<Polynomial> Poly = new ArrayList<Polynomial>();
		ArrayList<Pair> pair = new ArrayList<Pair>();
		
		Poly.add(new Polynomial(1,2));
		Poly.add(new Polynomial(-78.8,0));
		pair = sec.secant(Poly, 6, 12, 4);
		
		for (Pair pairAns : pair) {
			System.out.println(pairAns.getX());
			System.out.println(pairAns.getY());
		}
	}

}
