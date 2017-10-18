package com.bridgelabz.objectorientedprograms.programs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DemoOfJSon {
	public static void main(String[] args) {
		File file=new File("/home/bridgeit/Deepak Programs/ObjectOrientedPrograms/Demo.json");
		try {
			FileReader fileReader=new FileReader(file);
			JSONParser parser=new JSONParser();
			JSONArray jSonArray=new JSONArray();
			jSonArray=(JSONArray) parser.parse(fileReader);
			
			System.out.println(jSonArray);
			System.out.println();
			Iterator<?> iterator=jSonArray.iterator();
			while(iterator.hasNext())
			{
				JSONObject object=(JSONObject) iterator.next();
				//System.out.println(object);
				System.out.println("-------------");
				//System.out.println("Name : "+object.get("name")+" "+"Age : "+object.get("age")+"Id : "+object.get("id"));
				String key=(String) object.get("id");
				System.out.println(key);
				if(key.equals("120"))
				{
					//System.out.println(object);
					System.out.println("Name : "+object.get("name"));
					jSonArray.remove(object);
				}
				
			}
			FileWriter fw = new FileWriter(file);
			fw.write(JSONValue.toJSONString(jSonArray));
			fw.flush();
			fw.close();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
	}
}
