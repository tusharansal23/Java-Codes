package com.nagarro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.authenticator.Authenticator;
import com.nagarro.dao.HrUtilDao;
import com.nagarro.entity.Employee;
import com.nagarro.service.Service;

@Controller
public class SignUpController {
	@Autowired
	HrUtilDao dao;

	@RequestMapping("/signup")
	public ModelAndView login(@RequestParam("username") String uname, @RequestParam("password") String password) {

		// System.out.println(fu + " fu");
		// System.out.println(dao + " du");
		// System.out.println(folder + " folder");
		// fu.uploader();
		// folder.func();
		dao.create(uname, password);
		ModelAndView mv = new ModelAndView();
		mv.addObject("username", uname);

		mv.setViewName("index.jsp");
		return mv;
	}

}
