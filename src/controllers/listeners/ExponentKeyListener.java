package controllers.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import views.MainView;
import views.PolynomialField;

public class ExponentKeyListener implements KeyListener {
	
	private MainView view;
	private boolean added;
	
	public ExponentKeyListener() {
		view = null;
		added = false;
	}
	
	@Override
	public void keyPressed(KeyEvent event) {}

	
	@Override
	public void keyReleased(KeyEvent event) {}

	
	@Override
	public void keyTyped(KeyEvent event) {
		PolynomialField source = (PolynomialField) event.getSource();
		
		try {
			if (!added && source.getExponent() > 0) {
				ExponentKeyListener listener = new ExponentKeyListener();
				listener.setView(view);
				
				PolynomialField field = new PolynomialField();
				field.setListener(listener);
				
				view.addPolynomialField(field);
				added = true;
			}
		}
		catch (Exception e) {
			System.out.println("Exponent does not contain a number.");
		}
	}
	
	public void setView(MainView view) {
		this.view = view;
	}
	
}
