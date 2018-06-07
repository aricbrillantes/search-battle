package game;

import javax.swing.JFrame;

public class View {
	
	public View(Map map) {
		JFrame frame = new JFrame();
		frame.setSize(1000, 500);
		frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(new Display(map));
		frame.setVisible(true);
	}
	
}
