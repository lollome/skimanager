package it.openstyle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SkiController {

	@RequestMapping("/index")
	  // @ResponseBody
	  public String index() {
	    return "hello.html";
	  }
	
	
	@RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "saluto";
    }
}
