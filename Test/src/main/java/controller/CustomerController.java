package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Customer;
import model.Product;
import service.CustomerService;
import service.ProductService;
import utils.ReturnInfo;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService cusService;
	
	@Autowired
	ProductService proServiec;
	
	//首页查询显示
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt, Integer page, Integer limit) {
		String where="";
		if(txt!=null&&txt!="")
			where=" where cus_name like '%"+txt+"%'";
		return cusService.select(where,page,limit);
	}
	
	//删除
	@RequestMapping("delete")
	public @ResponseBody String delete(int id) {
		cusService.delete(id);
		return "{\"status\":1}";
	}
	
	@RequestMapping("select")
	public @ResponseBody Customer select(int id) {
		return cusService.selectById(id);
	}
	
	@RequestMapping("getCus_sex")
	public @ResponseBody String[] getCus_sex() {
		return Customer.cus_sexname;
	}
	
	@RequestMapping("getProduct")
	public @ResponseBody List<Product> getProduct() {
		return proServiec.select();
	}
	
	
	//新增
	@RequestMapping("insert")
	public @ResponseBody String insert(Customer c) {
		cusService.insert(c);
		return "{\"status\":1}";
	}
	
	//修改
	@RequestMapping("update")
	public @ResponseBody String update(Customer c) {
		cusService.update(c);
		return "{\"status\":1}";
	}
	
}
