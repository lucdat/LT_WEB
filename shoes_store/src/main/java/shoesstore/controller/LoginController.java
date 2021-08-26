package shoesstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shoesstore.dao.InvoiceDao;
import shoesstore.entities.Invoice;
import shoesstore.entities.User;
import shoesstore.service.UserService;

public class LoginController {
	 @Autowired
	 private UserService<User, Integer> userService;
	 
	  @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("user", new User());
	 
	    return mav;
	  }
	 
	  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("login") User user) {
	    ModelAndView mav = null;
	 
	     
	    if (null != user) {
	    mav = new ModelAndView("welcome");
	    
	    } else {
	    mav = new ModelAndView("login");
	    mav.addObject("message", "Username or Password is wrong!!");
	    }
	 
	    return mav;
	  }
}
