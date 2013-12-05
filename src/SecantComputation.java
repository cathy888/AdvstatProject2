import java.util.ArrayList;
import static java.lang.Math.pow;

public class SecantComputation {

	public ArrayList<Point> secant(ArrayList<Term> Poly, double x0 , double x1, int iteration) {
		ArrayList<Point> Ans = new ArrayList<Point>();
		double newX = 0;
		int current = 0;
		Point pair;
		//X0, X1
		Ans.add(new Point(x0, findY(Poly, x0)));
		Ans.add(new Point(x1, findY(Poly, x1)));
		current++;
		
		for (int i = 2; i <= iteration; i++){
			newX = Ans.get(current).getX() - ((Ans.get(current).getY() * (Ans.get(current - 1).getX() - Ans.get(current).getX())) / (Ans.get(current - 1).getY() - Ans.get(current).getY()));
			Ans.add( new Point( newX, findY(Poly, newX)));
			current++;
		}
		
		
		return Ans;
	}
	
	
	public static double findY( ArrayList<Term> Poly, double x){
		double y = 0;
		
		for (Term poly : Poly) {
			y += poly.getNumber() * pow(x, poly.getPower() );
		}
			
		return y;
	}
}
