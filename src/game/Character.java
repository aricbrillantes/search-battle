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
	
	/**
	 * This function starts the thread of Character that does that thinking.
	 */
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * This function is what the thread will contain.
	 */
	@Override
	public void run() {
		while(true) {
            try {Thread.sleep(10);} catch (Exception ex) {}
            this.think();
		}
	}
	
	/**
	 * This function should contain the search methods which the character will
	 * make a decision from and choose a direction to go to.
	 */
	protected void think() {
		direction = (int)(Math.random() * 4);
	}
	
	public int direction() {
		return direction;
	}

}
