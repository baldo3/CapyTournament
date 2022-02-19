package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Player {
	@GetMapping("/player")
    public String sayHello(Model model, @RequestParam String name) {
        List<String> players= Arrays.asList("Claudia","Javi","Nacho","Baldo","Rober");
    	model.addAttribute("name", name);
    	model.addAttribute("players", players);
    	return "player_template";
    }
	
	@GetMapping("/players_list")
    public String sayHello(Model model) {
    	model.addAttribute("sectionName", "Jugadores");
    	model.addAttribute("sectionID", "player");
    	model.addAttribute("isPlayersList", true);
    	return "list_template";
}
}