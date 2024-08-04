package application;
import java.nio.file.Files;
import java.io.File;
import java.io.*;
import java.nio.file.Path;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.StandardOpenOption;



public class LogFile {
	
	private Path pathName;
	private String string_name;
	private String orig_name;
	private File file;
	int value = 0;
	
	
	public LogFile(String name) throws IOException
	{
		orig_name = name;
		string_name = name + value + ".txt";
		file = new File(string_name);
		
		file.createNewFile();
		PrintWriter writer = new PrintWriter(string_name);
		writer.print("");
		// other operations
		writer.close();
		pathName = Path.of(string_name);
		
	}
	
	public void writeFile(String text) throws IOException
	{
		
		
		Files.writeString(pathName, text, StandardOpenOption.APPEND);
		Files.writeString(pathName, "\n", StandardOpenOption.APPEND);
		
	}
	
	public void saveFile() throws IOException
	{
		value = value + 1;
		string_name = orig_name + value + ".txt";
		file = new File(string_name);
		file.createNewFile();
		
		PrintWriter writer = new PrintWriter(string_name);
		writer.print("");
		// other operations
		writer.close();
		pathName = Path.of(string_name);
		
	}
	

	
	
	
	
	
	
	
	
	
}
