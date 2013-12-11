package controllers.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.MainView;
import views.PolynomialField;

public class ClearActionListener implements ActionListener {
	
	private MainView view;
	
	public ClearActionListener() {
		view = null;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		view.clearInput();
		
		NumericKeyListener numericListener = new NumericKeyListener();
		
		ExponentKeyListener exponentListener = new ExponentKeyListener();
		exponentListener.setView(view);
		
		PolynomialField field = new PolynomialField();
		exponentListener.setCurrentField(field);
		field.addNumericListener(numericListener);
		field.addExponentListener(exponentListener);
		
		view.addPolynomialField(field);
	}
	
	public void setView(MainView view) {
		this.view = view;
	}
	
}
