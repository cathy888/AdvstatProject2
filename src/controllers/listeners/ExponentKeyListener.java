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
		ExponentKeyListener listener = new ExponentKeyListener();
		listener.setPanel(panPolynomials);
		
		PolynomialField field = new PolynomialField();
		field.setListener(listener);
		
		panPolynomials.add(field);
	}
	
	public void setPanel(JPanel panPolynomials) {
		this.panPolynomials = panPolynomials;
	}
	
}
