package com.spring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSecurityController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/home")
	public String home(){
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login_error")
	public String handlerFailedLogin() {
		System.out.println("A user has failed to login");
		return "redirect:/login?error";
	}
	
	@RequestMapping("/login-error")
	  public String loginError(Model model) {
	    model.addAttribute("error", true);
	    return "redirect:/login";
	  }

}
