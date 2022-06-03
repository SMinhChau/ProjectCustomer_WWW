package spring.demo.dao;

import java.util.List;

import spring.demo.entity.Customer;

public interface CustomerDao {
	public List<Customer> getCustomers();
	public Customer getCustomer(int id);
	public void saveCustomer(Customer customer);
	public void deleteCustomer(int id);

}
