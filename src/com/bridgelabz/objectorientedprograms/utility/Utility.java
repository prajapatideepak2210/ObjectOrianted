package com.bridgelabz.objectorientedprograms.utility;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Utility {
	/**
	 * @param filePath
	 * @return it will return the JSONArray in which have all the content of a file.
	 */
	public JSONArray jsonFileReader(String filePath)
	{
		File file=new File(filePath);
		JSONArray jSonArray=null;
		try {
			FileReader fileReader=new FileReader(file);
			JSONParser jSonParser=new JSONParser();
			jSonArray=new JSONArray();
			jSonArray=(JSONArray) jSonParser.parse(fileReader);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return jSonArray;
	}
	
	public void jsonFileWriter(String filePath, JSONArray jsonArray)
	{
		FileWriter fileWriter=null;
		try {
			fileWriter=new FileWriter(filePath);
			fileWriter.write(JSONValue.toJSONString(jsonArray));
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * @param full_name
	 * @param mobile_number
	 * @return it will return a message after the replacing your name, full name, contact number and date.
	 */
	public String regularExpression(String full_name, String mobile_number)
	{
		String message="Hello <<name>>, We have your full name as "
				+ "<<full name>> in our system. your contact number "
				+ "is 91-xxxxxxxxxx. Please,let us know in case of any "
				+ "clarification Thank you BridgeLabz 01/01/2016.";
		
		String[] stringArray=full_name.split(" ");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date=new Date();
		String date2=dateFormat.format(date);
		
		Pattern pattern=Pattern.compile("<<name>>");
		Matcher matcher = pattern.matcher(message);
		message=matcher.replaceAll(stringArray[0]);
		
		pattern=Pattern.compile("<<full name>>");
		matcher=pattern.matcher(message);
		message=matcher.replaceAll(full_name);
		
		pattern=Pattern.compile("xxxxxxxxxx");
		matcher=pattern.matcher(message);
		message=matcher.replaceAll(mobile_number);
		
		pattern=Pattern.compile("01/01/2016");
		matcher=pattern.matcher(message);
		message=matcher.replaceAll(date2);
		
		return message;
	}
	
	/**
	 * @param suits
	 * @param cards
	 * @return this method will return the Deck Of Cards as a String array.
	 */
	public String[] Deck(String[] suits, String[] cards)
	{
		String[] deck = new String[suits.length * cards.length];
		
		for (int i = 0; i < cards.length; i++) 
		{
			for (int j = 0; j < suits.length; j++) 
			{
				deck[suits.length*i + j] = cards[i] + "=>" + suits[j];
			}
		}

		// shuffle
		for (int i = 0; i < deck.length; i++) 
		{
			int r = i + (int) (Math.random() * (deck.length-i));
			String temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}
		return deck;
	}
	
	/**
	 * @param deck
	 * 
	 * @description This method will distribute the deck of cards into four player.
	 */
	public void distribute(String[] deck)
	{
		int indexOfDeck=0;
		String [][] deckOfcard=new String[4][9];
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<9; j++)
			{
				deckOfcard[i][j]=deck[indexOfDeck];
				indexOfDeck++;
			}
		}
		for(int i=0; i<4; i++)
		{
			System.out.print("\nPlayer "+(i+1)+" : ");
			for(int j=0; j<9; j++)
			{
				System.out.print(deckOfcard[i][j]+", ");
			}
			System.out.print("\n----------------------------------------------------------------------------------------------------------------------");
		}
	}
}
