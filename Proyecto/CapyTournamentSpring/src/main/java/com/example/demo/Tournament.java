package com.example.demo;

import java.util.Arrays;
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
public class Tournament extends BasicWebController{
	
	@Autowired
	 private TournamentControl control;
	
	@Autowired
	private TeamControl teamControl;
	
	@Autowired
	private PlayerControl playerControl;
	
	@GetMapping("/tournament")
    public String visitTournament(Model model, @RequestParam String name) {
		TournamentEntity tournament = control.findTournamentByName(name);
        model.addAttribute("name", name);
        List<TeamEntity> teams = tournament.getTeams();
    	model.addAttribute("teams", teams);
    	updateCurrentPlayer(model);
    	return "tournament_template";
    }
	
	@GetMapping("/tournaments_list")
    public String visitTournamentsList(Model model, HttpSession session) {
		List<TournamentEntity> tournaments = control.findAllTournaments();
		
		Optional<PlayerEntity> player = playerControl.findPlayerById("Usuario");
		boolean hasTeam = false;
		if(player.isPresent()) {
			if(player.get().getTeam() != null) {
				hasTeam = true;
			}
		}
		model.addAttribute("hasTeam", hasTeam);
    	model.addAttribute("sectionName", "Torneos");
    	model.addAttribute("sectionID", "tournament");
    	model.addAttribute("items", tournaments);
    	model.addAttribute("isTournamentsList", true);
    	updateCurrentPlayer(model);

    	return "list_template";
    }
	
	@PostMapping("/tournament")
	public String visitTournamentAfterCreate(Model model, @RequestParam String name) {
		control.newTournament(name);
		model.addAttribute("name", name);
		
		
		updateCurrentPlayer(model);
    	return "tournament_template";
	}
	
	@GetMapping("/create_tournament")
	public String visitCreateTournament(Model model) {
		updateCurrentPlayer(model);
    	return "create_tournament_template";
	}
	
	/*@PostMapping("/delete_tournament/{id}")
	public String visitTeamsListAfterDelete(Model model, @PathVariable String id, HttpSession session) {
		TournamentEntity tournament = control.findTournamentByName(id);
		
		tournament.getTeams().forEach((team)->{
			team.leaveTournament();
			teamControl.saveTeam(team);
			});

		control.deleteTournamentByName(id);
		List<TournamentEntity> tournaments = control.findAllTournaments();
		model.addAttribute("sectionName", "Torneos");
    	model.addAttribute("sectionID", "tournament");
    	model.addAttribute("items", tournaments);
    	model.addAttribute("isTournamentsList", true);
	    	return "list_template";
		}*/
	
	@PostMapping("/join_tournament/{name}")
	public String visitTournamentAfterJoin(Model model, @PathVariable String name, HttpSession session) {
		TournamentEntity tournament = control.findTournamentByName(name);
		PlayerEntity player = (PlayerEntity) session.getAttribute("CurrentUser");
		boolean playerFree = player.getStatus() =="FREE";
		model.addAttribute("hasTeam", !playerFree);
		TeamEntity team = player.getTeam();
		control.joinTournament(tournament, team);
		control.saveTournament(tournament);
		teamControl.saveTeam(team);
		model.addAttribute("name", name);
        List<TeamEntity> teams = tournament.getTeams();
    	model.addAttribute("teams", teams);
    	updateCurrentPlayer(model);
    	return "tournament_template";
	}
}