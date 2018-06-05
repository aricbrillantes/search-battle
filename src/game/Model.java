package game;

public class Model {

	private Controller controller;
	private View view;
	private Map map;
	
	public Model() {
		map = new Map(50, 100);
//		this.display(map);
		view = new View(map);
	}
	
	private void display(Map map) {
		int x, y;
		for(y = 0; y < map.getHeight(); y++) {
			for(x = 0; x < map.getWidth(); x++) {
				if(map.getBlocks()[x][y] instanceof Wall) {
					System.out.print("[" + x + "," + y + "W]");
				} else {
					System.out.print("[" + x + "," + y + " ]");
				}
			}
			System.out.println();
		}
	}
	
}
