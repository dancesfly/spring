package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.User;

@Controller
public class DemoController {

	User user = new User();
	User user1 = new User();
	Map<String, User> users = new HashMap<String, User>();
	
	/**
	 * 前端->后台传值
	 */
	//方法1-cz1/helloMaven/cz1?cz1="hello"
	@RequestMapping("/cz1")
	public String cz1(String cz1) {
		System.out.println("cz1 "+cz1);		
		return "hello";
	}
	
	//方法2-cz2/helloMaven/cz2?cz2="hello"
	@RequestMapping("/cz2")
	public String cz2(@RequestParam("cz2") String cz) {
		System.out.println("cz2 " + cz);
		return "hello";
	}

	//方法3-cz2/helloMaven/cz3 + 合法性  + 上传文件
	@RequestMapping(value="/cz3",method=RequestMethod.GET)
	public String cz3(User user) {		
		System.out.println("GET  " + user);
		System.out.println("id:"+user.getId());
		System.out.println("name:"+user.getName());
		return "hello";
	}
	
	@RequestMapping(value="/cz3",method=RequestMethod.POST)
	public String cz30(@Validated User user,BindingResult br,@RequestParam("attachs") MultipartFile[] attachs,HttpServletRequest req) throws IOException {
		if(br.hasErrors()) {
			return "hello";
		}
		
		//上传文件
		String realPath = req.getSession().getServletContext().getRealPath("/statics/upload");
		System.out.println(realPath);
		for(MultipartFile attach:attachs) {
			if(attach.isEmpty()) continue;
			File f = new File(realPath+"/"+attach.getOriginalFilename());
			FileUtils.copyInputStreamToFile(attach.getInputStream(),f);
		}
		
		return "hello";
	}
	
	/**
	 * 后天->前台传值
	 */
	//方法1
	@RequestMapping("/czqt1")
	public ModelAndView czqt1(String czqt1) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", czqt1);
		ModelAndView view = new ModelAndView("hello"); //hello.jsp
		
		//this is my JSP page.${a.username}
		view.addObject("a", map);
		return view;
	}
	
	//方法2
	@RequestMapping("/czqt2")
	public String czqt2(String str1, String str2, Map<String, 
								Object> map1, Map<String, Object> map2) {
		//This is my JSP page.${id}
		map1.put("id", str1);
		//This is my JSP page.${username}
		map2.put("username", str2);
		return "hello";
	}
	
	//方法3
	@RequestMapping("/czqt3")
	public String czqt3(String str, Model model) {
		//This is my JSP page.${username}
		model.addAttribute("username", str);
		return "hello";
	}
	
	//方法4--一个对象
	@RequestMapping("/getList")
	public String getList(Model model) {
		user.setId(1);
		user.setName("hello");
		//${user.name}
		model.addAttribute("user",user);
		return "list";
	}
	
	//方法4--多个对象
	@RequestMapping("/getLists")
	public String getLists(Model model) {
		users.put("hello", new User(1, "hello"));
		users.put("vivi", new User(2, "vivi"));
		model.addAttribute("users", users);
		return "list";
	}
	
	/**
	 * 跳转
	 */
	@RequestMapping("/goTo")
	public String goTo(Model model) {
		users.put("begin", new User(3, "begin"));
		return "redirect:/getLists";
	}
	
	/***
	 * 返回json
	 */
	@RequestMapping("/json")
	@ResponseBody
	public User json() {
		user.setId(1);
		user.setName("json");
		return user;
	}
}
