package models;

import java.util.ArrayList;

import models.objects.Iteration;
import models.objects.Point;
import models.objects.Term;

public class BisectionComputation {
	/*
	 * returns null if invalid input
	 */
	public static ArrayList<Iteration> computeBisectionOutput(ArrayList<Term> polynomial, double aX, double bX, double threshold, int iterationLimit) {
		Point a = new Point(aX, SharedComputation.findY(polynomial, aX));
		Point b = new Point(bX, SharedComputation.findY(polynomial, bX));
		if (iterationLimit == -1) {
			iterationLimit = 1000;
		}
		
		if (!(a.getY() > 0 && b.getY() < 0 || a.getY() < 0 && b.getY() > 0)) {
			return null;
		}
		
		if (a.getY() > 0 && b.getY() < 0) {
			Point temp = a;
			a = b;
			b = temp;
		}
		
		ArrayList<Iteration> result = new ArrayList<>();
		
		double midX = (a.getX() + b.getX()) / 2;
		Point mid = new Point(midX, SharedComputation.findY(polynomial, midX));
		
		Iteration iteration = new Iteration();
		iteration.setLower(a);
		iteration.setUpper(b);
		iteration.setMid(mid);
		iteration.setRelativeError(1);
		result.add(iteration);
		
		if (mid.getY() == 0) {
			return result;
		}
		
		int i = 0;
		double previousMid = midX;
		double relativeError = 0;
		
		do {
			// choose new side of the binary split
			i++;
			if (mid.getY() > 0) {
				b = mid;
			}
			else if (mid.getY() < 0) {
				a = mid;
			}

			// get new iteration midpoint
			midX = (a.getX() + b.getX()) / 2;
			mid = new Point(midX, SharedComputation.findY(polynomial, midX));
			relativeError = (midX - previousMid) / midX;
			if (relativeError < 0) {
				relativeError *= -1;
			}
			
			iteration = new Iteration();
			iteration.setLower(a);
			iteration.setUpper(b);
			iteration.setMid(mid);
			iteration.setRelativeError(relativeError);
			result.add(iteration);
			
			previousMid = midX;
		}
		while( !isMidPointExactRoot(mid) && relativeError > threshold && !isIterationLimitReached(iterationLimit,i));
		
		return result;
	}

	public static boolean isMidPointExactRoot(Point mid) {
		if (mid.getY() == 0) {
			System.out.println("t1");
			return true;
		}
		return false;
	}

	public static boolean arePointsEqualWithinDecimalTolerance(Point a, Point b, double tol, int tolerance) {
		System.out.println("tol: " + tol);
		if (tolerance == -1) {
			return false;
		} else if (Math.round(a.getX() * tol) / tol == Math.round(b.getX()
				* tol)
				/ tol) {
			System.out.println("t2");
			return true;
		}
		return false;
	}

	public static boolean isIterationLimitReached(int limit, int i) {
		if (limit == -1) {
			return false;
		} else if (limit == i + 1) {
			System.out.println("t3");
			return true;
		}

		return false;
	}
	
}
