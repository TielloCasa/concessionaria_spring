package it.gianluca.concessionaria.service;

import java.util.List;

import it.gianluca.concessionaria.model.Propietario;

public interface PropietarioService {
	List<Propietario> getAllPropietari();
	void salvaPropietario(Propietario propietario);
	Propietario getPropietarioById(long id);
	void cancellaPropietarioById(long id);
	Propietario getPropietarioByCf(String cf);
}
