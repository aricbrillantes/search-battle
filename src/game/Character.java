package game;

public class Character extends Block implements Runnable {

	private static final int UP = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int RIGHT = 3;
	
	private Block[][] blocks;
	
	public Character(Block[][] blocks) {
		this.blocks = blocks;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
	
	public int direction() {
		return UP;
	}

}
