package com.bridgelabz.objectorientedprograms.programs;

import java.util.Scanner;

import com.bridgelabz.objectorientedprograms.utility.StockAccountFunctions;

public class StockAccount {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		String filePath="/home/bridgeit/Deepak Programs/ObjectOrientedPrograms/StockAccount.json";
		boolean check=true;
		do{
			StockAccountFunctions stockAccountFunction=new StockAccountFunctions();
			System.out.println("Enter 1 to check number of accounts , 2 to create account, 3 to sell the shares , 4 to buy the shares , 5 tp exit.");
			int option=scanner.nextInt();
			
			switch (option) {
			case 1:
				int totalAccounts=stockAccountFunction.valueOf(filePath);
				System.out.println("Total Number of Accounts : "+totalAccounts);
				break;
			case 2:
				stockAccountFunction.createAccount(filePath);
				break;
			case 3:
				System.out.println("AIRTEL : @ \nVODAPHONE : # \nSONY : & \nSAMSUNG : $");
				System.out.println("Enter the Symbol of company : ");
				scanner.nextLine();
				String symbol=scanner.nextLine();
				System.out.println("Enter how much share you want to sell : ");
				long share=scanner.nextLong();
				stockAccountFunction.sell(share, symbol);
				break;
			case 4:
				System.out.println("AIRTEL : @ \nVODAPHONE : # \nSONY : & \nSAMSUNG : $");
				System.out.println("Enter the Symbol of company : ");
				scanner.nextLine();
				String symbol2=scanner.nextLine();
				System.out.println("Enter how much share you want to buy : ");
				long shareToBuy=scanner.nextLong();
				stockAccountFunction.buy(shareToBuy, symbol2);
				break;
			case 5:
				check=false;
				break;
			default:
				System.out.println("You have entered wrong ption, please enter correct option.");
				break;
			}
			
		}while(check);
	}
}
