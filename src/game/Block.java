package game;

import java.awt.Color;

public class Block {
	
	protected int x;
	protected int y;
	protected Color color;
	
	protected void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	protected void setColor(Color color) {
		this.color = color;
	}
	
	protected int getX() {
		return x;
	}
	
	protected int getY() {
		return y;
	}
	
	protected Color getColor() {
		return color;
	}
	
}
