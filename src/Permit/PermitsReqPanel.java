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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import net.proteanit.sql.DbUtils;
import DB_Comms.CreateConnection;


class PermitsReqPanel extends JPanel {
	
	private int [] columnWidth = {12, 30, 30, 20, 20, 20};
	private String procedure = "EXEC AWS_WCH_DB.dbo.[p_PermitsRequired]";   
	
	private String[] doctype = {"Rates Notice","Certificate of Title", "Lease Agreement", "Sale & Purchase", "Other"};
	private String[] firestyle = {"FS","IS", "IB","Other"};
	private String[] fueltype = {"Wood","Pellet", "Oil","Other"};


	
	
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
	
	private JLabel ownerLbl;
	private JComboBox ownerCmbo;
	private JLabel fireLbl;
	private JComboBox fireCmbo;
	private JLabel fuelLbl;
	private JComboBox fuelCmbo;
	
	 

	  public PermitsReqPanel() {
	  	 		  	
		    model = new DefaultTableModel();    	       	        
	        permitsTbl = new JTable(model);
	        permitsTbl.setPreferredSize(new Dimension(0, 300));
	        permitsTbl.setAutoCreateRowSorter(true);
	        
	        JScrollPane scrollPane = new JScrollPane(permitsTbl);
	                
	        
	        infoPanel = new JPanel();
//	        infoPanel.setBackground(Color.GREEN);
	        infoPanel.setPreferredSize(new Dimension(0, 300));
	        infoPanel.setLayout(null);
	        
	        detailsTxtArea = new JTextArea("");
	        detailsTxtArea.setBounds(20, 20, 200, 260);
	        detailsTxtArea.setBorder(BorderFactory.createLineBorder(Color.black));
	  //      detailsTxtArea.setBackground(Color.lightGray);
	        detailsTxtArea.setLineWrap(true);
	        detailsTxtArea.setEditable(false);
	        infoPanel.add(detailsTxtArea);
	        
	        detailsTxtArea.append("Text in this Box:\n");
	        detailsTxtArea.append("Will be client details appended from a sql\nquery\n");
	        detailsTxtArea.append("lines end with \\n \n");
	        detailsTxtArea.append("Or they dont finish \n");
	        detailsTxtArea.append("They will wrap (badly) if too long!");
     	        
	        lotLbl = new JLabel("Lot:");
	        lotLbl.setBounds(250, 20, 50, 20);
	        infoPanel.add(lotLbl);
	        lotTxtBx = new JTextField(10);
	        lotTxtBx.setBounds(320, 20, 150, 20);
	        infoPanel.add(lotTxtBx);
	        
	        dpLbl = new JLabel("DP:");
	        dpLbl.setBounds(250, 50, 50, 20);
	        infoPanel.add(dpLbl);
	        dpTxtBx = new JTextField(10);
	        dpTxtBx.setBounds(320, 50, 150, 20);
	        infoPanel.add(dpTxtBx);
	        
	        consentLbl = new JLabel("Consent:");
	        consentLbl.setBounds(250, 80, 50, 20);
	        infoPanel.add(consentLbl);
	        consentTxtBx = new JTextField(10);
	        consentTxtBx.setBounds(320, 80, 150, 20);
	        infoPanel.add(consentTxtBx);
	        
	        buildingLbl = new JLabel("Building:");
	        buildingLbl.setBounds(500, 20, 50, 20);
	        infoPanel.add(buildingLbl);
	        buildingTxtBx = new JTextField("Residence", 10);
	        buildingTxtBx.setBounds(570, 20, 150, 20);
	        infoPanel.add(buildingTxtBx);
	        
	        levelLbl = new JLabel("Unit/Level:");
	        levelLbl.setBounds(500, 50, 70, 20);
	        infoPanel.add(levelLbl);
	        levelTxtBx = new JTextField(10);
	        levelTxtBx.setBounds(570, 50, 150, 20);
	        infoPanel.add(levelTxtBx);
	        
	        valueLbl = new JLabel("Value:");
	        valueLbl.setBounds(500, 80, 50, 20);
	        infoPanel.add(valueLbl);
	        valueTxtBx = new JTextField(10);
	        valueTxtBx.setBounds(570, 80, 150, 20);
	        infoPanel.add(valueTxtBx);
	        
	        ownerLbl = new JLabel("Proof:");
	        ownerLbl.setBounds(250, 130, 75, 20);
	        infoPanel.add(ownerLbl);
	        ownerCmbo = new JComboBox(doctype);
	        ownerCmbo.setSelectedIndex(0);
	        ownerCmbo.setBounds(320, 130, 150, 20);
	        infoPanel.add(ownerCmbo);
	        
	        fireLbl = new JLabel("Fire Type:");
	        fireLbl.setBounds(250, 160, 75, 20);
	        infoPanel.add(fireLbl);
	        fireCmbo = new JComboBox(firestyle);
	        fireCmbo.setSelectedIndex(0);
	        fireCmbo.setBounds(320, 160, 150, 20);
	        infoPanel.add(fireCmbo);
	        
	        fuelLbl = new JLabel("Fuel:");
	        fuelLbl.setBounds(250, 190, 50, 20);
	        infoPanel.add(fuelLbl);
	        fuelCmbo = new JComboBox(fueltype);
	        fuelCmbo.setSelectedIndex(0);
	        fuelCmbo.setBounds(320, 190, 150, 20);
	        infoPanel.add(fuelCmbo);
	      
//	        add(scrollPane);
       	  	
	        header= permitsTbl.getTableHeader();
	        columnModel = header.getColumnModel();
	        add(header); 
	        
	        this.setLayout(new BorderLayout()); // unless already there
		  	this.add(scrollPane, BorderLayout.CENTER);
		  	this.add(permitsTbl.getTableHeader(), BorderLayout.NORTH);        
		  	this.add(infoPanel, BorderLayout.SOUTH);
		  	
	   //     infoPanel.add(dpTxtBx, BorderLayout.WEST);
		  	
	       updatePermitsRequired();
		  	
		  	
		  	

	  }

		
	  
	  private void updatePermitsRequired() {
	        try
	        {
	        	Connection conn = CreateConnection();
	        	PreparedStatement st =conn.prepareStatement(procedure);
	        	ResultSet rs = st.executeQuery();
	        	permitsTbl.setModel(DbUtils.resultSetToTableModel(rs));
	        	conn.close();	
	        }
	        catch(Exception ex)
	        { 
	        JOptionPane.showMessageDialog(null, ex.toString());
	        }
		  	
	        int i;
	        TableColumn tabCol = columnModel.getColumn(0);
	        for (i=0; i<columnWidth.length; i++){
	             tabCol = columnModel.getColumn(i);
	     //       tabCol.setHeaderValue(columnHeader[i]);
	            tabCol.setPreferredWidth(columnWidth[i]*5);
	        }
	        header.repaint(); 
  
	        
	        
	    
		
	}



	public Connection CreateConnection() {
		  
	        Connection conn = null;

	        try {
	     	   final String dbURL = "jdbc:sqlserver://wchdb.cnfoxyxq90wv.ap-southeast-2.rds.amazonaws.com:1433";

	    	   final String user = "Khgv92367hdkfug9";
	    	   final String pass = "Locei02h84b5KJUVaW";
	          
	            conn = DriverManager.getConnection(dbURL, user, pass);
	            
	            if (conn != null) {

	            	return conn;
	            }
	        } catch (SQLException e) {
	        	System.out.println("Connection Failed");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        JOptionPane.showMessageDialog(null, "Connection Failed!");	        
			return conn;
  
	   }
	  
	  
	  
	
}
