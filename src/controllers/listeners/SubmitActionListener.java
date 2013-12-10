package controllers.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import models.BisectionComputation;
import models.BisectionOutput;
import models.InputValidation;
import models.SecantComputation;
import models.objects.Iteration;
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
			boolean bisection = view.getSelectedMethod().equals("Bisection Method");
			input = view.getInput();
			
			if (InputValidation.validateInput(bisection, input)) {
				if (bisection) {
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
		ArrayList<Iteration> pair = new ArrayList<Iteration>();
		
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
		
		for (Iteration pairAns : pair) {
			System.out.print(pairAns.getMid().getX());
			System.out.print("                        " + pairAns.getMid().getY() + "\n");
			System.out.print("                        " + pairAns.getRelativeError() + "\n");
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
