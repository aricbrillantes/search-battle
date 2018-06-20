package bots;

import java.awt.Color;

import game.Block;
import game.Character;

public class BotAndy extends Character {

	public BotAndy(Block[][] blocks, int x, int y) {
		super(blocks, x, y);
		this.setColor(Color.GREEN);
	}
	
	@Override
	public void think() {
//		direction = (int)(Math.random() * 2);
		direction = STAY;
	}

}
