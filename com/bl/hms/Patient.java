package com.bl.hms;

public class Patient {
	
	enum Gender
	{
		MALE, FEMALE, OTHERS
	}
	
	String patientId;
	String name;
    int age;
	long mobileNumber;
    String emailId;
    Gender gender;
    String address;
    String city;
    String disease;
    
    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\n' +
                ", address='" + address + '\n' +
                ", emailID='" + emailId + '\n' +
                ", disease='" + disease + '\n' +
                ", patientId='" + patientId + '\n' +
                ", mobNo=" + mobileNumber + '\n' +
                ", age=" + age + '\n' +
                '}';
    }
}
