package controllers.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.MainView;
import views.PolynomialField;

public class ClearActionListener implements ActionListener {
	
	private MainView view;
	
	public ClearActionListener() {
		view = null;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		view.clearFields();
		
		ExponentKeyListener listener = new ExponentKeyListener();
		listener.setView(view);
		
		PolynomialField field = new PolynomialField();
		listener.setCurrentField(field);
		field.setListener(listener);
		
		view.addPolynomialField(field);
	}
	
	public void setView(MainView view) {
		this.view = view;
	}
	
}
