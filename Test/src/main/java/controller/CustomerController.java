package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Customer;
import service.CustomerService;
import service.ProductService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService cusService;
	
	@Autowired
	ProductService proServiec;
	
	//首页查询显示
	@RequestMapping("index")
	public String index(String txt,ModelMap m) {
		String where="";
		if(txt!=null&&txt!="")
			where=" where cus_name like '%"+txt+"%'";
		m.put("cusList", cusService.select(where));
		m.put("txt", txt);
		return "cindex";
	}
	
	//删除
	@RequestMapping("delete")
	public String delete(int id,ModelMap m) {
		cusService.delete(id);
		return index(null, m);
	}
	
	@RequestMapping("add")
	public String add(ModelMap m) {
		m.put("cus_sexList",Customer.cus_sexname);
		m.put("proList", proServiec.select());
		return "cedit";
	}
	@RequestMapping("upd")
	public String upd(int id,ModelMap m) {
		m.put("cus", cusService.selectById(id));
		return add(m);
	}
	
	//新增
	@RequestMapping("insert")
	public String insert(Customer c,ModelMap m) {
		cusService.insert(c);
		return index(null, m);
	}
	
	//修改
	@RequestMapping("update")
	public String update(Customer c,ModelMap m) {
		cusService.update(c);
		return index(null, m);
	}
	
}
