package com.bridgelabz.objectorientedprograms.programs;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.objectorientedprograms.utility.Utility;

public class StockReport {
	public static void main(String[] args) {
		StockReport stockReport=new StockReport();
		Utility utility=new Utility();
		String filePath="/home/bridgeit/Deepak Programs/ObjectOrientedPrograms/StockReport.json";
		JSONArray jSonArray=new JSONArray();
		
		jSonArray=utility.jsonFileReader(filePath);
		
		int value=stockReport.test(jSonArray);
		
		
		
	}
	
	public int test(JSONArray jsonArray)
	{
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		JSONObject jsonObject2=new JSONObject();
		double  amount1=1, amount2=0;
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject) iterator.next();
			Iterator<?> iterator2=jsonObject.keySet().iterator();
			while(iterator2.hasNext())
			{
				String key=(String) iterator2.next();
				jsonObject2=(JSONObject) jsonObject.get(key);
				System.out.println("company_name : "+jsonObject2.get("company_name")+",	Share : "+jsonObject2.get("Share")+", Price	: "+jsonObject2.get("Price"));
				amount1=Double.parseDouble((String)jsonObject2.get("Share"))*Double.parseDouble((String)jsonObject2.get("Price"));
				amount2=amount2+amount1;
				System.out.println(amount1);
				System.out.println("-------------------------------------------------");
			}
			
			System.out.println("Total amount of all companies shares : "+amount2);
		}
		return 1;
	}
}
