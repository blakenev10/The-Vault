/**
 * <b>Project:</b>	The Vault
 * <b>Package:</b>	viewsAndControllers
 * <b>File:</b>		FieldTableModel.java
 * 
 * @author Blake Neville
 */
package viewsAndControllers;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import model.Field;

/**<b>Description:</b> 
 *
 * @author Blake Neville
 */
public class FieldTableModel implements TableModel {
	
	protected	Field[]		displayedFields = new Field[0];
	
	@Override
	public int getRowCount() {
		
		return displayedFields.length;
	}

	@Override
	public int getColumnCount() {
		
		return 0;
	}

	@Override
	public String getColumnName(int columnIndex) {
		
		return "Fields";
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		if(columnIndex != 0 || rowIndex < 0 || rowIndex >= displayedFields.length)
			throw new IndexOutOfBoundsException();
		
		return displayedFields[rowIndex];
			
	}
	
	public void setDisplayedFields(Field[] fields) { this.displayedFields = fields; }

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
	}

}
