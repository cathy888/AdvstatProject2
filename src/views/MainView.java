package views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainView extends JFrame {
	
	private JPanel contentPane;
	private JPanel panPolynomials;
	private JTable table;
	
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(200, 100));
		setSize(600, 400);
		
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
		panLeft.setMinimumSize(new Dimension(75, 100));
		
		JPanel panInputTop = new JPanel();
		panInputTop.setBorder(new TitledBorder(null, "Polynomial", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panLeft.add(panInputTop, BorderLayout.NORTH);
		panInputTop.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scpPolynomials = new JScrollPane();
		panInputTop.add(scpPolynomials);
		
		panPolynomials = new JPanel();
		scpPolynomials.setViewportView(panPolynomials);
		
		JPanel panInputBottom = new JPanel();
		panInputBottom.setBorder(new TitledBorder(null, "Limitations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panLeft.add(panInputBottom, BorderLayout.SOUTH);
		
		JPanel panRight = new JPanel();
		splitPane.setRightComponent(panRight);
		panRight.setLayout(new BorderLayout(0, 0));
		
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
	}
	
	public void addPolynomialField(PolynomialField field) {
		panPolynomials.add(field);
	}
	
}
