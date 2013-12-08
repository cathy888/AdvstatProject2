package models;

import java.util.ArrayList;

import models.objects.Point;
import models.objects.Term;
import static java.lang.Math.pow;

public class SecantComputation {

	public static ArrayList<Point> secantIteration(ArrayList<Term> Poly, double x0, double x1, int iteration) {
		ArrayList<Point> Ans = new ArrayList<Point>();
		double newX = 0;
		int current = 0;
		// X0, X1
		Ans.add(new Point(x0, findY(Poly, x0)));
		Ans.add(new Point(x1, findY(Poly, x1)));
		current++;

		for (int i = 2; i <= iteration; i++) {
			newX = Ans.get(current).getX()
					- ((Ans.get(current).getY() * (Ans.get(current - 1).getX() - Ans
							.get(current).getX())) / (Ans.get(current - 1)
							.getY() - Ans.get(current).getY()));
			Ans.add(new Point(newX, findY(Poly, newX)));
			current++;
		}

		return Ans;
	}

	public static ArrayList<Point> secantThreshold(ArrayList<Term> Poly, double x0, double x1, double threshold) {
		ArrayList<Point> Ans = new ArrayList<Point>();
		double newX = 0;
		int current = 0;
		double temp = 0;
		// X0, X1
		Ans.add(new Point(x0, findY(Poly, x0)));
		Ans.add(new Point(x1, findY(Poly, x1)));
		temp = (x1 - x0) / x1;
		if (temp < 0)
			temp = temp * -1;
		current++;

		while (temp > threshold) {
			newX = Ans.get(current).getX()
					- ((Ans.get(current).getY() * (Ans.get(current - 1).getX() - Ans
							.get(current).getX())) / (Ans.get(current - 1)
							.getY() - Ans.get(current).getY()));
			Ans.add(new Point(newX, findY(Poly, newX)));
			current++;

			temp = (Ans.get(current).getX() - Ans.get(current - 1).getX())
					/ Ans.get(current).getX();
			if (temp < 0)
				temp = temp * -1;
		}

		return Ans;
	}

	public static ArrayList<Point> secantBoth(ArrayList<Term> Poly, double x0, double x1, double threshold, int iteration) {
		ArrayList<Point> Ans = new ArrayList<Point>();
		double newX = 0;
		int current = 0;
		double temp = 0;
		int i = 2;
		// X0, X1
		Ans.add(new Point(x0, findY(Poly, x0)));
		Ans.add(new Point(x1, findY(Poly, x1)));
		temp = (x1 - x0) / x1;
		if (temp < 0)
			temp = temp * -1;
		current++;

		while (temp > threshold && i <= iteration) {
			i++;
			newX = Ans.get(current).getX()
					- ((Ans.get(current).getY() * (Ans.get(current - 1).getX() - Ans
							.get(current).getX())) / (Ans.get(current - 1)
							.getY() - Ans.get(current).getY()));
			Ans.add(new Point(newX, findY(Poly, newX)));
			current++;

			temp = (Ans.get(current).getX() - Ans.get(current - 1).getX())
					/ Ans.get(current).getX();
			if (temp < 0)
				temp = temp * -1;

		}

		return Ans;
	}

	public static double findY(ArrayList<Term> Poly, double x) {
		double y = 0;

		for (Term poly : Poly) {
			y += poly.getNumber() * pow(x, poly.getPower());
		}

		return y;
	}
}
