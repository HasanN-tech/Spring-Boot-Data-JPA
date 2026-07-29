package com.hasan.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hasan.entity.VehicleInsurance;

@Service
public interface VehicleInsuranceService {
	 public String addPolicy(VehicleInsurance vi);
	 public String  addMultiplePolicies(List<VehicleInsurance> insuranceList);
	 public VehicleInsurance getPolicyById(Long id);
	 public List<VehicleInsurance> getAllPolicies();
	 public String updatePolicy(Long vNum, Double amt);
	 public String deletePolicy(Long id);
	 public String deleteAllPolicies();
	 public long countPolicies();
	 public String PolicyExists(Long id);
}
