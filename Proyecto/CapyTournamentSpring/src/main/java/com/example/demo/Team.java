package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Team implements CommandLineRunner{
	
	@Autowired
	 private TeamControl control;
	
	@GetMapping("/team")
    public String sayHello(Model model, @RequestParam String name) {
		Optional<TeamEntity> team = control.findTeamById(name);
    	model.addAttribute("name", name);
    	List<PlayerEntity> players = null;
    	String motto = "";
    	if(team.isPresent()) {
    		players = team.get().getPlayers();
    		motto = team.get().getMotto();
    	}
    	model.addAttribute("players", players);
    	model.addAttribute("description", motto);
    	return "team_template";
    }
	
	@PostMapping("/team")
	public String teamPost(Model model, @RequestParam String name, @RequestParam String motto){
		control.newTeam(name, motto);
		model.addAttribute("name", name);
    	model.addAttribute("players", null);
    	model.addAttribute("description", motto);
		return "team_template";
	}
	
	@GetMapping("/teams_list")
    public String sayHello(Model model) {
    	model.addAttribute("sectionName", "Equipos");
    	model.addAttribute("sectionID", "team");
    	model.addAttribute("isTeamsList", true);
    	return "list_template";
    }
	
	@GetMapping("/create_team")
	public String teamForm(Model model) {
		System.out.println("Crear equipo:");
		return "create_team_template";
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}