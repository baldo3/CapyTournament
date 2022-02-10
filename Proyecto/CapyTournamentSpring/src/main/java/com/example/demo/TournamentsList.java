package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TournamentsList {
	@GetMapping("/tournaments_list")
    public String sayHello(Model model) {       
        List<String> tournaments= Arrays.asList("Copa Pistón","Copa del Fari","El Matar");
    	model.addAttribute("sectionName", "Torneos");
    	model.addAttribute("items", tournaments);
    	model.addAttribute("sectionID", "tournament");
    	return "list_template";
    }
}