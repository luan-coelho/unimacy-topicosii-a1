package br.unitins.unimacy.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pessoa extends DefaultEntity {

	private static final long serialVersionUID = 2886589069101743676L;

	//@Email(message = "Informe um email válido")
	private String email;
	private String senha;
	private String telefone;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	private boolean ativo = true;

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Pessoa(String email, String senha, String telefone, Endereco endereco, boolean ativo) {
		super();
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.endereco = endereco;
		this.ativo = ativo;
	}
	
	public Pessoa(String email, String senha, String telefone, Endereco endereco) {
		super();
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public Pessoa(boolean ativo, Endereco endereco) {
		this.ativo = ativo;
		this.endereco = endereco;
	}
	
	public Pessoa(Endereco endereco) {
		this.endereco = endereco;
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
