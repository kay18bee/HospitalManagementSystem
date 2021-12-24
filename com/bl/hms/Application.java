package com.bl.hms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Application {

	public static void main(String[] args) {
	
		int exit = 13;
		int answer;
        UserInterface userInterface = UserInterface.getInstance();
		Application application = new Application();
		do {
			answer = userInterface.ShowMainMenu();
			application.handleUserSelection(answer);
		}while(answer != exit);
	}
	
	void handleUserSelection(int option) {
		
        UserInterface userInterface = UserInterface.getInstance();
 		DoctorRepo doctorRepo = DoctorRepo.getInstance();

		 switch (option) {
			 	case 1: 
			 		addDoctor();
			 		break;
			 	case 2:
			 		System.out.println("Enter ID of the doctor you want to remove.");
			 		Scanner scanner = new Scanner(System.in);
			 		String value = scanner.nextLine();
			 		Doctor doctor = doctorRepo.getDoctor(value);
			 		doctorRepo.remove(doctor);
			 		break;
			 	case 3: 
			 		break;
			 	case 4: 
			 		List firstDoctor = doctorRepo.getDoctorsList();
			 		userInterface.printAllDoctors(firstDoctor);
			 		break;
			 	case 5: 
			 		addPatient();
			 		break;
			 	case 6: 
			 		break;
			 	case 7: 
			 		break;
			 	case 8: 
			 		PatientRepo patientRepo = PatientRepo.getInstance();
			 		List firstPatient = patientRepo.getPatientList();
			 		userInterface.printAllPatients(firstPatient);
			 		break;
			 	case 9: 
			 		addAppointment();
			 		break;
			 	case 10: 
			 		break;
			 	case 11: 
			 		break;
			 	case 12: 
			 		AppointmentRepo appointmentRepo = AppointmentRepo.getInstance();
			 		List firstAppointment = appointmentRepo.getAppointmentList();
			 		userInterface.printAllAppointment(firstAppointment);
			 		break;
			 	case 13: 
			 		break;
			 	default:
			 		System.out.println("Invalid input.");
			 		break;
		 }
		
	}

	private void addDoctor() {
	
		Scanner scanner = new Scanner(System.in);
		Doctor doctor = new Doctor();
		System.out.println("Enter Doctor ID: ");
		doctor.id = scanner.next();
		System.out.println("Enter doctor name: ");
		doctor.name = scanner.next();
		System.out.println("Enter doctor's phone number");
		doctor.mobileNumber = scanner.nextInt();
		System.out.println("Enter specialization");
		doctor.specialisation = scanner.next();
	
		doctor.availability = new HashMap<>();
		doctor.availability.put(Doctor.Weekdays.SUN,"10 AM to 12 PM");
		doctor.availability.put(Doctor.Weekdays.MON,"10 AM to 3 PM");
		doctor.availability.put(Doctor.Weekdays.TUE,"10 AM to 3 PM");
		doctor.availability.put(Doctor.Weekdays.WED,"10 AM to 1 PM");
		doctor.availability.put(Doctor.Weekdays.THU,"10 AM to 1 PM");
		doctor.availability.put(Doctor.Weekdays.FRI,"10 AM to 5 PM");
		doctor.availability.put(Doctor.Weekdays.SAT,"10 AM to 12 PM");

		DoctorRepo doctorRepo = DoctorRepo.getInstance();
		doctorRepo.add(doctor);
	}

	private void addPatient() {
		
		Patient patient = new Patient();
		System.out.println("Enter the patient details.");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter patient's Id");
		patient.patientId = scanner.next();
		System.out.println("Enter patient's disease");
		patient.disease = scanner.next();
		System.out.println("Enter patient's e-mail Id");
		patient.emailId = scanner.next();
		System.out.println("Enter patient's age");
		patient.age = scanner.nextInt();
		System.out.println("Enter patient's address");
		patient.address = scanner.next();
		System.out.println("Enter patient's mobile number");
		patient.mobileNumber = scanner.nextLong();
		System.out.println("Enter patient's name");
		patient.name = scanner.next();
		
		System.out.println("Enter patient's city");
		patient.city = scanner.nextLine();
		
		System.out.println("Enter 1. For female\n 2.For male\n 3. For others\n");
		int option = scanner.nextInt();
		switch(option) {
		case 1: 
			System.out.println("Female");
			break;
		case 2:
			System.out.println("Male");
			break;
		case 3: 
			System.out.println("Other");
			break;
		default:
			System.out.println("Enter correct option.");
			break;
		}
		
		PatientRepo patientRepo = PatientRepo.getInstance();
		patientRepo.add(patient);
	}
	
	private void addAppointment() {
		
		Appointment appointment = new Appointment();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter doctor ID ");
		appointment.doctorId = scanner.next();
		DoctorRepo doctorRepo = DoctorRepo.getInstance();
		if(doctorRepo.isDoctorAvailable(appointment.doctorId) != true) {
			System.out.println("Doctor is not available.");
			return;
		}
		
		System.out.println("Enter patient ID ");
		appointment.patientId = scanner.next();
		PatientRepo patientRepo = PatientRepo.getInstance();
		if(!patientRepo.isPatientAvailable(appointment.patientId) == true) {
			System.out.println("Patient ID does not match.");
			return;
		}
		
		System.out.println("Enter room number ");
		appointment.roomNumber = scanner.nextInt();
		System.out.println("Enter the appointment date in dd-MMM-yyyy format ");
		Scanner snew = new Scanner(System.in);
		appointment.appointmentDate = snew.nextLine();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		try {
			Date date = formatter.parse(appointment.appointmentDate);
		} catch(Exception e) {
			e.printStackTrace(); //print exception in details
		}
		
		AppointmentRepo appointmentRepo = AppointmentRepo.getInstance();
		appointmentRepo.add(appointment);
	}
}
