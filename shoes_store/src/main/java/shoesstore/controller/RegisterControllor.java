package shoesstore.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import shoesstore.dao.RoleDao;
import shoesstore.dao.UserDao;
import shoesstore.entities.Role;
import shoesstore.entities.User;
import shoesstore.validator.UserValidate;

@Controller
public class RegisterControllor {
	@Autowired
	private UserDao<User, Integer> userDao;
	@Autowired
	private RoleDao<Role, Integer> roleDao;
	
	@Autowired
	private UserValidate userValidate;
	
	@GetMapping("/register")
	public String Formlogin(Model model, HttpSession session) {
		model.addAttribute("customer", new User());
		return "auth/register";
	}
	@PostMapping("/register")
	public String register(@ModelAttribute("customer") User customer, Model model) {
		List<User> userEmail = userDao.findByProperty("email", customer.getEmail());
		List<User> userPhone = userDao.findByProperty("phone", customer.getPhone());
		if(customer.getName().equals("")) {
			model.addAttribute("message", "Name is Empty");
			return "auth/register";
		}else if(customer.getEmail().equals("")) {
			model.addAttribute("message", "Email is Empty");
			return "auth/register";
		}else if(userEmail!=null && !userEmail.isEmpty()) {
			model.addAttribute("message", "Email was exist");
			return "auth/register";
		}else if(customer.getPassword().equals("")) {
			model.addAttribute("message", "Password is Empty");
			return "auth/register";
		}else if(customer.getPhone().equals("")) {
			model.addAttribute("message", "Phone is Empty");
			return "auth/register";
		}else if(userPhone!=null && !userPhone.isEmpty()) {
			model.addAttribute("message", "Phone was exist");
			return "auth/register";
		}else {
			MultipartFile file = customer.getFile();
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			if(fileName.contains(".."))
			{
				System.out.println("not a a valid file");
			}
			try {
				customer.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			List<Role> role = roleDao.findByProperty("name", "CUSTOMER");
			customer.setRole(role.get(0));
			userDao.insert(customer);
			return "redirect:login";
		}
		
	}
}
