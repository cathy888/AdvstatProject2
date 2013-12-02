package controllers;

import views.MainView;

public class MainController {
	
	public static void main(String[] args) {
		new MainController();
	}
	
	public MainController() {
		MainView frame = new MainView();
		frame.setVisible(true);
	}
	
}
