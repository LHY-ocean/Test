package service;

import java.util.List;

import model.Customer;

public interface CustomerService {

	public List<Customer> select(String where);
	
	public Customer selectById(int id);
	
	public void delete(int id);
	
	public void insert(Customer c);
	
	public void update(Customer c);

	
}
