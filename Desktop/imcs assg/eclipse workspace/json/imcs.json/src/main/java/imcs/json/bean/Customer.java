package imcs.json.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	private int customerId;
	private String customerName;
	private Date dateOfBirth;
	private double annualSalary;
	private Address address;
	private Payment payment;
}
