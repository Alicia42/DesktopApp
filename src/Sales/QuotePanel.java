package Sales; 

import javax.swing.JComboBox;
import javax.swing.JPanel;

class QuotePanel extends JPanel {

	  public QuotePanel() {

	    JComboBox jcb = new JComboBox();
	    jcb.addItem("Vanilla");
	    jcb.addItem("Chocolate");
	    jcb.addItem("Strawberry");
	    add(jcb);
	  }
	}

