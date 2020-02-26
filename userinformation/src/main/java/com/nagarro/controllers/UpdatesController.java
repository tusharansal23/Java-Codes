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
public class UpdatesController {
	@Autowired
	Service s;

	@RequestMapping("/updates")
	public ModelAndView upload(@RequestParam("ecode") String ecode, @RequestParam("ename") String ename,
			@RequestParam("location") String location, @RequestParam("email") String email,
			@RequestParam("edate") String edate) {

		System.out.println("hi");

		System.out.println("hey");
		Employee emp = s.updateEmp(Integer.parseInt(ecode), ename, location, email, edate);
		System.out.println(emp);
		List<Employee> arr = s.getEmp();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("emp.jsp");
		mv.addObject("array", arr);
		return mv;
	}

}
