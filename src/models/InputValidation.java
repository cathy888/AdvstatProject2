package models;

import models.objects.ProjectInput;

public class InputValidation {
	
	public InputValidation() {}
	
	public static boolean validateInput(ProjectInput input) {
		if (input.getPolynomial().size() <= 0) {
			return false;
		}
		
		if (!input.getIteration().isEnabled() && !input.getThreshold().isEnabled()) {
			return false;
		}
		
		return true;
	}
	
	public static boolean validateBisectionInput(ProjectInput input) {
		if (input.getX0() >= input.getX1()) {
			return false;
		}
		
		return true;
	}
	
}
