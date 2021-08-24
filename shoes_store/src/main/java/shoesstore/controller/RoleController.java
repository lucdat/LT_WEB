package shoesstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import shoesstore.entities.Paging;
import shoesstore.entities.Role;
import shoesstore.service.RoleService;

@Controller
@RequestMapping("role")
public class RoleController {
	@Autowired
	private RoleService<Role, Integer> roleService;
	
	@GetMapping("list")
	public String redirectUserList() {
		return "redirect:/role/list/1";
	}

	@GetMapping("list/{indexPage}")
	public String findAll(@PathVariable("indexPage") int indexPage, Model model) {
		Paging paging = new Paging(indexPage);
		List<Role> roles = roleService.findAll(paging);
		model.addAttribute("roles", roles);
		model.addAttribute("paging", paging);
		return "role-list";
	}
	@GetMapping("add")
	public String redirectUserForm(Model model) {
		model.addAttribute("role", new Role());
		return "role-form";
	}

	@PostMapping("add")
	public String addUser(@ModelAttribute("role") Role role) {
		role.setActiveFlag(1);
		roleService.insert(role);
		return "redirect:/role/list";
	}

	@GetMapping("/delete/{roleId}")
	public String deleteUser(@PathVariable("roleId") Integer roleId) {
		Role role = roleService.findById(Role.class, roleId);
		role.setActiveFlag(0);
		roleService.update(role);
		return "redirect:/role/list";
	}
}
