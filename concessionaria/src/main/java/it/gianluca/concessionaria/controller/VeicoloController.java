package it.gianluca.concessionaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.gianluca.concessionaria.model.Propietario;
import it.gianluca.concessionaria.model.Veicolo;
import it.gianluca.concessionaria.service.PropietarioService;
import it.gianluca.concessionaria.service.VeicoloService;

@Controller
public class VeicoloController {

	@Autowired
	private VeicoloService veicoloService;
	@Autowired
	private PropietarioService propietarioService;
	

	@GetMapping ( "/inserisci_veicolo" )
	public String nuovoVeicolo (Model model) {
		Veicolo veicolo = new Veicolo();
		model.addAttribute("veicolo", veicolo);
		model.addAttribute("listaPropietari", propietarioService.getAllPropietari());
		return "inserisci_veicolo";
		
	}
	
	
	@PostMapping("/salva_veicolo")
	public String salvaVeicolo(@ModelAttribute("veicolo") Veicolo veicolo) {
		//gestire l'errore delle targhe e de
		
		Veicolo v;
		boolean b= false;
		try {
			v=veicoloService.getVeicoloById(veicolo.getNumero_telaio());
			b=true;
		}catch(Exception e) {
			v=null;
		}
		
		if(b==false) {
			try {			//ricerca per targa
				v=veicoloService.getVeicoloByTarga(veicolo.getTarga());
				b=true;
			}catch(Exception e) {
				v=null;
			}
		}
		
		
		
		if(v==null) {
			Propietario propietario = propietarioService.getPropietarioByCf("Concessionaria");
			//setto di base che il veicolo appartiene alla concessionaria
			veicolo.setPropietario(propietario);
			veicoloService.salvaVeicolo(veicolo);
			return "redirect:/";
		}else {
			return "error/already_exist";
		}
		
	}
	
	
	
	@GetMapping ("/veicoli/{id}")
	public String showVeicoli(@PathVariable ( value = "id") long id , Model model) {
		Propietario propietario = propietarioService.getPropietarioById(id);
		//fare la stampa dei veicoli in base al propietario
		model.addAttribute("listaVeicoli" , veicoloService.findAllByPropietario(propietario));
		return "veicoli";
	}
	

	@GetMapping ("/modifica_veicolo/{id}")
	public String showModificaUtenteForm(@PathVariable ( value = "id") String id , Model model) {
		//gestire bene
		Veicolo veicolo = veicoloService.getVeicoloById(id);
		
		model.addAttribute("veicolo" , veicolo);
		return "/modifica_veicolo";
	}
	
	
	@PostMapping("/salva_veicolo_mod")
	public String salvaVeicoloMod(@ModelAttribute("veicolo") Veicolo veicolo) {
		//gestire l'errore delle targhe e de
		veicoloService.salvaVeicolo(veicolo);
			return "redirect:/";		
		
	}
	

	@GetMapping ("/elimina_veicolo/{id}")
	public String cancellaConto(@PathVariable ( value = "id") String id , Model model) {
		
		veicoloService.cancellaVeicoloById(id);

		return "redirect:/";
	}
	
	
	@GetMapping ("/concessionaria/{id}")
	public String showConcessionaria(@PathVariable ( value = "id") String id , Model model) {
		
		Propietario propietario = propietarioService.getPropietarioByCf(id);
		model.addAttribute("listaVeicoli" , veicoloService.findAllByPropietario(propietario));
		return "concessionaria";
	}
	
	@GetMapping ("/vendita/{id}")
	public String showVendita(@PathVariable ( value = "id") String id , Model model) {
		//gestire bene
		Veicolo veicolo = veicoloService.getVeicoloById(id);
		
		model.addAttribute("listaPropietari", propietarioService.getAllPropietari());
		model.addAttribute("veicolo" , veicolo);
		return "/vendita";
	}
}
