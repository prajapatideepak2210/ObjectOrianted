package com.bridgelabz.objectorientedprograms.programs;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgelabz.objectorientedprograms.utility.Utility;

/**
 * @author Deepak Prajapati
 */
public class RegularExpression {
	public static void main(String[] args) {
		Utility utility=new Utility();
		boolean check=true;
		do{
			RegularExpression re=new RegularExpression();
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter Your Full name : ");
			String fullName=scanner.nextLine();

			System.out.println("Enter your contact number Which should be 10 digit : ");
			long contactNumber=scanner.nextLong();
			int contactNumber2=(int) (Math.log10(contactNumber)+1);
			String message="";

			if(contactNumber2==10)
			{
				String stringContactNumber=Long.toString(contactNumber);
				message=utility.regularExpression(fullName, stringContactNumber);
				System.out.println("Message : \n\n"+message);
				check=false;
			}
			else{
				System.out.println("You have entered wrong Contact number.");
			}
		}while(check);
	}
}
