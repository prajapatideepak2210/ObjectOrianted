package com.bridgelabz.objectorientedprograms.utility;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AddressBookFunctions {
	Utility utility=new Utility();
	Scanner scanner=new Scanner(System.in);
	
	/**
	 * @param filePath
	 * 
	 * @Description it will write the jsonObject into the file.
	 */
	public void addObject(String filePath)
	{
		
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePath);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		
		//Accepting the values from user.
		System.out.println("\nEnter your first name : ");
		String fname=scanner.nextLine();
		System.out.println("\nEnter your last name : ");
		String lname=scanner.nextLine();
		System.out.println("Enter your address : ");
		String address=scanner.nextLine();
		System.out.println("Enter your city : ");
		String city=scanner.nextLine();
		System.out.println("Enter your state : ");
		String state=scanner.nextLine();
		System.out.println("Enter the zip : ");
		String zip=scanner.nextLine();
		System.out.println("Enter your phone number : ");
		String phoneNumber=scanner.next();
		
		// Puting the value into the object. 
		jsonObject.put("Fname", fname);
		jsonObject.put("Lname", lname);
		jsonObject.put("Address", address);
		jsonObject.put("City", city);
		jsonObject.put("State", state);
		jsonObject.put("Zip", zip);
		jsonObject.put("PhoneNumber", phoneNumber);
		jsonArray.add(jsonObject);
		
		//writing the jsonArray into the file.
		utility.jsonFileWriter(filePath, jsonArray);
		System.out.println("Object is Added");
	}
	
	public void edit(String filePath)
	{
		
		
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePath);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		
		System.out.println("Enter the name of person, whos data you want to update : ");
		String person=scanner.nextLine();
		boolean found=true;
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject) iterator.next();
			
			if(person.equals((String) jsonObject.get("Fname")))
			{
				Set keys=jsonObject.keySet();
				String keyArray[]=(String[])keys.toArray(new String[keys.size()]);
				for(int i=0;i<keyArray.length;i++){
					System.out.println("Enter "+(i+1)+" to "+keyArray[i]);
				}
				System.out.println("Enter what you want to do edit : ");
				int key=scanner.nextInt();
				System.out.println("Enter new value : ");
				scanner.nextLine();
				String value=scanner.nextLine();
				jsonObject.put(keyArray[key-1], value);
				utility.jsonFileWriter(filePath, jsonArray);
				System.out.println("Object is updated.");
				found=false;
			}
		}
		if(found)
		{
			System.out.println("Persons name is not found.");
		}
		
	}
	
	
	public void delete(String filePath)
	{
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePath);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		
		System.out.println("Enter the name of person to delete : ");
		scanner.nextLine();
		String person2=scanner.nextLine();
		boolean found2=true;
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject) iterator.next();
			if(person2.equals((String)jsonObject.get("Fname")))
			{
				jsonArray.remove(jsonObject);
				found2=false;
				System.out.println("Removed");
				break;
			}
		}
		if(found2)
		{
			System.out.println("Person not found.");
		}
		utility.jsonFileWriter(filePath, jsonArray);
	}
	
	public void sortByName(String filePath)
	{
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePath);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		
		String[] name=new String[jsonArray.size()];
		int index=0;
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject) iterator.next();
			name[index]=(String) jsonObject.get("Fname");
			index++;
		}
		Arrays.sort(name);
		
		for(int i=0; i<name.length; i++)
		{
			Iterator<?> iterator2=jsonArray.iterator();
			JSONObject jsobject=new JSONObject();
			while(iterator2.hasNext())
			{
				jsobject=(JSONObject) iterator2.next();
				if(name[i].equals(jsobject.get("Fname")))
				{
					System.out.println(jsobject);
					System.out.println("-------------------------------------------------------------------------------------------------------------------------");
				}
				
			}
		}
	}
	
	/**
	 * @param filePath
	 * 
	 * @Description it will give you sorted list of objects by zip
	 */
	public void sortByZip(String filePath)
	{
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePath);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		
		String[] name=new String[jsonArray.size()];
		int index=0;
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject) iterator.next();
			name[index]=(String) jsonObject.get("Zip");
			index++;
		}
		Arrays.sort(name);
		
		for(int i=0; i<name.length; i++)
		{
			System.out.println(name[i]);
		}
		for(int i=0; i<name.length; i++)
		{
			Iterator<?> iterator2=jsonArray.iterator();
			JSONObject jsobject=new JSONObject();
			while(iterator2.hasNext())
			{
				jsobject=(JSONObject) iterator2.next();
				if(name[i].equals(jsobject.get("Zip")))
				{
					System.out.println(jsobject);
					System.out.println("-------------------------------------------------------------------------------------------------------------------------");
					break;
				}
			}
		}
	}
}
