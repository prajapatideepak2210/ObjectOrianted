package com.bridgelabz.objectorientedprograms.programs;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.objectorientedprograms.utility.CompanySharesInLinkedListFunctions;

public class CompanySharesInLinkedList {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		boolean check=true;
		String filePath="/home/bridgeit/Deepak Programs/ObjectOrientedPrograms/shares.json";

		do{

			System.out.println("Enter 1 to display all companies shares\n2 to remove shares\n3 "
					+ "to add the shares\n4 to exit.");

			int choise=scanner.nextInt();
			CompanySharesInLinkedListFunctions companySharesInLinkedListFunctions=new CompanySharesInLinkedListFunctions();
			switch (choise) {

			case 1:
				companySharesInLinkedListFunctions.displayShares(filePath);
				break;
			case 2:
				companySharesInLinkedListFunctions.removeShare(filePath);
				break;
			case 3:
				companySharesInLinkedListFunctions.addShares(filePath);
				break;
			case 4:
				check=false;
				break;
			default:
				System.out.println("You have entered wrong choise, please enter correct choise.");
				break;
			}
		}while(check);

	}
}
