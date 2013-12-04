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

public class MainView extends JFrame {
	
	private JPanel contentPane;
	private JPanel panPolynomials;
	private JTable table;
	private JTextField txtA;
	private JTextField txtB;
	
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
		panInputBottom.setBorder(new TitledBorder(null, "Limitations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panLeft.add(panInputBottom, BorderLayout.SOUTH);
		panInputBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panRange = new JPanel();
		panRange.setBorder(new TitledBorder(null, "Range", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panInputBottom.add(panRange);
		
		txtA = new JTextField();
		txtA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panRange.add(txtA);
		txtA.setColumns(5);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panRange.add(lblTo);
		
		txtB = new JTextField();
		txtB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtB.setColumns(5);
		panRange.add(txtB);
		
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
