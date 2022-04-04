package br.unitins.unimacy.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado extends DefaultEntity {

	private static final long serialVersionUID = 5693436511646646283L;

	@NotBlank
	private String nome;
	private String uf;

	public Estado() {
		// TODO Auto-generated constructor stub
	}

	public Estado(String nome, String uf) {
		super();
		this.nome = nome;
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
