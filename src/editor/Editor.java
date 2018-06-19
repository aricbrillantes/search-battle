package editor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editor extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editor frame = new Editor(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Editor(Controller controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewMap = new JMenuItem("New Map");
		mnFile.add(mntmNewMap);
		
		JMenuItem mntmSelectMap = new JMenuItem("Select Map");
		mnFile.add(mntmSelectMap);
		
		JMenuItem mntmSaveMap = new JMenuItem("Save Map");
		mntmSaveMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.save();
			}
		});
		mnFile.add(mntmSaveMap);
		
		JMenu mnTool = new JMenu("Tool");
		menuBar.add(mnTool);
		
		JMenuItem mntmSpace = new JMenuItem("Space");
		mntmSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.selectSpace();
			}
		});
		mnTool.add(mntmSpace);
		
		JMenuItem mntmWall = new JMenuItem("Wall");
		mntmWall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.selectWall();
			}
		});
		mnTool.add(mntmWall);
		
		JMenuItem mntmTreasure = new JMenuItem("Treasure");
		mntmTreasure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.selectTreasure();
			}
		});
		mnTool.add(mntmTreasure);
		
		JMenuItem mntmBot = new JMenuItem("Bot");
		mnTool.add(mntmBot);
		
		JMenuItem mntmEnemy = new JMenuItem("Enemy");
		mntmEnemy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.selectEnemy();
			}
		});
		mnTool.add(mntmEnemy);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
