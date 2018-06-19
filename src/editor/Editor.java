package editor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editor extends JFrame {

	private static final int SPACE = 0;
	private static final int WALL = 1;
	private static final int TREASURE = 2;
	private static final int BOT = 3;
	private static final int ENEMY = 4;
	private static final int ANDY = 5;
	
	private int tool;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editor frame = new Editor();
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
	public Editor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewMap = new JMenuItem("New Map");
		mnFile.add(mntmNewMap);
		
		JMenuItem mntmSelectMap = new JMenuItem("SelectMap");
		mnFile.add(mntmSelectMap);
		
		JMenuItem mntmSaveMap = new JMenuItem("Save Map");
		mnFile.add(mntmSaveMap);
		
		JMenu mnTool = new JMenu("Tool");
		menuBar.add(mnTool);
		
		JMenuItem mntmSpace = new JMenuItem("Space");
		mntmSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tool = SPACE;
			}
		});
		mnTool.add(mntmSpace);
		
		JMenuItem mntmWall = new JMenuItem("Wall");
		mntmWall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tool = WALL;
			}
		});
		mnTool.add(mntmWall);
		
		JMenuItem mntmBot = new JMenuItem("Bot");
		mnTool.add(mntmBot);
		
		JMenuItem mntmEnemy = new JMenuItem("Enemy");
		mnTool.add(mntmEnemy);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public int getTool() {
		return tool;
	}

}
