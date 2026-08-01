package com.hasan.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hasan.entity.Customer;
import com.hasan.entity.PanCard;
import com.hasan.services.PandCardAndCustomerService;

@Component
public class DoctorAndPatientRunner implements CommandLineRunner {

	@Autowired
	private PandCardAndCustomerService pcs;

	@Override
	public void run(String... args) throws Exception {
		boolean flag = true;

		while (flag) {
			int choice = Integer.parseInt(IO.readln("Enter your choice: "));
			switch (choice) {

			case 1 -> {
				PanCard pc1=new PanCard("BHI233N", "12/03/2020");
				PanCard pc2=new PanCard("GDTS98B", "22/07/2015");
				PanCard pc3=new PanCard("QWBS65I", "16/12/2023");
				
				Customer c1=new Customer("Hasan", "hasan@hmail.com", "Ayodhya",pc1);
				Customer c2=new Customer("Alex", "alex@hmail.com", "Hyderabad",pc2);
				Customer c3=new Customer("Smith", "smith@hmail.com", "Dubai",pc3);
				
				pc1.setCustomer(c1);
				pc2.setCustomer(c2);
				pc3.setCustomer(c3);
				
				pcs.addData(c1);
				pcs.addData(c2);
				pcs.addData(c3);
			}

			case 2 -> {
				Customer uni = pcs.getData(2L);
				IO.println("Customer Details::");
				IO.println("Customer id: " + uni.getCustomerId());
				IO.println("Customer Name: " + uni.getCustomerName());
				IO.println("Customer email: " + uni.getEmail());
				IO.println("City: " + uni.getCity());
				IO.println("Pan id: " + uni.getPanCard().getPanId());
				IO.println("Pan Number: " + uni.getPanCard().getPanNumber());
				IO.println("Issue Date: " + uni.getPanCard().getIssueDate());
				
			}
			case 3 -> pcs.viewAll().forEach(uni -> {
				IO.println("Customer Details::");
				IO.println("Customer id: " + uni.getCustomerId());
				IO.println("Customer Name: " + uni.getCustomerName());
				IO.println("Customer email: " + uni.getEmail());
				IO.println("City: " + uni.getCity());
				IO.println("Pan id: " + uni.getPanCard().getPanId());
				IO.println("Pan Number: " + uni.getPanCard().getPanNumber());
				IO.println("Issue Date: " + uni.getPanCard().getIssueDate());

			});

			case 4 -> IO.println(pcs.deleteRecord(3L));

			case 5 -> {
				IO.println("Thank you!");
				flag = false;
			}

			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}

//IO.println(rs.addData(new RecipeBook("Java", "NIT", List.of("SQL", "MYSQl", "Oracle"),
//		List.of("eat", "sleep", "repeat"))));
