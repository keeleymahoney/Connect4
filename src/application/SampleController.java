package application;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.shape.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.fxml.FXML;
import java.util.ArrayList;
import javafx.scene.control.TextField;



public class SampleController {
	
	@FXML private Button button1;
	@FXML private Button button2;
	@FXML private Button button3;
	@FXML private Button button4;
	@FXML private Button button5;
	@FXML private Button button6;
	@FXML private Button button7;
	
	private ShadowData board;
	
	@FXML private Button reset;
	@FXML private Button load;
	@FXML private Button save;
	@FXML private Button thoughtful;
	@FXML private Button random;
	
	@FXML private Label label1;
	
	
	@FXML private Circle circle00;
	@FXML private Circle circle01;
	@FXML private Circle circle02;
	@FXML private Circle circle03;
	@FXML private Circle circle04;
	@FXML private Circle circle05;
	@FXML private Circle circle06;
	
	@FXML private Circle circle10;
	@FXML private Circle circle11;
	@FXML private Circle circle12;
	@FXML private Circle circle13;
	@FXML private Circle circle14;
	@FXML private Circle circle15;
	@FXML private Circle circle16;
	
	@FXML private Circle circle20;
	@FXML private Circle circle21;
	@FXML private Circle circle22;
	@FXML private Circle circle23;
	@FXML private Circle circle24;
	@FXML private Circle circle25;
	@FXML private Circle circle26;
	
	@FXML private Circle circle30;
	@FXML private Circle circle31;
	@FXML private Circle circle32;
	@FXML private Circle circle33;
	@FXML private Circle circle34;
	@FXML private Circle circle35;
	@FXML private Circle circle36;
	
	@FXML private Circle circle40;
	@FXML private Circle circle41;
	@FXML private Circle circle42;
	@FXML private Circle circle43;
	@FXML private Circle circle44;
	@FXML private Circle circle45;
	@FXML private Circle circle46;
	
	@FXML private Circle circle50;
	@FXML private Circle circle51;
	@FXML private Circle circle52;
	@FXML private Circle circle53;
	@FXML private Circle circle54;
	@FXML private Circle circle55;
	@FXML private Circle circle56;
	
	@FXML private Button finished;
	
	@FXML private TextField text;
	
	
	private LoadFile load_file;
	
	private boolean win;
	
	private ArrayList<ArrayList<Circle>> circles;
	
	private AI artificial;
	
	private LogFile file;
	
	
	
	
	public void initialize()
	{
		win = false;
		
		board = new ShadowData(7, 6);
		circles = new ArrayList<ArrayList<Circle>>();
		
		try
		{
			file = new LogFile("/Users/keeleymahoney/Desktop/CSCE314/log");
		}
		catch (IOException e) {
	        e.printStackTrace();
		}
		
		
		
		
		
		ArrayList<Circle> row = new ArrayList<Circle>();
		row.add(circle00);
		row.add(circle01);
		row.add(circle02);
		row.add(circle03);
		row.add(circle04);
		row.add(circle05);
		row.add(circle06);
		circles.add(row);
		
		ArrayList<Circle> row1 = new ArrayList<Circle>();
		row1.add(circle10);
		row1.add(circle11);
		row1.add(circle12);
		row1.add(circle13);
		row1.add(circle14);
		row1.add(circle15);
		row1.add(circle16);
		circles.add(row1);
		
		ArrayList<Circle> row2 = new ArrayList<Circle>();
		row2.add(circle20);
		row2.add(circle21);
		row2.add(circle22);
		row2.add(circle23);
		row2.add(circle24);
		row2.add(circle25);
		row2.add(circle26);
		circles.add(row2);
		
		ArrayList<Circle> row3 = new ArrayList<Circle>();
		row3.add(circle30);
		row3.add(circle31);
		row3.add(circle32);
		row3.add(circle33);
		row3.add(circle34);
		row3.add(circle35);
		row3.add(circle36);
		circles.add(row3);
		
		ArrayList<Circle> row4 = new ArrayList<Circle>();
		row4.add(circle40);
		row4.add(circle41);
		row4.add(circle42);
		row4.add(circle43);
		row4.add(circle44);
		row4.add(circle45);
		row4.add(circle46);
		circles.add(row4);
		
		ArrayList<Circle> row5 = new ArrayList<Circle>();
		row5.add(circle50);
		row5.add(circle51);
		row5.add(circle52);
		row5.add(circle53);
		row5.add(circle54);
		row5.add(circle55);
		row5.add(circle56);
		circles.add(row5);
	}
	
	public void randomPress(ActionEvent e)
	{
		artificial = new AI(true, board);
	}
	
	public void thoughtfulPress(ActionEvent e)
	{
		artificial = new AI(false, board);
	}
	
	public void button1Press()
	{
		if(win == true)
		{
			label1.setText("This game has already been won. Please reset!");
		}
		else
		{
			ArrayList<Integer> return_value = board.placeData(0, "X");
			if(return_value.get(0) == -1)
			{
				label1.setText("Column is full!");
			}
			else
			{
				circles.get(return_value.get(0)).get(return_value.get(1)).setFill(Color.RED);
				label1.setText("Item has been dropped!");
				try
				{
					file.writeFile("Player has dropped item at (" + return_value.get(0) + ", " + return_value.get(1) + ")" );
				}
				catch (IOException e) {
			        e.printStackTrace();
				}
				
				String winner = board.checkWinner();
				if(winner == "X")
				{
					label1.setText("You have won!");
					win = true;
				}
				else if(winner == "O")
				{
					label1.setText("The computer has won!");
					win = true;
				}
				
			}
			
			if(win != true)
			{
				int spot = artificial.colSpace();
				ArrayList<Integer> spot_value = board.placeData(spot, "O");
				circles.get(spot_value.get(0)).get(spot_value.get(1)).setFill(Color.YELLOW);
				label1.setText("Item has been dropped!");
				try
				{
					file.writeFile("Computer has dropped item at (" + spot_value.get(0) + ", " + spot_value.get(1) + ")" );
				}
				catch (IOException e) {
			        e.printStackTrace();
				}
				
				
				
				String winner = board.checkWinner();
				if(winner == "X")
				{
					label1.setText("You have won!");
					win = true;
				}
				else if(winner == "O")
				{
					label1.setText("The computer has won!");
					win = true;
				}
				
			}
		}
		board.printBoard();
		System.out.println();
		
	}
	
	public void button2Press()
	{
		if(win == true)
		{
			label1.setText("This game has already been won. Please reset!");
		}
		else
		{
			ArrayList<Integer> return_value = board.placeData(1, "X");
			if(return_value.get(0) == -1)
			{
				label1.setText("Column is full!");
			}
			else
			{
				circles.get(return_value.get(0)).get(return_value.get(1)).setFill(Color.RED);
				label1.setText("Item has been dropped!");
				try
				{
					file.writeFile("Player has dropped item at (" + return_value.get(0) + ", " + return_value.get(1) + ")" );
				}
				catch (IOException e) {
			        e.printStackTrace();
				}
				
				String winner = board.checkWinner();
				if(winner == "X")
				{
					label1.setText("You have won!");
					win = true;
				}
				else if(winner == "O")
				{
					label1.setText("The computer has won!");
					win = true;
				}
				
			}
			
			if(win != true)
			{
				int spot = artificial.colSpace();
				ArrayList<Integer> spot_value = board.placeData(spot, "O");
				circles.get(spot_value.get(0)).get(spot_value.get(1)).setFill(Color.YELLOW);
				label1.setText("Item has been dropped!");
				try
				{
					file.writeFile("Computer has dropped item at (" + spot_value.get(0) + ", " + spot_value.get(1) + ")" );
				}
				catch (IOException e) {
			        e.printStackTrace();
				}
				
				
				
				String winner = board.checkWinner();
				if(winner == "X")
				{
					label1.setText("You have won!");
					win = true;
				}
				else if(winner == "O")
				{
					label1.setText("The computer has won!");
					win = true;
				}
				
			}
		}
		board.printBoard();
		System.out.println();
	}
	
	public void button3Press()
	{
		if(win == true)
		{
			label1.setText("This game has already been won. Please reset!");
		}
		else
		{
			ArrayList<Integer> return_value = board.placeData(2, "X");
			if(return_value.get(0) == -1)
			{
				label1.setText("Column is full!");
			}
			else
			{
				circles.get(return_value.get(0)).get(return_value.get(1)).setFill(Color.RED);
				label1.setText("Item has been dropped!");
				try
				{
					file.writeFile("Player has dropped item at (" + return_value.get(0) + ", " + return_value.get(1) + ")" );
				}
				catch (IOException e) {
			        e.printStackTrace();
				}
				
				String winner = board.checkWinner();
				if(winner == "X")
				{
					label1.setText("You have won!");
					win = true;
				}
				else if(winner == "O")
				{
					label1.setText("The computer has won!");
					win = true;
				}
				
			}
			
			if(win != true)
			{
				int spot = artificial.colSpace();
				ArrayList<Integer> spot_value = board.placeData(spot, "O");
				circles.get(spot_value.get(0)).get(spot_value.get(1)).setFill(Color.YELLOW);
				label1.setText("Item has been dropped!");
				try
				{
					file.writeFile("Computer has dropped item at (" + spot_value.get(0) + ", " + spot_value.get(1) + ")" );
				}
				catch (IOException e) {
			        e.printStackTrace();
				}
				
				
				
				String winner = board.checkWinner();
				if(winner == "X")
				{
					label1.setText("You have won!");
					win = true;
				}
				else if(winner == "O")
				{
					label1.setText("The computer has won!");
					win = true;
				}
				
			}
		}
		board.printBoard();
		System.out.println();
	}
	
	
	public void button4Press()
	{
		if(win == true)
		{
			label1.setText("This game has already been won. Please reset!");
		}
		else
		{
			ArrayList<Integer> return_value = board.placeData(3, "X");
			if(return_value.get(0) == -1)
			{
				label1.setText("Column is full!");
			}
			else
			{
				circles.get(return_value.get(0)).get(return_value.get(1)).setFill(Color.RED);
				label1.setText("Item has been dropped!");
				try
				{
					file.writeFile("Player has dropped item at (" + return_value.get(0) + ", " + return_value.get(1) + ")" );
				}
				catch (IOException e) {
			        e.printStackTrace();
				}
				
				String winner = board.checkWinner();
				if(winner == "X")
				{
					label1.setText("You have won!");
					win = true;
				}
				else if(winner == "O")
				{
					label1.setText("The computer has won!");
					win = true;
				}
				
			}
			
			if(win != true)
			{
				int spot = artificial.colSpace();
				ArrayList<Integer> spot_value = board.placeData(spot, "O");
				circles.get(spot_value.get(0)).get(spot_value.get(1)).setFill(Color.YELLOW);
				label1.setText("Item has been dropped!");
				try
				{
					file.writeFile("Computer has dropped item at (" + spot_value.get(0) + ", " + spot_value.get(1) + ")" );
				}
				catch (IOException e) {
			        e.printStackTrace();
				}
				
				
				
				String winner = board.checkWinner();
				if(winner == "X")
				{
					label1.setText("You have won!");
					win = true;
				}
				else if(winner == "O")
				{
					label1.setText("The computer has won!");
					win = true;
				}
				
			}
		}
		board.printBoard();
		System.out.println();
	}
	
	public void button5Press()
	{
		if(win == true)
		{
			label1.setText("This game has already been won. Please reset!");
		}
		else
		{
			ArrayList<Integer> return_value = board.placeData(4, "X");
			if(return_value.get(0) == -1)
			{
				label1.setText("Column is full!");
			}
			else
			{
				circles.get(return_value.get(0)).get(return_value.get(1)).setFill(Color.RED);
				label1.setText("Item has been dropped!");
				try
				{
					file.writeFile("Player has dropped item at (" + return_value.get(0) + ", " + return_value.get(1) + ")" );
				}
				catch (IOException e) {
			        e.printStackTrace();
				}
				
				String winner = board.checkWinner();
				if(winner == "X")
				{
					label1.setText("You have won!");
					win = true;
				}
				else if(winner == "O")
				{
					label1.setText("The computer has won!");
					win = true;
				}
				
			}
			
			if(win != true)
			{
				int spot = artificial.colSpace();
				ArrayList<Integer> spot_value = board.placeData(spot, "O");
				circles.get(spot_value.get(0)).get(spot_value.get(1)).setFill(Color.YELLOW);
				label1.setText("Item has been dropped!");
				try
				{
					file.writeFile("Computer has dropped item at (" + spot_value.get(0) + ", " + spot_value.get(1) + ")" );
				}
				catch (IOException e) {
			        e.printStackTrace();
				}
				
				
				
				String winner = board.checkWinner();
				if(winner == "X")
				{
					label1.setText("You have won!");
					win = true;
				}
				else if(winner == "O")
				{
					label1.setText("The computer has won!");
					win = true;
				}
				
			}
		}
		board.printBoard();
		System.out.println();
	}
	
	public void button6Press()
	{
		if(win == true)
		{
			label1.setText("This game has already been won. Please reset!");
		}
		else
		{
			ArrayList<Integer> return_value = board.placeData(5, "X");
			if(return_value.get(0) == -1)
			{
				label1.setText("Column is full!");
			}
			else
			{
				circles.get(return_value.get(0)).get(return_value.get(1)).setFill(Color.RED);
				label1.setText("Item has been dropped!");
				try
				{
					file.writeFile("Player has dropped item at (" + return_value.get(0) + ", " + return_value.get(1) + ")" );
				}
				catch (IOException e) {
			        e.printStackTrace();
				}
				
				String winner = board.checkWinner();
				if(winner == "X")
				{
					label1.setText("You have won!");
					win = true;
				}
				else if(winner == "O")
				{
					label1.setText("The computer has won!");
					win = true;
				}
				
			}
			
			if(win != true)
			{
				int spot = artificial.colSpace();
				ArrayList<Integer> spot_value = board.placeData(spot, "O");
				circles.get(spot_value.get(0)).get(spot_value.get(1)).setFill(Color.YELLOW);
				label1.setText("Item has been dropped!");
				try
				{
					file.writeFile("Computer has dropped item at (" + spot_value.get(0) + ", " + spot_value.get(1) + ")" );
				}
				catch (IOException e) {
			        e.printStackTrace();
				}
				
				
				
				String winner = board.checkWinner();
				if(winner == "X")
				{
					label1.setText("You have won!");
					win = true;
				}
				else if(winner == "O")
				{
					label1.setText("The computer has won!");
					win = true;
				}
				
			}
		}
		board.printBoard();
		System.out.println();
	}
	
	public void button7Press()
	{
		if(win == true)
		{
			label1.setText("This game has already been won. Please reset!");
		}
		else
		{
			ArrayList<Integer> return_value = board.placeData(6, "X");
			if(return_value.get(0) == -1)
			{
				label1.setText("Column is full!");
			}
			else
			{
				circles.get(return_value.get(0)).get(return_value.get(1)).setFill(Color.RED);
				label1.setText("Item has been dropped!");
				try
				{
					file.writeFile("Player has dropped item at (" + return_value.get(0) + ", " + return_value.get(1) + ")" );
				}
				catch (IOException e) {
			        e.printStackTrace();
				}
				
				String winner = board.checkWinner();
				if(winner == "X")
				{
					label1.setText("You have won!");
					win = true;
				}
				else if(winner == "O")
				{
					label1.setText("The computer has won!");
					win = true;
				}
				
			}
			
			if(win != true)
			{
				int spot = artificial.colSpace();
				ArrayList<Integer> spot_value = board.placeData(spot, "O");
				circles.get(spot_value.get(0)).get(spot_value.get(1)).setFill(Color.YELLOW);
				label1.setText("Item has been dropped!");
				try
				{
					file.writeFile("Computer has dropped item at (" + spot_value.get(0) + ", " + spot_value.get(1) + ")" );
				}
				catch (IOException e) {
			        e.printStackTrace();
				}
				
				
				
				String winner = board.checkWinner();
				if(winner == "X")
				{
					label1.setText("You have won!");
					win = true;
				}
				else if(winner == "O")
				{
					label1.setText("The computer has won!");
					win = true;
				}
				
			}
		}
		board.printBoard();
		System.out.println();
		
	}
	
	public void save(ActionEvent event)
	{
		try
		{
			file.saveFile();
		}
		catch (IOException e) {
	        e.printStackTrace();
		}
	}
	
	public void load(ActionEvent event)
	{
		text.setText("Please enter in the location of the load file: ");
	}
	
	public void finsihed(ActionEvent event)
	{
		String value = text.getText();
		value = value.substring(47);
		
		board = new ShadowData(7, 6);
		try
		{
			load_file = new LoadFile(value);
			ArrayList<ArrayList<String>> file_result = load_file.readFile();
			
			for(int i = 0; i < file_result.size(); i++)
			{
				ArrayList<String> line = file_result.get(i);
				
				if(line.get(0).equals("X"))
				{
					int row = Integer.parseInt(line.get(1));
					int col = Integer.parseInt(line.get(2));
					
					board.putData(col, row, "X");
					circles.get(row).get(col).setFill(Color.RED);
				}
				
				else if (line.get(0).equals("O"))
				{
					int row = Integer.parseInt(line.get(1));
					int col = Integer.parseInt(line.get(2));
					
					board.putData(col, row, "O");
					circles.get(row).get(col).setFill(Color.YELLOW);
				}
			}
		}
		catch (IOException e) {
	        e.printStackTrace();
		}
		
		
		
	}
	
	
	public void reset(ActionEvent e)
	{
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				circles.get(i).get(j).setFill(Color.WHITE);
			}
		}
		board.resetGame();
		label1.setText("Game has been reset!");
		win = false;
	}
	
	
	
	
}
