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
	
	public BotBrad(Block[][] blocks, int x, int y) {
		super(blocks, x, y);
		
		int flag=0;
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
						if(bestdistanceTreasure>distance) {
							bestdistanceTreasure=distance;
							TreasureX=j;
							TreasureY=i;
						}
					}
				}
			}
			flag=1;
		}
		/*int b=0;
		for(int j=x-1;j<x+2;j++)
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
				
			}*/
		
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
			distance=rise/run;
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
			distance=rise/run;
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
			distance=rise/run;
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
			distance=rise/run;
			Dir[3]=distance;
		}
		
		// Move Choose
		for(int i=0; i<Dir.length; i++)
		{
			if(bestdistanceMove>Dir[i])
			{
				bestdistanceMove=Dir[i];
				if(i==0) 
					direction = DOWN;
				else if(i==1)
					direction = UP;
				else if(i==2)
					direction = RIGHT;
				else if(i==3)
					direction = LEFT;
				else
					direction = NONE;
			}
		}
		
		System.out.println("Go "+ direction);

		
//		moveList.add(UP);
//		moveList.add(DOWN);
//		moveList.add(LEFT);
//		moveList.add(RIGHT);
//		moveList.add(STAY);
//		moveList.add(NONE);

//		
//		direction = (int)(Math.random() * 4);

	}
}