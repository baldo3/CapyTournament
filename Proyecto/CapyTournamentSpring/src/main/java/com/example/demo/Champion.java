package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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
    public String visitChampion(Model model, @RequestParam String name) {
    	model.addAttribute("name", name);
    	return "champion_template";
    }
	
	@PostMapping("/champion")
	public String visitChampionAfterCreate(Model model, @RequestParam String name) {
		control.newChampion(name);
		model.addAttribute("name", name);
		return "champion_template";
	}
	
	@GetMapping("/champions_list")
    public String visitChampionList(Model model) {
		List<ChampionEntity> champions = control.findAllChampions();
        //List<String> champions= Arrays.asList("Aatrox","Ahri","Akali","Bardo","Blitzcrank");
    	model.addAttribute("sectionName", "Campeones");
    	model.addAttribute("items", champions);
    	model.addAttribute("sectionID", "champion");
    	model.addAttribute("isChampionsList", true);
    	return "list_template";
    }
	
	@GetMapping("/create_champion")
	public String visitCreateChampion(Model model) {
		return "create_champion_template";
	}
	
	@PostMapping("/delete_champion/{name}")
		public String visitChampionListAfterDelete(Model model, @PathVariable String name) {
			control.deleteChampionById(name);
			List<ChampionEntity> champions = control.findAllChampions();
			model.addAttribute("sectionName", "Campeones");
	    	model.addAttribute("items", champions);
	    	model.addAttribute("sectionID", "champion");
	    	model.addAttribute("isChampionsList", true);
	    	
			return "list_template";
		}
	}