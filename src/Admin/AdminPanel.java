package Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel extends JFrame{

	private JFrame frame;
	private JTextField txtBxUsername;
	private JPasswordField txtBxPassword;
	private JPanel panel;

	/**
	 * Create the application.
	 */
	public AdminPanel() {  
		
        // setting up JFrame
        getContentPane().setLayout(null);
        setPreferredSize(new Dimension(1100, 700));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame = new JFrame();
		frame.setBounds(0, 0, 1100, 700);
		System.out.println("+++**");
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(null);
		
       // JPanel 
		panel = new JPanel();
	  	panel.setBounds(0, 0, 1100, 700);
	  	//getContentPane().add(panel);
	  	panel.setLayout(null);
	  	frame.getContentPane().add(panel);
	  	
	  	//panel.setBackground(Color.black);
		setPreferredSize(new Dimension(1100, 700));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		//Personal Customer Information
	  	JLabel lbllogIn = new JLabel("Log in");
	  	lbllogIn.setFont(new Font("Arial", Font.BOLD, 20));
	  	lbllogIn.setBounds(493, 63, 87, 20);
	  	add(lbllogIn);
	  	
	  	txtBxUsername = new JTextField();
	  	txtBxUsername.setBounds(493, 150, 229, 20);
	  	add(txtBxUsername);
	  	txtBxUsername.setColumns(10);
	  	
	  	txtBxPassword = new JPasswordField();
	  	txtBxPassword.setBounds(493, 204, 229, 20);
	  	add(txtBxPassword);
	  	
	  	JLabel lblUsername = new JLabel("Username:");
	  	lblUsername.setBounds(397, 153, 86, 14);
	  	add(lblUsername);
	  	
	  	JLabel lblPsssword = new JLabel("Password:");
	  	lblPsssword.setBounds(397, 210, 86, 14);
	  	add(lblPsssword);
	  	
	  	JButton btnLogIn = new JButton("Log In");
	  	btnLogIn.setBounds(546, 297, 89, 23);
	  	add(btnLogIn);
        
	  	pack();

	  	System.out.println("++++++++++++++++");
	  	
	}
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			
			//public void run() {
				//try {
					AdminPanel window = new AdminPanel();
					window.frame.setVisible(true);
					
				//} catch (Exception e) {
					//e.printStackTrace();
				//}
			//}
		//});
	}*/

    public static void main(String[] arguments) {
        // creating JFrame object and setting it visible
        AdminPanel frame = new AdminPanel();
        frame.setVisible(true);
        

    }
}
