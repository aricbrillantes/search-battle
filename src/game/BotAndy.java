package game;

import java.awt.Color;

public class BotAndy extends Character {

	public BotAndy(Block[][] blocks, int x, int y) {
		super(blocks, x, y);
		this.setColor(Color.GREEN);
	}
	
	@Override
	public void think() {
		direction = (int)(Math.random() * 2);
	}

}
