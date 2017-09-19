package Sales;

import javax.swing.JComboBox;
import javax.swing.JPanel;

class FollowUpPanel extends JPanel {

	  public FollowUpPanel() {

	    JComboBox jcb = new JComboBox();
	    jcb.addItem("Vanilla");
	    jcb.addItem("Chocolate");
	    jcb.addItem("Strawberry");
	    add(jcb);
	  }
	}

