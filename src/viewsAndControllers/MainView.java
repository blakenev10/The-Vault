/**
 * <b>Project:</b>	The Vault
 * <b>Package:</b>	viewsAndControllers
 * <b>File:</b>		MainView.java
 * 
 * @author Blake Neville
 */
package viewsAndControllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import model.Field;

/**
 * <b>Description:</b> This is the application view that the user will interact with and have
 * data displayed in.  It will have a connection to it's controller who will be the listener
 * to any actions that the user makes.
 *
 * @author Blake Neville
 */
public class MainView {
	
	private 	MainViewController controller;
	
	private 	JFrame 				frame;
	private 	final int			HEIGHT 	= 500;
	private 	final int			WIDTH	= 900;
	
	private 	JPanel				fieldPickerPanel;
	private 	JPanel				fieldViewerPanel;
	
	private		JTextField			searchTextField;
	
	protected 	JTable				fieldTable;
		
	/**
	 * Constructs a new MainView
	 */
	public MainView(MainViewController vc) {
		
		controller = vc;
		
		initComponents();
		
		frame.setVisible(true);
	}

	// Initialize components
	private void initComponents() {
		
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("The Vault");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLayout(new BorderLayout());
		
		fieldPickerPanel = new JPanel();
		fieldPickerPanel.setPreferredSize(new Dimension(WIDTH / 10 * 3, HEIGHT));
		fieldPickerPanel.setBackground(new Color(120, 122, 118));
		frame.add(fieldPickerPanel, BorderLayout.WEST);
		
		fieldViewerPanel = new JPanel();
		fieldViewerPanel.setPreferredSize(new Dimension(WIDTH / 10 * 7 - 3, HEIGHT));
		fieldViewerPanel.setBackground(new Color(108, 109, 106));
		frame.add(fieldViewerPanel, BorderLayout.EAST);
		
		searchTextField = new JTextField();
		searchTextField.addKeyListener(controller);
		searchTextField.setPreferredSize(new Dimension(WIDTH / 10 * 3, HEIGHT / 10 * 1));
		fieldPickerPanel.add(searchTextField);
		
		fieldTable = new JTable(new FieldTableModel()); // rows, columns
		fieldTable.setTableHeader(null);
		JScrollPane scrollPane = new JScrollPane(fieldTable);
		scrollPane.setPreferredSize(new Dimension(WIDTH / 10 * 3, HEIGHT / 10 * 9));
		fieldTable.setFillsViewportHeight(true);
		fieldTable.setRowHeight(30);
		fieldTable.setCellSelectionEnabled(true);
		fieldTable.getSelectionModel().addListSelectionListener(controller);
		fieldPickerPanel.add(scrollPane);
	}
}
