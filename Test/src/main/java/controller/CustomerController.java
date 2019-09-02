package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@GetMapping("Customer")
	public @ResponseBody ReturnInfo index(String txt, Integer page, Integer limit) {
		String where="";
		if(txt!=null&&txt!="")
			where=" where cus_name like '%"+txt+"%'";
		return cusService.select(where,page,limit);
	}
	//查询单行
	@GetMapping("Customer/{id}")
	public @ResponseBody Customer select(@PathVariable("id")int id) {
		return cusService.selectById(id);
	}
	//查询状态列
	@GetMapping("Customer/getCus_sex")
	public @ResponseBody String[] getCus_sex() {
		return Customer.cus_sexname;
	}
	//查询外键列
	@GetMapping("Customer/getProduct")
	public @ResponseBody List<Product> getProduct() {
		return proServiec.select();
	}
	
	//删除
	@DeleteMapping("Customer/{id}")
	public @ResponseBody String delete(@PathVariable("id")int id) {
		cusService.delete(id);
		return "{\"status\":1}";
	}
	
	//新增
	@PostMapping("Customer")
	public @ResponseBody String insert(Customer c) {
		cusService.insert(c);
		return "{\"status\":1}";
	}
	
	//修改
	@PutMapping("Customer")
	public @ResponseBody String update(Customer c) {
		cusService.update(c);
		return "{\"status\":1}";
	}
	
}
