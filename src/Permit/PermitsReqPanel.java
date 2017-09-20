package Permit;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class PermitsReqPanel extends JPanel {
	
	private JTable permitsTbl;

	  public PermitsReqPanel() {
		  	setLayout(null);	  
		  
	        DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("Code");
	        model.addColumn("Name");
	        model.addColumn("Quantity");
	        model.addColumn("Unit Price");
	        model.addColumn("Price");
	        model.addRow(new Object[]{"Column 1", "Column 2", "Column 3","Column 4","Column 5"});
	        model.addRow(new Object[]{"Column 1", "Column 2", "Column 2","Column 4","Column 5"});
	        model.addRow(new Object[]{"Column 1", "Column 2", "Column 4","Column 4","Column 5"});
	        model.addRow(new Object[]{"Column 1", "Column 2", "Column 1","Column 4","Column 5"});
	        model.addRow(new Object[]{"Column 1", "Column 2", "Column 99","Column 4","Column 5"});
	        
	        JTable table = new JTable(model);
		  	

	//	  permitsTbl.setColumns(10);
	        table.setBounds(20, 20, 800, 200);
		  	add(table);
	    

		 // Create a couple of columns 
		//  	model.addColumn("Col1"); 
		//  	model.addColumn("Col2"); 

		  	// Append a row 
		//  	model.addRow(new Object[]{"v1", "v2"});
	    
		}
	
}
