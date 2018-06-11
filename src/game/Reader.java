package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {

	protected static final int SPACE = 0;
	protected static final int WALL = 1;
	protected static final int TREASURE = 2;
	
	public Map getMap(String fileName) {
		File file = new File(fileName);
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			int height = Integer.parseInt(scanner.nextLine());
			int width = Integer.parseInt(scanner.nextLine());
			Map map = new Map(height, width);
			for(int y = 0; y < height; y++) {
				String line = scanner.nextLine();
				for(int x = 0; x < line.length(); x++) {
					int i = Integer.parseInt(line.charAt(x) + "");
					if(i == SPACE) {
						
					}
					else if(i == WALL) {
						map.addWall(x, y);
					}
					else if(i == TREASURE) {
						map.addTreasure(x, y);
					}
				}	
			}
			scanner.close();
			return map;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
