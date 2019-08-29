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
	
	@Select("select * from customer ${txt}")
	public List<Customer> select(@Param(value = "txt") String where);
	
	@Delete("delete from customer where id=#{id}")
	public void delete(int id);
	
	@Insert("insert into customer(cus_no,cus_name) values(#{cus_no},#{cus_name})")
	public void insert(Customer c);
	
	@Update("update customer set cus_no=#{cus_no} cus_name=#{cus_name} where id=#{id}")
	public void update(Customer c);
}
