package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Team {
	@GetMapping("/team")
    public String sayHello(Model model, @RequestParam String name) {
        List<String> players= Arrays.asList("Claudia","Javi","Nacho","Baldo","Rober");
    	model.addAttribute("name", name);
    	model.addAttribute("players", players);
    	return "team_template";
    }
	
	@PostMapping("/team")
	public String teamPost(Model model, @RequestParam String name){
		//AÑADIRLO A LA BD
		model.addAttribute("name", name);
		return "team_template";
	}
}