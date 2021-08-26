package shoesstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping("/detail")
	public String detail() {
		return "detail";
	}
	@GetMapping("/card")
	public String card() {
		return "card";
	}
	@GetMapping("/admin/login")
	public String login() {
		return "auth/login";
	}
}
