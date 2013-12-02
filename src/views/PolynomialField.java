package views;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class PolynomialField extends JPanel {
	private JTextField txtCoefficient;
	private JTextField txtExponent;
	
	public PolynomialField() {
		
		txtCoefficient = new JTextField();
		txtCoefficient.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(txtCoefficient);
		txtCoefficient.setColumns(10);
		
		JLabel lblX = new JLabel("x^(");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblX);
		
		txtExponent = new JTextField();
		txtExponent.setFont(new Font("Tahoma", Font.PLAIN, 8));
		add(txtExponent);
		txtExponent.setColumns(10);
		
		JLabel lblCloseParenthesis = new JLabel(")");
		lblCloseParenthesis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblCloseParenthesis);

	}
	
}
