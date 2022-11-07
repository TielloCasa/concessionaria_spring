package it.gianluca.concessionaria.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name =  "propietario")
public class Propietario {


	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long id;

	@Column ( name = "nome")
	private String nome;
	@Column ( name = "cognome")
	private String cognome;
	@Column ( name = "data_di_nascita")
	private Date dataNascita;
	@Column ( name = "cf", unique=true) //non univoca perché potrebbero esserci casi rarissimi di persone con lo stesso codice fiscale
	private String cf;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id")
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}


}
	