package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CustomerDao;
import model.Customer;
import service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao dao;
	
	public List<Customer> select(String where) {
		return dao.select(where);
	}
	
	public void delete(int id) {
		dao.delete(id);
	}

	public void insert(Customer c) {
		dao.insert(c);
	}

	public void update(Customer c) {
		dao.update(c);
	}

	

}
