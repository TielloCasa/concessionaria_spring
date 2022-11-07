package it.gianluca.concessionaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.gianluca.concessionaria.model.Propietario;
import it.gianluca.concessionaria.model.Veicolo;
import it.gianluca.concessionaria.repository.VeicoloRepository;

@Service
public class VeicoloServiceImpl implements VeicoloService{
	@Autowired
	private VeicoloRepository veicoloRepository;
	
	@Override
	public List<Veicolo> getAllVeicoli() {
		// TODO Auto-generated method stub
		return veicoloRepository.findAll();	
	}

	@Override
	public void salvaVeicolo(Veicolo veicolo) {
		// TODO Auto-generated method stub
		this.veicoloRepository.save(veicolo);

	}

	@Override
	public Veicolo getVeicoloById(String id) {
		Optional<Veicolo> optional = veicoloRepository.findById(id);
		Veicolo veicolo = null;
	
			
			veicolo = optional.get();


		return veicolo;
	}

	@Override
	public void cancellaVeicoloById(String id) {
		
		this.veicoloRepository.deleteById(id);
		
	}

	@Override
	public Veicolo getVeicoloByTarga(String targa) {
		List<Veicolo> optional = veicoloRepository.findAllByTarga(targa);
		Veicolo veicolo = null;
	
			
			veicolo = optional.get(0);


		return veicolo;
	}

	
	@Override
	public List<Veicolo> findAllByPropietario(Propietario propietario) {
		return veicoloRepository.findAllByPropietario(propietario);
	}

}
