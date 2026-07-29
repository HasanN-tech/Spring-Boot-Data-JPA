package com.hasan.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.VehicleInsurance;
import com.hasan.repository.VehicleInsuranceRepository;

@Service
public class VehicleInsuranceServiceImpl implements VehicleInsuranceService {
	@Autowired
	private VehicleInsuranceRepository repo;

	@Override
	public String addPolicy(VehicleInsurance vi) {
		if (vi != null) {
			repo.save(vi);
			return "Policy added successfully";
		}
		return "Please check the given data.";
	}

	@Override
	public String addMultiplePolicies(List<VehicleInsurance> insuranceList) {
		if (insuranceList != null) {
			repo.saveAll(insuranceList);
			return "Policies added successfully";
		}
		return "Please check the given data.";
	}

	@Override
	public VehicleInsurance getPolicyById(Long id) {
		return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id"));
	}

	@Override
	public List<VehicleInsurance> getAllPolicies() {
		if(repo.count()>0)
			return repo.findAll();
		else return Collections.emptyList();
	}

	@Override
	public String updatePolicy(Long vNum, Double amt) {
		VehicleInsurance vi=repo.findById(vNum).orElseThrow(()->new IllegalArgumentException("vehicle number is Invalid"));
		vi.setAmount(amt);
		repo.save(vi);
		return "Policy Updated successfully";
	}

	@Override
	public String deletePolicy(Long id) {
		VehicleInsurance vi=repo.findById(id).orElseThrow(()->new IllegalArgumentException("Id does not exist."));
		repo.delete(vi);
		return "Policy deleted.";
	}

	@Override
	public String deleteAllPolicies() {
		if(repo.count()>0) {
			repo.deleteAll();
			return "All record deleted.";
		}
		else return "Record not exist table is empty";
	}

	@Override
	public long countPolicies() {
		return repo.count();
	}

	@Override
	public String PolicyExists(Long id) {
		if(repo.existsById(id))
			return "Policy exist with id: "+id;
		else return "Policy does not exist with id: "+id;
	}

}
