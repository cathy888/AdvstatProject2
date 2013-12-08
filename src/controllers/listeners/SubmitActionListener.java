package controllers.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import models.BisectionComputation;
import models.BisectionOutput;
import models.InputValidation;
import models.SecantComputation;
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
			input = view.getInput();
			
			if (InputValidation.validateInput(input)) {
				if (view.getSelectedMethod().equals("Bisection Method")) {
					bisectionMethod(input);
				}
				else if (view.getSelectedMethod().equals("Secant Method")) {
					secantMethod(input);
				}
			}
			else {
				System.out.println("Invalid input.");
			}
		}
		catch (Exception e) {
			System.out.println("Something went wrong");
		}
	}
	
	private void secantMethod(ProjectInput input) {
		ArrayList<Point> pair = new ArrayList<Point>();
		
		if (input.getIteration().isEnabled() && input.getThreshold().isEnabled()) {
			pair = SecantComputation.secantBoth(input.getPolynomial(), input.getX0(), input.getX1(),
					input.getThreshold().getValue(), (int) input.getIteration().getValue());
		}
		else if (input.getIteration().isEnabled() && !input.getThreshold().isEnabled()) {
			pair = SecantComputation.secantIteration(input.getPolynomial(), input.getX0(), input.getX1(),
					(int) input.getIteration().getValue());
		}
		else if (!input.getIteration().isEnabled() && input.getThreshold().isEnabled()) {
			pair = SecantComputation.secantThreshold(input.getPolynomial(), input.getX0(), input.getX1(),
					input.getThreshold().getValue());
		}
		else {
			return;
		}
		
		for (Point pairAns : pair) {
			System.out.print(pairAns.getX());
			System.out.print("                        " + pairAns.getY() + "\n");
		}
	}
	
	private void bisectionMethod(ProjectInput input) {
		ArrayList<BisectionOutput> testCases = new ArrayList<BisectionOutput>();
		
		testCases.add(BisectionComputation.computeBisectionOutput(input.getPolynomial(), input.getX0(), input.getX1(),
				(int) input.getThreshold().getValue(), (int) input.getIteration().getValue()));
		
		for (BisectionOutput bo : testCases) {
			bo.displayBisectionOutput();
		}
	}
	
	public void setView(MainView view) {
		this.view = view;
	}
	
}
