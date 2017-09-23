package Permit;

import java.awt.Dimension;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Main.*;
import DB_Comms.*;
import Permit.*;
import net.proteanit.sql.DbUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PermitPane extends JPanel
{
	private String user = "";
	private String pass = "";
	private String dbURL = "";
	private CreateConnection connecting;
	private ResultSet results;
	private int tabIndex = 0;
	
	 

	private String[] procedure = new String[]{	"EXEC AWS_WCH_DB.dbo.p_PermitsRequired",
												"EXEC AWS_WCH_DB.dbo.p_PermitsRequired",
												"EXEC AWS_WCH_DB.dbo.p_PermitsRequired",
												"EXEC AWS_WCH_DB.dbo.p_PermitsRequired",
												"EXEC AWS_WCH_DB.dbo.p_PermitsRequired",
												"EXEC AWS_WCH_DB.dbo.p_PermitsRequired"};

	
        public PermitPane(ConnDetails conDeets)
        {   
        	//Get User connection details
    		user = conDeets.getUser();
    		pass = conDeets.getPass();
    		dbURL = conDeets.getURL();
    		
  		  connecting = new CreateConnection();
        	
    		//Adding Jpanels to the SAles panel area 
    		JTabbedPane permitP = new JTabbedPane();
    		permitP.setPreferredSize(new Dimension(1070, 610));
    		permitP.addTab("Permits Required", new PermitsReqPanel(conDeets, this));
    		permitP.addTab("Recieve Permits", new RecvPermitPanel(conDeets, this));
    		permitP.addTab("Producer Statement", new ProdStatementPanel());
    		permitP.addTab("CCC to Council", new CCCToCounPanel());
    		permitP.addTab("CCC Approved", new CCCApprovedPanel());
    		permitP.addTab("CCC to Client", new CCCToClientPanel());
    		add(permitP); 

    		getResults(0);  
    		
    		permitP.addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent e) {
                    if (e.getSource() instanceof JTabbedPane) {
                        JTabbedPane pane = (JTabbedPane) e.getSource();
                        tabIndex = pane.getSelectedIndex();
                        
                        System.out.println("Tab " + tabIndex);
                        
                        getResults(tabIndex); 

                    }
                }
            });
        }
        
        
        private void getResults(int ind){
            try
	        {
	        	Connection conn = connecting.CreateConnection();
	        	PreparedStatement st =conn.prepareStatement(procedure[0]);	//ind]);
	        	results = st.executeQuery();
	        }
	        catch(Exception ex)
	        { 
	        JOptionPane.showMessageDialog(null, ex.toString());
	        }	  	
        }
        
        
        
        public ResultSet getTableData(){
        	if (results==null){
        		getResults(0);
        		return results;
        	}else {

        		return results;
        	}       	
        }
               
}
