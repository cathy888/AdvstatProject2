package views;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import models.Nomial;

public class PolynomialField extends JPanel {
	
	private JTextField txtCoefficient;
	private JTextField txtExponent;
	
	public PolynomialField() {
		txtCoefficient = new JTextField();
		txtCoefficient.setHorizontalAlignment(SwingConstants.CENTER);
		txtCoefficient.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCoefficient.setColumns(5);
		add(txtCoefficient);
		
		JLabel lblX = new JLabel("x^(");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblX);
		
		txtExponent = new JTextField();
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
	
	public Nomial getNomial() {
		Nomial nomial = new Nomial();
		nomial.setCoefficient(getCoefficient());
		nomial.setExponent(getExponent());
		return nomial;
	}
	
}
