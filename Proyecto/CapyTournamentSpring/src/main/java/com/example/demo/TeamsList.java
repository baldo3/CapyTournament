package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	public String createTeam(Model model) {
		return "create_team_template";
	}
}
