package it.gianluca.concessionaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table( name =  "veicolo")
public class Veicolo {


	@Id
	private String numero_telaio;

	@Column ( name = "modello")
	private String modello;
	
	@Column ( name = "marca")
	private String marca;
	
	@Column ( name = "targa", unique=true)
	private String targa;
	
	@ManyToOne
	@JoinColumn(name="id_propietario", nullable=false)
    private Propietario propietario;

	

	public String getNumero_telaio() {
		return numero_telaio;
	}

	public void setNumero_telaio(String numero_telaio) {
		this.numero_telaio = numero_telaio;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}



}