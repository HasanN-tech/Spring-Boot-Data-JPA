package com.hasan.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Doctor;
import com.hasan.entity.Patient;
import com.hasan.service.DoctorAndPatientService;

@Component
public class ProjectRunner implements CommandLineRunner {

	@Autowired
	private DoctorAndPatientService service;
	
	@Override
	public void run(String... args) throws Exception {
		Patient p1=new Patient("Aman","Fever",22);
		Patient p2=new Patient("Rahul","Cold",24);
		Patient p3=new Patient("Pawan","Headache",25);
		
		Doctor d1=new Doctor("Hasan", "All rounder");
		Doctor d2=new Doctor("Nawab", "Dermatologist");
		
		p1.setDoctor(d1);
		p2.setDoctor(d1);
		p3.setDoctor(d2);
		
		d1.setPatients(List.of(p1,p2));
		d2.setPatients(List.of(p3));
		
//		IO.println(service.saveDoctor(d1));
//		IO.println(service.saveDoctor(d2));
		
		service.getAllDoctor().forEach(d->IO.println(d+" "+d.getPatients()));
		service.getAllPatient().forEach(p->IO.println(p+" "+p.getDoctor()));
	}

}
