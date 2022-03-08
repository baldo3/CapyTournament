package com.example.demo;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

@Controller
public class UserWebController extends BasicWebController{
	
	@Autowired
	private PlayerControl playerControl;
	
	@Autowired
	public UserWebController() {
		
	}
	
	/*@PostConstruct
	 void started() {
		//por ahora de testeo, al pasar mysql a update estas lineas deben comentarse
	
		controlUsuarios.newUser("Celtia", "115", controlPersonajes, controlFormacion, controlMercado, controlBatalla,true);
		
		controlUsuarios.newUser("Daniel", "115", controlPersonajes, controlFormacion, controlMercado, controlBatalla,false);	
		controlUsuarios.newUser("AristoGato", "Gato", controlPersonajes, controlFormacion, controlMercado, controlBatalla,false);
		controlUsuarios.newUser("Paimon", "EmergencyFood", controlPersonajes, controlFormacion, controlMercado, controlBatalla,false);
		controlUsuarios.newUser("Richtofen","hayquequemarlasconfire", controlPersonajes, controlFormacion, controlMercado, controlBatalla,false);
		controlUsuarios.newUser("M.Rajoy", "persianas", controlPersonajes, controlFormacion, controlMercado, controlBatalla,false);
		controlUsuarios.newUser("Kala", "ffviii", controlPersonajes, controlFormacion, controlMercado, controlBatalla,false);
		controlUsuarios.newUser("Panumo","115" , controlPersonajes, controlFormacion, controlMercado, controlBatalla,false);
		controlUsuarios.newUser("Joselito", "joselito", controlPersonajes, controlFormacion, controlMercado, controlBatalla,false);
		controlUsuarios.newUser("Japi","115" , controlPersonajes, controlFormacion, controlMercado, controlBatalla,false);
		controlUsuarios.newUser("Musa","115" , controlPersonajes, controlFormacion, controlMercado, controlBatalla,false);
		controlUsuarios.newUser("Jaimito", "chiste", controlPersonajes, controlFormacion, controlMercado, controlBatalla,false);
		controlUsuarios.newUser("Cactus",  "noAgua", controlPersonajes, controlFormacion, controlMercado, controlBatalla,false);
			
		controlPersonajes.iniciar();
		controlMercado.newMercado(controlPersonajes);
		controlBatalla.nuevaBatalla();
	}*/
	
	/*@GetMapping("/newUsuario")
	public String NuevoUsuario(Model model, HttpServletRequest request) {
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		
		model.addAttribute("token", token.getToken());
		
		model.addAttribute("errorUsuario", currentUser.isErrorUsuario());
		model.addAttribute("errorContra", currentUser.isErrorContra());
		model.addAttribute("datosInsuficientes", currentUser.isDatosInsuficientes());
		currentUser.setErrorUsuario(false);
		currentUser.setErrorContra(false);
		currentUser.setDatosInsuficientes(false);

		return "newUsuario";
	}*/

	/*@PostMapping("/newUsuario")
	public String newUser(@RequestParam String nombre ,@RequestParam String contrasena, Model model,HttpServletRequest request) {
		
		if(nombre.trim().equals("")||contrasena.trim().equals("")) {
			currentUser.setDatosInsuficientes(true);
			model.addAttribute("datosInsuficientes",currentUser.isDatosInsuficientes());
			currentUser.setDatosInsuficientes(false);
			
			return NuevoUsuario(model,request);
		}
		else {
			
			if(controlUsuarios.newUser(nombre, contrasena,controlPersonajes,controlFormacion,controlMercado, controlBatalla,false)) {
			
				return Inicio(model);
			}
			else {
				currentUser.setErrorUsuario(true);
				
				return NuevoUsuario(model,request);
			}
		}
	}*/
	
	/*@GetMapping("/clasificacion")
	public String MostrarClasificacion(Model model,HttpServletRequest request) {
		model.addAttribute("clasificacion", controlUsuarios.findTop10ByPuntosDesc());
		if(ActualizarEncabezado(model,request,false)) {
			return "clasificacion";
		}else {
			return "errorNoLogin";
		}
	}*/
	

	/*@GetMapping("/administrarUsuarios")
	public String AdministrarUsuarios(Model model,HttpServletRequest request) {
		if(ActualizarEncabezado(model,request,true)) {
			Page<User> users= controlUsuarios.findWithPage(0);
			model.addAttribute("hasPrev", users.hasPrevious());
			model.addAttribute("hasNext", users.hasNext());
			model.addAttribute("nextPage", users.getNumber()+1);
			model.addAttribute("prevPage", users.getNumber()-1);
			model.addAttribute("baneoExito", currentUser.isUsuarioBaneadoConExito());
			model.addAttribute("error",currentUser.isErrorBaneo());
			model.addAttribute("usuarios", users);
			currentUser.setErrorBaneo(false);
			currentUser.setUsuarioBaneadoConExito(false);
			return "administradorUsuarios";
		}
		else {
			return "errorNoLogin";
		}
	}*/
	
	/*@GetMapping("/administrarUsuarios/{page}")
	public String AdministrarUsuariosPage(Model model,@PathVariable int page,HttpServletRequest request) {
		if(ActualizarEncabezado(model,request,true)) {
		
			Page<User> users= controlUsuarios.findWithPage(page);
			model.addAttribute("hasPrev", users.hasPrevious());
			model.addAttribute("hasNext", users.hasNext());
			model.addAttribute("nextPage", users.getNumber()+1);
			model.addAttribute("prevPage", users.getNumber()-1);
			model.addAttribute("baneoExito", currentUser.isUsuarioBaneadoConExito());
			model.addAttribute("error",currentUser.isErrorBaneo());
			model.addAttribute("usuarios", users);
			currentUser.setErrorBaneo(false);
			currentUser.setUsuarioBaneadoConExito(false);
		return "administradorUsuarios";
		}
		else {
			return "errorNoLogin";
		}
	}*/
	
	/*@PostMapping("/banear/{id}")
	public String Banear(Model model,@PathVariable Long id,HttpServletRequest request) {
		Optional<User> user= controlUsuarios.findById(id);
		if(user.isPresent()) {
			user.get().setBaneado(!user.get().isBaneado());
			controlUsuarios.Update(user.get());
			currentUser.setUsuarioBaneadoConExito(true);
			
		}
		else{
			currentUser.setErrorBaneo(true);
			
		}
		return AdministrarUsuarios(model,request);
	}*/
	
	/*@GetMapping("/BorrarUsuario")
	public String BorrarUsuario( Model model) {
		if(currentUser!=null) {
			Optional<User> user= controlUsuarios.findByNombre(currentUser.getCurrentName());
			if(user.isPresent()) {
				
				Formacion f= user.get().getFormacion();
				controlFormacion.BorrarPersonajes(f.getId(), controlPersonajes);
				controlUsuarios.delete(user.get());
			}
			
			return Inicio(model);
		}
		return "errorNoLogin";
	}
	
}*/
	/*@GetMapping("/login")
	public String LogIn(Model model, HttpServletRequest request) {
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		
		model.addAttribute("token", token.getToken()); 
		model.addAttribute("errorUsuario", currentUser.isErrorUsuario());
		model.addAttribute("errorContra",currentUser.isErrorContra());
		model.addAttribute("hasSidoBaneado",currentUser.isBaneado());
		currentUser.setErrorUsuario(false);
		currentUser.setErrorContra(false);
		currentUser.setDatosInsuficientes(false);
		currentUser.setBaneado(false);
		
		return "login";
	}*/
	
	/*@GetMapping("/login")
		public String login(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		
		model.addAttribute("token", token.getToken()); 
		model.addAttribute("errorUsuario", currentPlayer.isErrorUsuario());
		model.addAttribute("errorContra",currentPlayer.isErrorContra());
		model.addAttribute("hasSidoBaneado",currentPlayer.isBaneado());
		currentPlayer.setErrorUsuario(false);
		currentPlayer.setErrorContra(false);
		currentPlayer.setDatosInsuficientes(false);
		currentPlayer.setBaneado(false);
		
		return "login";
		}*/
	
	@GetMapping("/login")
	public String getLogin() {
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
