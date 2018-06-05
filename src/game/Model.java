package game;

public class Model {

	private Controller controller;
	private View view;
	private Map map;
	
	public Model() {
		map = new Map(3, 5);
		this.display(map);
	}
	
	private void display(Map map) {
		int x, y;
		for(y = 0; y < map.getHeight(); y++) {
			for(x = 0; x < map.getWidth(); x++) {
				System.out.print("[" + x + "," + y + "]");
			}
			System.out.println();
		}
	}
	
}
