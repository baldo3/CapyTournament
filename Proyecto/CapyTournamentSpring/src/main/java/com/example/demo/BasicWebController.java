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
public class BasicWebController {
	
	@Autowired
    private PlayerControl playerControl;
	
	@Autowired
	protected PlayerSession currentPlayer;
	
 /*@GetMapping("/")
 public String index() {
 return "login";
 
}*/
}

