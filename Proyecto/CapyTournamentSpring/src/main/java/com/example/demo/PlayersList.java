package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayersList {
	@GetMapping("/players_list")
    public String sayHello(Model model) {
        List<String> players= Arrays.asList("Baldo","Claudia","Javi");
    	model.addAttribute("sectionName", "Jugadores");
    	model.addAttribute("items", players);
    	model.addAttribute("sectionID", "player");
    	return "list_template";
    }
}
