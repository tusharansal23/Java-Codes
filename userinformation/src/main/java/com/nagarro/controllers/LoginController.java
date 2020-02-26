package com.nagarro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.authenticator.Authenticator;
import com.nagarro.service.Service;
import com.nagarro.entity.Employee;
//import com.nagarro.authenticator.Authenticator;

@Controller
public class LoginController {
	@Autowired
	Authenticator obj;
	@Autowired
	Service s;

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("username") String uname, @RequestParam("password") String password) {

		// System.out.println(fu + " fu");
		// System.out.println(dao + " du");
		// System.out.println(folder + " folder");
		// fu.uploader();
		// folder.func();
		System.out.println(obj);
		System.out.println("hey");
		ModelAndView mv = new ModelAndView();
		mv.addObject("username", uname);
		System.out.println(s);
		List<Employee> arr = s.getEmp();
		if (arr != null) {
			for (Employee e : arr) {
				System.out.println(e);
			}
		}
		mv.addObject("array", arr);
		if (obj.check(uname, password)) {
			mv.setViewName("emp.jsp");
		} else {
			mv.setViewName("index.jsp");
		}
		return mv;
	}
}
