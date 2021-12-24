package com.bl.hms;

import java.util.Date;

public class Appointment {
	
	String doctorId;
	String patientId;
	String appointmentDate;
	int roomNumber;
	
	@Override
    public String toString() {
        return "Appointment{" +
                "patientId='" + patientId + '\n' +
                ", doctorId='" + doctorId + '\n' +
                ", roomNumber=" + roomNumber + '\n' +
                ",appointmentDate=" + appointmentDate +
                '}';
	}
}
