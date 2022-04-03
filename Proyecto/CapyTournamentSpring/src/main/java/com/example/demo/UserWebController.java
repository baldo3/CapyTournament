package com.example.demo;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserWebController extends BasicWebController{
	
	@Autowired
	private PlayerControl playerControl;
	
	@Autowired
	public UserWebController() {
		
	}
	
	@GetMapping("/login")
	public String getLogin(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
        model.addAttribute("token", token.getToken());
        
    	return "login";
	}

	@GetMapping("/register")
	public String getRegister(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
        model.addAttribute("token", token.getToken());
        
    	return "register";
	}

	@PostMapping("/register")
	public String postRegister(Model model, @RequestParam String username, @RequestParam String email,
		 @RequestParam String password, @RequestParam(value="isAdmin", required=false) String isAdmin, HttpServletRequest request) {
	 boolean isAdminBool = false;
	 if(isAdmin != null) {
		 isAdminBool = true;
	 }
	 playerControl.newPlayer(username, email, password, isAdminBool);
	 
	 String homeText = new String("CapyTournament es tu herramienta de creación de torneos, de amateurs para amateurs.\r\n"
				+ "¡Crea tu equipo, inscríbete a un torneo y compite!");
	model.addAttribute("sectionName", "Inicio");
	model.addAttribute("description", homeText);
	model.addAttribute("hasDescription", true);
	model.addAttribute("hasImage", true);
	
	RestTemplate rt = new RestTemplate();
    String url = "http://localhost:8080/sendMailRegister?email=" + email + "&name=" + username;
    rt.postForEntity(url, null, String.class);
    //Boolean b = rt.getForObject(url, Boolean.class);
	
    CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
    model.addAttribute("token", token.getToken());
    
	updateCurrentPlayer(model);
	return "login";
    }

@GetMapping("/loginerror")
public String loginerror(Model model, HttpServletRequest request) {
	CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
    model.addAttribute("token", token.getToken());
return "loginerror";
}

@GetMapping("/error")
public String error(Model model, HttpServletRequest request) {
	CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
    model.addAttribute("token", token.getToken());
return "login";
}
	

}
