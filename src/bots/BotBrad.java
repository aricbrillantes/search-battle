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
	public static int flag;
	public static int flag2;
	public static int flagmap;
	public static int recursemap;
	public static int reset;
	
	public BotBrad(Block[][] blocks, int x, int y) {
		super(blocks, x, y);
		
		flag=0;
		flag2=0;
		flagmap=0;
		recursemap=0;
		reset=0;
	}
	
	public int[][] getMap()
	{
		int row=blocks.length;
		int col=blocks[0].length;
		
		int[][] Map  = new int[row][col];		
		
		
		int rise, run;
		float distance;

		if(flagmap==0)
		{
			for(int i=0;i<col;i++)
			{
				for(int j=0;j<row;j++)
				{
					if(blocks[j][i] instanceof Wall)
					{
						Map[j][i] = 1;
//						System.out.println("wall "+Map[j][i]);
					}
					
					else if(blocks[j][i] instanceof Treasure)
					{
						Map[j][i] = 2;
//						System.out.println("treasure "+Map[j][i]);
					}
					
					else
					{
						Map[j][i] = 4;
//					System.out.println("space "+Map[j][i]);
					}
				}
					
			}
			flagmap++;
		}
	
		System.out.println("Map: ");
		for(int i=0;i<col;i++)
		{
			for(int j=0;j<row;j++)
			{
				System.out.print(Map[j][i]);
				
			}
			System.out.println("");
				
		}
		
		return Map;
	}
	
	
	//visited = 3
	//not visited = 4
	
	public boolean searchPath(int[][] map, int x, int y, List<Integer> path)	
	{
		
//		System.out.println("pasok sa searchpath");
//		System.out.println("currently at x"+x+", y"+y+" at "+map[x][y]);
		
		if(map[x][y] == 2)
		{
			path.add(x);
			path.add(y);
//			System.out.println("searchpath found");
			return true;
		}
		
		if(map[x][y]==4)
		{
			map[x][y]=3;
			
			int dx=-1;
			int dy=0;
			
			if(searchPath(map, x+dx,y+dy,path))
			{
				path.add(x);
				path.add(y);
//				System.out.println("searchpath 1");
				return true;
				
			}
			
			dx=1;
			dy=0;
			
			if(searchPath(map, x+dx,y+dy,path))
			{
				path.add(x);
				path.add(y);
//				System.out.println("searchpath 2"); 
				return true;
				
			}
			
			dx=0;
			dy=-1;
			
			if(searchPath(map, x+dx,y+dy,path))
			{
				path.add(x);
				path.add(y);
//				System.out.println("searchpath 3");
				return true;
				
			}
			
			dx=0;
			dy=1;
			
			if(searchPath(map, x+dx,y+dy,path))
			{
				path.add(x);
				path.add(y);
//				System.out.println("searchpath 4");
				return true;
				
			}
			
		}
		
		return false;
	}
	
	
	@Override
	public void think() 
	{
//		flag=0;
//		flag2=0;
		
		int row=blocks.length;
		int col=blocks[0].length;
		
		int[][] Map = new int[row][col];
		Block[][] previousPath  = new Block[row][col];
		List<Integer> Treasures = new ArrayList<Integer>();
		
		int rise, run;
		float distance;
		float bestdistanceTreasure=10000000;
		float bestdistanceMove=10000000;
		
		int TreasureX=0, TreasureY=0;
		//ArrayList<Integer>  = new ArrayList<Integer>();
		float[] Dir= new float[4];
		
		if(flag==0)
		{
			for(int j=0;j<row;j++)
			{
				for(int i=0;i<col;i++)
				{
					if(blocks[j][i] instanceof Wall)
					{
						Map[j][i] = 1;
//						System.out.println("wall "+Map[j][i]);
					}
					
					else if(blocks[j][i] instanceof Treasure)
					{
						Map[j][i] = 2;
						Treasures.add(i);
						Treasures.add(j);
//						System.out.println("treasure "+Map[j][i]);
						run=j-x;
						rise=i-y;
						if(run<0) {
							run*=-1;
						}
						if(rise<0) {
							rise*=-1;
						}
						distance=rise+run;
						if(bestdistanceTreasure>distance) {
							bestdistanceTreasure=distance;
							TreasureX=j;
							TreasureY=i;
//							System.out.println("treasureX "+ TreasureX +", TreasureY "+TreasureY+"\n");
						}
					}
					
					else
					{
						Map[j][i] = 0;
//						System.out.println("space "+Map[j][i]);
					}
						
				}
			}
			flag=1;
		}
		
		/*	int b=0;
		for(int j=x-1;j<x+2;j++) {
			for(int i=y-1;i<y+2;i++) {
				if(blocks[j][i] instanceof Wall || blocks[j][i]==blocks[x][y])
					Dir[b]=100;
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
						Dir[b]=distance;
					}
				b++;
				
			}
		}*/
			
		/*
		//Move Down
		if(blocks[x][y-1] instanceof Wall) 
		{
			Dir[0]=10000000;
			direction = DOWN;
		}
		
		else
		{
			run=TreasureX-x;
			rise=TreasureY-(y-1);
			if(run<0) {
				run*=-1;
			}
			if(rise<0) {
				rise*=-1;
			}
			if(run==0)
				distance=rise;
			else if(rise==0)
				distance=run;
			else
				distance=rise+run;
			Dir[0]=distance;
		}
		
		//Move Up
		if(blocks[x][y+1] instanceof Wall) 
		{
			Dir[1]=10000000;
			direction = UP;
		}
		else
		{
			run=TreasureX-x;
			rise=TreasureY-(y+1);
			if(run<0) {
				run*=-1;
			}
			if(rise<0) {
				rise*=-1;
			}
			if(run==0)
				distance=rise;
			else if(rise==0)
				distance=run;
			else
				distance=rise+run;
			Dir[1]=distance;
		}
		
		//Move Right
		if(blocks[x+1][y] instanceof Wall) {
			Dir[2]=10000000;
			direction = RIGHT;
		}
		else
		{
			run=TreasureX-(x+1);
			rise=TreasureY-y;
			if(run<0) {
				run*=-1;
			}
			if(rise<0) {
				rise*=-1;
			}
			if(run==0)
				distance=rise;
			else if(rise==0)
				distance=run;
			else
				distance=rise+run;
			Dir[2]=distance;
		}
			
		//Move Left
		if(blocks[x-1][y] instanceof Wall) {
			Dir[3]=10000000;
			direction = LEFT;
		}
		else
		{
			run=TreasureX-(x-1);
			rise=TreasureY-y;
			if(run<0) {
				run*=-1;
			}
			if(rise<0) {
				rise*=-1;
			}
			if(run==0)
				distance=rise;
			else if(rise==0)
				distance=run;
			else
				distance=rise+run;
			Dir[3]=distance;
		}
		int move=NONE;
		// Move Choose
		for(int i=0; i<Dir.length; i++)
		{
			System.out.println("\nMove choose");
			if(bestdistanceMove>=Dir[i])
			{
//				System.out.println("Move "+i);
//				System.out.println("Press Any Key To Continue...");
//		        new java.util.Scanner(System.in).nextLine();
				
				bestdistanceMove=Dir[i];
				
				System.out.println("previous: x="+x+", y="+y);
				
				if(i==0 && (blocks[x][y+1]!=previousPath[x][y])) 
				{
					previousPath[x][y]=blocks[x][y];
					move = DOWN;
				}
				else if(i==1 && (blocks[x][y-1]!=previousPath[x][y]))
				{
					previousPath[x][y]=blocks[x][y];
					move = UP;
				}
				else if(i==2 && (blocks[x+1][y]!=previousPath[x][y]))
				{
					previousPath[x][y]=blocks[x][y];
					move = RIGHT;
				}
				else if(i==3 && (blocks[x-1][y]!=previousPath[x][y]))
				{
					previousPath[x][y]=blocks[x][y];
					move = LEFT;
				}
				else
				{
					previousPath[x][y]=blocks[x][y];
					move = NONE;
				}
						
				System.out.println("i="+i+", move="+move);
//				System.out.println("next: x="+x+", y="+y);
			}
		}
		direction = move;
		System.out.println("Go "+ direction);
		System.out.println("next: x="+x+", y="+y);
*/
			
//		moveList.add(UP);
//		moveList.add(DOWN);
//		moveList.add(LEFT);
//		moveList.add(RIGHT);
//		moveList.add(STAY);
//		moveList.add(NONE);

//		
//		direction = (int)(Math.random() * 4);


		if(flag2==0)
		{
			flag2=1;
			List<Integer> path = new ArrayList<Integer>();
			searchPath(getMap(), x, y, path);
			
			System.out.println("\nTreasures: ");
			for(int i=0;i<Treasures.size();i+=2)
				System.out.println(Treasures.get(i+1)+", "+Treasures.get(i));
			
			System.out.println("\npath: ");
			
			//original path
//			for(int i=0;i<path.size();i+=2)
//			{
//				System.out.println(path.get(i+1)+", "+path.get(i));
//			}
			
			//reverse path
//			System.out.println("\n------path 2------\n");
			Collections.reverse(path);
		
			for(int i=0;i<path.size();i+=2)
			{
//				UNCOMMENT TO TRACE PATH
//				System.out.println(path.get(i+1)+", "+path.get(i));
				
//				System.out.println("X:"+x+" Y:"+y);
				
				if(x+1==(path.get(i+1)))
				{
					System.out.println("right");
//					for(i=x;i<path.get(i);i++)
						moveList.add(RIGHT);
				}
				
				else if(x-1==(path.get(i+1)))
				{
					System.out.println("left");
//					for(i=x;i>path.get(i);i--)
						moveList.add(LEFT);
				}
				
				else if(y+1==(path.get(i)))
				{
					System.out.println("down");
//					for(i=y;i<path.get(i+1);i++)
						moveList.add(DOWN);
				}
				
				else if(y-1==(path.get(i)))
				{
					System.out.println("up");
//					for(i=y;i>path.get(i+1);i--)
						moveList.add(UP);
				}
				
			}
			
		}
	}
}