package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import model.Type;

@Repository
public interface TypeDao {
	
	@Select("select * from type")
	public List select();
}
