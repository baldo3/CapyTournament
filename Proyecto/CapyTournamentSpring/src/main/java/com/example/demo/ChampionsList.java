package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
