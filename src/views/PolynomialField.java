package views;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

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
	
	public JTextField getTxtCoefficient() {
		return txtCoefficient;
	}
	
	public void setTxtCoefficient(JTextField txtCoefficient) {
		this.txtCoefficient = txtCoefficient;
	}
	
	public JTextField getTxtExponent() {
		return txtExponent;
	}
	
	public void setTxtExponent(JTextField txtExponent) {
		this.txtExponent = txtExponent;
	}
	
}
