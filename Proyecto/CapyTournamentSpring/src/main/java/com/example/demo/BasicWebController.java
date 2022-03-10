package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class BasicWebController {
	
	@Autowired
    private PlayerControl playerControl;
	
	@Autowired
	protected PlayerSession currentPlayer;
	
	public void updateCurrentPlayer(Model model) {
		if(currentPlayer!= null) {
			model.addAttribute("isLogged", currentPlayer.isLogged());
			model.addAttribute("playerName", currentPlayer.getCurrentName());
		}
	}
}

