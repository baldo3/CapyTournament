package com.example.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Player extends BasicWebController{
	
	@Autowired
	 private PlayerControl control;
	
	@GetMapping("/player")
    public String visitPlayer(Model model, @RequestParam String name) {
		Optional<PlayerEntity> player = control.findPlayerById(name);
		String teamName = "Sin equipo";
		boolean hasTeam = false;
		if(player.isPresent()) {
			if(player.get().getTeam() != null) {
				TeamEntity team = player.get().getTeam();
				teamName = team.getName();
				hasTeam = true;
			}
		}
		model.addAttribute("hasTeam", hasTeam);
		model.addAttribute("teamName", teamName);
    	model.addAttribute("name", name);
    	updateCurrentPlayer(model);
    	return "player_template";
    }
	
	@PostMapping("/leave_my_team")
    public String visitPlayerAfterLeaveTeam(Model model, HttpSession session) {
		PlayerEntity player = (PlayerEntity) session.getAttribute("CurrentUser");
		player.leaveTeam();
		
		control.savePlayer(player);
		String teamName = "Sin equipo";
		boolean hasTeam = false;
		model.addAttribute("hasTeam", hasTeam);
		model.addAttribute("teamName", teamName);
    	model.addAttribute("name", player.getName());
    	updateCurrentPlayer(model);
    	return "player_template";
    }
	
	@GetMapping("/players_list")
    public String visitPlayersList(Model model) {
		List<PlayerEntity> players = control.findAllPlayers();
    	model.addAttribute("sectionName", "Jugadores");
    	model.addAttribute("items", players);
    	model.addAttribute("sectionID", "player");
    	model.addAttribute("isPlayersList", true);
    	updateCurrentPlayer(model);

    	return "list_template";
    }
	
	@PostMapping("/delete_player/{id}")
	public String visitPlayerListAfterDelete(Model model, @PathVariable String id) {
		control.findPlayerById(id).get().leaveTeam();
		control.deletePlayerById(id);
		List<PlayerEntity> players = control.findAllPlayers();
    	model.addAttribute("sectionName", "Jugadores");
    	model.addAttribute("items", players);
    	model.addAttribute("sectionID", "player");
    	model.addAttribute("isPlayersList", true);
    	updateCurrentPlayer(model);
    	return "list_template";
	}
}