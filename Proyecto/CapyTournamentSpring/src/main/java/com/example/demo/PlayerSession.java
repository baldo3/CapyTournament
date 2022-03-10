package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class PlayerSession {
	
	private String currentName;
	
	private boolean errorUsuario = false;
	private boolean errorContra = false;
	private boolean datosInsuficientes = false;
	private boolean baneado=false;
	private boolean usuarioBaneadoConExito= false;
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

	public boolean isErrorUsuario() {
		return errorUsuario;
	}

	public void setErrorUsuario(boolean errorUsuario) {
		this.errorUsuario = errorUsuario;
	}

	public boolean isErrorContra() {
		return errorContra;
	}

	public void setErrorContra(boolean errorContra) {
		this.errorContra = errorContra;
	}

	public boolean isDatosInsuficientes() {
		return datosInsuficientes;
	}

	public void setDatosInsuficientes(boolean datosInsuficientes) {
		this.datosInsuficientes = datosInsuficientes;
	}

	public void setUsuarioBaneadoConExito(boolean usuarioBaneadoConExito) {
		this.usuarioBaneadoConExito = usuarioBaneadoConExito;
	}
}

