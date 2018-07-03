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
	public static int flagdis;
	public static int recursemap;
	public static int treasurecount;
	public static int treasurecounted;
	public static int treasureindex;
	public static int flagthink;
	public static int xtemp;
	public static int ytemp;
	public static int reset;
	List<Integer> Treasures = new ArrayList<Integer>();
	
	public BotBrad(Block[][] blocks, int x, int y) {
		super(blocks, x, y);
		
		flag=0;
		flag2=0;
		flagmap=0;
		recursemap=0;
		reset=0;
		flagdis=0;
//		treasureindex=0;
		flagthink=0;
		xtemp=0;
		ytemp=0;
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
		System.out.println("THINK");
		int row=blocks.length;
		int col=blocks[0].length;
		
		int[][] Map = new int[row][col];
		Block[][] previousPath  = new Block[row][col];
		
		int rise, run;
		int distance;
		float bestdistanceTreasure=10000000;
		float bestdistanceMove=10000000;
		ArrayList<Integer> TreasDis = new ArrayList<Integer>();
		ArrayList<Integer> DistanceSorted = new ArrayList<Integer>();
		ArrayList<Integer> TreasureSorted = new ArrayList<Integer>();
		
		int TreasureX=0, TreasureY=0;
		//ArrayList<Integer>  = new ArrayList<Integer>();
		float[] Dir= new float[4];
		
		
		if(treasurecounted==0)
		{
			for(int j=0;j<row;j++)
			{
				for(int i=0;i<col;i++)
				{
					if(blocks[j][i] instanceof Treasure)
					{
						Treasures.add(i);
						Treasures.add(j);
						treasurecount++;
						run=j-x;
						rise=i-y;
						if(run<0) {
							run*=-1;
						}
						if(rise<0) {
							rise*=-1;
						}
						distance=rise+run;
						TreasDis.add(j);
						System.out.println("added j"+j);
						TreasDis.add(i);
						System.out.println("added i"+i);
						TreasDis.add(distance);
							System.out.println("treasureX "+ j +", TreasureY "+i+"\n");
						System.out.println("treasure count: "+treasurecount);
					}
				}
			}
			treasurecounted=1;
		}
		if(flagdis==0)
		{
			System.out.println("TreasDis");
			for(int i=0;i<TreasDis.size();i+=3)
				System.out.println(TreasDis.get(i)+", "+TreasDis.get(i+1)+", "+TreasDis.get(i+2));

			for(int a=2;a<=TreasDis.size();a+=3)
				DistanceSorted.add(TreasDis.get(a));
			
			Collections.sort(DistanceSorted);
			
			System.out.println("DistanceSorted");
//			System.out.println(DistanceSorted);
			for(int i=0;i<DistanceSorted.size()-1;i++)
				System.out.println(DistanceSorted.get(i));
			
			int b=0;
			int a=2;
			
//			while(TreasureSorted.size()!=2*DistanceSorted.size()) 
//			{
//				if(TreasDis.get(a)==DistanceSorted.get(b)) 
//				{
//					TreasureSorted.add(TreasDis.get(a-2));
//					TreasureSorted.add(TreasDis.get(a-1));
//					a=2;
//					b++;
//				}
//				a+=3;	
//			}
			
			while(TreasureSorted.size()!=2*DistanceSorted.size()) 
			{
				System.out.println("TreasDis size: "+TreasDis.size());
				System.out.println("DistanceSorted size: "+DistanceSorted.size()+"\n");
				System.out.println("TreasDis[a]: "+TreasDis.get(a));
				System.out.println("TreasDis[a-1]: "+TreasDis.get(a-1));
				System.out.println("TreasDis[a-2]: "+TreasDis.get(a-2));
				System.out.println("DistanceSorted[b]: "+DistanceSorted.get(b));
				if(TreasDis.get(a)==DistanceSorted.get(b)) 
				{
					TreasureSorted.add(TreasDis.get(a-2));
					TreasureSorted.add(TreasDis.get(a-1));
					a=2;
					b++;
				}
				a+=3;	
			}
			
			System.out.println(TreasureSorted);
			
			flagdis=1;
		}
		System.out.println("size "+Treasures.size()+" index "+treasureindex);
		if(x == Treasures.get(treasureindex+1) && y == Treasures.get(treasureindex))
		{
			System.out.println("repetpls");
			treasureindex+=2;
			Map[x][y]=0;
			flagmap=0;
			flag=0;
			flag2=0;
			flagthink=0;
		}
//		Treasures.size();
		while(treasureindex*2 != treasurecount && flagthink==0)
		{
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
//							System.out.println("treasure "+Map[j][i]);
							
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
		
			
	
	
			if(flag2==0)
			{
				
				List<Integer> path = new ArrayList<Integer>();
				flag2=1;
				if(xtemp==0)
				{
					
					searchPath(getMap(), x, y, path);
				}
				else
				{
//					List<Integer> path = new ArrayList<Integer>();
					searchPath(getMap(), xtemp, ytemp, path);
				}
				System.out.println(x+", "+y);
	
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
				
				int x1 = x;
				int y1 = y;
			
				for(int i=0;i<path.size();i+=2)
				{
					
	//				UNCOMMENT TO TRACE PATH
					System.out.println(path.get(i+1)+", "+path.get(i));
					System.out.println("X:"+x1+" Y:"+y1);
					
	//				System.out.println("X:"+x+" Y:"+y);
					
					if(x1+1==(path.get(i+1)))
					{
						x1++;
						System.out.println("right\n");
	//					for(i=x;i<path.get(i);i++)
							moveList.add(RIGHT);
					}
					
					else if(x1-1==(path.get(i+1)))
					{
						x1--;
						System.out.println("left\n");
	//					for(i=x;i>path.get(i);i--)
							moveList.add(LEFT);
					}
					
					else if(y1+1==(path.get(i)))
					{
						y1++;
						System.out.println("down\n");
	//					for(i=y;i<path.get(i+1);i++)
							moveList.add(DOWN);
					}
					
					else if(y1-1==(path.get(i)))
					{
						y1--;
						System.out.println("up\n");
	//					for(i=y;i>path.get(i+1);i--)
							moveList.add(UP);
					}
					
//					if(Map[x1][y1] == 2)
//					{
//						System.out.println("MAP[X][Y] "+Map[x1][y1]);
//						Map[x1][y1]=0;
//						System.out.println("MAP[X][Y] "+Map[x1][y1]);
//						
//						System.out.println("Map 2: ");
//						for(i=0;i<col;i++)
//						{
//							for(int j=0;j<row;j++)
//							{
//								System.out.print(Map[j][i]);
//								
//							}
//							System.out.println("");
//								
//						}
						xtemp=x1;
						ytemp=y1;
						
//					}
				}
				System.out.println("END");
				flagthink=1;
				
				
				
			}
			System.out.println("think");
		///
		}
		

	}
}