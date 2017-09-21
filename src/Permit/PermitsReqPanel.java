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
	private String result2 = "EXEC AWS_WCH_DB.dbo.[p_PermitsDetails] ";
	private String result3 = "EXEC AWS_WCH_DB.dbo.[p_PermitFire] ";
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
	        detailsTxtArea.setBounds(20, 20, 250, 260);
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
	        lotLbl.setBounds(300, 20, 70, 20);
	        infoPanel.add(lotLbl);
	        lotTxtBx = new JTextField(10);
	        lotTxtBx.setBounds(370, 20, 150, 20);
	        infoPanel.add(lotTxtBx);
	        
	        dpLbl = new JLabel("DP:");
	        dpLbl.setBounds(550, 20, 70, 20);
	        infoPanel.add(dpLbl);
	        dpTxtBx = new JTextField(10);
	        dpTxtBx.setBounds(620, 20, 150, 20);
	        infoPanel.add(dpTxtBx);
	        
	        consentLbl = new JLabel("Consent:");
	        consentLbl.setBounds(800, 20, 70, 20);
	        infoPanel.add(consentLbl);
	        consentTxtBx = new JTextField(10);
	        consentTxtBx.setBounds(870, 20, 150, 20);
	        infoPanel.add(consentTxtBx);
	        
	        buildingLbl = new JLabel("Building:");
	        buildingLbl.setBounds(300, 50, 70, 20);
	        infoPanel.add(buildingLbl);
	        buildingTxtBx = new JTextField("Residence", 10);
	        buildingTxtBx.setBounds(370, 50, 150, 20);
	        infoPanel.add(buildingTxtBx);
	        
	        levelLbl = new JLabel("Unit/Level:");
	        levelLbl.setBounds(550, 50, 70, 20);
	        infoPanel.add(levelLbl);
	        levelTxtBx = new JTextField(10);
	        levelTxtBx.setBounds(620, 50, 150, 20);
	        infoPanel.add(levelTxtBx);
	        
	        valueLbl = new JLabel("Value:");
	        valueLbl.setBounds(800, 50, 70, 20);
	        infoPanel.add(valueLbl);
	        valueTxtBx = new JTextField(10);
	        valueTxtBx.setBounds(870, 50, 150, 20);
	        infoPanel.add(valueTxtBx);
	        	        
	        yearLbl = new JLabel("Year:");
	        yearLbl.setBounds(300, 80, 70, 20);
	        infoPanel.add(yearLbl);
	        yearTxtBx = new JTextField(10);
	        yearTxtBx.setBounds(370, 80, 150, 20);
	        infoPanel.add(yearTxtBx);
	        
	        locationLbl = new JLabel("Location:");
	        locationLbl.setBounds(550, 80, 70, 20);
	        infoPanel.add(locationLbl);
	        locationTxtBx = new JTextField(10);
	        locationTxtBx.setBounds(620, 80, 150, 20);
	        infoPanel.add(locationTxtBx);
	        	        	        
	        ownerLbl = new JLabel("Proof:");
	        ownerLbl.setBounds(800, 80, 70, 20);
	        infoPanel.add(ownerLbl);
	        ownerCmbo = new JComboBox(doctype);
	        ownerCmbo.setSelectedIndex(0);
	        ownerCmbo.setBackground(Color.WHITE);
	        ownerCmbo.setBounds(870, 80, 150, 20);
	        infoPanel.add(ownerCmbo);
	        
	        wetLbl = new JLabel("Wetback:");
	        wetLbl.setBounds(800, 110, 70, 20);
	        infoPanel.add(wetLbl);
	        wetChk = new JCheckBox("");
	        wetChk.setSelected(false);
	        wetChk.setBounds(870, 110, 150, 20);
	        infoPanel.add(wetChk);
	        
	        fireIDLbl = new JLabel("Fire Code:");
	        fireIDLbl.setBounds(300, 140, 70, 20);
	        infoPanel.add(fireIDLbl);
	        fireIDTxtBx = new JTextField(10);
	        fireIDTxtBx.setBounds(370, 140, 150, 20);
	        infoPanel.add(fireIDTxtBx);
	        
	        makeLbl = new JLabel("Make:");
	        makeLbl.setBounds(550, 140, 70, 20);
	        infoPanel.add(makeLbl);
	        makeTxtBx = new JTextField(10);
	        makeTxtBx.setBounds(620, 140, 150, 20);
	        infoPanel.add(makeTxtBx);
	        
	        modelLbl = new JLabel("Model:");
	        modelLbl.setBounds(800, 140, 70, 20);
	        infoPanel.add(modelLbl);
	        modelTxtBx = new JTextField(10);
	        modelTxtBx.setBounds(870, 140, 150, 20);
	        infoPanel.add(modelTxtBx);
	        
	        lifeLbl = new JLabel("Life Time:");
	        lifeLbl.setBounds(300, 170, 70, 20);
	        infoPanel.add(lifeLbl);
	        lifeTxtBx = new JTextField(10);
	        lifeTxtBx.setBounds(370, 170, 150, 20);
	        infoPanel.add(lifeTxtBx);
	        
	        ecanLbl = new JLabel("ECAN:");
	        ecanLbl.setBounds(550, 170, 70, 20);
	        infoPanel.add(ecanLbl);
	        ecanTxtBx = new JTextField(10);
	        ecanTxtBx.setBounds(620, 170, 150, 20);
	        infoPanel.add(ecanTxtBx);
	        
	        nelsonLbl = new JLabel("Nelson:");
	        nelsonLbl.setBounds(800, 170, 70, 20);
	        infoPanel.add(nelsonLbl);
	        nelsonTxtBx = new JTextField(10);
	        nelsonTxtBx.setBounds(870, 170, 150, 20);
	        infoPanel.add(nelsonTxtBx);
	            	        	           	        
	        fireLbl = new JLabel("Fire Type:");
	        fireLbl.setBounds(550, 200, 70, 20);
	        infoPanel.add(fireLbl);
	        fireCmbo = new JComboBox(firestyle);
	        fireCmbo.setSelectedIndex(0);
	        fireCmbo.setBackground(Color.WHITE);
	        fireCmbo.setBounds(620, 200, 150, 20);
	        infoPanel.add(fireCmbo);
	        
	        fuelLbl = new JLabel("Fuel:");
	        fuelLbl.setBounds(800, 200, 70, 20);
	        infoPanel.add(fuelLbl);
	        fuelCmbo = new JComboBox(fueltype);
	        fuelCmbo.setSelectedIndex(0);
	        fuelCmbo.setBackground(Color.WHITE);
	        fuelCmbo.setBounds(870, 200, 150, 20);
	        infoPanel.add(fuelCmbo);
	        

       	  	
	        header= permitsTbl.getTableHeader();
	        columnModel = header.getColumnModel();
	        add(header); 
	        
	        this.setLayout(new BorderLayout()); // unless already there
		  	this.add(scrollPane, BorderLayout.CENTER);
		  	this.add(permitsTbl.getTableHeader(), BorderLayout.NORTH);        
		  	this.add(infoPanel, BorderLayout.SOUTH);
		  	
		  	permitsTbl.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					if (!arg0.getValueIsAdjusting()){
						param = permitsTbl.getValueAt(permitsTbl.getSelectedRow(), 0).toString();
			        	updatePermitDetails(param);
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
	        	PreparedStatement st2 =conn.prepareStatement(result2 + parameter);
	        	ResultSet rs2 = st2.executeQuery();
	    
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
	        	 
	        	 
		        	PreparedStatement st3 =conn.prepareStatement(result3 + parameter);
		        	
		        	ResultSet rs3 = null;
		        	rs3 = st3.executeQuery();
		    
		        	 while(rs3.next()){
		        		 
		        	if (!rs3.getString("FireID").equals(parameter)){
		                //Retrieve by column name
		        		fireIDTxtBx.setText("");
		        		makeTxtBx.setText("");
		        		makeTxtBx.setText("");
		        		modelTxtBx.setText("");
		    	        ecanTxtBx.setText("");
		    	        nelsonTxtBx.setText("");
		    	        lifeTxtBx.setText("");
		    	        fireCmbo.setSelectedIndex(0);
		    	        fireCmbo.setSelectedIndex(0);
		        	
		        		fireIDTxtBx.setText(rs3.getString("FireID"));
		        		makeTxtBx.setText(rs3.getString("Make"));
		        		makeTxtBx.setText(rs3.getString("Make"));
		        		modelTxtBx.setText(rs3.getString("Model"));
		    	        ecanTxtBx.setText(rs3.getString("ECAN"));
		    	        nelsonTxtBx.setText(rs3.getString("Nelson"));
		   // 	        lifeTxtBx.setText(rs2.getString("Life"));
		    	        
		    	        String ft = rs3.getString("FireType");
		    	        if (ft.equals("FS")){
		    	        	fireCmbo.setSelectedIndex(0);
		    	        } else if(ft.equals("IS")){
		    	        	fireCmbo.setSelectedIndex(1);
		    	        } else if(ft.equals("IB")){
		    	        	fireCmbo.setSelectedIndex(2);
		    	        } else{
		    	        	fireCmbo.setSelectedIndex(3);
		    	        }
		    	        
		    	        String fl = rs3.getString("Fuel");
		    	        if (fl.equals("Wood")){
		    	        	fireCmbo.setSelectedIndex(0);
		    	        } else if(fl.equals("Pellet")){
		    	        	fireCmbo.setSelectedIndex(1);
		    	        } else if(fl.equals("Oil")){
		    	        	fireCmbo.setSelectedIndex(2);
		    	        } else{
		    	        	fireCmbo.setSelectedIndex(3);
		    	        }
		        	 }
		        } 
		        
	        	conn.close();	
	        }
	        catch(Exception ex)
	        { 
	        JOptionPane.showMessageDialog(null, ex.toString());
	        }	  	
 	}	
		
}
