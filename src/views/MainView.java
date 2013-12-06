package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import models.Limit;
import models.PolynomialItem;
import models.ProjectInput;

public class MainView extends JFrame {
	
	/** Declaration of Class Variables **/
	
	private JPanel contentPane;
	private JPanel panPolynomials;
	private JTable table;
	private JPanel panPoint;
	private JLabel lblX0;
	private JLabel lblX1;
	private JTextField txtX0;
	private JTextField txtX1;
	private JButton btnBisectionMethod;
	private JSpinner spinIterations;
	private JTextField txtThreshold;
	private AbstractButton chckbxIterations;
	private JCheckBox chckbxThreshold;
	private JButton btnClear;
	private JButton btnSubmit;
	
	private DefaultTableModel tableModel;
	
	/* Constructor */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(300, 100));
		setSize(650, 450);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		splitPane.setResizeWeight(0.1);
		
		JPanel panLeft = new JPanel();
		splitPane.setLeftComponent(panLeft);
		panLeft.setLayout(new BorderLayout(0, 0));
		panLeft.setMinimumSize(new Dimension(210, 100));
		
		JPanel panInputTop = new JPanel();
		panInputTop.setBorder(new TitledBorder(null, "Polynomial", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panLeft.add(panInputTop, BorderLayout.CENTER);
		panInputTop.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scpPolynomials = new JScrollPane();
		panInputTop.add(scpPolynomials);
		
		panPolynomials = new JPanel();
		scpPolynomials.setViewportView(panPolynomials);
		panPolynomials.setLayout(new BoxLayout(panPolynomials, BoxLayout.Y_AXIS));
		
		JPanel panInputBottom = new JPanel();
		panLeft.add(panInputBottom, BorderLayout.SOUTH);
		panInputBottom.setLayout(new BorderLayout(0, 0));
		
		JPanel panLeft1 = new JPanel();
		panInputBottom.add(panLeft1);
		panLeft1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Parameters", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panLeft1.setLayout(new BorderLayout(0, 0));
		
		JPanel panMethod = new JPanel();
		panMethod.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Selected Method", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panLeft1.add(panMethod, BorderLayout.NORTH);
		
		btnBisectionMethod = new JButton("Bisection Method");
		btnBisectionMethod.setToolTipText("Click to toggle.");
		btnBisectionMethod.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panMethod.add(btnBisectionMethod);
		
		JPanel panLeft2 = new JPanel();
		panLeft1.add(panLeft2, BorderLayout.CENTER);
		panLeft2.setLayout(new BorderLayout(0, 0));
		
		panPoint = new JPanel();
		panLeft2.add(panPoint, BorderLayout.NORTH);
		panPoint.setBorder(new TitledBorder(null, "Starting Interval", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		lblX0 = new JLabel("");
		lblX0.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panPoint.add(lblX0);
		
		txtX0 = new JTextField();
		txtX0.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtX0.setColumns(5);
		panPoint.add(txtX0);
		
		lblX1 = new JLabel("to");
		lblX1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panPoint.add(lblX1);
		
		txtX1 = new JTextField();
		txtX1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtX1.setColumns(5);
		panPoint.add(txtX1);
		
		JPanel panLimitations = new JPanel();
		panLeft2.add(panLimitations, BorderLayout.CENTER);
		panLimitations.setBorder(new TitledBorder(null, "Limitations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panLimitations.setLayout(new BorderLayout(0, 0));
		
		JPanel panIterations = new JPanel();
		panIterations.setBorder(new TitledBorder(null, "Iterations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panLimitations.add(panIterations, BorderLayout.NORTH);
		panIterations.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panSpinner = new JPanel();
		panIterations.add(panSpinner);
		GridBagLayout gbl_panSpinner = new GridBagLayout();
		gbl_panSpinner.columnWidths = new int[] {60};
		gbl_panSpinner.rowHeights = new int[] {25};
		gbl_panSpinner.columnWeights = new double[]{0.0};
		gbl_panSpinner.rowWeights = new double[]{0.0};
		panSpinner.setLayout(gbl_panSpinner);
		
		spinIterations = new JSpinner();
		GridBagConstraints gbc_spinIterations = new GridBagConstraints();
		gbc_spinIterations.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinIterations.gridx = 0;
		gbc_spinIterations.gridy = 0;
		panSpinner.add(spinIterations, gbc_spinIterations);
		spinIterations.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinIterations.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		
		chckbxIterations = new JCheckBox("Enable");
		chckbxIterations.setSelected(true);
		chckbxIterations.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panIterations.add(chckbxIterations);
		
		JPanel panThreshold = new JPanel();
		panThreshold.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Threshold", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panLimitations.add(panThreshold, BorderLayout.CENTER);
		panThreshold.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtThreshold = new JTextField();
		txtThreshold.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtThreshold.setHorizontalAlignment(SwingConstants.RIGHT);
		panThreshold.add(txtThreshold);
		txtThreshold.setColumns(5);
		
		chckbxThreshold = new JCheckBox("Enable");
		chckbxThreshold.setSelected(true);
		chckbxThreshold.setFont(new Font("Dialog", Font.PLAIN, 12));
		panThreshold.add(chckbxThreshold);
		
		JPanel panButtons = new JPanel();
		panInputBottom.add(panButtons, BorderLayout.SOUTH);
		panButtons.setLayout(new BorderLayout(0, 0));
		
		btnClear = new JButton("Clear");
		panButtons.add(btnClear, BorderLayout.WEST);
		
		btnSubmit = new JButton("Submit");
		panButtons.add(btnSubmit, BorderLayout.EAST);
		
		JPanel panRight = new JPanel();
		splitPane.setRightComponent(panRight);
		panRight.setLayout(new BorderLayout(0, 0));
		panRight.setMinimumSize(new Dimension(90, 100));
		
		JPanel panGraph = new JPanel();
		panRight.add(panGraph, BorderLayout.SOUTH);
		
		JScrollPane scpTable = new JScrollPane();
		panRight.add(scpTable, BorderLayout.CENTER);
		
		tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Lower Root", "Upper Root", "Middle Root",
						"f( Lower Root )", "f( Upper Root )", "f( Middle Root )",
						"Relative Error" });
		
		table = new JTable(tableModel);
		scpTable.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		TableColumnAdjuster adjuster = new TableColumnAdjuster(table);
		adjuster.setDynamicAdjustment(true);
	}
	
	/* Add a Polynomial Field */
	public void addPolynomialField(PolynomialField field) {
		panPolynomials.add(field);
		panPolynomials.updateUI();
	}
	
	/* Toggle Interval and Starting Points */
	public void setIntervalMode(boolean b) {
		if (b) {
			lblX0.setText("");
			lblX1.setText("to");
			panPoint.setBorder(new TitledBorder(null, "Starting Interval", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		}
		else {
			lblX0.setText("x0:");
			lblX1.setText("x1:");
			panPoint.setBorder(new TitledBorder(null, "Starting Points", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		}
	}
	
	/* Toggle Method Button */
	public void setBisection(boolean b) {
		if (b) {
			btnBisectionMethod.setText("Bisection Method");
		}
		else {
			btnBisectionMethod.setText("Secant Method");
		}
	}
	
	/* Get Selected Method */
	public String getSelectedMethod() {
		return btnBisectionMethod.getText();
	}
	
	/* Get the Input in Fields */
	public ProjectInput getInput() throws Exception {
		TreeMap<Double, Double> map = new TreeMap<>();
		ProjectInput input = new ProjectInput();
		
		/** Get Polynomials **/
		
		for (Component component : panPolynomials.getComponents()) {
			PolynomialField field = (PolynomialField) component;
			double exponent = 0;
			double coefficient = 0;
			
			try {
				exponent = field.getExponent();
				coefficient = field.getCoefficient();
			}
			catch (Exception e) {}
			
			try {
				coefficient += map.get(exponent);
			}
			catch (Exception e) {}
			
			map.put(exponent, coefficient);
		}
		
		if (map.isEmpty()) {
			return null;
		}
		
		input.initializePolynomial();
		
		for (Entry<Double, Double> entry : map.entrySet()) {
			PolynomialItem nomial = new PolynomialItem();
			
			if (entry.getValue() <= 0) {
				nomial.setExponent(entry.getKey());
				nomial.setCoefficient(entry.getValue());
				
				input.add(nomial);
			}
		}
		
		/** Get Parameters **/
		
		/* Get Interval / Starting Points */
		input.setX0(Double.parseDouble(txtX0.getText()));
		input.setX1(Double.parseDouble(txtX1.getText()));
		
		/* Get Iterations */
		Limit iteration = new Limit();
		iteration.setEnabled(chckbxIterations.isSelected());
		iteration.setValue(Double.parseDouble(spinIterations.getValue().toString()));
		input.setIteration(iteration);
		
		/* Get Threshold */
		Limit threshold = new Limit();
		threshold.setEnabled(chckbxThreshold.isSelected());
		threshold.setValue(Double.parseDouble(txtThreshold.getText().toString()));
		input.setThreshold(threshold);
		
		return input;
	}
	
}
