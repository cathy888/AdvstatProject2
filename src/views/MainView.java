package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

import models.objects.Iteration;
import models.objects.Limit;
import models.objects.Point;
import models.objects.ProjectInput;
import models.objects.Term;

public class MainView extends JFrame {
	
	/** Declaration of Class Variables **/
	
	private JPanel contentPane;
	private JPanel panPolynomials;
	private JTable table;
	private JPanel panPoint;
	private JPanel panGraph;
	
	private JButton btnBisectionMethod;
	private AbstractButton chkbxIterations;
	private JCheckBox chkbxThreshold;
	
	private JLabel lblX0;
	private JLabel lblX1;
	
	private JTextField txtX0;
	private JTextField txtX1;
	private JSpinner spinIterations;
	private JTextField txtThreshold;
	
	private JButton btnClear;
	private JButton btnSubmit;
	
	private XYSeries line1;
	private XYSeries line2;
	private XYSeries line3;
	private XYSeries line4;
	
	private DefaultTableModel tableModel;
	
	/* Constructor */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(650, 450));
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
		txtX0.setHorizontalAlignment(SwingConstants.CENTER);
		txtX0.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtX0.setColumns(5);
		panPoint.add(txtX0);
		
		lblX1 = new JLabel("to");
		lblX1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panPoint.add(lblX1);
		
		txtX1 = new JTextField();
		txtX1.setHorizontalAlignment(SwingConstants.CENTER);
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
		
		chkbxIterations = new JCheckBox("Enable");
		chkbxIterations.setSelected(true);
		chkbxIterations.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panIterations.add(chkbxIterations);
		
		JPanel panThreshold = new JPanel();
		panThreshold.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Threshold", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panLimitations.add(panThreshold, BorderLayout.CENTER);
		panThreshold.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtThreshold = new JTextField();
		txtThreshold.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtThreshold.setHorizontalAlignment(SwingConstants.RIGHT);
		panThreshold.add(txtThreshold);
		txtThreshold.setColumns(5);
		
		chkbxThreshold = new JCheckBox("Enable");
		chkbxThreshold.setSelected(true);
		chkbxThreshold.setFont(new Font("Dialog", Font.PLAIN, 12));
		panThreshold.add(chkbxThreshold);
		
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
		
		panGraph = new JPanel();
		panGraph.setLayout(new BorderLayout(0, 0));
		panGraph.add(createGraphPanel(true), BorderLayout.CENTER);
		panRight.add(panGraph, BorderLayout.SOUTH);
		
		JScrollPane scpTable = new JScrollPane();
		panRight.add(scpTable, BorderLayout.CENTER);
		
		tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Iteration", "Lower Root", "Upper Root", "Middle Root",
						"f( Lower Root )", "f( Upper Root )", "f( Middle Root )",
						"Relative Error" });
		
		table = new JTable(tableModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scpTable.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		TableColumnAdjuster adjuster = new TableColumnAdjuster(table);
		adjuster.setDynamicAdjustment(true);
	}
	
	/* Add Rows to Table */
	public void addRows(ArrayList<Iteration> iterations) {
		if (getSelectedMethod().equals("Bisection Method")) {
			for (Iteration iteration : iterations) {
				addBisectionRow(iteration);
			}
		}
		else if (getSelectedMethod().equals("Secant Method")) {
			for (Iteration iteration : iterations) {
				addSecantRow(iteration);
			}
		}
	}
	
	/* Add Row to Table */
	public void addBisectionRow(Iteration iteration) {
		tableModel.addRow(new Object[] {
				tableModel.getRowCount() + 1, iteration.getLower().getX(),
				iteration.getUpper().getX(), iteration.getMid().getX(),
				iteration.getLower().getY(), iteration.getUpper().getY(),
				iteration.getMid().getY(), iteration.getRelativeError()
		});
	}
	
	/* Add Row to Table */
	public void addSecantRow(Iteration iteration) {
		tableModel.addRow(new Object[] {
				tableModel.getRowCount(),  iteration.getMid().getX(),
				iteration.getMid().getY(), iteration.getRelativeError()
		});
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
	
	/* Toggle Table */
	public void setTableBisection(boolean b) {
		if (b) {
			tableModel = new DefaultTableModel(new Object[][] {},
					new String[] { "Iteration", "Lower Root", "Upper Root", "Middle Root",
							"f( Lower Root )", "f( Upper Root )", "f( Middle Root )",
							"Relative Error" });
		}
		else {
			tableModel = new DefaultTableModel(new Object[][] {},
					new String[] { "Iteration", "Middle Root", "f( Middle Root )",
							"Relative Error" });
		}
		table.setModel(tableModel);
	}
	
	/* Toggle Method Button */
	public void setBisection(boolean b) {
		if (b) {
			btnBisectionMethod.setText("Bisection Method");
		}
		else {
			btnBisectionMethod.setText("Secant Method");
		}
		setIntervalMode(b);
		setTableBisection(b);
		panGraph.add(createGraphPanel(b), BorderLayout.CENTER);
	}
	
	/* Toggle Line Names */
	public void setGraphLines(boolean b) {
		if (b) {
			line2 = new XYSeries("Lower");
			line3 = new XYSeries("Upper");
			line4 = new XYSeries("Mid");
		}
		else {
			line2 = new XYSeries("Xi-2");
			line3 = new XYSeries("Xi-1");
			line4 = new XYSeries("Xi");
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
			Term term = new Term();
			
			if (entry.getValue() != 0) {
				term.setPower(entry.getKey());
				term.setNumber(entry.getValue());
				
				input.add(term);
			}
		}
		
		/** Get Parameters **/
		
		/* Get Interval / Starting Points */
		input.setX0(Double.parseDouble(txtX0.getText()));
		input.setX1(Double.parseDouble(txtX1.getText()));
		
		/* Get Iterations */
		Limit iteration = new Limit();
		if (chkbxIterations.isSelected()) {
			iteration.setEnabled(true);
			iteration.setValue(Double.parseDouble(spinIterations.getValue().toString()));
		}
		input.setIteration(iteration);
		
		/* Get Threshold */
		Limit threshold = new Limit();
		if (chkbxThreshold.isSelected()) {
			threshold.setEnabled(true);
			threshold.setValue(Double.parseDouble(txtThreshold.getText().toString()));
		}
		input.setThreshold(threshold);
		
		return input;
	}
	
	/* Clear the Input Fields */
	public void clearInput() {
		panPolynomials.removeAll();
		txtX0.setText("");
		txtX1.setText("");
		spinIterations.setValue(1);
		txtThreshold.setText("");
		chkbxIterations.setSelected(true);
		chkbxThreshold.setSelected(true);
	}
	
	/* Clear the Output Fields */
	public void clearOutput() {
		line1.clear();
		line2.clear();
		line3.clear();
		line4.clear();
		
		while (tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);
		}
	}
	
	/* Create a Graph */
	private ChartPanel createGraphPanel(boolean b) {
		line1 = new XYSeries("Polynomial");
		setGraphLines(b);
		
		XYSeriesCollection xyDataset = new XYSeriesCollection();
		xyDataset.addSeries(line2);
		xyDataset.addSeries(line3);
		xyDataset.addSeries(line4);
		xyDataset.addSeries(line1);

		
		JFreeChart chart = ChartFactory.createXYLineChart("", "x", "f(x)",
				xyDataset, PlotOrientation.VERTICAL, true, true, false);
		
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.white);
		plot.setDomainGridlinePaint(Color.GREEN);
		plot.setRangeGridlinePaint(Color.orange);
		plot.setAxisOffset(new RectangleInsets(50, 0, 20, 5));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
		
		XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
		renderer.setBaseShapesVisible(true);
		renderer.setBaseShapesFilled(true);
		
		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new Dimension(180, 250));
		
		return panel;
	}
	
	/* Update Graph Data */
	public void updateGraphData(int line, Point point) {
		if (line == 1) {
			line1.add(point.getX(), point.getY());
		}
		else if (line == 2) {
			line2.add(point.getX(), point.getY());
		}
	}
	
	/* Plot Graph Points */
	public void plotGraphPoints(Iteration iteration) {
		line2.clear();
		line3.clear();
		line4.clear();

		if (iteration.getLower() != null) {
			line2.add(iteration.getLower().getX(), iteration.getLower().getY());
		}
		if (iteration.getUpper() != null) {
			line3.add(iteration.getUpper().getX(), iteration.getUpper().getY());
		}
		line4.add(iteration.getMid().getX(), iteration.getMid().getY());
	}
	
	/* Get Table Selected Iteration */
	public Iteration getSelectedIteration() {
		Iteration iteration = null;
		int row = table.getSelectedRow();
		
		if (row > -1) {
			iteration = new Iteration();
			if (btnBisectionMethod.getText().equals("Bisection Method")) {
				iteration.setLower(Double.parseDouble("" + tableModel.getValueAt(row, tableModel.findColumn("Lower Root"))),
						Double.parseDouble("" + tableModel.getValueAt(row, tableModel.findColumn("f( Lower Root )"))));
				iteration.setUpper(Double.parseDouble("" + tableModel.getValueAt(row, tableModel.findColumn("Upper Root"))),
						Double.parseDouble("" + tableModel.getValueAt(row, tableModel.findColumn("f( Upper Root )"))));
			}
			iteration.setMid(Double.parseDouble("" + tableModel.getValueAt(row, tableModel.findColumn("Middle Root"))),
					Double.parseDouble("" + tableModel.getValueAt(row, tableModel.findColumn("f( Middle Root )"))));
			iteration.setRelativeError(Double.parseDouble("" + tableModel.getValueAt(row, tableModel.findColumn("Relative Error"))));
		}
		
		return iteration;
	}
	
	/** Add Listeners **/
	
	public void addBtnMethodListener(ActionListener listener) {
		btnBisectionMethod.addActionListener(listener);
	}
	
	public void addBtnSubmitListener(ActionListener listener) {
		btnSubmit.addActionListener(listener);
	}
	
	public void addBtnClearListener(ActionListener listener) {
		btnClear.addActionListener(listener);
	}
	
	public void addNumericListeners(KeyListener listener) {
		txtX0.addKeyListener(listener);
		txtX1.addKeyListener(listener);
		txtThreshold.addKeyListener(listener);
	}
	
	public void addTableListener(MouseListener listener) {
		table.addMouseListener(listener);
	}
	
}
