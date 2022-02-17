package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChampionsList {
	@GetMapping("/champions_list")
    public String sayHello(Model model) {
        List<String> champions= Arrays.asList("Aatrox","Ahri","Akali","Bardo","Blitzcrank");
    	model.addAttribute("sectionName", "Campeones");
    	model.addAttribute("items", champions);
    	model.addAttribute("sectionID", "champion");
    	model.addAttribute("isChampionsList", true);
    	return "list_template";
    }
	
	@GetMapping("/create_champion")
	public String teamForm(Model model) {
		System.out.println("Crear campeón:");
		return "create_champion_template";
	}
	
	@PostMapping("/create_champion")
	public String teamForm(Model model, @RequestParam boolean create) {
		if(!create) {
			System.out.println("Borrar campeón");
		}
		return "create_champion_template";
	}
}
