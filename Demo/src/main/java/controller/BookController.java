package controller;

import java.io.File;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import service.BookService;
import utils.ReturnInfo;

@Controller
public class BookController {
	
	@Autowired
	BookService bService;
	
	@RequestMapping("aaa")
	public @ResponseBody String upload(@RequestParam("filename")CommonsMultipartFile file, HttpServletRequest req) throws Exception {
		String oname = file.getOriginalFilename();
		String ex = oname.substring(oname.lastIndexOf("."),oname.length());
		String nname = UUID.randomUUID()+ex;
		
		String path = req.getSession().getServletContext().getRealPath("/");
		path=new File(path).getParentFile().getPath()+"/upload";
		System.out.println(path);
		file.transferTo(new File(path,nname));
		return "/upload/"+nname;
	}
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt, Integer page, Integer limit) {
		String where="";
		if(txt!=null && txt!="")
			where=" where name like '%"+txt+"%'";
		return bService.select(where, page, limit);
		
	}
}
