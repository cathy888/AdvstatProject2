package controllers.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.MainView;

public class MethodActionListener implements ActionListener {
	
	private MainView view;
	
	public MethodActionListener() {
		view = null;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		view.setBisection(!view.getSelectedMethod().equals("Bisection Method"));
	}
	
	public void setView(MainView view) {
		this.view = view;
	}
	
}
