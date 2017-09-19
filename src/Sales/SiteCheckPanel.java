package Sales;

import javax.swing.JComboBox;
import javax.swing.JPanel;

class SiteCheckPanel extends JPanel {

	public SiteCheckPanel() {

		JComboBox jcb = new JComboBox();
		jcb.addItem("Vanilla");
		jcb.addItem("Chocolate");
		jcb.addItem("Strawberry");
		add(jcb);
	}
}
