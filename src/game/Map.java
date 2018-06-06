package game;

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
	private Character boi;
	
	public Map(int height, int width) {
		this.height = height;
		this.width = width;
		this.blocks = new Block[width][height];
		this.characters = new ArrayList<Character>();
		
		// add walls
		int x, y;
		for(y = 0; y < this.height; y++) {
			for(x = 0; x < this.width; x++) {
				if(y == 0 || x == 0 || y == this.height - 1 || x == this.width - 1) {
					this.blocks[x][y] = new Wall();
				}
			}
		}
		
		characters.add(new Character(this.blocks, 3, 30));
		this.blocks[3][30] = characters.get(0);
		
		/**
		 * this is to test wall collision
		 * P.S it works as of branch karl-1
		this.blocks[4][30] = new Wall();
		this.blocks[2][30] = new Wall();
		this.blocks[3][31] = new Wall();
		this.blocks[3][29] = new Wall();
		**/
		
		
		characters.add(new Character(this.blocks, 30, 30));
		this.blocks[30][30] = characters.get(0);
		characters.add(new Character(this.blocks, 4, 4));
		this.blocks[4][4] = characters.get(0);
		this.startGame();
	}
	
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
		// change this because i have assumed that there are walls in the edges of the map
		// this so far does not accept moves to the other side of the map through the edges,
		// this will be updated to have that feature soon
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
