package models;

import java.util.ArrayList;

import models.objects.Iteration;
import models.objects.Point;
import models.objects.Term;

public class SecantComputation {

	public static ArrayList<Iteration> secantIteration(ArrayList<Term> Poly, double x0, double x1, int iteration) {
		ArrayList<Iteration> Ans = new ArrayList<Iteration>();
		
		double newX = 0;
		int current = 0;
		double error = -1;
		// X0, X1
		
		Iteration oneAns = new Iteration();
		oneAns.setMid(new Point(x0, SharedComputation.findY(Poly, x0)));
		oneAns.setRelativeError(error);
		Ans.add(oneAns);
		oneAns = new Iteration();
		oneAns.setMid(new Point(x1, SharedComputation.findY(Poly, x1)));
		error = (x1 - x0) / x1;
		if (error < 0)
			error = error * -1;
		oneAns.setRelativeError(error);
		Ans.add(oneAns);
		/*System.out.println(Ans.get(0).getRelativeError());
		System.out.println(Ans.get(1).getRelativeError());*/
		current++;
		
		for (int i = 2; i <= iteration; i++) {
			newX = Ans.get(current).getMid().getX()
					- ((Ans.get(current).getMid().getY() * (Ans.get(current - 1).getMid().getX() - Ans
							.get(current).getMid().getX())) / (Ans.get(current - 1).
							getMid().getY() - Ans.get(current).getMid().getY()));
			
			oneAns = new Iteration();
			oneAns.setMid(new Point(newX, SharedComputation.findY(Poly, newX)));
			Ans.add(oneAns);
			current++;
			error = (Ans.get(current).getMid().getX() - Ans.get(current - 1).getMid().getX())
					/ Ans.get(current).getMid().getX();
			
			if (error < 0) {
				error = error * -1;
			}
			
			Ans.get(current).setRelativeError(error);
			
			if (error == 0.0) {
				break;
			}
			
			if (Ans.get(current).getMid().getY() == 0) {
				break;
			}
		}

		return Ans;
	}

	public static ArrayList<Iteration> secantThreshold(ArrayList<Term> Poly, double x0, double x1, double threshold) {
		ArrayList<Iteration> Ans = new ArrayList<Iteration>();
		double newX = 0;
		int current = 0;
		double error = -1;
		// X0, X1
		Iteration oneAns = new Iteration();
		oneAns.setMid(new Point(x0, SharedComputation.findY(Poly, x0)));
		oneAns.setRelativeError(error);
		Ans.add(oneAns);
		oneAns = new Iteration();
		oneAns.setMid(new Point(x1, SharedComputation.findY(Poly, x1)));
		
		error = (x1 - x0) / x1;
		if (error < 0)
			error = error * -1;
		oneAns.setRelativeError(error);
		Ans.add(oneAns);
		current++;

		while (error > threshold) {
			newX = Ans.get(current).getMid().getX()
					- ((Ans.get(current).getMid().getY() * (Ans.get(current - 1).getMid().getX() - Ans
							.get(current).getMid().getX())) / (Ans.get(current - 1).
									getMid().getY() - Ans.get(current).getMid().getY()));
			oneAns = new Iteration();
			oneAns.setMid(new Point(newX, SharedComputation.findY(Poly, newX)));
			Ans.add(oneAns);
			current++;
			error = (Ans.get(current).getMid().getX() - Ans.get(current - 1).getMid().getX())
					/ Ans.get(current).getMid().getX();
			if (error < 0)
				error = error * -1;
			Ans.get(current).setRelativeError(error);
		}

		return Ans;
	}

	public static ArrayList<Iteration> secantBoth(ArrayList<Term> Poly, double x0, double x1, double threshold, int iteration) {
		ArrayList<Iteration> Ans = new ArrayList<Iteration>();
		double newX = 0;
		int current = 0;
		double error = -1;
		int i = 2;
		// X0, X1
		Iteration oneAns = new Iteration();
		oneAns.setMid(new Point(x0, SharedComputation.findY(Poly, x0)));
		oneAns.setRelativeError(error);
		Ans.add(oneAns);
		oneAns = new Iteration();
		oneAns.setMid(new Point(x1, SharedComputation.findY(Poly, x1)));
		error = (x1 - x0) / x1;
		if (error < 0)
			error = error * -1;
		oneAns.setRelativeError(error);
		Ans.add(oneAns);
		current++;

		while (error > threshold && i <= iteration) {
			i++;
			newX = Ans.get(current).getMid().getX()
					- ((Ans.get(current).getMid().getY() * (Ans.get(current - 1).getMid().getX() - Ans
							.get(current).getMid().getX())) / (Ans.get(current - 1)
							.getMid().getY() - Ans.get(current).getMid().getY()));
			oneAns = new Iteration();
			oneAns.setMid(new Point(newX, SharedComputation.findY(Poly, newX)));
			Ans.add(oneAns);
			current++;
			error = (Ans.get(current).getMid().getX() - Ans.get(current - 1).getMid().getX())
					/ Ans.get(current).getMid().getX();
			if (error < 0)
				error = error * -1;
			Ans.get(current).setRelativeError(error);

		}

		return Ans;
	}
}
