package views;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyListener;

import javax.swing.SwingConstants;

import models.PolynomialItem;

public class PolynomialField extends JPanel {
	
	private JTextField txtCoefficient;
	private JTextField txtExponent;
	
	public PolynomialField() {
		txtCoefficient = new JTextField("0");
		txtCoefficient.setHorizontalAlignment(SwingConstants.CENTER);
		txtCoefficient.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCoefficient.setColumns(5);
		add(txtCoefficient);
		
		JLabel lblX = new JLabel("x^(");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblX);
		
		txtExponent = new JTextField("0");
		txtExponent.setHorizontalAlignment(SwingConstants.CENTER);
		txtExponent.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtExponent.setColumns(5);
		add(txtExponent);
		
		JLabel lblCloseParenthesis = new JLabel(")");
		lblCloseParenthesis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblCloseParenthesis);
	}
	
	public double getCoefficient() {
		return Double.parseDouble(txtCoefficient.getText());
	}
	
	public double getExponent() {
		return Double.parseDouble(txtExponent.getText());
	}
	
	public PolynomialItem getNomial() throws Exception {
		PolynomialItem nomial = new PolynomialItem();
		nomial.setCoefficient(getCoefficient());
		nomial.setExponent(getExponent());
		return nomial;
	}
	
	public void setListener(KeyListener listener) {
		clearListeners();
		txtExponent.addKeyListener(listener);
	}
	
	private void clearListeners() {
		KeyListener[] listeners = txtExponent.getKeyListeners();
		while (listeners.length > 0) {
			txtExponent.removeKeyListener(listeners[0]);
		}
		
	}
	
}
