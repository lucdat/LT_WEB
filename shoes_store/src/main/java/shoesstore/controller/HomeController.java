package shoesstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import shoesstore.entities.User;

@Controller

public class HomeController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	@GetMapping("/card")
	public String card() {
		return "card";
	}
	
	@GetMapping("/admin")
	public String admin(HttpSession session) {
		
		while(session.getAttribute("usernameAdmin") != null) {
			return "admin";
		}
		return "redirect:loginadmin";	
		
	}
}
