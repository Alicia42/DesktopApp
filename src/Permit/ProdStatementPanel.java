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


	

	  public ProdStatementPanel() {
		  
			JButton b1 = new JButton("New York");
			add(b1);
			JButton b2 = new JButton("London");
			add(b2);
			JButton b3 = new JButton("Hong Kong");
			add(b3);
			JButton b4 = new JButton("Tokyo");
			add(b4);
		}
	  
}
