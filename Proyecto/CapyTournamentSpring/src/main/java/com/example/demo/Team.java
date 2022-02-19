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
public class Team implements CommandLineRunner{
	
	@Autowired
	 private TeamControl control;
	
	@Autowired
	private PlayerControl playerControl;
	
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
    public String visitTeamsList(Model model, HttpSession session) {
		List<TeamEntity> teams = control.findAllTeams();
		PlayerEntity player = (PlayerEntity) session.getAttribute("CurrentUser");
		boolean playerFree;
		switch(player.getStatus()) {
		case "FREE":
			playerFree = true;
			break;
		default:
			playerFree = false;
			break;
		}
		model.addAttribute("playerFree", playerFree);
    	model.addAttribute("sectionName", "Equipos");
    	model.addAttribute("sectionID", "team");
    	model.addAttribute("items", teams);
    	model.addAttribute("isTeamsList", true);
    	return "list_template";
    }
	
	@GetMapping("/create_team")
	public String teamForm(Model model) {
		return "create_team_template";
	}
	
	@PostMapping("/delete_team/{id}")
	public String visitTeamsListAfterDelete(Model model, @PathVariable String id, HttpSession session) {
		TeamEntity t = control.findTeamById(id).orElseThrow();
		
		t.getPlayers().forEach((p)->{
			p.setTeam(null);
			playerControl.savePlayer(p);
			});

		control.deleteTeamById(id);
		
		List<TeamEntity> teams = control.findAllTeams();
		PlayerEntity player = (PlayerEntity) session.getAttribute("CurrentUser");
		boolean playerFree;
		switch(player.getStatus()) {
		case "FREE":
			playerFree = true;
			break;
		default:
			playerFree = false;
			break;
		}
		model.addAttribute("playerFree", playerFree);
    	model.addAttribute("sectionName", "Equipos");
    	model.addAttribute("sectionID", "team");
    	model.addAttribute("items", teams);
    	model.addAttribute("isTeamsList", true);
    	return "list_template";
	}
	
	@PostMapping("/join_team/{id}")
	public String visitTeamAfterJoin(Model model, @PathVariable String id, HttpSession session) {
		TeamEntity t = control.findTeamById(id).get();
		PlayerEntity p = (PlayerEntity) session.getAttribute("CurrentUser");
		control.joinTeam(t, p);
		control.saveTeam(t);
		playerControl.savePlayer(p);
		Optional<TeamEntity> team = control.findTeamById(id);
    	model.addAttribute("name", id);
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
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}