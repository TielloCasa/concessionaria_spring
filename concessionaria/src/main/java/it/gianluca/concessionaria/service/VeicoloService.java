package it.gianluca.concessionaria.service;

import java.util.List;

import it.gianluca.concessionaria.model.Propietario;
import it.gianluca.concessionaria.model.Veicolo;

public interface VeicoloService {
	List<Veicolo> getAllVeicoli();
	void salvaVeicolo(Veicolo veicolo);
	Veicolo getVeicoloById(String id);
	void cancellaVeicoloById(String id);
	Veicolo getVeicoloByTarga(String targa);
	List<Veicolo> findAllByPropietario(Propietario propietario);

}
