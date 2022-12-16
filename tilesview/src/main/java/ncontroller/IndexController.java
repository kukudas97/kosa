package ncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@RequestMapping("/index.htm")
	public String index() {
		System.out.println("index");
		return "index";
	}
	
	@RequestMapping("/error.htm")
	public String error() {
		System.out.println("error");
		return "error";
	}
}
