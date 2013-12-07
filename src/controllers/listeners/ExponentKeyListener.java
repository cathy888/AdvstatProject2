package controllers.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import views.MainView;
import views.PolynomialField;

public class ExponentKeyListener implements KeyListener {
	
	private MainView view;
	private PolynomialField currentField;
	private boolean added;
	
	public ExponentKeyListener() {
		view = null;
		added = false;
	}
	
	@Override
	public void keyPressed(KeyEvent event) {}
	
	@Override
	public void keyReleased(KeyEvent event) {
		try {
			if (!added && currentField.getExponent() > 0) {
				NumericKeyListener numericListener = new NumericKeyListener();
				
				ExponentKeyListener exponentListener = new ExponentKeyListener();
				exponentListener.setView(view);
				
				PolynomialField field = new PolynomialField();
				exponentListener.setCurrentField(field);
				field.addNumericListener(numericListener);
				field.addExponentListener(exponentListener);
				
				view.addPolynomialField(field);
				added = true;
			}
		}
		catch (Exception e) {
			System.out.println("Exponent does not contain a number (" + currentField.getTextExponent() + ").");
		}
	}
	
	@Override
	public void keyTyped(KeyEvent event) {}
	
	public void setView(MainView view) {
		this.view = view;
	}
	
	public void setCurrentField(PolynomialField currentField) {
		this.currentField = currentField;
	}
	
}
