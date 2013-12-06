package controllers;

import views.MainView;
import controllers.listeners.ClearActionListener;

public class MainController {
	
	public static void main(String[] args) {
		new MainController();
	}
	
	public MainController() {
		MainView view = new MainView();
		view.setVisible(true);
		
		ClearActionListener clearListener = new ClearActionListener();
		clearListener.setView(view);
		clearListener.actionPerformed(null);
		view.addBtnClearListener(clearListener);
	}
	
}
