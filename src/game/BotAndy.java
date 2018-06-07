package game;

public class BotAndy extends Character {

	public BotAndy(Block[][] blocks, int x, int y) {
		super(blocks, x, y);
	}
	
	@Override
	public void think() {
		direction = (int)(Math.random() * 2);
	}

}
