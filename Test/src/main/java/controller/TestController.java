package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import service.CustomerService;

@Controller
public class TestController {
	
	@Autowired
	CustomerService cusService;
	
	//首页全部查询显示
	@RequestMapping("index")
	public String index(String txt,ModelMap m) {
		String where="";
		if(txt!=null&&txt!="")
			where=" where cus_name like '%"+txt+"%'";
		m.put("cusList", cusService.select(where));
		m.put("txt", txt);
		return "cindex";
	}
	
	
}
