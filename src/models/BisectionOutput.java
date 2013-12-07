package models;

import java.util.ArrayList;

public class BisectionOutput {
	private ArrayList<BisectionIteration> outputs;
	private double tolerance;

	public BisectionOutput(int tolerance) {
		this.outputs = new ArrayList<BisectionIteration>();
		this.tolerance = tolerance;
	}

	public void insertIteration(Point a, Point b, Point mid) {
		outputs.add(new BisectionIteration(a, b, mid));
	}

	public ArrayList<BisectionIteration> getList() {
		return outputs;
	}

	public double getRoot() {
		BisectionIteration lastIteration = outputs.get(outputs.size() - 1);
		Point a = lastIteration.getA();
		if (this.tolerance != -1) {
			double tol = Math.pow(10, this.tolerance);
			return Math.round(a.getX() * tol) / tol;
		}
		return a.getX();
	}

	public void displayBisectionOutput() {
		System.out
				.println("<<<<<<<<<<START-OF-BISECTION-OUTPUT>>>>>>>>>> \n \titerationCount: "
						+ outputs.size());
		for (BisectionIteration i : outputs) {
			System.out
					.printf("iteration[%d]: a= %.4f  mid= %.4f  b= %.4f |f(a)= %.4f f(mid)= %.4f f(b)= %.4f\n",
							outputs.indexOf(i) + 1, i.getA().getX(), i.getMid()
									.getX(), i.getB().getX(), i.getA().getY(),
							i.getMid().getY(), i.getB().getY());

		}
		System.out.println("<<<<<<<<<<END-OF-BISECTION-OUTPUT>>>>>>>>>>");
	}

}
