package imcs.jpa.dao;

import java.util.List;

import imcs.jpa.bean.Customer;


public interface CustomerDao {
	Customer loadStudent(int id);

	Customer saveCustomer(Customer customer);

	void saveCustomers(List<Customer> customer);

	Customer updateCustomer(Customer customer);

	boolean deleteCustomer(int id);
		
	List<Customer> getCustomer();

}
