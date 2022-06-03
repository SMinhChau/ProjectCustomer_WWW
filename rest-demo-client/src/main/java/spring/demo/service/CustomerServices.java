package spring.demo.service;

import java.util.List;

import spring.demo.entity.Customer;

public interface CustomerServices {
	public List<Customer> getCustomers();
	public Customer getCustomer(int id);
	public void saveCustomer(Customer customer);
	public void deleteCustomer(int id);
}
