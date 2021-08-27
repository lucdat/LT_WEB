package shoesstore.controller;



import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StatisticalCostController {

	@RequestMapping("test")
	@ResponseBody
	public String test() {
		Date date = new Date();
		System.out.println(date);
		return "ok";
	}
}
