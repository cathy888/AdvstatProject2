package controllers.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.MainView;

public class ClearActionListener implements ActionListener {
	
	private MainView view;
	
	public ClearActionListener() {
		view = null;
	}
	

	@Override
	public void actionPerformed(ActionEvent event) {
		
	}
	
	public void setView(MainView view) {
		this.view = view;
	}
	
}
