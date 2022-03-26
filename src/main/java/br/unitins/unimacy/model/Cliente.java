package br.unitins.unimacy.model;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 3809727639444385556L;

	private Pessoa pessoa;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(Pessoa pessoa) {
		super();
		this.pessoa = pessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
