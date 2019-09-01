package service;

import model.Customer;
import utils.ReturnInfo;

public interface CustomerService {

	public ReturnInfo select(String where,Integer page, Integer max);
	
	public Customer selectById(int id);
	
	public void delete(int id);
	
	public void insert(Customer c);
	
	public void update(Customer c);

	
}
