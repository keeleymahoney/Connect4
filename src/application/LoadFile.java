package application;
import java.io.*;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;



public class LoadFile
{
	File file;
	Scanner sc;
	String path_name;
	
	
	
	public LoadFile(String name) throws IOException
	{
		path_name = name;
		file = new File(path_name);
		sc = new Scanner(file);
	}
	
	public ArrayList<ArrayList<String>> readFile()
	{
		ArrayList<ArrayList<String>> final_result = new ArrayList<ArrayList<String>>();
		while(sc.hasNextLine())
		{
			ArrayList<String> line = new ArrayList<String>();
			String value = sc.nextLine();
			
			if(value.charAt(0) == 'P')
			{
				line.add("X");
				String substr = value.substring(27);
				String first_num = substr.substring(1, substr.indexOf(","));
				
				String second_num = substr.substring(substr.indexOf(",") + 2, substr.indexOf(")"));
				
				
				line.add(first_num);
				line.add(second_num);
			}
			else
			{
				line.add("O");
				String substr = value.substring(29);
				String first_num = substr.substring(1, substr.indexOf(","));
				System.out.println("First num is " + first_num);
				String second_num = substr.substring(substr.indexOf(",") + 2, substr.indexOf(")"));
				System.out.println("Second num is " + second_num);
				
				line.add(first_num);
				line.add(second_num);	
			}
			final_result.add(line);
		}
		
		return final_result;
	}
	
	
}