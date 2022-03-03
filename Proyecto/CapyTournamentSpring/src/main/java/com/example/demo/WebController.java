package com.example.demo;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
	
	@Autowired
    private PlayerControl playerControl;
	
 @GetMapping("/")
 public String index() {
 return "login";
 }
 @GetMapping("/login")
 public String login() {
 return "login";
 }
 
 @GetMapping("/register")
 public String getRegister() {
 return "register";
 }
 
 @PostMapping("/register")
 public String postRegister(Model model, HttpSession session, @RequestParam String username, @RequestParam String email,
		 @RequestParam String password/*, @RequestParam(value="isAdmin", required=false) String isAdmin*/) {
	 /*boolean isAdminBool = false;
	 if(isAdmin != null) {
		 isAdminBool = true;
	 }*/
	 playerControl.newPlayer(username, email, password);
	 
	 String homeText = new String("CapyTournament es tu herramienta de creación de torneos, de amateurs para amateurs.\r\n"
				+ "¡Crea tu equipo, inscríbete a un torneo y compite!");
 	model.addAttribute("sectionName", "Inicio");
 	model.addAttribute("description", homeText);
 	model.addAttribute("hasDescription", true);
 	model.addAttribute("hasImage", true);
 	
 	Optional<PlayerEntity> player = playerControl.findPlayerById("Usuario");
 	if(player.isPresent()) {
 		session.setAttribute("CurrentUser", player.get());
 	}    	
 	return "list_template";
 }

 @GetMapping("/loginerror")
 public String loginerror() {
 return "login";
 }
 
 @GetMapping("/error")
 public String error() {
 return "login";
 }
}

