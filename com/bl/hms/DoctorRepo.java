package com.bl.hms;

import java.util.ArrayList;
import java.util.List;

public class DoctorRepo {
	
	private static DoctorRepo instance;
	public List<Doctor> doctorList = new ArrayList();
	
	private DoctorRepo(){
	
	}
	
	public static DoctorRepo getInstance() {
		if(instance == null) {
			instance = new DoctorRepo();
		}
		return instance;
	}
	
	void add(Doctor doctor) {
		doctorList.add(doctor);
	}
	
	public void remove(Doctor doctor) {
		doctorList.remove(doctor);
	}
	
	public Doctor getDoctor(String id) {
		for (int i = 0; i < doctorList.size(); i++) {
			if(doctorList.get(i).id.equals(id)){
				return doctorList.get(i);
			}
		}
		return null;
	}
	
	List getDoctorsList() {
		return doctorList;
	}
	
	public boolean isDoctorAvailable(String id) {
		for( int i = 0; i < doctorList.size(); i++) {
			if(doctorList.get(i).id.equals(id)) {
				return true;
			}
		}
		return false;	
	}
}

