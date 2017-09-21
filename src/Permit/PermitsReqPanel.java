package Permit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import net.proteanit.sql.DbUtils;
import DB_Comms.CreateConnection;


class PermitsReqPanel extends JPanel {
	
	private int [] columnWidth = {6, 30, 30, 20, 20, 20};
	private String procedure = "EXEC AWS_WCH_DB.dbo.[p_PermitsRequired]";  
	private String result = "EXEC AWS_WCH_DB.dbo.[p_PermitsDetails] ";  
	private String param = "";  
	
	private String[] doctype = {"NONE","Rates Notice","Certificate of Title", "Lease Agreement", "Sale & Purchase", "Other"};
	private String[] firestyle = {"FS","IS", "IB","Other"};
	private String[] fueltype = {"Wood","Pellet", "Oil","Other"};
	
	private CreateConnection connecting;
	
	private JTableHeader header;
	private TableColumnModel columnModel;
	private JPanel infoPanel;
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
	
	private JLabel ownerLbl;
	private JComboBox ownerCmbo;
	private JLabel fireLbl;
	private JComboBox fireCmbo;
	private JLabel fuelLbl;
	private JComboBox fuelCmbo;
	private JLabel wetLbl;
	private JCheckBox wetChk;
	

	  public PermitsReqPanel() {
		  
		  connecting = new CreateConnection();
	  	 		  	
		    model = new DefaultTableModel();  
		    model.setRowCount(0);
	        permitsTbl = new JTable(model);
	        permitsTbl.setPreferredSize(new Dimension(0, 300));
	        permitsTbl.setAutoCreateRowSorter(true);
	        
	        JScrollPane scrollPane = new JScrollPane(permitsTbl);
	                	        
	        infoPanel = new JPanel();
	        infoPanel.setPreferredSize(new Dimension(0, 300));
	        infoPanel.setLayout(null);
	        
	        detailsTxtArea = new JTextArea("");
	        detailsTxtArea.setBounds(20, 20, 200, 260);
	        detailsTxtArea.setBorder(BorderFactory.createLineBorder(Color.black));
	        detailsTxtArea.setLineWrap(true);
	        detailsTxtArea.setEditable(false);
	        infoPanel.add(detailsTxtArea);
	        
	        detailsTxtArea.append("Text in this Box:\n");
	        detailsTxtArea.append("Will be client details appended from a sql\nquery\n");
	        detailsTxtArea.append("lines end with \\n \n");
	        detailsTxtArea.append("Or they dont finish \n");
	        detailsTxtArea.append("They will wrap (badly) if too long!");
     	        
	        lotLbl = new JLabel("Lot:");
	        lotLbl.setBounds(250, 20, 70, 20);
	        infoPanel.add(lotLbl);
	        lotTxtBx = new JTextField(10);
	        lotTxtBx.setBounds(320, 20, 150, 20);
	        infoPanel.add(lotTxtBx);
	        
	        dpLbl = new JLabel("DP:");
	        dpLbl.setBounds(500, 20, 70, 20);
	        infoPanel.add(dpLbl);
	        dpTxtBx = new JTextField(10);
	        dpTxtBx.setBounds(570, 20, 150, 20);
	        infoPanel.add(dpTxtBx);
	        
	        consentLbl = new JLabel("Consent:");
	        consentLbl.setBounds(750, 20, 70, 20);
	        infoPanel.add(consentLbl);
	        consentTxtBx = new JTextField(10);
	        consentTxtBx.setBounds(820, 20, 150, 20);
	        infoPanel.add(consentTxtBx);
	        
	        buildingLbl = new JLabel("Building:");
	        buildingLbl.setBounds(250, 50, 70, 20);
	        infoPanel.add(buildingLbl);
	        buildingTxtBx = new JTextField("Residence", 10);
	        buildingTxtBx.setBounds(320, 50, 150, 20);
	        infoPanel.add(buildingTxtBx);
	        
	        levelLbl = new JLabel("Unit/Level:");
	        levelLbl.setBounds(500, 50, 70, 20);
	        infoPanel.add(levelLbl);
	        levelTxtBx = new JTextField(10);
	        levelTxtBx.setBounds(570, 50, 150, 20);
	        infoPanel.add(levelTxtBx);
	        
	        valueLbl = new JLabel("Value:");
	        valueLbl.setBounds(750, 50, 70, 20);
	        infoPanel.add(valueLbl);
	        valueTxtBx = new JTextField(10);
	        valueTxtBx.setBounds(820, 50, 150, 20);
	        infoPanel.add(valueTxtBx);
	        	        
	        yearLbl = new JLabel("Year:");
	        yearLbl.setBounds(250, 80, 70, 20);
	        infoPanel.add(yearLbl);
	        yearTxtBx = new JTextField(10);
	        yearTxtBx.setBounds(320, 80, 150, 20);
	        infoPanel.add(yearTxtBx);
	        
	        locationLbl = new JLabel("Location:");
	        locationLbl.setBounds(500, 80, 70, 20);
	        infoPanel.add(locationLbl);
	        locationTxtBx = new JTextField(10);
	        locationTxtBx.setBounds(570, 80, 150, 20);
	        infoPanel.add(locationTxtBx);
	        
	        fireIDLbl = new JLabel("Fire Code:");
	        fireIDLbl.setBounds(750, 80, 70, 20);
	        infoPanel.add(fireIDLbl);
	        fireIDTxtBx = new JTextField(10);
	        fireIDTxtBx.setBounds(820, 80, 150, 20);
	        infoPanel.add(fireIDTxtBx);
	        	        	        
	        ownerLbl = new JLabel("Proof:");
	        ownerLbl.setBounds(250, 130, 70, 20);
	        infoPanel.add(ownerLbl);
	        ownerCmbo = new JComboBox(doctype);
	        ownerCmbo.setSelectedIndex(0);
	        ownerCmbo.setBackground(Color.WHITE);
	        ownerCmbo.setBounds(320, 130, 150, 20);
	        infoPanel.add(ownerCmbo);
	        	        
	        fireLbl = new JLabel("Fire Type:");
	        fireLbl.setBounds(250, 160, 70, 20);
	        infoPanel.add(fireLbl);
	        fireCmbo = new JComboBox(firestyle);
	        fireCmbo.setSelectedIndex(0);
	        fireCmbo.setBackground(Color.WHITE);
	        fireCmbo.setBounds(320, 160, 150, 20);
	        infoPanel.add(fireCmbo);
	        
	        fuelLbl = new JLabel("Fuel:");
	        fuelLbl.setBounds(250, 190, 70, 20);
	        infoPanel.add(fuelLbl);
	        fuelCmbo = new JComboBox(fueltype);
	        fuelCmbo.setSelectedIndex(0);
	        fuelCmbo.setBackground(Color.WHITE);
	        fuelCmbo.setBounds(320, 190, 150, 20);
	        infoPanel.add(fuelCmbo);
	        
	        wetLbl = new JLabel("Wetback:");
	        wetLbl.setBounds(250, 220, 70, 20);
	        infoPanel.add(wetLbl);
	        wetChk = new JCheckBox("");
	        wetChk.setSelected(false);
	        wetChk.setBounds(320, 220, 150, 20);
	        infoPanel.add(wetChk);
       	  	
	        header= permitsTbl.getTableHeader();
	        columnModel = header.getColumnModel();
	        add(header); 
	        
	        this.setLayout(new BorderLayout()); // unless already there
		  	this.add(scrollPane, BorderLayout.CENTER);
		  	this.add(permitsTbl.getTableHeader(), BorderLayout.NORTH);        
		  	this.add(infoPanel, BorderLayout.SOUTH);
		  	
	   //     infoPanel.add(dpTxtBx, BorderLayout.WEST);
		  	
		  	permitsTbl.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					if (!arg0.getValueIsAdjusting()){
			    //    if (permitsTbl.getSelectedRow() > 0) {
			            // print first column value from selected row
						param = permitsTbl.getValueAt(permitsTbl.getSelectedRow(), 0).toString();
			       // 	detailsTxtArea.append("\n" + param);
			        	updatePermitDetails(param);
			           // System.out.println(permitsTbl.getValueAt(permitsTbl.getSelectedRow(), 0).toString());
			   //     }
					}
				}
		  	});
		  	
	       updatePermitsRequired();
	       spaceHeader();
	  	
	  }
	  
	  private void spaceHeader() {
	        int i;
	        TableColumn tabCol = columnModel.getColumn(0);
	        for (i=0; i<columnWidth.length; i++){
	             tabCol = columnModel.getColumn(i);
	            tabCol.setPreferredWidth(columnWidth[i]*5);
	        }
	        header.repaint();
	  }
	  
		private void updatePermitsRequired() {
	        try
	        {
	        	Connection conn = connecting.CreateConnection();
	        	PreparedStatement st =conn.prepareStatement(procedure);
	        	ResultSet rs = st.executeQuery();
	        	permitsTbl.setModel(DbUtils.resultSetToTableModel(rs));
	      
	        	conn.close();	
	        }
	        catch(Exception ex)
	        { 
	        JOptionPane.showMessageDialog(null, ex.toString());
	        }	  	
 	}	
		
		private void updatePermitDetails(String parameter) {
	        try
	        {
	        	Connection conn = connecting.CreateConnection();
	        	PreparedStatement st =conn.prepareStatement(result + parameter);
	        	ResultSet rs2 = st.executeQuery();

	    
	                //Retrieve by column name
	        	 while(rs2.next()){
	        		 
	        		 detailsTxtArea.setText("\n INVOICE:\t" + param + "\n");
	        		 detailsTxtArea.append( " CLIENT:\t" + rs2.getString("CustomerName") + "\n\n");
	        		 detailsTxtArea.append( " SITE:\t" + rs2.getString("StreetAddress") + "\n");
	        		 detailsTxtArea.append( "\t" + rs2.getString("Suburb") + "\n\n");
	        		 detailsTxtArea.append( " POSTAL:\t" + rs2.getString("CustomerAddress") + "\n");
	        		 detailsTxtArea.append( "\t" + rs2.getString("CustomerSuburb") + "\n");
	        		 detailsTxtArea.append( "\t" + rs2.getString("CustomerPostCode") + "\n\n");
	        		 detailsTxtArea.append( " PHONE:\t" + rs2.getString("CustomerPhone") + "\n");
	        		 detailsTxtArea.append( " MOBILE:\t" + rs2.getString("CustomerMobile") + "\n\n");
	        		 detailsTxtArea.append( " EMAIL:\t" + rs2.getString("CustomerEmail") + "\n");

	    	        lotTxtBx.setText(rs2.getString("Lot"));
	    	        dpTxtBx.setText(rs2.getString("DP"));
	    	        consentTxtBx.setText(rs2.getString("Consent"));
	    	        buildingTxtBx.setText(rs2.getString("Building"));
	    	        valueTxtBx.setText(rs2.getString("Unit_Level"));
	    	        yearTxtBx.setText(rs2.getString("YearConstructed"));
	    	        locationTxtBx.setText(rs2.getString("Fire_Location"));
	    	        valueTxtBx.setText(rs2.getString("Value"));	                
	        	 }
	        	
	        	conn.close();	
	        }
	        catch(Exception ex)
	        { 
	        JOptionPane.showMessageDialog(null, ex.toString());
	        }	  	
 	}	
		
}
