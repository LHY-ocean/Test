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
	
	@Select("select count(1) from customer inner join product on customer.pro_id = product.id ${txt}")
	public int search(@Param(value = "txt") String where);
	
	@Select("select customer.*,product.pro_no pro_no from customer inner join product on customer.pro_id = product.id ${txt} order by id ${limit}")
	public List<Customer> select(@Param(value = "txt") String where, @Param(value = "limit") String limit);
	
	@Delete("delete from customer where id=#{id}")
	public void delete(int id);
	
	@Insert("insert into customer(cus_no,cus_name,cus_sex,pro_id) values(#{cus_no},#{cus_name},#{cus_sex},#{pro_id})")
	public void insert(Customer c);
	
	@Update("update customer set cus_no=#{cus_no}, cus_name=#{cus_name},cus_sex=#{cus_sex},pro_id=#{pro_id} where id=#{id}")
	public void update(Customer c);
}
