/**
 * <b>Project:</b>	The Vault
 * <b>Package:</b>	viewsAndControllers
 * <b>File:</b>		MainViewController.java
 * 
 * @author Blake Neville
 */
package viewsAndControllers;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Field;

/**
 * <b>Description:</b> This controls the MainView application view
 *
 * @author Blake Neville
 */
public class MainViewController implements KeyListener, ListSelectionListener {

	private MainView 	view;
	
	private Field[]		allFields;
	private	Field[]		displayedFields = new Field[0];
	
	private boolean		allowedConfidential = false;

	private int			selectedIndex;
	
	/**
	 * Constructs a new MainViewController
	 */
	public MainViewController() {
		
		selectedIndex = 0;
	}
	
	public void loadFields() {
		
	}

	public void setView(MainView v) { view = v; }
	
	public void displaySelection() {
		
		((FieldTableModel)view.fieldTable.getModel()).displayedFields = displayedFields;
	}
	
	public void searchAndDisplay(String searchFor) {
		
		int count = 0;
				
		Field[] temp = new Field[allFields.length];
		
		if( allowedConfidential )
			for(Field f : allFields)
				if( f.clearanceSearch(searchFor) )
					temp[count++] = f;
				else;
		else
			for(Field f : allFields)
				if( f.searchForStringInField(searchFor) )
					temp[count++] = f;	
				else;
		
		displayedFields = new Field[count];
		
		for(int x = 0; x < count; x++)
			temp[x] = displayedFields[x];
		
		((FieldTableModel)view.fieldTable.getModel()).setDisplayedFields(displayedFields);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		selectedIndex = e.getFirstIndex();
	}
}
