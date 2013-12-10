package controllers.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import models.BisectionComputation;
import models.InputValidation;
import models.SecantComputation;
import models.objects.Iteration;
import models.objects.Point;
import models.objects.ProjectInput;
import views.MainView;

public class SubmitActionListener implements ActionListener {
	
	private MainView view; 
	
	public SubmitActionListener() {
		view = null;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		ProjectInput input = null;
		
		try {
			ArrayList<Iteration> iterations = null;
			boolean bisection = view.getSelectedMethod().equals("Bisection Method");
			input = view.getInput();
			
			if (InputValidation.validateInput(bisection, input)) {
				view.clearFields();
				
				if (bisection) {
					iterations = bisectionMethod(input);
					graphBisectionPolynomial(input, iterations);
				}
				else if (view.getSelectedMethod().equals("Secant Method")) {
					iterations = secantMethod(input);
					graphSecantPolynomial(input, iterations);
				}
				
				view.addRows(iterations);
			}
			else {
				System.out.println("Invalid input.");
			}
		}
		catch (Exception e) {
			System.out.println("Something went wrong");
		}
	}
	
	private void graphBisectionPolynomial(ProjectInput input, ArrayList<Iteration> iterations) {
		TreeMap<Double, Double> map = new TreeMap<>();
		
		map.put(iterations.get(0).getLower().getX(), iterations.get(0).getLower().getY());
		map.put(iterations.get(0).getUpper().getX(), iterations.get(0).getUpper().getY());
		for (Iteration iteration : iterations) {
			map.put(iteration.getMid().getX(), iteration.getMid().getY());
		}
		
		double i = input.getX0() + 0.1;
		
		for (Map.Entry<Double, Double> entry : map.entrySet()) {
			while (i < entry.getKey()) {
				Point point = new Point();
				point.setX(entry.getKey());
				point.setY(entry.getValue());
				view.updateGraphData(1, point);
				
				i = i + 0.1;
			}
			
			Point point = new Point();
			point.setX(entry.getKey());
			point.setY(entry.getValue());
			view.updateGraphData(1, point);
			view.updateGraphData(2, point);
		}
	}
	
	private void graphSecantPolynomial(ProjectInput input, ArrayList<Iteration> iterations) {
		TreeMap<Double, Double> map = new TreeMap<>();
		
		for (Iteration iteration : iterations) {
			map.put(iteration.getMid().getX(), iteration.getMid().getY());
		}
		
		double i = input.getX0() + 0.1;
		
		for (Map.Entry<Double, Double> entry : map.entrySet()) {
			while (i < entry.getKey()) {
				Point point = new Point();
				point.setX(entry.getKey());
				point.setY(entry.getValue());
				view.updateGraphData(1, point);
				
				i = i + 0.1;
			}
			
			Point point = new Point();
			point.setX(entry.getKey());
			point.setY(entry.getValue());
			view.updateGraphData(1, point);
			view.updateGraphData(2, point);
		}
	}
	
	private ArrayList<Iteration> secantMethod(ProjectInput input) {
		ArrayList<Iteration> iterations = new ArrayList<Iteration>();
		
		if (input.getIteration().isEnabled() && input.getThreshold().isEnabled()) {
			iterations = SecantComputation.secantBoth(input.getPolynomial(), input.getX0(), input.getX1(),
					input.getThreshold().getValue(), (int) input.getIteration().getValue());
		}
		else if (input.getIteration().isEnabled() && !input.getThreshold().isEnabled()) {
			iterations = SecantComputation.secantIteration(input.getPolynomial(), input.getX0(), input.getX1(),
					(int) input.getIteration().getValue());
		}
		else if (!input.getIteration().isEnabled() && input.getThreshold().isEnabled()) {
			iterations = SecantComputation.secantThreshold(input.getPolynomial(), input.getX0(), input.getX1(),
					input.getThreshold().getValue());
		}
		else {
			return null;
		}
		
		/* debugging
		for (Iteration iteration : iterations) {
			System.out.print(iteration.getMid().getX());
			System.out.print("\t\t" + iteration.getMid().getY());
			System.out.print("\t\t" + iteration.getRelativeError() + "\n");
		}
		*/
		
		return iterations;
	}
	
	private ArrayList<Iteration> bisectionMethod(ProjectInput input) {
		return BisectionComputation.computeBisectionOutput(input.getPolynomial(),
				input.getX0(), input.getX1(), (int) input.getThreshold().getValue(),
				(int) input.getIteration().getValue());
	}
	
	public void setView(MainView view) {
		this.view = view;
	}
	
}
