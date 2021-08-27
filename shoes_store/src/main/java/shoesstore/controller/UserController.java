package shoesstore.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import shoesstore.entities.Paging;
import shoesstore.entities.Role;
import shoesstore.entities.User;
import shoesstore.service.RoleService;
import shoesstore.service.UserService;
import shoesstore.validator.UserValidate;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService<User, Integer> userService;
	@Autowired
	private RoleService<Role, Integer> roleService;
	
	@Autowired
	private UserValidate userValidate;

	@InitBinder("user")
	public void customizeBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		dateFormatter.setLenient(false);
		binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(dateFormatter, true));
		binder.setValidator(userValidate);
	}

	@GetMapping("list")
	public String redirectUserList() {
		return "redirect:/user/list/1";
	}

	@GetMapping("list/{indexPage}")
	public String findAll(@PathVariable("indexPage") int indexPage, Model model, HttpSession session) {
		while(session.getAttribute("usernameAdmin") != null) {
			Paging paging = new Paging(indexPage);
			List<User> users = userService.findAll(paging);
			model.addAttribute("users", users);
			model.addAttribute("paging", paging);
			return "user-list";
		}
		return "redirect:/loginadmin";
		
	}

	@GetMapping("add")
	public String redirectUserForm(Model model) {
		model.addAttribute("user", new User());
		return "user-form";
	}

	@PostMapping("add")
	public String addUser(@ModelAttribute("user") @Validated User user, BindingResult result) {
		if (result.hasErrors()) {
			return "user-form";
		}
		userService.insert(user);
		return "redirect:/user/list";
	}

	@GetMapping("/delete/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) {
		User user = userService.findById(User.class, userId);
		userService.delete(user);
		return "redirect:/user/list";
	}
	@GetMapping("edit/{userId}")
	public String updateForm(@PathVariable("userId") Integer userId,Model model) {
		model.addAttribute("roles", roleService.findAll(null));
		model.addAttribute("url", "../edit/"+userId);
		model.addAttribute("user", userService.findById(User.class, userId));
		return "user-update";
	}
	@PostMapping("edit/{userId}")
	public String updateUser(@ModelAttribute("user") User userUpdate,@PathVariable("userId") Integer userId) {
		User user =  userService.findById(User.class, userId);
		try {
			MultipartFile file = userUpdate.getFile();
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			if(fileName.contains(".."))
			{
				return "user-update";
			}
			try {
				userUpdate.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(userUpdate.getRole().getId()!=null) {
				int roleId = userUpdate.getRole().getId();
				Role role = roleService.findById(Role.class,roleId);
				user.setRole(role);
			}else {
				user.setRole(null);
			}
			user.setEmail(userUpdate.getEmail());
			user.setImage(userUpdate.getImage());
			user.setPhone(userUpdate.getPhone());
			user.setName(userUpdate.getName());
			userService.update(user);
			return "redirect:/user/list";
		} catch (Exception e) {
			return "user-update";
		}
	}
}
