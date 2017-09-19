package Permit;

import java.awt.Dimension;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Permit.PermitsReqPanel;
import Permit.RecvPermitPanel;
import Permit.ProdStatementPanel;
import Permit.CCCToCounPanel;
import Permit.CCCApprovedPanel;
import Permit.CCCToClientPanel;

/*import Sales.CustomerPanel;
import Sales.ExtimationPanel;
import Sales.FollowUpPanel;
import Sales.QuotePanel;
import Sales.SiteCheckPanel;*/

public class PermitPane extends JPanel
{
        public PermitPane()
        {
    		//Adding Jpanels to the SAles panel area 
    		JTabbedPane permitP = new JTabbedPane();
    		permitP.setPreferredSize(new Dimension(1080, 570));
    		permitP.addTab("Permits Required", new PermitsReqPanel());
    		permitP.addTab("Recieve Permits", new RecvPermitPanel());
    		permitP.addTab("Produce Statement", new ProdStatementPanel());
    		permitP.addTab("CCC to Council", new CCCToCounPanel());
    		permitP.addTab("CCC Approved", new CCCApprovedPanel());
    		permitP.addTab("CCC to Client", new CCCToClientPanel());

    		add(permitP); 
        }
}