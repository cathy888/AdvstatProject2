package controllers.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.MainView;

public class SubmitActionListener implements ActionListener {
	
	private MainView view; 
	
	public SubmitActionListener() {
		view = null;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
	}
	
	public void setView(MainView view) {
		this.view = view;
	}
	
}
