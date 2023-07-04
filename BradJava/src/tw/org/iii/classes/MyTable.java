package tw.org.iii.classes;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JTable {
	private FoodDB foodDB;
	public MyTable() {
		// database
		try {
			foodDB = new FoodDB();
			foodDB.queryData();
			
			setModel(new MyModle());
			
		}catch(Exception e) {}
	}
	
	private class MyModle extends DefaultTableModel {

		@Override
		public boolean isCellEditable(int row, int column) {
			// TODO Auto-generated method stub
			return column != 0;
		}

		@Override
		public int getRowCount() {
			return foodDB.getRows();
		}

		@Override
		public int getColumnCount() {
			return foodDB.getCols();
		}

		@Override
		public Object getValueAt(int row, int column) {
			return foodDB.getData(row+1, column+1);
		}
		
	}
}
