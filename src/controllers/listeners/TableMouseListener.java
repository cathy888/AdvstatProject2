package controllers.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import models.objects.Iteration;
import views.MainView;

public class TableMouseListener implements MouseListener {
	
	private MainView view;
	
	public TableMouseListener() {
		view = null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Iteration iteration = view.getSelectedIteration();
		if (iteration != null) {
			view.plotGraphPoints(iteration);
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	
	@Override
	public void mouseExited(MouseEvent e) {}
	
	@Override
	public void mousePressed(MouseEvent e) {}
	
	@Override
	public void mouseReleased(MouseEvent e) {}
	
	public void setView(MainView view) {
		this.view = view;
	}
	
}
