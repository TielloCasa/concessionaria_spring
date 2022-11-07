package it.gianluca.concessionaria.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.gianluca.concessionaria.model.Propietario;
import it.gianluca.concessionaria.model.Veicolo;
import it.gianluca.concessionaria.service.PropietarioService;

@Controller
public class PropietarioController {

	@Autowired
	private PropietarioService propietarioService;

	
	@RequestMapping ( "/" )
	public String viewHomePage (Model model) {
		
		List<Propietario> p = propietarioService.getAllPropietari();
		if(p.isEmpty()) {
			Propietario propietario = new Propietario();
			propietario.setId(1);
			propietario.setNome("Concessionaria");
			propietario.setCognome("Concessionaria");
			propietario.setDataNascita(null);
			propietario.setCf("Concessionaria");
			
			propietarioService.salvaPropietario(propietario);
			
		}
		//model.addAttribute("listaUtenti", utentiService.getAllUtenti());
		return "index";
		
	}
	
	
	@GetMapping ( "/inserisci_propietario" )
	public String nuovoPropietario (Model model) {
		Propietario propietario = new Propietario ();
		model.addAttribute("propietario", propietario);
		return "inserisci_propietario";
		
	}
	
	@PostMapping("/salva_propietario")
	public String salvaPropietario(@ModelAttribute("propietario") Propietario propietario) {
		Propietario p;
		boolean b= false;
		try {
			p=propietarioService.getPropietarioByCf(propietario.getCf());
			b=true;
		}catch(Exception e) {
			p=null;
		}
		
		
		
		if(p==null) {
			propietarioService.salvaPropietario(propietario);
			return "redirect:/";
		}else {
			return "error/propietario_exist";
		}
	}
	
	@PostMapping("/salva_propietario_mod")
	public String salvaPropietrioMod(@ModelAttribute("propietario") Propietario propietario) {
		
			propietarioService.salvaPropietario(propietario);
			return "redirect:/";
	}
	
	@GetMapping ( "/lista" )
	public String nuovaLista (Model model) {
		
		model.addAttribute("listaPropietari", propietarioService.getAllPropietari());
		return "lista";
		
	}
	
	@GetMapping ("/modifica_propietario/{id}")
	public String showModificaUtenteForm(@PathVariable ( value = "id") long id , Model model) {
		
		Propietario propietario = propietarioService.getPropietarioById(id);
		
		model.addAttribute("propietario" , propietario);
		return "modifica_propietario";
	}
	
	
}
