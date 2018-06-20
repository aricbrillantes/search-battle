package game;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View {
	
	JFrame frame;
	
	public View(Map map) {
		frame = new JFrame();
		frame.setSize(1000, 500);
		frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(new Display(map));
		frame.setVisible(true);
	}
	
}
