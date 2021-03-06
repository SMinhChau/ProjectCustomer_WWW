package spring.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.demo.entity.Customer;
import spring.demo.service.CustomerServices;

@Controller
public class CustomerController {
	@Autowired
	private CustomerServices service;

	@GetMapping("/")
	public String getList(Model model) {
		List<Customer> customers = service.getCustomers();
		model.addAttribute("customers", customers);
		return "customers-list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		service.deleteCustomer(id);
		return "redirect:/";
	}

	@GetMapping("/showFormAdd")
	public String showFormAdd(Model model) {
		Customer customer= new Customer();
		model.addAttribute("customer",customer);
		return "form-customer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer")Customer customer, Errors error, Model model) {
	Customer cus=customer;
	if(error.hasErrors()) {
		model.addAttribute("customer",cus);
		return "form-customer";
	}
	service.saveCustomer(customer);
	return "redirect:/";
	}
	
	@GetMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, Model model) {
		Customer cus= service.getCustomer(id);
		model.addAttribute("customer",cus);
		return "form-customer";
	}
}
