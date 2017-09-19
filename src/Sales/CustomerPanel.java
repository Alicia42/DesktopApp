package Sales;

import javax.swing.JButton;
import javax.swing.JPanel;

class CustomerPanel extends JPanel {

	  public CustomerPanel() {

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