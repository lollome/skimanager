package it.openstyle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.openstyle.Message;

@Controller
public class SkiController {

	@RequestMapping("/index")
	  // @ResponseBody
	  public String index() {
	    return "hello.html";
	  }
	
	
	@RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name,@ModelAttribute Message message) {
        model.addAttribute("name", name);
        
        model.addAttribute("message", message);
        return "cerca-maestro";
    }
}
