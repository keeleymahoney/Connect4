package application;
import java.util.Random;
import java.util.ArrayList;

public class AI {
	
	private boolean random;
	private ShadowData shadow;
	
	public AI(boolean rand, ShadowData shadowData)
	{
		random = rand;
		shadow = shadowData;
	}
	
	public int colSpace()
	{
		if(random == true)
		{
			Random rand = new Random();
			int upperBound = shadow.getCols();
			int random_num = rand.nextInt(upperBound);
			ArrayList<Integer> randomSpot = new ArrayList<Integer>();
			randomSpot = shadow.placeData(random_num, "O");
			shadow.putData(randomSpot.get(1), randomSpot.get(0), "-");
			while(randomSpot.get(0) == -1)
			{
				random_num = rand.nextInt(upperBound);
				randomSpot = shadow.placeData(random_num, "O");
				shadow.putData(randomSpot.get(1), randomSpot.get(0), "-");
			}
			
			return random_num;
		}
		
		
		ArrayList<ArrayList<Integer>> value = new ArrayList<ArrayList<Integer>>();
		value = shadow.threeInARow("O");
		
		if(value.get(0).get(0) != -1)
		{
			for(int i = 0; i < value.size(); i++)
			{
				System.out.println("three in a row");
				ArrayList<Integer> place = new ArrayList<Integer>();
				place = shadow.placeData(value.get(i).get(1), "O");
				if(shadow.checkWinner() == "O")
				{
					System.out.println("O could win here");
					shadow.putData(place.get(1), place.get(0), "-");
					return value.get(i).get(1);
				}
				shadow.putData(place.get(1), place.get(0), "-");
				
				ArrayList<ArrayList<Integer>> playerWin = new ArrayList<ArrayList<Integer>>();
				
				playerWin = shadow.threeInARow("X");
				
				if(playerWin.get(0).get(0) != -1)
				{
					for(int j = 0; j < playerWin.size(); j++)
					{
						System.out.println("X could win here");
						ArrayList<Integer> place2 = shadow.placeData(playerWin.get(j).get(1), "X");
						if(shadow.checkWinner() == "X")
						{
							shadow.putData(place2.get(1), place2.get(0), "-");
							return playerWin.get(j).get(1);
						}
						shadow.putData(place2.get(1), place2.get(0), "-");
					}
				}
				
				place = shadow.placeData(value.get(i).get(1), "O");
				ArrayList<Integer> value2 = new ArrayList<Integer>();
				value2 = shadow.placeData(value.get(i).get(1), "X");
				if(shadow.checkWinner() == "X")
				{
					
					shadow.putData(place.get(1), place.get(0), "-");
					if(value2.get(0) != -1)
					{
						shadow.putData(value2.get(1), value2.get(0), "-");
					}
				}
				else
				{
					shadow.putData(place.get(1), place.get(0), "-");
					if(value2.get(0) != -1)
					{
						shadow.putData(value2.get(1), value2.get(0), "-");
					}
					return value.get(i).get(1);
				}
				if(value2.get(0) != -1)
				{
					shadow.putData(value2.get(1), value2.get(0), "-");
				}
				
			}
		}
		
		ArrayList<ArrayList<Integer>> playerWin = new ArrayList<ArrayList<Integer>>();
		
		playerWin = shadow.threeInARow("X");
		
		if(playerWin.get(0).get(0) != -1)
		{
			System.out.println("x about to win");
			for(int j = 0; j < playerWin.size(); j++)
			{
				ArrayList<Integer> place = new ArrayList<Integer>();
				place = shadow.placeData(playerWin.get(j).get(1), "X");
				System.out.println("this is the board");
				shadow.printBoard();
				if(shadow.checkWinner() == "X")
				{
					shadow.putData(place.get(1), place.get(0), "-");
					return playerWin.get(j).get(1);
				}
				shadow.putData(place.get(1), place.get(0), "-");
			}
		}
		
		
		
		ArrayList<ArrayList<Integer>> value3 = new ArrayList<ArrayList<Integer>>();
		value3 = shadow.twoInARow("O");
		
		if(value3.get(0).get(0) != -1)
		{
			System.out.println("two in a row");
			
			for(int i = 0; i < value3.size(); i++)
			{
				ArrayList<Integer> place = new ArrayList<Integer>();
				place = shadow.placeData(value3.get(i).get(1), "O");
				ArrayList<Integer> value4 = new ArrayList<Integer>();
				value4 = shadow.placeData(value3.get(i).get(1), "X");
				if(shadow.checkWinner() == "X")
				{
					if(value4.get(0) != -1)
					{
						shadow.putData(value4.get(1), value4.get(0), "-");
					}
					
					shadow.putData(place.get(1), place.get(0), "-");
				}
				else
				{
					shadow.putData(place.get(1), place.get(0), "-");
					if(value4.get(0) != -1)
					{
						shadow.putData(value4.get(1), value4.get(0), "-");
					}
					return value3.get(i).get(1);
				}
				if(value4.get(0) != -1)
				{
					shadow.putData(value4.get(1), value4.get(0), "-");
				}
				
			}
		}
		
		ArrayList<ArrayList<Integer>> value5 = new ArrayList<ArrayList<Integer>>();
		value5 = shadow.oneInARow("O");
		
		if(value5.get(0).get(0) != -1)
		{
			System.out.println("one in a row");
			
			for(int i = 0; i < value5.size(); i++)
			{
				ArrayList<Integer> place = new ArrayList<Integer>();
				place = shadow.placeData(value5.get(i).get(1), "O");
				ArrayList<Integer> value6 = new ArrayList<Integer>();
				value6 = shadow.placeData(value5.get(i).get(1), "X");
				if(shadow.checkWinner() == "X")
				{
					shadow.putData(place.get(1), place.get(0), "-");
					if(value6.get(0) != -1)
					{
						shadow.putData(value6.get(1), value6.get(0), "-");
					}
					
				}
				else
				{
					shadow.putData(place.get(1), place.get(0), "-");
					if(value6.get(0) != -1)
					{
						shadow.putData(value6.get(1), value6.get(0), "-");
					}
					return value5.get(i).get(1);
				}
				
				
			}
		}
		
		System.out.println("nothing");
		int num = shadow.find("X", shadow.getRows() - 1);
		if(num == shadow.getCols() -1)
		{
			return num -1;
		}
		return num+1;
		
		
		
		
		
		
	}
	
}
