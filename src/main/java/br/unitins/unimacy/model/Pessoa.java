package br.unitins.unimacy.model;

import javax.persistence.Entity;

@Entity
public class Pessoa extends DefaultEntity {

	private static final long serialVersionUID = 2886589069101743676L;

	private String email;
	private String senha;
	private String telefone;
	private boolean ativo;

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Pessoa(String email, String senha, String telefone, boolean ativo) {
		super();
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.ativo = ativo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	
}
