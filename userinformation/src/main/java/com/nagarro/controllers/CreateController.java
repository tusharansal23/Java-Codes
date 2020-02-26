package com.nagarro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.entity.Employee;
import com.nagarro.service.Service;

@Controller
public class CreateController {
	@Autowired
	Service s;

	@RequestMapping("/create")
	public ModelAndView login(@RequestParam("ecode") String ecode, @RequestParam("ename") String ename,
			@RequestParam("location") String location, @RequestParam("email") String email,
			@RequestParam("edate") String edate) {

		// System.out.println(fu + " fu");
		// System.out.println(dao + " du");
		// System.out.println(folder + " folder");
		// fu.uploader();
		// folder.func();
		// System.out.println(obj);
		System.out.println("hey");
		Employee emp = s.createEmp(Integer.parseInt(ecode), ename, location, email, edate);
		System.out.println(emp);
		List<Employee> arr = s.getEmp();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("emp.jsp");
		mv.addObject("array", arr);
		return mv;
	}

}
