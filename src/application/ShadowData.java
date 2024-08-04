package application;
import java.util.ArrayList;



public class ShadowData {
	
	private ArrayList<ArrayList<String>> board;
	private int num_col;
	private int num_rows;
	
	public ShadowData(int cols, int rows)
	{
		board = new ArrayList<ArrayList<String>>(rows);
		num_col =  cols;
		num_rows = rows;
		
		for(int i = 0; i < rows; i++)
		{
			ArrayList<String> row = new ArrayList<String>();
			for(int j = 0; j < cols; j++)
			{
				row.add("-");
			}
			board.add(row);
		}
		
	}
	
	public int getCols()
	{
		return num_col;
	}
	
	public int getRows()
	{
		return num_rows;
	}
	
	public void putData(int col, int row, String letter)
	{
		board.get(row).set(col, letter);
	}
	
	public ArrayList<Integer> placeData(int col, String letter)
	{
		ArrayList<Integer> return_value = new ArrayList<Integer>();
		for(int i = num_rows-1; i >= 0; i--)
		{
			if((board.get(i)).get(col).equals("-"))
			{
				
				(board.get(i)).set(col, letter);
				return_value.add(i);
				return_value.add(col);
				return return_value;
			}
		}
		return_value.add(-1);
		return_value.add(-1);
		return return_value;
	}
	
	public int find(String value, int row)
	{
		for(int i = 0; i < num_col; i++)
		{
			if(board.get(row).get(i).equals(value))
			{
				return i;
			}
		}
		return -1;
	}
	
	public void resetGame()
	{
		for(int i = 0; i < num_rows; i++)
		{
			for(int j = 0; j < num_col; j++)
			{
				board.get(i).set(j, "-");
			}
		}
	}
	
	public ArrayList<ArrayList<Integer>> threeInARow(String value)
	{
		ArrayList<ArrayList<Integer>> return_value = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < num_rows; i++)
		{
			for(int j = 0; j < num_col - 3; j++)
			{
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i).get(j+1))) && (board.get(i).get(j).equals(board.get(i).get(j+2))) && (board.get(i).get(j+3).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j+3);
					return_value.add(array_value);
				}
				
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i).get(j+1))) && (board.get(i).get(j).equals(board.get(i).get(j+3))) && (board.get(i).get(j+2).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j+2);
					return_value.add(array_value);
				}
				
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i).get(j+2))) && (board.get(i).get(j).equals(board.get(i).get(j+3))) && (board.get(i).get(j+1).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j+1);
					return_value.add(array_value);
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i).get(j+1).equals(value)) && (board.get(i).get(j+1).equals(board.get(i).get(j+2))) && (board.get(i).get(j+1).equals(board.get(i).get(j+3))))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j);
					return_value.add(array_value);
				}
				
			}
		}
		
		for(int j = 0; j < num_col; j++)
		{
			for(int i = num_rows -1 ; i > 2; i--)
			{
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i-1).get(j))) && (board.get(i).get(j).equals(board.get(i-2).get(j))) && (board.get(i-3).get(j).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i-3);
					array_value.add(j);
					return_value.add(array_value);
				}
				
			}
		}
		
		for(int j = 0; j < num_col - 3; j++)
		{
			for(int i = 0; i < num_rows - 3; i++)
			{
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i+1).get(j+1))) && (board.get(i).get(j).equals(board.get(i+2).get(j+2))) && (board.get(i+3).get(j+3).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+3);
					array_value.add(j+3);
					return_value.add(array_value);
				}
				
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i+1).get(j+1))) && (board.get(i).get(j).equals(board.get(i+3).get(j+3))) && (board.get(i+2).get(j+2).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+2);
					array_value.add(j+2);
					return_value.add(array_value);
				}
				
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i+2).get(j+2))) && (board.get(i).get(j).equals(board.get(i+3).get(j+3))) && (board.get(i+1).get(j+1).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+1);
					array_value.add(j+1);
					return_value.add(array_value);
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i+1).get(j+1).equals(value)) && (board.get(i+1).get(j+1).equals(board.get(i+2).get(j+2))) && (board.get(i+1).get(j+1).equals(board.get(i+3).get(j+3))))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j);
					return_value.add(array_value);
				}
			}
		}
		
		for(int j = num_col -1; j > 2; j--)
		{
			for(int i = 0; i < num_rows - 3; i++)
			{
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i+1).get(j-1))) && (board.get(i).get(j).equals(board.get(i+2).get(j-2))) && (board.get(i+3).get(j-3).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+3);
					array_value.add(j-3);
					return_value.add(array_value);
					
				}
				
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i+1).get(j-1))) && (board.get(i).get(j).equals(board.get(i+3).get(j-3))) && (board.get(i+2).get(j-2).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+2);
					array_value.add(j-2);
					return_value.add(array_value);
					
				}
				
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i+2).get(j-2))) && (board.get(i).get(j).equals(board.get(i+3).get(j-3))) && (board.get(i+1).get(j-1).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+1);
					array_value.add(j-1);
					return_value.add(array_value);
					
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i+1).get(j-1).equals(value))&&(board.get(i+1).get(j-1).equals(board.get(i+2).get(j-2))) && (board.get(i+1).get(j-1).equals(board.get(i+3).get(j-3))))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j);
					return_value.add(array_value);
					
				}
			}
		}
		if(return_value.size() == 0)
		{
			ArrayList<Integer> array_value = new ArrayList<Integer>();
			array_value.add(-1);
			array_value.add(-1);
			return_value.add(array_value);
		}
		
		return return_value;
	}
	
	public ArrayList<ArrayList<Integer>> twoInARow(String value)
	{
		ArrayList<ArrayList<Integer>> return_value = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < num_rows; i++)
		{
			for(int j = 0; j < num_col - 3; j++)
			{
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i).get(j+1))) && (board.get(i).get(j+2).equals("-")) && (board.get(i).get(j+3).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j+3);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i);
					array_value2.add(j+2);
					return_value.add(array_value2);
				}
				
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i).get(j+2))) && (board.get(i).get(j+3).equals("-")) && (board.get(i).get(j+1).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j+3);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i);
					array_value2.add(j+1);
					return_value.add(array_value2);
				}
				
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i).get(j+3))) && (board.get(i).get(j+2).equals("-")) && (board.get(i).get(j+1).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j+1);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i);
					array_value2.add(j+2);
					return_value.add(array_value2);
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i).get(j+1).equals(value)) && (board.get(i).get(j+1).equals(board.get(i).get(j+2))) && (board.get(i).get(j+3).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i);
					array_value2.add(j+3);
					return_value.add(array_value2);
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i).get(j+1).equals(value)) && (board.get(i).get(j+1).equals(board.get(i).get(j+3))) && (board.get(i).get(j+2).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i);
					array_value2.add(j+2);
					return_value.add(array_value2);
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i).get(j+2).equals(value)) && (board.get(i).get(j+2).equals(board.get(i).get(j+3))) && (board.get(i).get(j+1).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i);
					array_value2.add(j+1);
					return_value.add(array_value2);
				}
			}
		}
		
		for(int j = 0; j < num_col; j++)
		{
			for(int i = num_rows -1 ; i >2  ; i--)
			{
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i-1).get(j))) && (board.get(i-2).get(j).equals("-")) && (board.get(i-3).get(j).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i-2);
					array_value.add(j);
					return_value.add(array_value);
				}
				
			}
		}
		
		for(int j = 0; j < num_col - 3; j++)
		{
			for(int i = 0; i < num_rows - 3; i++)
			{
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i+1).get(j+1))) && (board.get(i+2).get(j+2).equals("-")) && (board.get(i+3).get(j+3).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+3);
					array_value.add(j+3);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i+2);
					array_value2.add(j+2);
					return_value.add(array_value2);
				}
				
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i+2).get(j+2))) && (board.get(i+3).get(j+3).equals("-")) && (board.get(i+1).get(j+1).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+3);
					array_value.add(j+3);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i+1);
					array_value2.add(j+1);
					return_value.add(array_value2);
				}
				
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i+3).get(j+3))) && (board.get(i+2).get(j+2).equals("-")) && (board.get(i+1).get(j+1).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+1);
					array_value.add(j+1);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i+2);
					array_value2.add(j+2);
					return_value.add(array_value2);
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i+1).get(j+1).equals(value))&& (board.get(i+1).get(j+1).equals(board.get(i+2).get(j+2))) && (board.get(i+3).get(j+3).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+3);
					array_value.add(j+3);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i);
					array_value2.add(j);
					return_value.add(array_value2);
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i+1).get(j+1).equals(value))&& (board.get(i+1).get(j+1).equals(board.get(i+3).get(j+3))) && (board.get(i+2).get(j+2).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+2);
					array_value.add(j+2);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i);
					array_value2.add(j);
					return_value.add(array_value2);
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i+2).get(j+2).equals(value))&&(board.get(i+2).get(j+2).equals(board.get(i+3).get(j+3))) && (board.get(i+3).get(j+1).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+1);
					array_value.add(j+1);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i);
					array_value2.add(j);
					return_value.add(array_value2);
				}
			}
		}
		
		for(int j = num_col -1; j > 2; j--)
		{
			for(int i = 0; i < num_rows - 3; i++)
			{
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i+1).get(j-1))) && (board.get(i+2).get(j-2).equals("-")) && (board.get(i+3).get(j-3).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+3);
					array_value.add(j-3);
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i+2);
					array_value2.add(j-2);
					return_value.add(array_value2);
					
				}
				
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i+2).get(j-2))) && (board.get(i+3).get(j-3).equals("-")) && (board.get(i+1).get(j-1).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+1);
					array_value.add(j-1);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i+3);
					array_value2.add(j-3);
					return_value.add(array_value2);
				}
				
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j).equals(board.get(i+3).get(j-3))) && (board.get(i+2).get(j-2).equals("-")) && (board.get(i+1).get(j-1).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+1);
					array_value.add(j-1);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i+2);
					array_value2.add(j-2);
					return_value.add(array_value2);
					
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i+1).get(j-1).equals(value)) && (board.get(i+1).get(j-1).equals(board.get(i+3).get(j-3))) && (board.get(i+2).get(j-2).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i+2);
					array_value2.add(j-2);
					return_value.add(array_value2);
					
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i+1).get(j-1).equals(value)) && (board.get(i+1).get(j-1).equals(board.get(i+2).get(j-2))) && (board.get(i+3).get(j-3).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i+3);
					array_value2.add(j-3);
					return_value.add(array_value2);
					
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i+2).get(j-2).equals(value)) && (board.get(i+2).get(j-2).equals(board.get(i+3).get(j-3))) && (board.get(i+1).get(j-1).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i+1);
					array_value2.add(j-1);
					return_value.add(array_value2);
					
				}
			}
		}
		if(return_value.size() == 0)
		{
			ArrayList<Integer> array_value = new ArrayList<Integer>();
			array_value.add(-1);
			array_value.add(-1);
			return_value.add(array_value);
		}
		
		return return_value;
		
		
	}
	
	public ArrayList<ArrayList<Integer>> oneInARow(String value)
	{
		ArrayList<ArrayList<Integer>> return_value = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < num_rows; i++)
		{
			for(int j = 0; j < num_col - 3; j++)
			{
				if((board.get(i).get(j).equals(value)) && (board.get(i).get(j+1).equals("-")) && (board.get(i).get(j+2).equals("-")) && (board.get(i).get(j+3).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j+3);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i);
					array_value2.add(j+2);
					return_value.add(array_value2);
					
					ArrayList<Integer> array_value3 = new ArrayList<Integer>();
					array_value3.add(i);
					array_value3.add(j+1);
					return_value.add(array_value3);
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i).get(j+1).equals(value)) && (board.get(i).get(j+2).equals("-")) && (board.get(i).get(j+3).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j+3);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i);
					array_value2.add(j+2);
					return_value.add(array_value2);
					
					ArrayList<Integer> array_value3 = new ArrayList<Integer>();
					array_value3.add(i);
					array_value3.add(j);
					return_value.add(array_value3);
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i).get(j+1).equals("-")) && (board.get(i).get(j+2).equals(value)) && (board.get(i).get(j+3).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j+3);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i);
					array_value2.add(j+1);
					return_value.add(array_value2);
					
					ArrayList<Integer> array_value3 = new ArrayList<Integer>();
					array_value3.add(i);
					array_value3.add(j);
					return_value.add(array_value3);
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i).get(j+1).equals("-")) && (board.get(i).get(j+2).equals("-")) && (board.get(i).get(j+3).equals(value)))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i);
					array_value2.add(j+1);
					return_value.add(array_value2);
					
					ArrayList<Integer> array_value3 = new ArrayList<Integer>();
					array_value3.add(i);
					array_value3.add(j+2);
					return_value.add(array_value3);
				}
			}
		}
		
		for(int j = 0; j < num_col; j++)
		{
			for(int i = num_rows -1 ; i > 2; i--)
			{
				if((board.get(i).get(j).equals(value)) && (board.get(i-1).get(j).equals("-")) && (board.get(i-2).get(j).equals("-")) && (board.get(i-3).get(j).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i-1);
					array_value.add(j);
					return_value.add(array_value);
				}
				
			}
		}
		
		for(int j = 0; j < num_col - 3; j++)
		{
			for(int i = 0; i < num_rows - 3; i++)
			{
				if((board.get(i).get(j).equals(value)) && (board.get(i+1).get(j+1).equals("-")) && (board.get(i+2).get(j+2).equals("-")) && (board.get(i+3).get(j+3).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+3);
					array_value.add(j+3);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i+2);
					array_value2.add(j+2);
					return_value.add(array_value2);
					
					ArrayList<Integer> array_value3 = new ArrayList<Integer>();
					array_value3.add(i+1);
					array_value3.add(j+1);
					return_value.add(array_value3);
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i+1).get(j+1).equals(value)) && (board.get(i+2).get(j+2).equals("-")) && (board.get(i+3).get(j+3).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+3);
					array_value.add(j+3);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i+2);
					array_value2.add(j+2);
					return_value.add(array_value2);
					
					ArrayList<Integer> array_value3 = new ArrayList<Integer>();
					array_value3.add(i);
					array_value3.add(j);
					return_value.add(array_value3);
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i+1).get(j+1).equals("-")) && (board.get(i+2).get(j+2).equals(value)) && (board.get(i+3).get(j+3).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+3);
					array_value.add(j+3);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i);
					array_value2.add(j);
					return_value.add(array_value2);
					
					ArrayList<Integer> array_value3 = new ArrayList<Integer>();
					array_value3.add(i+1);
					array_value3.add(j+1);
					return_value.add(array_value3);
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i+1).get(j+1).equals("-")) && (board.get(i+2).get(j+2).equals("-")) && (board.get(i+3).get(j+3).equals(value)))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j);
					return_value.add(array_value);
					
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i+2);
					array_value2.add(j+2);
					return_value.add(array_value2);
					
					ArrayList<Integer> array_value3 = new ArrayList<Integer>();
					array_value3.add(i+1);
					array_value3.add(j+1);
					return_value.add(array_value3);
				}
				
			}
		}
		
		for(int j = num_col -1; j > 2; j--)
		{
			for(int i = 0; i < num_rows - 3; i++)
			{
				if((board.get(i).get(j).equals(value)) && (board.get(i+1).get(j-1).equals("-")) && (board.get(i+2).get(j-2).equals("-")) && (board.get(i+3).get(j-3).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+3);
					array_value.add(j-3);
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i+2);
					array_value2.add(j-2);
					return_value.add(array_value2);
					
					ArrayList<Integer> array_value3 = new ArrayList<Integer>();
					array_value3.add(i+1);
					array_value3.add(j-1);
					return_value.add(array_value3);
					
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i+1).get(j-1).equals(value)) && (board.get(i+2).get(j-2).equals("-")) && (board.get(i+3).get(j-3).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+3);
					array_value.add(j-3);
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i+2);
					array_value2.add(j-2);
					return_value.add(array_value2);
					
					ArrayList<Integer> array_value3 = new ArrayList<Integer>();
					array_value3.add(i);
					array_value3.add(j);
					return_value.add(array_value3);
					
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i+1).get(j-1).equals("-")) && (board.get(i+2).get(j-2).equals(value)) && (board.get(i+3).get(j-3).equals("-")))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i+3);
					array_value.add(j-3);
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i);
					array_value2.add(j);
					return_value.add(array_value2);
					
					ArrayList<Integer> array_value3 = new ArrayList<Integer>();
					array_value3.add(i+1);
					array_value3.add(j-1);
					return_value.add(array_value3);
					
				}
				
				if((board.get(i).get(j).equals("-")) && (board.get(i+1).get(j-1).equals("-")) && (board.get(i+2).get(j-2).equals("-")) && (board.get(i+3).get(j-3).equals(value)))
				{
					ArrayList<Integer> array_value = new ArrayList<Integer>();
					array_value.add(i);
					array_value.add(j);
					ArrayList<Integer> array_value2 = new ArrayList<Integer>();
					array_value2.add(i+2);
					array_value2.add(j-2);
					return_value.add(array_value2);
					
					ArrayList<Integer> array_value3 = new ArrayList<Integer>();
					array_value3.add(i+1);
					array_value3.add(j-1);
					return_value.add(array_value3);
					
				}
			}
		}
		if(return_value.size() == 0)
		{
			ArrayList<Integer> array_value = new ArrayList<Integer>();
			array_value.add(-1);
			array_value.add(-1);
			return_value.add(array_value);
		}
		
		return return_value;
	}
	
	public String checkWinner()
	{
		//check across
		for(int i = 0; i < num_rows; i++)
		{
			for(int j = 0; j < num_col - 3; j++)
			{
				if(!(board.get(i).get(j).equals("-")) && (board.get(i).get(j).equals(board.get(i).get(j+1))) && (board.get(i).get(j).equals(board.get(i).get(j+2))) && (board.get(i).get(j).equals(board.get(i).get(j+3))))
				{
					return board.get(i).get(j);
				}
			}
		}
		
		for(int j = 0; j < num_col; j++)
		{
			for(int i = 0; i < num_rows - 3; i++)
			{
				if(!(board.get(i).get(j).equals("-")) && (board.get(i).get(j).equals(board.get(i+1).get(j))) && (board.get(i).get(j).equals(board.get(i+2).get(j))) && (board.get(i).get(j).equals(board.get(i+3).get(j))))
				{
					return board.get(i).get(j);
				}
			}
		}
		
		for(int j = 0; j < num_col - 3; j++)
		{
			for(int i = 0; i < num_rows - 3; i++)
			{
				if(!(board.get(i).get(j).equals("-")) && (board.get(i).get(j).equals(board.get(i+1).get(j+1))) && (board.get(i).get(j).equals(board.get(i+2).get(j+2))) && (board.get(i).get(j).equals(board.get(i+3).get(j+3))))
				{
					return board.get(i).get(j);
				}
			}
		}
		
		for(int j = num_col -1; j > 2; j--)
		{
			for(int i = 0; i < num_rows - 3; i++)
			{
				if(!(board.get(i).get(j).equals("-")) && (board.get(i).get(j).equals(board.get(i+1).get(j-1))) && (board.get(i).get(j).equals(board.get(i+2).get(j-2))) && (board.get(i).get(j).equals(board.get(i+3).get(j-3))))
				{
					return board.get(i).get(j);
				}
			}
		}
		return "No winner";	
	}
	
	public void printBoard()
	{
		for(int i= 0; i < num_rows; i++)
		{
			for(int j = 0; j < num_col; j++)
			{
				System.out.print((board.get(i)).get(j) + " ");
			}
			System.out.println();
		}
	}
	
}
