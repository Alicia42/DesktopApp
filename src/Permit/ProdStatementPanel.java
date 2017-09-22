package Permit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import DB_Comms.CreateConnection;

class ProdStatementPanel extends JPanel {

	private JTableHeader header;
	private TableColumnModel columnModel;
	private JPanel infoPanel;
	private JPanel tablePanel;
	private JTable permitsTbl;
	private DefaultTableModel model;
	
	private JTextArea detailsTxtArea;
	
	private JLabel lotLbl;
	private JTextField lotTxtBx;
	private JLabel dpLbl;
	private JTextField dpTxtBx;
	private JLabel consentLbl;
	private JTextField consentTxtBx;
	
	private JLabel buildingLbl;
	private JTextField buildingTxtBx;
	private JLabel levelLbl;
	private JTextField levelTxtBx;
	private JLabel valueLbl;
	private JTextField valueTxtBx;
	
	private JLabel yearLbl;
	private JTextField yearTxtBx;
	private JLabel locationLbl;
	private JTextField locationTxtBx;
	private JLabel fireIDLbl;
	private JTextField fireIDTxtBx;
	
	private JLabel makeLbl;
	private JTextField makeTxtBx;
	private JLabel modelLbl;
	private JTextField modelTxtBx;
    
	private JLabel lifeLbl;
	private JTextField lifeTxtBx;	
	private JLabel ecanLbl;
	private JTextField ecanTxtBx;
	private JLabel nelsonLbl;
	private JTextField nelsonTxtBx;
	
	private JLabel ownerLbl;
	private JComboBox ownerCmbo;
	private JLabel fireLbl;
	private JComboBox fireCmbo;
	private JLabel fuelLbl;
	private JComboBox fuelCmbo;
	private JLabel wetLbl;
	private JCheckBox wetChk;
	

	  public ProdStatementPanel() {
		  
	//	  connecting = new CreateConnection();
	  	 		  	
		    model = new DefaultTableModel();  
		    model.setRowCount(0);
	        permitsTbl = new JTable(model);
	        permitsTbl.setPreferredSize(new Dimension(0, 300));
	        permitsTbl.setAutoCreateRowSorter(true);
	        
	        JScrollPane scrollPane = new JScrollPane(permitsTbl);
	                	        
	        tablePanel = new JPanel();
	        tablePanel.setBounds(20, 20, 1000, 300);
	        tablePanel.setBackground(Color.red);
	        tablePanel.setLayout(new BorderLayout());
	        
	        infoPanel = new JPanel();
	        infoPanel.setBounds(320, 20, 1000, 300);  //setPreferredSize(new Dimension(0, 300));
	        infoPanel.setBackground(Color.green);
	        infoPanel.setLayout(null);
	        
	        add(tablePanel);
	        add(infoPanel);
	  }
}
