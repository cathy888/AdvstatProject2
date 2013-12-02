package controllers.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import views.PolynomialField;

public class ExponentKeyListener implements KeyListener {
	
	private JPanel panPolynomials;
	
	public ExponentKeyListener() {
		panPolynomials = null;
	}
	
	@Override
	public void keyPressed(KeyEvent event) {}

	
	@Override
	public void keyReleased(KeyEvent event) {}

	
	@Override
	public void keyTyped(KeyEvent event) {
		PolynomialField source = (PolynomialField) event.getSource();
		
		try {
			if (source.getExponent() > 0) {
				ExponentKeyListener listener = new ExponentKeyListener();
				listener.setPanel(panPolynomials);
				
				PolynomialField field = new PolynomialField();
				field.setListener(listener);
				
				panPolynomials.add(field);
			}
		}
		catch (Exception e) {
			System.out.println("Exponent does not contain a number.");
		}
	}
	
	public void setPanel(JPanel panPolynomials) {
		this.panPolynomials = panPolynomials;
	}
	
}
