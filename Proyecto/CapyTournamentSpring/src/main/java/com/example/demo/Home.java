package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {
	@GetMapping("/home")
    public String sayHello(Model model) {
		String homeText = new String("Texto de ejemplo del inicio de relleno bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla");
    	model.addAttribute("sectionName", "Inicio");
    	model.addAttribute("description", homeText);
    	model.addAttribute("hasDescription", true);
    	return "list_template";
    }
}