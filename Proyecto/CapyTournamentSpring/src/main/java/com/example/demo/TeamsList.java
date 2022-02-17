package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeamsList {
	@GetMapping("/teams_list")
    public String sayHello(Model model) {
        List<String> teams= Arrays.asList("Móstoles","Fuenlabrada","Leganés");
    	model.addAttribute("sectionName", "Equipos");
    	model.addAttribute("items", teams);
    	model.addAttribute("sectionID", "team");
    	model.addAttribute("isTeamsList", true);
    	return "list_template";
    }
	
	@GetMapping("/create_team")
	public String teamForm(Model model) {
		System.out.println("Crear equipo:");
		return "create_team_template";
	}
	
	/*@PostMapping("/create_team")
	public String teamPost(Model model, @RequestParam String name){
		System.out.println(name);
		return "create_team_template";
	}*/
}
