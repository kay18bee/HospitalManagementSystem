package com.bl.hms;

import java.util.ArrayList;
import java.util.List;

public class PatientRepo {
	
	private static PatientRepo instance;
	List<Patient> patientList = new ArrayList();
	
	private PatientRepo() {
		
	}
	
	public static PatientRepo getInstance() {
		if(instance == null) {
			instance = new PatientRepo();
		}
		return instance;
	}
	
	void add(Patient patient) {
		patientList.add(patient);
	}
	
	List getPatientList() {
		return patientList;
	}
	
	public boolean isPatientAvailable(String id) {
		for( int i = 0; i < patientList.size(); i++) {
			if(patientList.get(i).patientId.equals(id)) {
				return true;
			}
		}
		return false;	
	}
}	
