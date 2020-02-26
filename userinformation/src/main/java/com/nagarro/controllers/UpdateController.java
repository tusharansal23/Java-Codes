package com.nagarro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.entity.Employee;
import com.nagarro.service.Service;

@Controller
public class UpdateController {
	@Autowired
	Service s;

	@RequestMapping("/update")
	public ModelAndView upload(@RequestParam("username") String uname, @RequestParam("eid") String eid) {

		System.out.println("hi");

		int id = Integer.parseInt(eid);
		Employee emp = s.getObject(id);
		System.out.println(emp);
		ModelAndView mv = new ModelAndView();
		mv.addObject("username", uname);
		mv.addObject("ecode", emp.getEcode());
		mv.addObject("ename", emp.getEname());
		mv.addObject("dob", emp.getDob());
		mv.addObject("eid", emp.getEid());
		mv.addObject("location", emp.getLocation());
		mv.setViewName("update.jsp");
		return mv;
	}

}
