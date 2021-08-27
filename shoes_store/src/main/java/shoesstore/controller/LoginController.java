package shoesstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import shoesstore.dao.RoleDao;
import shoesstore.dao.UserDao;
import shoesstore.entities.Role;
import shoesstore.entities.User;
import shoesstore.validator.UserValidate;
@Controller
@Scope("session")
public class LoginController {
	
	@Autowired
	private UserDao<User, Integer> userDao;
	@Autowired
	private RoleDao<Role, Integer> roleDao;
	
	@Autowired
	private UserValidate userValidate;
	
	@GetMapping("/login")
	public String Formlogin(Model model, HttpSession session) {
		model.addAttribute("account", new User());
		session.setAttribute("username", null);
		return "auth/login";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute("account") User account, Model model, HttpSession session) {
		List<User> user = userDao.findByProperty("email", account.getEmail());
		
		if(user!=null && !user.isEmpty()) {
			if(user.get(0).getPassword().equals(account.getPassword())) {
				session.setAttribute("username", user.get(0).getEmail());
				session.setAttribute("name", user.get(0).getName());
				session.setAttribute("image", user.get(0).getImage());
				session.setAttribute("role", user.get(0).getRole().getName());
				if(user.get(0).getRole().getName().equals("ADMIN")) {
					return "redirect:admin";
				}
				else {
					return "redirect:/";
				}
			}
			else {
				model.addAttribute("message", "Wrong Password");
				return "auth/login";
			}
		}
		else {
			model.addAttribute("message", "Wrong Username");
			return "auth/login";
		}
		

	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("name");
		session.removeAttribute("image");
		session.removeAttribute("role");
		return "redirect:login";
	}
}
