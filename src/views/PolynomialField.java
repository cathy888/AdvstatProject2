package views;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyListener;

import javax.swing.SwingConstants;

import models.objects.Term;

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
	
	public String getTextCoefficient() {
		return txtCoefficient.getText();
	}
	
	public String getTextExponent() {
		return txtExponent.getText();
	}
	
	public Double getCoefficient() {
		return Double.parseDouble(txtCoefficient.getText());
	}
	
	public Double getExponent() {
		return Double.parseDouble(txtExponent.getText());
	}
	
	public Term getTerm() throws Exception {
		Term term = new Term();
		term.setPower(getCoefficient());
		term.setNumber(getExponent());
		return term;
	}
	
	public void addExponentListener(KeyListener listener) {
		txtExponent.addKeyListener(listener);
	}
	
	public void addNumericListener(KeyListener listener) {
		txtExponent.addKeyListener(listener);
		txtCoefficient.addKeyListener(listener);
	}
	
}
