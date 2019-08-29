package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Type;
import dao.TypeDao2;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JunitTest {
	
	@Autowired
	TypeDao2 dao;
	
	@Test
	public void test() {
		
		
		Type t = new Type(8,"aa");
//		dao.insert(t);
		dao.delete(6);
		t.setName("bb");
		dao.update(t);
		
		List<model.Type> list = dao.select();
		System.out.println("id  name");
		for(Type p:list) {
			System.out.print(p.getId()+"  ");
			System.out.println(p.getName());
		}
	}
	
}
