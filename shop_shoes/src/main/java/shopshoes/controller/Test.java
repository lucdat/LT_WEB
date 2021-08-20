package shopshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import shopshoes.dao.TestDao;
import shopshoes.entities.Demo;
import shopshoes.entities.Paging;

@Controller
public class Test {
	
	@Autowired
	private TestDao<Demo, Integer> testDao;
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("insert")
	public String insert(Model model) {
		model.addAttribute("test", new shopshoes.entities.Demo());
		return "test/insert";
	}
	@PostMapping("insert")
	public String insert(@ModelAttribute("test")Demo demo) {
		testDao.insert(demo);
		return "successfull";
	}
	@RequestMapping("list")
	public String redirect() {
		return "redirect:list/1";
	}
	
	@RequestMapping("list/{indexPage}")
	public String getList(@PathVariable("indexPage")int indexPage,Model model) {
		Paging paging = new Paging(indexPage);
		model.addAttribute("list", testDao.findAll(paging));
		return "list";
	}
}
