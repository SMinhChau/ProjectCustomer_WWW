package spring.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.demo.entity.Customer;


@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		Session session= sessionFactory.getCurrentSession();
		Query<Customer> query= session.createQuery("from Customer",Customer.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		Session session= sessionFactory.getCurrentSession();
		Customer customer= session.get(Customer.class, id);
		return customer;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		Session session= sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		Session session= sessionFactory.getCurrentSession();
		Customer customer= getCustomer(id);
		session.delete(customer);
	}

}
