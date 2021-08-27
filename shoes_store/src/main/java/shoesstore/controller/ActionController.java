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

import shoesstore.entities.Action;
import shoesstore.entities.Paging;
import shoesstore.service.ActionService;

@Controller
@RequestMapping("action")
public class ActionController {
	@Autowired
	private ActionService<Action, Integer> actionService;

	@GetMapping("list")
	public String redirectUserList() {
		return "redirect:/action/list/1";
	}

	@GetMapping("list/{indexPage}")
	public String findAll(@PathVariable("indexPage") int indexPage, Model model, HttpSession session) {
		while(session.getAttribute("usernameAdmin") != null) {
			Paging paging = new Paging(indexPage);
			List<Action> actions = actionService.findAll(paging);
			model.addAttribute("actions", actions);
			model.addAttribute("paging", paging);
			return "action-list";
		}
		return "redirect:/loginadmin";
		
		
	}

	@GetMapping("add")
	public String redirectUserForm(Model model) {
		model.addAttribute("action", new Action());
		return "action-form";
	}

	@PostMapping("add")
	public String addUser(@ModelAttribute("action") Action action) {
		actionService.insert(action);
		return "redirect:/action/list";
	}

	@GetMapping("/delete/{actionId}")
	public String deleteUser(@PathVariable("actionId") Integer actionId) {
		Action action = actionService.findById(Action.class, actionId);
		actionService.delete(action);
		return "redirect:/action/list";
	}

	@GetMapping("edit/{actionId}")
	public String updateForm(@PathVariable("actionId") Integer roleId, Model model) {
		model.addAttribute("url", "../edit/" + roleId);
		model.addAttribute("action", actionService.findById(Action.class, roleId));
		return "action-update";
	}

	@PostMapping("edit/{actionId}")
	public String updateUser(@ModelAttribute("action") Action actionUpdate, @PathVariable("actionId") Integer actionId) {
		Action action = actionService.findById(Action.class, actionId);
		action.setUrl(actionUpdate.getUrl());
		action.setName(actionUpdate.getName());
		actionService.update(action);
		return "redirect:/action/list";
	}
}
