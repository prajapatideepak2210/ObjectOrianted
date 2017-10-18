package com.bridgelabz.objectorientedprograms.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.objectorientedprograms.utility.AddressBookFunctions;
import com.bridgelabz.objectorientedprograms.utility.Utility;

public class JsonTrail {
	public static void main(String[] args) {
		Utility utility=new Utility();
		Scanner scan=new Scanner(System.in);
		String filePath="/home/bridgeit/Deepak Programs/ObjectOrientedPrograms/JsonTrail.json";
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePath);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		/*JSONObject jsonObject2=new JSONObject();
		System.out.println("Enter the value : ");
		int value=scan.nextInt();
		jsonObject2.put("Zip", value);
		jsonArray.add(jsonObject2);
		utility.jsonFileWriter(filePath, jsonArray);*/
		
		Integer[] zip=new Integer[jsonArray.size()];
		int index=0;
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject) iterator.next();
			System.out.println(jsonObject.get("Zip"));
			
			String zip1=jsonObject.get("Zip").toString();
			zip[index]=Integer.parseInt(zip1);
			index++;
		}
		Arrays.sort(zip);
		System.out.println("----------------");
		for(int i=0; i<zip.length; i++)
		{
			System.out.print(zip[i]+" ");
		}
	}
}
