package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Team {
	@GetMapping("/team")
    public String sayHello(Model model) {
		String teamName = new String("Pisillo");
        List<String> players= Arrays.asList("Claudia","Javi","Nacho","Baldo","Rober");
    	model.addAttribute("teamName", teamName);
    	model.addAttribute("players", players);
    	return "team_template";
    }
}
