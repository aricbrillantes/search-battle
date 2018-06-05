package game;

public class Map {

	private static final int UP = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int RIGHT = 3;
	
	private int height;
	private int width;
	private Block[][] blocks;

	private Character boi;
	
	public Map(int height, int width) {
		this.height = height;
		this.width = width;
		this.blocks = new Block[width][height];
		
		// add walls
		int x, y;
		for(y = 0; y < this.height; y++) {
			for(x = 0; x < this.width; x++) {
				if(y == 0 || x == 0 || y == this.height - 1 || x == this.width - 1) {
					this.blocks[x][y] = new Wall();
				}
			}
		}
		
		boi = new Character(this.blocks);
		this.blocks[3][30] = boi;
		this.blocks[3][30].setLocation(3, 30);
		this.startGame();
	}
	
	public void startGame() {
		Thread game = new Thread(new Runnable() {
			@Override
			public void run() {
                while (true) {
                	update();
                    try {Thread.sleep(1000);} catch (Exception ex) {}
                }
			}
		});
		game.start();
	}
	
	private void update() {
		System.out.println(boi.getX() + "," + boi.getY());
		if(boi.direction() == UP) {
			this.moveUp(boi);
		}
	}
	
	private void moveUp(Block block) {
		int x = block.getX();
		int y = block.getY();
		if(y > 1 && y < this.height - 2) {
			this.blocks[x][y] = new Block();
			this.blocks[x][y - 1] = block;
			block.setLocation(x, y - 1);
        	System.out.println("hello");
		}
	}
	
	private void moveDown(Block block) {
		
	}
	
	private void moveLeft(Block block) {
		
	}
	
	private void moveRight(Block block) {
		
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
