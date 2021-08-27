package shoesstore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	public String findAll(@PathVariable("indexPage") int indexPage, Model model, HttpSession session) {
		while(session.getAttribute("usernameAdmin") != null) {
			Paging paging = new Paging(indexPage);
			List<Role> roles = roleService.findAll(paging);
			model.addAttribute("roles", roles);
			model.addAttribute("paging", paging);
			return "role-list";
		}
		return "redirect:/loginadmin";
		
	}
	@GetMapping("add")
	public String redirectUserForm(Model model) {
		model.addAttribute("role", new Role());
		return "role-form";
	}

	@PostMapping("add")
	public String addUser(@ModelAttribute("role") Role role) {
		roleService.insert(role);
		return "redirect:/role/list";
	}

	@GetMapping("/delete/{roleId}")
	public String deleteUser(@PathVariable("roleId") Integer roleId) {
		Role role = roleService.findById(Role.class, roleId);
		roleService.delete(role);
		return "redirect:/role/list";
	}
	@GetMapping("edit/{roleId}")
	public String updateForm(@PathVariable("roleId") Integer roleId,Model model) {
		model.addAttribute("url", "../edit/"+roleId);
		model.addAttribute("role", roleService.findById(Role.class, roleId));
		return "role-update";
	}
	@PostMapping("edit/{roleId}")
	public String updateUser(@ModelAttribute("role") Role roleUpdate,@PathVariable("roleId") Integer roleId) {
		Role role =  roleService.findById(Role.class, roleId);
		role.setName(roleUpdate.getName());
		role.setDescription(roleUpdate.getDescription());
		roleService.update(role);
		return "redirect:/role/list";
	}
}
