package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import model.Type;

@Repository
public interface TypeDao2 {
	
	public List<Type> select();
	public void insert(Type t);
	public void update(Type t);
	public void delete(int id);
	
}
