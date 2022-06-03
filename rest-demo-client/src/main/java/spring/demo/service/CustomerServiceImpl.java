package spring.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import spring.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerServices {

	@Autowired
	private RestTemplate restTemplate;
	private String url = "http://localhost:8080/rest-demo/api/customers";

//	@Autowired
//	public CustomerServiceImpl(RestTemplate  therestTemplate) {
//		restTemplate= therestTemplate;
//		url="http://localhost:8080/rest-demo/api/customers";
//	}

	@Override
	public List<Customer> getCustomers() {
		ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Customer>>() {
				});
		return responseEntity.getBody();
	}

	@Override
	public Customer getCustomer(int id) {
		Customer customer= restTemplate.getForObject(url + "/" +id, Customer.class);
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		int id= customer.getId();
		if(id == 0) {
			restTemplate.postForEntity(url, customer, Customer.class);
		}else
			restTemplate.put(url, customer);
	}

	@Override
	public void deleteCustomer(int id) {
		restTemplate.delete(url + "/"+ id);
	}

}
