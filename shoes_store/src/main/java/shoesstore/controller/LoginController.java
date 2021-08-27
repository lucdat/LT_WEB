package shoesstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String login(@ModelAttribute("account") User account, Model model, HttpSession session1) {
		List<User> user = userDao.findByProperty("email", account.getEmail());
		
		if(user!=null && !user.isEmpty()) {
			if(user.get(0).getPassword().equals(account.getPassword())) {
				session1.setAttribute("usernameC", user.get(0).getEmail());
				session1.setAttribute("nameC", user.get(0).getName());
				session1.setAttribute("imageC", user.get(0).getImage());
				session1.setAttribute("roleC", user.get(0).getRole().getName());
				if(user.get(0).getRole().getName().equals("CUSTOMER")) {
					return "redirect:/";
				}
				else {
					model.addAttribute("message", "Not Account Customer");
					return "auth/login";
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
	
	@GetMapping("/loginadmin")
	public String FormLoginAdmin(Model model, HttpSession session) {
		model.addAttribute("accountAdmin", new User());
		session.setAttribute("usernameAdmin", null);
		return "auth/loginadmin";
	}
	@PostMapping("/loginadmin")
	public String loginAdmin(@ModelAttribute("accountAdmin") User account, Model model, HttpSession session) {
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
					model.addAttribute("message", "Not Account Admin");
					return "auth/loginadmin";
				}
			}
			else {
				model.addAttribute("message", "Wrong Password");
				return "auth/loginadmin";
			}
		}
		else {
			model.addAttribute("message", "Wrong Username");
			return "auth/loginadmin";
		}
		

	}
	
	@GetMapping("logoutadmin")
	public String logoutAdmin(HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("name");
		session.removeAttribute("image");
		session.removeAttribute("role");
		return "redirect:loginadmin";
	}
	@GetMapping("logout")
	public String logout(HttpSession session1) {
		session1.removeAttribute("usernameC");
		session1.removeAttribute("nameC");
		session1.removeAttribute("imageC");
		session1.removeAttribute("roleC");
		return "redirect:login";
	}
}
