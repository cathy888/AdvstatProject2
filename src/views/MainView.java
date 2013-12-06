package views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import models.PolynomialItem;
import models.ProjectInput;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class MainView extends JFrame {
	
	private JPanel contentPane;
	private JPanel panPolynomials;
	private JTable table;
	private JTextField txtX0;
	private JTextField txtX1;
	
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(300, 100));
		setSize(600, 400);
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
		FlowLayout flowLayout = (FlowLayout) panPolynomials.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		scpPolynomials.setViewportView(panPolynomials);
		
		JPanel panInputBottom = new JPanel();
		panInputBottom.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Parameters", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panLeft.add(panInputBottom, BorderLayout.SOUTH);
		panInputBottom.setLayout(new BorderLayout(0, 0));
		
		JPanel panMethod = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panMethod.getLayout();
		panMethod.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Selected Method", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panInputBottom.add(panMethod, BorderLayout.NORTH);
		
		JButton btnBisectionMethod = new JButton("Bisection Method");
		btnBisectionMethod.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panMethod.add(btnBisectionMethod);
		
		JPanel panLeft1 = new JPanel();
		panInputBottom.add(panLeft1, BorderLayout.CENTER);
		panLeft1.setLayout(new BorderLayout(0, 0));
		
		JPanel panPoint = new JPanel();
		panLeft1.add(panPoint, BorderLayout.NORTH);
		panPoint.setBorder(new TitledBorder(null, "Starting Points", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		FlowLayout flowLayout_2 = (FlowLayout) panPoint.getLayout();
		
		JLabel lblX0 = new JLabel("x0:");
		lblX0.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panPoint.add(lblX0);
		
		txtX0 = new JTextField();
		txtX0.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtX0.setColumns(5);
		panPoint.add(txtX0);
		
		JLabel lblX1 = new JLabel("x1:");
		lblX1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panPoint.add(lblX1);
		
		txtX1 = new JTextField();
		txtX1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtX1.setColumns(5);
		panPoint.add(txtX1);
		
		JPanel panLimitations = new JPanel();
		panLeft1.add(panLimitations, BorderLayout.CENTER);
		panLimitations.setBorder(new TitledBorder(null, "Limitations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panLimitations.setLayout(new BorderLayout(0, 0));
		
		JPanel panIterations = new JPanel();
		panIterations.setBorder(new TitledBorder(null, "Iterations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panLimitations.add(panIterations, BorderLayout.NORTH);
		panIterations.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		panIterations.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {50};
		gbl_panel.rowHeights = new int[] {25};
		gbl_panel.columnWeights = new double[]{0.0};
		gbl_panel.rowWeights = new double[]{0.0};
		panel.setLayout(gbl_panel);
		
		JSpinner spinIterations = new JSpinner();
		GridBagConstraints gbc_spinIterations = new GridBagConstraints();
		gbc_spinIterations.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinIterations.gridx = 0;
		gbc_spinIterations.gridy = 0;
		panel.add(spinIterations, gbc_spinIterations);
		spinIterations.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinIterations.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JCheckBox chckbxEnable = new JCheckBox("Enable");
		chckbxEnable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panIterations.add(chckbxEnable);
		
		JPanel panRight = new JPanel();
		splitPane.setRightComponent(panRight);
		panRight.setLayout(new BorderLayout(0, 0));
		panRight.setMinimumSize(new Dimension(90, 100));
		
		JPanel panGraph = new JPanel();
		panRight.add(panGraph, BorderLayout.SOUTH);
		
		JScrollPane scpTable = new JScrollPane();
		panRight.add(scpTable, BorderLayout.CENTER);
		
		DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Lower Root", "Upper Root", "Middle Root",
						"f( Lower Root )", "f( Upper Root )", "f( Middle Root )",
						"Relative Error" });
		
		table = new JTable(tableModel);
		scpTable.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		TableColumnAdjuster adjuster = new TableColumnAdjuster(table);
		adjuster.setDynamicAdjustment(true);
	}
	
	public void addPolynomialField(PolynomialField field) {
		panPolynomials.add(field);
		panPolynomials.updateUI();
	}
	
	public ProjectInput getInput() {
		TreeMap<Double, Double> map = new TreeMap<>();
		ProjectInput input = new ProjectInput();
		
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
			nomial.setExponent(entry.getKey());
			nomial.setCoefficient(entry.getValue());
			
			input.add(nomial);
		}
		
		return input;
	}
	
}
