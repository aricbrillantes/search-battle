package bots;

import java.util.*;

import game.Block;
import game.Character;
import game.Wall;
import game.Map;
import game.Model;
import game.Treasure;
 
public class BotBrad extends Character {

	public static Block[][] blocks2;
	public static TreasureLocation[] treasures;
	public static int flag;
	
	public BotBrad(Block[][] blocks, int x, int y) {
		super(blocks, x, y);
		
		TreasureLocation[] treasures;
		Block[][] blocks2=this.blocks;
		int flag=0;
	}
	
	public static class TreasureLocation
	{
		private int xCoordinate;
		private int yCoordinate;
		
		public void setX(int x)
		{
			this.xCoordinate=x;
		}
		
		public void setY(int y)
		{
			this.yCoordinate=y;
		}
		
		public int getX()
		{
			return this.xCoordinate;
		}
		
		public int getY()
		{
			return this.yCoordinate;
		}
		
		public TreasureLocation() {
			// TODO Auto-generated constructor stub
			int x; int y;
		}
	}
	
	@Override
	public void think() 
	{
//		int flag=0;
		int row=blocks.length;
		int col=blocks[0].length;
		Block[][] Treasures  = new Block[row][col];
		int rise, run;
		float distance;
		int a=0;
		float bestdistance=0;
		int TreasureX=0, TreasureY=0;
		//ArrayList<Integer>  = new ArrayList<Integer>();
		float[] Dir= new float[4];
		if(flag==0)
		{
			for(int j=0;j<row;j++)
			{
				for(int i=0;i<col;i++)
				{
					if(blocks[j][i] instanceof Treasure)
					{
						Treasures[j][i] = blocks[j][i];
						System.out.println("treasure at "+ j +", "+i);
						run=j-x;
						rise=i-y;
						if(run<0) {
							run*=-1;
						}
						if(rise<0) {
							rise*=-1;
						}
						distance=rise/run;
						if(bestdistance<distance) {
							bestdistance=distance;
							TreasureX=j;
							TreasureY=i;
						}
					}
				}
			}
			flag=1;
		}
		int b=0;
		for(int j=x-1;j<x+2;j++)
			for(int i=y-1;i<y+2;i++) {
				if(blocks[j][i] instanceof Wall || blocks[j][i]==blocks[x][y])
					Dir[a]=0;
				else
				{
					
					run=TreasureX-j;
					rise=TreasureY-i;
					if(run<0) {
						run*=-1;
					}
					if(rise<0) {
						rise*=-1;
					}
					distance=rise/run;
					Dir[a]=distance;
				}
				b++;
				
			}
		
		
		
//		TreasureL1ocation[] z = treasures;
//		moveList.add(UP);
//		moveList.add(DOWN);
//		moveList.add(LEFT);
//		moveList.add(RIGHT);
//		moveList.add(STAY);
//		moveList.add(NONE);
		
		if(blocks[x][y-1] instanceof Wall) 
		{
//			System.out.println("brad hit a wall");
			direction = DOWN;
		}
		
		if(blocks[x][y+1] instanceof Wall) 
		{
//			System.out.println("brad hit a wall");
			direction = UP;
		}
		
		if(blocks[x+1][y] instanceof Wall) 
			direction = RIGHT;
		
		if(blocks[x-1][y] instanceof Wall) 
			direction = LEFT;
//		
//		direction = (int)(Math.random() * 4);
		
		
	}
	
	
	public static void getTreasures(Block[][] blocks)
	{
		TreasureLocation[] TreasureLocations = new TreasureLocation[blocks.length*blocks[0].length];
		
//		System.out.println("length "+blocks.length);
		
		int h=0,i,j;
		
		for(i=0;i<20;i++)
		{
			for(j=0;j<10;j++)
			{
//				System.out.println(i+", "+j);
//				Blocks[][] blocks2;
				
				if(blocks[i][j] instanceof Wall)
				{
					System.out.println("wall at "+ i +", "+j);
					TreasureLocation tempTreasureLocation =  new BotBrad.TreasureLocation();
					tempTreasureLocation.setX(i);
					tempTreasureLocation.setY(j);
//					System.out.println(TreasureLocations[h].getX()+", "+TreasureLocations[h].getY());
					TreasureLocations[h]=tempTreasureLocation;
					
					h++;
				}
				
				if(blocks[i][j] instanceof Treasure)
				{
					System.out.println("treasure at "+ i +", "+j);
					TreasureLocation tempTreasureLocation =  new BotBrad.TreasureLocation();
					tempTreasureLocation.setX(i);
					tempTreasureLocation.setY(j);
//					System.out.println(TreasureLocations[h].getX()+", "+TreasureLocations[h].getY());
					TreasureLocations[h]=tempTreasureLocation;
					
					h++;
				}

			}
			
		}
			
		treasures = TreasureLocations;
	}	
	
//	public static void getTreasures2()
//	{
//		getTreasures(blocks);
//	}	
}