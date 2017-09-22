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

public class PermitPane extends JPanel
{
        public PermitPane()
        {
    		//Adding Jpanels to the SAles panel area 
    		JTabbedPane permitP = new JTabbedPane();
    		permitP.setPreferredSize(new Dimension(1070, 610));
    		permitP.addTab("Permits Required", new PermitsReqPanel());
    		permitP.addTab("Recieve Permits", new RecvPermitPanel());
    		permitP.addTab("Producer Statement", new ProdStatementPanel());
    		permitP.addTab("CCC to Council", new CCCToCounPanel());
    		permitP.addTab("CCC Approved", new CCCApprovedPanel());
    		permitP.addTab("CCC to Client", new CCCToClientPanel());

    		add(permitP); 
        }
}