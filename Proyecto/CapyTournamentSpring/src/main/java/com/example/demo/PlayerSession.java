package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class PlayerSession {
	
	private String currentName = "invitado";
	
	private boolean isLogged = false;
	
	public PlayerSession() {
		
	}
	
	public void setLogged(boolean logged) {
		isLogged = logged;
	}
	
	public boolean isLogged() {
		return isLogged;
	}

	public String getCurrentName() {
		return currentName;
	}

	public void setCurrentName(String currentName) {
		this.currentName = currentName;
	}
}

