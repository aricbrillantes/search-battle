package game;

import java.util.Random;

public class Character extends Block implements Runnable {

	private static final int UP = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int RIGHT = 3;
	private static final int STAY = 4;
	private int direction = STAY;
	private Block[][] blocks;
	
	public Character(Block[][] blocks, int x, int y) {
		this.blocks = blocks;
		super.setLocation(x, y);
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
	
	public void think() {
		direction = (int)(Math.random() * 4);	
	}
	
	public int direction() {
		return direction;
	}

}
