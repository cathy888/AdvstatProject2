import java.util.ArrayList;
import static java.lang.Math.pow;

public class SecantComputation {

	public ArrayList<Pair> secant(ArrayList<Polynomial> Poly, double x0 , double x1, int iteration) {
		ArrayList<Pair> Ans = new ArrayList<Pair>();
		double newX = 0;
		int current = 0;
		Pair pair;
		//X0, X1
		Ans.add(new Pair(x0, findY(Poly, x0)));
		Ans.add(new Pair(x1, findY(Poly, x1)));
		current++;
		
		for (int i = 2; i <= iteration; i++){
			newX = Ans.get(current).getX() - ((Ans.get(current).getY() * (Ans.get(current - 1).getX() - Ans.get(current).getX())) / (Ans.get(current - 1).getY() - Ans.get(current).getY()));
			Ans.add( new Pair( newX, findY(Poly, newX)));
			current++;
		}
		
		
		return Ans;
	}
	
	
	public double findY( ArrayList<Polynomial> Poly, double x){
		double y = 0;
		
		for (Polynomial poly : Poly) {
			y += poly.getNumber() * pow(x, poly.getPower() );
		}
			
		return y;
	}
}
