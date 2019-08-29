package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Customer;

@Repository
public interface CustomerDao {
	
	public List<Customer> select(String where);
	
	public void delete(int id);
	
	public void insert(Customer c);
	
	public void update(Customer c);
}
