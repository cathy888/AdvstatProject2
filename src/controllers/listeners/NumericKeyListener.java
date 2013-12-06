package controllers.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import views.MainView;

public class NumericKeyListener implements KeyListener {
	
	private MainView view;
	
	public NumericKeyListener() {
		view = null;
	}
	
	@Override
	public void keyTyped(KeyEvent event) {
		
	}
	
	public void setView(MainView view) {
		this.view = view;
	}
	
	@Override
	public void keyPressed(KeyEvent event) {}
	
	@Override
	public void keyReleased(KeyEvent event) {}
	
}
