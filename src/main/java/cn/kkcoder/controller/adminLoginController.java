package cn.kkcoder.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kkcoder.domain.User;
import cn.kkcoder.service.UserService;

@Controller
public class adminLoginController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/toAdminLogin.action")
	public String toAdminLogin(){
		return "templates/admin/login";
	}
	
	@RequestMapping("/admin/login.action")
	public String adminLogin(String username,String password,HttpServletResponse response){
		/*
		 * 用户名验证
		 */
		Map<String ,Object> map = new HashMap<>();
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		map.put("User", u);
		List<User> listUser =  userService.find(map);
		if(listUser == null){
			try {
				response.getWriter().println("{\"msg\":\"no\"}");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		/*
		 * @time 2.1
		 * 验证这个  之后在写，把验证相关的内容google 一遍再说。。。
		 * 
		 */
		
//		response.addCookie();
		
		return "templates/admin/index";
	}
	
}
