package com.CodingDojo.LognadReg.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.CodingDojo.LognadReg.Models.User;
import com.CodingDojo.LognadReg.Service.UserService;
import com.CodingDojo.LognadReg.Validator.UserValidator;

public class JobController {
	
	private final UserService userService;
	private final UserValidator userValidator;
    
    public JobController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

	@GetMapping("/dashboard")
	public String dash(Model model, HttpSession session) {
		Long id = (Long)session.getAttribute("userid");
		User loggedinuser = this.userService.findUserById(id);
		model.addAttribute("loggedinuser", loggedinuser);
		return "/LognadReg/dashboard.jsp";
	}
	
}
