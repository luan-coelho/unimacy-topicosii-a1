package br.unitins.unimacy.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Inheritance(strategy=InheritanceType.JOINED)
@Entity
public class Pessoa extends DefaultEntity {

	private static final long serialVersionUID = 2886589069101743676L;

	// @Email(message = "Informe um email válido")
	private String email;
	private String senha;
	private String telefone;

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	private boolean ativo = true;

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Pessoa(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Pessoa(boolean ativo) {
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public boolean isAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Pessoa [email=" + email + ", senha=" + senha + ", telefone=" + telefone + ", endereco=" + endereco
				+ ", ativo=" + ativo + "]";
	}
}
