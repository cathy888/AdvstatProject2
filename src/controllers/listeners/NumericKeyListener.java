package controllers.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class NumericKeyListener implements KeyListener {
	
	public NumericKeyListener() {}
	
	@Override
	public void keyTyped(KeyEvent event) {}
	
	@Override
	public void keyPressed(KeyEvent event) {}
	
	@Override
	public void keyReleased(KeyEvent event) {
		String text = null;
		
		/* Get text */
		if (event.getSource().getClass() == JTextField.class) {
			text = ((JTextField) event.getSource()).getText();
		}
		
		/* Check if text is numeric only (maybe with .s) */
		text = text.replaceAll("[^\\d.]", "");
		
		/* Set text */
		if (event.getSource().getClass() == JTextField.class) {
			((JTextField) event.getSource()).setText(text);
		}
	}
	
}
