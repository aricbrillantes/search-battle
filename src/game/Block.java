package game;

public class Block {
	
	protected int x;
	protected int y;
	
	protected void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	protected int getX() {
		return x;
	}
	
	protected int getY() {
		return y;
	}
	
}
