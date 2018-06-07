package game;

import java.awt.Color;

public class Character extends Block implements Runnable {

	protected static final int UP = 0;
	protected static final int DOWN = 1;
	protected static final int LEFT = 2;
	protected static final int RIGHT = 3;
	protected static final int STAY = 4;
	protected int direction = STAY;
	protected Block[][] blocks;
	
	public Character(Block[][] blocks, int x, int y) {
		this.blocks = blocks;
		super.setLocation(x, y);
		this.start();
	}
	
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while(true) {
            try {Thread.sleep(10);} catch (Exception ex) {}
            this.think();
		}
	}
	
	protected void think() {
		direction = (int)(Math.random() * 4);
	}
	
	public int direction() {
		return direction;
	}

}
