package editor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import game.Display;
import game.Map;
import game.Reader;

public class Model {

	private static final int SPACE = 0;
	private static final int WALL = 1;
	private static final int TREASURE = 2;
	private static final int BOT = 3;
	private static final int ENEMY = 4;
	private static final int ANDY = 5;
	
	private Editor editor;
	private Map map;
	
	public Model() {
		Reader reader = new Reader();
		map = reader.getMap("map.txt");
		editor = new Editor();
		editor.setVisible(true);
		Display display = new Display(map);
		editor.setContentPane(display);
		
		display.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) { 
//				System.out.println(me);
				int[] coordinates = display.getCoordinates(me.getX(), me.getY());
				System.out.println(coordinates[0] + ", " + coordinates[1]);
				add(coordinates[0], coordinates[1]);
			}
		});
	}
	
	public void add(int x, int y) {
		switch(editor.getTool()) {
			case SPACE:
				this.addSpace(x, y);
				break;
			case WALL:
				this.addWall(x, y);
				break;
			case TREASURE:
//				this.addWall(x, y);
				break;
			case BOT:
//				this.addWall(x, y);
				break;
			case ENEMY:
//				this.addWall(x, y);
				break;
		}
	}
	
	public void addWall(int x, int y) {
		map.addWall(x, y);
	}
	
	public void addTreasre(int x, int y) {
		map.addTreasure(x, y);
	}
	
	public void addSpace(int x, int y) {
		map.addSpace(x, y);
	}

}
