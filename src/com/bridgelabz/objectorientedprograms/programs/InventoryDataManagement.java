package com.bridgelabz.objectorientedprograms.programs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.objectorientedprograms.utility.Utility;

public class InventoryDataManagement {
	public static void main(String[] args) {
		Utility utility=new Utility();
		String filePath="/home/bridgeit/Deepak Programs/ObjectOrientedPrograms/InventoryDataManagement.json";
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePath);
		Iterator<?> iterator=jsonArray.iterator();
		double totalAmount=0, amount=1;
		while(iterator.hasNext())
		{
			JSONObject jSonObject=(JSONObject) iterator.next();
			
			amount=Double.parseDouble((String) jSonObject.get("price"))* Double.parseDouble((String) jSonObject.get("weight"));
			totalAmount=totalAmount+amount;
			System.out.println("Name : "+jSonObject.get("name")+"	, Weight : "+jSonObject.get("weight")+"	, Price	: "+jSonObject.get("price"));
			System.out.println("Total Amount of "+jSonObject.get("name")+"	: "+amount);
			System.out.println("===============================================");
		}
		System.out.println("\nCalculated Value is : "+totalAmount);
	}
	
	
}
