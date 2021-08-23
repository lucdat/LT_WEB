package shoesstore.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import shoesstore.entities.Paging;
import shoesstore.entities.User;
import shoesstore.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	private UserService<User, Integer> userService;
	
	@GetMapping("list")
	public String redirectUserList() {
		return "user-list";
	}
	@GetMapping("list/{indexPage}")
	public String findAll(@PathVariable("indexPage") int indexPage,Model model) {
		Paging paging = new Paging(indexPage);
		List<User> users = userService.findAll(paging);
		model.addAttribute("user-list", users);
		model.addAttribute("paging", paging);
		return "user-list";
	}
}
