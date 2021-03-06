package spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.demo.dao.CustomerDao;
import spring.demo.entity.Customer;
import spring.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerControllerRest {
	
	@Autowired
	private CustomerService dao;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return dao.getCustomers();
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {
		Customer customer= dao.getCustomer(id);
		return customer;
	}
	
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id) {
		Customer customer= dao.getCustomer(id);
		dao.deleteCustomer(id);
		return "Delete id: " +id;
	}

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		dao.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		dao.saveCustomer(customer);
		return customer;
	}
}
