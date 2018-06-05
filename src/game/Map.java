package game;

public class Map {
	
	private int height;
	private int width;
	private Block[][] blocks;
	
	public Map(int height, int width) {
		this.height = height;
		this.width = width;
		this.blocks = new Block[height][width];
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
