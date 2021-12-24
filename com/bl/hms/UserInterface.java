package com.bl.hms;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
	
	private static UserInterface instance;
	
	private UserInterface() {
		
	}
	
	public int ShowMainMenu() {
		
		System.out.println("Main Menu:\n1. Add Doctor \n2. Delete Doctor \n3. Edit Doctor \n" +
                "4. Print all Doctors\n 5. Add Patient \n 6. Delete Patient \n 7. Edit Patient \n" +
                "8. Print all Patient \n 9. Add Appointment \n 10. Delete Appointment \n 11. Edit Appointment " +
                "\n 12. List all Appointment\n 13. Exit");

		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		return option;
	}
	
	public static UserInterface getInstance() {
		if(instance == null) {
			instance = new UserInterface();
		}
		return instance;
	}
	
	public void printAllDoctors(List doctorList) {
		for(int i = 0; i < doctorList.size() ; i++) {
			System.out.println(doctorList.get(i));
		}
	}
	
	public void printAllPatients(List patientList) {
		for(int i = 0; i < patientList.size(); i++) {
			System.out.println(patientList.get(i));
		}
	}
	
	public void printAllAppointment(List appointmentList) {
		for( int i = 0; i<appointmentList.size(); i++) {
			System.out.println(appointmentList.get(i));
		}
	}
	
}
