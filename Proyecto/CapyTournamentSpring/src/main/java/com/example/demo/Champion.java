package com.example.demo;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Champion extends BasicWebController{
	
	@Autowired
	 private ChampionControl control;
	
	@GetMapping("/champion")
    public String visitChampion(Model model, @RequestParam String name, HttpServletRequest request) {
    	model.addAttribute("name", name);
    	updateCurrentPlayer(model);
    	
        
    	return "champion_template";
    }
	
	@PostMapping("/champion")
	public String visitChampionAfterCreate(Model model, @RequestParam String name, HttpServletRequest request) {
		control.newChampion(name);
		model.addAttribute("name", name);
		updateCurrentPlayer(model);
    	return "champion_template";
	}
	
	@GetMapping("/champions_list")
    public String visitChampionList(Model model, HttpServletRequest request) {
		List<ChampionEntity> champions = control.findAllChampions();
        //List<String> champions= Arrays.asList("Aatrox","Ahri","Akali","Bardo","Blitzcrank");
    	model.addAttribute("sectionName", "Campeones");
    	model.addAttribute("items", champions);
    	model.addAttribute("sectionID", "champion");
    	model.addAttribute("isChampionsList", true);
    	
    	updateCurrentPlayer(model);
    	
        
    	return "list_template";
    }
	
	@GetMapping("/create_champion")
	public String visitCreateChampion(Model model, HttpServletRequest request) {
		updateCurrentPlayer(model);
		
        
    	return "create_champion_template";
	}
	
	@PostMapping("/delete_champion/{name}")
		public String visitChampionListAfterDelete(Model model, @PathVariable String name, HttpServletRequest request) {
			control.deleteChampionById(name);
			List<ChampionEntity> champions = control.findAllChampions();
			model.addAttribute("sectionName", "Campeones");
	    	model.addAttribute("items", champions);
	    	model.addAttribute("sectionID", "champion");
	    	model.addAttribute("isChampionsList", true);
	    	
	    	updateCurrentPlayer(model);
	    	return "list_template";
		}
	}