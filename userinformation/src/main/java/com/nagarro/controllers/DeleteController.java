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
public class DeleteController {
	@Autowired
	Service s;

	@RequestMapping("/delete")
	public ModelAndView upload(@RequestParam("username") String uname, @RequestParam("eid") String eid) {

		System.out.println("hi");

		int id = Integer.parseInt(eid);
		s.delete(id);
		List<Employee> arr = s.getEmp();
		ModelAndView mv = new ModelAndView();
		mv.addObject("username", uname);
		mv.addObject("array", arr);
		mv.setViewName("emp.jsp");
		return mv;
	}

}
