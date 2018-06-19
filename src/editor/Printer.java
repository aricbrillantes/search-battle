package editor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import game.Enemy;
import game.Map;
import game.Treasure;
import game.Wall;

public class Printer {

	protected static final int SPACE = 0;
	protected static final int WALL = 1;
	protected static final int TREASURE = 2;
	protected static final int BOT = 3;
	protected static final int ENEMY = 4;
	protected static final int ANDY = 5;

	public Printer(Map map, String fileName) {
		try {
			PrintWriter p = new PrintWriter(fileName, "UTF-8");

			p.println(map.getHeight());
			p.println(map.getWidth());
			
			for(int y = 0; y < map.getHeight(); y++) {
				for(int x = 0; x < map.getWidth(); x++) {
					if(map.getBlocks()[x][y] instanceof Wall) {
						p.print(WALL);
					}
					else if(map.getBlocks()[x][y] instanceof Treasure) {
						p.print(TREASURE);
					}
					else if(map.getBlocks()[x][y] instanceof Enemy) {
						p.print(ENEMY);
					}
					else {
						p.print(SPACE);
					}
				}
				p.println();
			}
			
			p.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
}
