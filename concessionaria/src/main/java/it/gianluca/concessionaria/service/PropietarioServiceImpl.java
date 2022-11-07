package it.gianluca.concessionaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.gianluca.concessionaria.model.Propietario;
import it.gianluca.concessionaria.repository.PropietarioRepository;

@Service
public class PropietarioServiceImpl implements PropietarioService{

	@Autowired
	private PropietarioRepository propietarioRepository;
	
	@Override
	public List<Propietario> getAllPropietari() {
		// TODO Auto-generated method stub
		return propietarioRepository.findAll();	
	}

	@Override
	public void salvaPropietario(Propietario propietario) {
		// TODO Auto-generated method stub
		this.propietarioRepository.save(propietario);

	}

	@Override
	public Propietario getPropietarioById(long id) {
		Optional<Propietario> optional = propietarioRepository.findById(id);
		Propietario propietario = null;
	
			
			propietario = optional.get();


		return propietario;
	}

	@Override
	public void cancellaPropietarioById(long id) {
		
		this.propietarioRepository.deleteById(id);
		
	}

	@Override
	public Propietario getPropietarioByCf(String cf) {
		List<Propietario> optional = propietarioRepository.findByCf(cf);
		Propietario propietario = null;
	
			
			propietario = optional.get(0);


		return propietario;
	}



}
