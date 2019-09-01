package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CustomerDao;
import model.Customer;
import service.CustomerService;
import utils.ReturnInfo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao dao;
	
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage = page != null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where, ReturnInfo.getLimit(page, max)));
		if (canpage)
			info.setCount(dao.search(where));
		return info;
	}
	
	
	public Customer selectById(int id) {
		return dao.select(" where customer.id="+id, "limit 1").get(0);
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
