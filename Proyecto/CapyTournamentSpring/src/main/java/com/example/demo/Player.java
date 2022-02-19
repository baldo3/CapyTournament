package com.example.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Player implements CommandLineRunner{
	
	@Autowired
	 private PlayerControl control;
	
	@GetMapping("/player")
    public String visitPlayer(Model model, @RequestParam String name) {
		Optional<PlayerEntity> player = control.findPlayerById(name);
		String teamName = "SIN EQUIPO";
		if(player.isPresent()) {
			if(player.get().getTeam() != null) {
				TeamEntity team = player.get().getTeam();
				teamName = team.getName();
			}
		}
		model.addAttribute("teamName", teamName);
    	model.addAttribute("name", name);
    	return "player_template";
    }
	
	@GetMapping("/players_list")
    public String visitPlayersList(Model model) {
		List<PlayerEntity> players = control.findAllPlayers();
    	model.addAttribute("sectionName", "Jugadores");
    	model.addAttribute("items", players);
    	model.addAttribute("sectionID", "player");
    	model.addAttribute("isPlayersList", true);
    	return "list_template";
    }
	
	@PostMapping("/delete_player/{id}")
	public String visitPlayerListAfterDelete(Model model, @PathVariable String id) {
		control.deletePlayerById(id);
		List<PlayerEntity> players = control.findAllPlayers();
    	model.addAttribute("sectionName", "Jugadores");
    	model.addAttribute("items", players);
    	model.addAttribute("sectionID", "player");
    	model.addAttribute("isPlayersList", true);
    	return "list_template";
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}