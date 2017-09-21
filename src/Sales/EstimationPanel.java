package Sales; 

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Choice;

class EstimationPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	

	public EstimationPanel() {
		setLayout(null);
		
		JComboBox sortcombx = new JComboBox();
		sortcombx.setModel(new DefaultComboBoxModel(new String[] {"All", "Last Name"}));
		sortcombx.setBounds(44, 22, 164, 20);
		
		add(sortcombx);
		
		JButton btnRefresh = new JButton("Refresh List");
		btnRefresh.setBounds(238, 21, 89, 23);
		add(btnRefresh);
		
		JTable table = new JTable(new DefaultTableModel(null, new Object[]{"Name", "Site Address", "Phone number"}));
		table.setShowGrid(false);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		//I don't know how to display the column names 
		model.addRow(new Object[]{"Name", "Site Address", "Phone number"});
		//Sample data
		model.addRow(new Object[]{"Ben Smith", "123 Sesame Street", "0225698531"});
		
		//Make table scrollable
		
		table.setBounds(44, 60, 377, 458);
		add(table);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(497, 60, 104, 14);
		add(lblName);
		
		JLabel lblSAddr = new JLabel("Site Address:");
		lblSAddr.setBounds(497, 92, 104, 14);
		add(lblSAddr);
		
		JLabel lblSSuburb = new JLabel("Suburb:");
		lblSSuburb.setBounds(497, 117, 104, 14);
		add(lblSSuburb);
		
		JLabel lblPostalAddress = new JLabel("Postal Address:");
		lblPostalAddress.setBounds(497, 142, 104, 14);
		add(lblPostalAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(497, 192, 104, 14);
		add(lblPhoneNumber);
		
		JLabel lblPAddress = new JLabel("Suburb:");
		lblPAddress.setBounds(497, 167, 104, 14);
		add(lblPAddress);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(497, 217, 104, 14);
		add(lblEmail);
		
		JTextArea txtAreaCustInfo = new JTextArea();
		txtAreaCustInfo.setEditable(false);
		txtAreaCustInfo.setBounds(631, 55, 428, 195);
		add(txtAreaCustInfo);
		
		JLabel siteAddrLbl = new JLabel("Fire Place");
	  	siteAddrLbl.setBounds(447, 286, 201, 20);
	  	siteAddrLbl.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
	  	add(siteAddrLbl);
		
		JLabel lblfire = new JLabel("Fire:");
		lblfire.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblfire.setBounds(497, 330, 46, 14);
		add(lblfire);
		
		textField = new JTextField();
		textField.setBounds(631, 324, 218, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(930, 324, 129, 20);
		add(textField_1);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrice.setBounds(880, 327, 46, 14);
		add(lblPrice);
		
		JComboBox comBxInstType = new JComboBox();
		comBxInstType.setBounds(631, 367, 341, 20);
		add(comBxInstType);
		
		JLabel lblNewLabel = new JLabel("Install Type:");
		lblNewLabel.setBounds(497, 370, 104, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Site Check:");
		lblNewLabel_1.setBounds(497, 414, 104, 14);
		add(lblNewLabel_1);
		
		JCheckBox chckbxToBook = new JCheckBox("To Book:");
		chckbxToBook.setBounds(631, 410, 97, 23);
		add(chckbxToBook);
		
		Choice choice = new Choice();
		choice.setBounds(776, 414, 173, 20);
		add(choice);
		
		
		/*JComboBox jcb = new JComboBox();
		jcb.addItem("Vanilla");
		jcb.addItem("Chocolate");
		jcb.addItem("Strawberry");
		add(jcb);*/
		
	}
}
