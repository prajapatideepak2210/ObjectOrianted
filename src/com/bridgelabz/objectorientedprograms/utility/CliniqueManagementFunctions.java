package com.bridgelabz.objectorientedprograms.utility;

import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Deepak Prajapati
 * 
 * @Description this class will provide you some functions to manage the clinique functionality, 
 * like schedule the appointments and checking availability of doctors.
 *
 */
public class CliniqueManagementFunctions {
	Scanner scanner=new Scanner(System.in);
	Utility utility=new Utility();
	
	/**
	 * @param filePath
	 * 
	 * @Description it will print the doctor name with detail if doctor found.
	 */
	public void searchDoctor(String filePath)
	{
		System.out.println("Enter the name of Doctor to search : ");
		String doctorName=scanner.nextLine();
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePath);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		boolean check=true;
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject)iterator.next();
			if(doctorName.equals(jsonObject.get("name")))
			{
				System.out.println("Doctor Name : "+jsonObject.get("name")+", ID : "+jsonObject.get("id")
				+", Specialization : "+jsonObject.get("specialization"));
				check=false;
				break;
			}
		}
		if(check)
		{
			System.out.println("Doctor not found.");
		}
		System.out.println("-----------------------------------------------------------------------------------");
	}
	
	/**
	 * @param filePath
	 * 
	 * @Description it will print the patient name with detail.
	 */
	public void searchPatient(String filePath)
	{
		System.out.println("Enter the name of Patient to search : ");
		String doctorName=scanner.nextLine();
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePath);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		boolean check=true;
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject)iterator.next();
			if(doctorName.equals(jsonObject.get("name")))
			{
				System.out.println("Patient Name : "+jsonObject.get("name")+", ID : "+jsonObject.get("id")
				+", Mobile Number : "+jsonObject.get("mobile")+", Age : "+jsonObject.get("age"));
				check=false;
				break;
			}
		}
		if(check)
		{
			System.out.println("Patient not found.");
		}
		System.out.println("-----------------------------------------------------------------------------------");
	}
	
	/**
	 * @param fileForPatient
	 * @param fileForDoctor
	 * 
	 * @Dscription it is used to take the appointment.
	 */
	public void takeAppointment(String fileForPatient, String fileForDoctor)
	{
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(fileForPatient);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		System.out.println("Enter the patient name : ");
		String patientName=scanner.nextLine();
		boolean check=false;
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject)iterator.next();
			if(patientName.equals(jsonObject.get("name")))
			{
				JSONArray jsonArray2=new JSONArray();
				jsonArray2=utility.jsonFileReader(fileForDoctor);
				Iterator<?> iterator2=jsonArray2.iterator();
				JSONObject jsonObject2=new JSONObject();
				System.out.println("Enter the Doctor name : ");
				String doctorName=scanner.nextLine();
				while(iterator2.hasNext())
				{
					jsonObject2=(JSONObject) iterator2.next();
					if(doctorName.equals(jsonObject2.get("name")))
					{
						JSONArray jsonArrayForsize= (JSONArray) jsonObject2.get("patient");
						System.out.println("Array size"+jsonArrayForsize.size());
						if(jsonArrayForsize.size()<5)
						{
							jsonArrayForsize.add(jsonObject);
							System.out.println("Appointment done.");
							check=true;
							break;
						}
						else
						{
							System.out.println("Appointment full.");
							break;
						}
					}
				}
				if(check)
				{
					utility.jsonFileWriter(fileForDoctor, jsonArray2);
					break;
				}
				else if(!check)
				{
					System.out.println("Invailid doctor name.");
				}
				System.out.println("-----------------------------------------------------------------------------------");
			}
		}
	}
	
	/**
	 * @param fileForDoctor
	 * 
	 * @Description This function will give you detail of remaining appointments.
	 */
	public void doctorAvailability(String fileForDoctor)
	{
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(fileForDoctor);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		System.out.println("Available appointments : ");
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject) iterator.next();
			JSONArray jsonArrayForsize= (JSONArray) jsonObject.get("patient");
			if(jsonArrayForsize.size()<3)
			{
				System.out.println("Doctor Name : "+jsonObject.get("name")+", Remaining Appointment : "+(3-jsonArrayForsize.size()));
			}
			else
			{
				System.out.println("Doctor Name : "+jsonObject.get("name")+", No Remaining Appointments");
			}
		}
		System.out.println("-----------------------------------------------------------------------------------");
	}
	
	/**
	 * @param fileForDoctor
	 * 
	 * @Description it will print full appointment report.
	 */
	public void printAppointmentReport(String fileForDoctor)
	{
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(fileForDoctor);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject)iterator.next();
			System.out.print("Doctor "+jsonObject.get("name")+" have Patients : ");
			JSONArray jsonArray2=new JSONArray();
			jsonArray2=(JSONArray) jsonObject.get("patient");
			Iterator<?> iterator2=jsonArray2.iterator();
			JSONObject jsonObject2=new JSONObject();
			
			while(iterator2.hasNext())
			{
				jsonObject2=(JSONObject) iterator2.next();
				System.out.print(jsonObject2.get("name")+"  ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------------------------------------------");
	}
}
