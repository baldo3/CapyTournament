package com.example.demo;

import java.util.Optional;

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
			Optional<PlayerEntity> player = playerControl.findPlayerById(currentPlayer.getCurrentName());
			model.addAttribute("isLogged", currentPlayer.isLogged());
			if(player.isPresent()) {
			model.addAttribute("playerName", player.get().getName());
			model.addAttribute("isAdmin", player.get().getRoles().contains("ADMIN"));
			}
		}
	}
}

