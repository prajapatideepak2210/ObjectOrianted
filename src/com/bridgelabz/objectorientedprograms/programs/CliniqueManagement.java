package com.bridgelabz.objectorientedprograms.programs;

import java.util.Scanner;

import com.bridgelabz.objectorientedprograms.utility.CliniqueManagementFunctions;

public class CliniqueManagement {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String fileForDoctores="/home/bridgeit/Deepak Programs/ObjectOrientedPrograms/Doctor.json";
		String fileForPatients="/home/bridgeit/Deepak Programs/ObjectOrientedPrograms/Patients.json";
		boolean check=true;
		do {
			CliniqueManagementFunctions cliniqueManagementFunctions=new CliniqueManagementFunctions();
			System.out.println("Enter 1 to Search the Doctor by name.\n2 to search patient by name.\n3 to "
					+ "take appointment.\n4 to check doctor availability.\n5 to print appointment report \n6 to exit the pogram.");
			int option=scanner.nextInt();
			switch (option) {
			case 1:
				cliniqueManagementFunctions.searchDoctor(fileForDoctores);
				break;
			case 2:
				cliniqueManagementFunctions.searchPatient(fileForPatients);
				break;
			case 3:
				cliniqueManagementFunctions.takeAppointment(fileForPatients, fileForDoctores);
				break;
			case 4:
				cliniqueManagementFunctions.doctorAvailability(fileForDoctores);
				break;
			case 5:
				cliniqueManagementFunctions.printAppointmentReport(fileForDoctores);
				break;
			case 6:
				check=false;
				break;
			default:
				System.out.println("You have entered wrong choise, please enter write choise.");
				break;
			}
		} while (check);
	}
}
