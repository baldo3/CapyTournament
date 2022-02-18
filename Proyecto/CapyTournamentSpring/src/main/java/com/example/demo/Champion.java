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
public class Champion implements CommandLineRunner{
	
	@Autowired
	 private ControlChampion control;
	
	@GetMapping("/champion")
    public String visitChampion(Model model, @RequestParam String name) {
        List<String> players= Arrays.asList("Claudia","Javi","Nacho","Baldo","Rober");
    	model.addAttribute("name", name);
    	model.addAttribute("players", players);
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
		System.out.println("Crear campeón:");
		return "create_champion_template";
	}
	
	@PostMapping("/delete_champion/{id}")
		public String visitChampionListAfterDelete(Model model, @PathVariable String id) {
			control.deleteChampionById(id);
			List<ChampionEntity> champions = control.findAllChampions();
			System.out.println("Campeón borrado");
			model.addAttribute("sectionName", "Campeones");
	    	model.addAttribute("items", champions);
	    	model.addAttribute("sectionID", "champion");
	    	model.addAttribute("isChampionsList", true);
	    	
			return "list_template";
		}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	}