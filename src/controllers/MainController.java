package controllers;

import views.MainView;
import controllers.listeners.ClearActionListener;
import controllers.listeners.MethodActionListener;
import controllers.listeners.SubmitActionListener;

public class MainController {
	
	public static void main(String[] args) {
		new MainController();
	}
	
	public MainController() {
		MainView view = new MainView();
		view.setVisible(true);
		
		MethodActionListener methodListener = new MethodActionListener();
		methodListener.setView(view);
		view.addBtnMethodListener(methodListener);
		
		ClearActionListener clearListener = new ClearActionListener();
		clearListener.setView(view);
		clearListener.actionPerformed(null);
		view.addBtnClearListener(clearListener);
		
		SubmitActionListener submitListener = new SubmitActionListener();
		submitListener.setView(view);
		view.addBtnSubmitListener(submitListener);
	}
	
}
