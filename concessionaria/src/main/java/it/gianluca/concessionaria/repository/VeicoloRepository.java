package it.gianluca.concessionaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.gianluca.concessionaria.model.Propietario;
import it.gianluca.concessionaria.model.Veicolo;

@Repository
public interface VeicoloRepository extends JpaRepository<Veicolo, String>{
	List<Veicolo> findAllByTarga(String targa);
	List<Veicolo> findAllByPropietario(Propietario propietario);
}
