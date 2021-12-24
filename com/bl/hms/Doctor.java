package com.bl.hms;

import java.util.Map;
import java.util.HashMap;


public class Doctor {
	
    enum Weekdays
    {
    	SUN, MON, TUE, WED, THU, FRI, SAT;
	}
    
    String id;
	String name;
	String specialisation;
	String emailId;
	long mobileNumber;
	Map<Weekdays, String> availability;
	
	@Override
    public String toString() {
        return "Doctor{" +
                "id = " + id + '\n' +
                ", name = " + name + '\n' +
                ", specialisation = " + specialisation + '\n' +
                ", emailId = " + emailId + '\n' +
                ", mobileNumber = " + mobileNumber + '\n' +
                ", availability = " + availability + '\n' +
                '}';
	}
}
