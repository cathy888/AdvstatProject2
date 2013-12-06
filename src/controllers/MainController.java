package controllers;

import controllers.listeners.ExponentKeyListener;
import views.MainView;
import views.PolynomialField;

public class MainController {
	
	public static void main(String[] args) {
		new MainController();
	}
	
	public MainController() {
		MainView view = new MainView();
		view.setVisible(true);
		
		ExponentKeyListener listener = new ExponentKeyListener();
		listener.setView(view);
		
		PolynomialField field = new PolynomialField();
		listener.setCurrentField(field);
		field.setListener(listener);
		
		view.addPolynomialField(field);
		
		
	}
	
}
