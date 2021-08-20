package shopshoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	
	@RequestMapping("cc")
	@ResponseBody
	public String abc() {
		return "abcs";
	}
}
