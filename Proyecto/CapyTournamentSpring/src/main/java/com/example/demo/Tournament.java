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
import org.springframework.web.client.RestTemplate;

@Controller
public class Tournament extends BasicWebController{
	
	@Autowired
	 private TournamentControl control;
	
	@Autowired
	private TeamControl teamControl;
	
	@Autowired
	private PlayerControl playerControl;
	
	@Autowired
	private PlayerSession currentPlayer;
	
	@Autowired
	 private ChampionControl championControl;
	
	@GetMapping("/tournament")
    public String visitTournament(Model model, @RequestParam String name) {
		TournamentEntity tournament = control.findTournamentByName(name);
        model.addAttribute("tournamentName", name);
        List<TeamEntity> teams = tournament.getTeams();
    	model.addAttribute("teams", teams);
    	updateCurrentPlayer(model);
    	return "tournament_template";
    }
	
	@GetMapping("/tournaments_list")
    public String visitTournamentsList(Model model) {
		List<TournamentEntity> tournaments = control.findAllTournaments();
		
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
		model.addAttribute("tournamentName", name);
		
		
		updateCurrentPlayer(model);
    	return "tournament_template";
	}
	
	@GetMapping("/create_tournament")
	public String visitCreateTournament(Model model) {
		updateCurrentPlayer(model);
    	return "create_tournament_template";
	}
	
	@PostMapping("/join_tournament/{tournamentName}")
	public String visitTournamentAfterJoin(Model model, @PathVariable String tournamentName) {
		TournamentEntity tournament = control.findTournamentByName(tournamentName);
		PlayerEntity player = playerControl.findPlayerById(currentPlayer.getCurrentName()).get();
		TeamEntity team = player.getTeam();
		control.joinTournament(tournament, team);
		control.saveTournament(tournament);
		teamControl.saveTeam(team);
		model.addAttribute("tournamentName", tournamentName);
        List<TeamEntity> teams = tournament.getTeams();
    	model.addAttribute("teams", teams);
    	updateCurrentPlayer(model);
    	return "tournament_template";
	}
	
	@GetMapping("/play_game/{tournamentName}/{teamName}")
	public String visitGame(Model model, @PathVariable String teamName, @PathVariable String tournamentName) {
		TournamentEntity tournament = control.findTournamentByName(tournamentName);
        model.addAttribute("tournamentName", tournamentName);
        model.addAttribute("teamName", teamName);
        model.addAttribute("isGame", true);
        List<TeamEntity> teams = tournament.getTeams();
    	model.addAttribute("teams", teams);
    	TeamEntity team = teamControl.findTeamById(teamName).get();
    	List<PlayerEntity> players = team.getPlayers();
    	model.addAttribute("players", players);
    	List<ChampionEntity> champions = championControl.findAllChampions();
    	model.addAttribute("champions", champions);
    	updateCurrentPlayer(model);
    	return "tournament_template";
	}
	
	@PostMapping("/game_played/{teamName}")
	public String gamePlayed(Model model, @RequestParam String champion1, @RequestParam String champion2, @RequestParam String champion3,
			@RequestParam String champion4, @RequestParam String champion5, @RequestParam String result, @PathVariable String teamName) {
    	System.out.println(teamName + " - " + result + ": " +champion1 + ", " + champion2 + ", " + champion3 + ", " + champion4 + ", " + champion5);
    	if(result.equals("victory")) {
    		RestTemplate rt = new RestTemplate();
    		TeamEntity team = teamControl.findTeamById(teamName).get();
    		
            String url = "http://localhost:8080/sendMailVictory?email=" + team.getPlayers().get(0).getEmail() + "&playerName=" + team.getPlayers().get(0).getName() + "&teamName=" + teamName + "&championName=" + champion1;
            rt.postForEntity(url, null, String.class);
            
            url = "http://localhost:8080/sendMailVictory?email=" + team.getPlayers().get(1).getEmail() + "&playerName=" + team.getPlayers().get(1).getName() + "&teamName=" + teamName + "&championName=" + champion2;
            rt.postForEntity(url, null, String.class);
            
            url = "http://localhost:8080/sendMailVictory?email=" + team.getPlayers().get(2).getEmail() + "&playerName=" + team.getPlayers().get(2).getName() + "&teamName=" + teamName + "&championName=" + champion3;
            rt.postForEntity(url, null, String.class);
            
            url = "http://localhost:8080/sendMailVictory?email=" + team.getPlayers().get(3).getEmail() + "&playerName=" + team.getPlayers().get(3).getName() + "&teamName=" + teamName + "&championName=" + champion4;
            rt.postForEntity(url, null, String.class);
            
            url = "http://localhost:8080/sendMailVictory?email=" + team.getPlayers().get(4).getEmail() + "&playerName=" + team.getPlayers().get(4).getName() + "&teamName=" + teamName + "&championName=" + champion5;
            rt.postForEntity(url, null, String.class);
    	}
    	
		return "login";
	}
}