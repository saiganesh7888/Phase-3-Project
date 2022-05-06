package com.simplilearn.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/status")
	public ModelAndView indexMapping() {
		ModelAndView mv = new ModelAndView("response");
		mv.addObject("server"," SPRING MVC WEBSERVER");
		mv.addObject("message","Serve is up and running !");
		return mv;
	}

	
	@RequestMapping("/hello")
	public ModelAndView helloMapping(@RequestParam(name="username") String username) {
		ModelAndView mv = new ModelAndView("response");
		mv.addObject("server", username);
		mv.addObject("message","Hello user, Today is a good day!");
		return mv;
	}
	
	
	@RequestMapping("/message")
	public ModelAndView messageMapping(@RequestParam(name="username") String username, 
			@RequestParam(name="message") String message) {
		ModelAndView mv = new ModelAndView("response");
		mv.addObject("server", username);
		mv.addObject("message",message);
		return mv;
	}

}