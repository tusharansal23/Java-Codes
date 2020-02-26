package com.nagarro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	@RequestMapping("/upload")
	public ModelAndView upload(@RequestParam("username") String uname) {

		// System.out.println(fu + " fu");
		// System.out.println(dao + " du");
		// System.out.println(folder + " folder");
		// fu.uploader();
		// folder.func();
		// System.out.println(obj);
		System.out.println("hey");
		ModelAndView mv = new ModelAndView();
		mv.addObject("username", uname);
		mv.setViewName("upload.jsp");
		return mv;
	}

}
