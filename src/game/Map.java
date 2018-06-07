package game;

import java.awt.Color;
import java.util.ArrayList;

public class Map {

	private static final int UP = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int RIGHT = 3;
	private static final int STAY = 4;
	
	private int height;
	private int width;
	private Block[][] blocks;

	private ArrayList<Character> characters;
	
	public Map(int height, int width) {
		this.setup(height, width);
		this.startGame();
	}
	
	/**
	 * This function sets up the game.
	 * @param height
	 * @param width
	 */
	public void setup(int height, int width) {
		this.height = height;
		this.width = width;
		this.blocks = new Block[this.width][this.height];
		this.characters = new ArrayList<Character>();
		this.setMap();
	}
	
	/**
	 * This function sets up the game map and it's entities.
	 */
	public void setMap() {
		// add walls
		int x, y;
		for(y = 0; y < this.height; y++) {
			for(x = 0; x < this.width; x++) {
				if(y == 0 || x == 0 || y == this.height - 1 || x == this.width - 1) {
					this.blocks[x][y] = new Wall();
				}
			}
		}
		
		/**
		 * this is to test wall collision
		 * P.S it works as of branch karl-1
		this.blocks[4][30] = new Wall();
		this.blocks[2][30] = new Wall();
		this.blocks[3][31] = new Wall();
		this.blocks[3][29] = new Wall();
		**/

		characters.add(new Character(this.blocks, 3, 30));
		characters.get(characters.size() - 1).setColor(Color.CYAN);;
		characters.add(new Character(this.blocks, 30, 30));
		characters.get(characters.size() - 1).setColor(Color.CYAN);;
		characters.add(new Character(this.blocks, 4, 4));
		characters.get(characters.size() - 1).setColor(Color.CYAN);;
		characters.add(new BotAndy(this.blocks, 10, 10));
		characters.get(characters.size() - 1).setColor(Color.GREEN);;
		
	}
	
	/**
	 * This function starts a thread that will run continuously updating the game.
	 */
	public void startGame() {
		Thread game = new Thread(new Runnable() {
			@Override
			public void run() {
                while (true) {
                	update();
                    try {Thread.sleep(100);} catch (Exception ex) {}
                }
			}
		});
		game.start();
	}
	
	private void update() {
		for(Character boi : characters) {
			if(boi.direction() == UP) {
				this.moveUp(boi);
			}
			else if(boi.direction() == DOWN) {
				this.moveDown(boi);
			}
			else if(boi.direction() == LEFT) {
				this.moveLeft(boi);
			}
			else if(boi.direction() == RIGHT) {
				this.moveRight(boi);
			}
		}
	}
	
	private void moveUp(Block block) {
		int x = block.getX();
		int y = block.getY();
		if(y > 0 && y < this.height - 2 && !(this.getBlocks()[x][y-1] instanceof Wall)) {
			this.blocks[x][y] = new Block();
			this.blocks[x][y - 1] = block;
			block.setLocation(x, y - 1);
		}
	}
	
	private void moveDown(Block block) {
		int x = block.getX();
		int y = block.getY();
		if(y < this.height - 1 && !(this.getBlocks()[x][y+1] instanceof Wall)) {
			this.blocks[x][y] = new Block();
			this.blocks[x][y + 1] = block;
			block.setLocation(x, y + 1);
		}
	}
	
	private void moveLeft(Block block) {
		int x = block.getX();
		int y = block.getY();
		if(x > 0 && x < this.width - 1 && !(this.getBlocks()[x-1][y] instanceof Wall)) {
			this.blocks[x][y] = new Block();
			this.blocks[x - 1][y] = block;
			block.setLocation(x - 1, y);
		}
	}
	
	private void moveRight(Block block) {
		int x = block.getX();
		int y = block.getY();
		if(x < this.width - 1 && !(this.getBlocks()[x+1][y] instanceof Wall)) {
			this.blocks[x][y] = new Block();
			this.blocks[x + 1][y] = block;
			block.setLocation(x + 1, y);
		}
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
