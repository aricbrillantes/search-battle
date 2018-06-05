package game;

public class Map {
	
	private int height;
	private int width;
	private Block[][] blocks;
	
	public Map(int height, int width) {
		this.height = height;
		this.width = width;
		this.blocks = new Block[width][height];
		
		// add wall
		this.blocks[1][1] = new Wall();
		
		int x, y;
		for(y = 0; y < this.height; y++) {
			for(x = 0; x < this.width; x++) {
				if(y == 0 || x == 0 || y == this.height - 1 || x == this.width - 1) {
					this.blocks[x][y] = new Wall();
				}
			}
		}
	}
	
	public Block[][] getBlocks() {
		return blocks;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}

}
