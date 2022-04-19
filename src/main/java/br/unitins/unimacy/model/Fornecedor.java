package br.unitins.unimacy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Fornecedor extends DefaultEntity {

	private static final long serialVersionUID = 5302778775042634051L;

	private String razaoSocial;
	private String nomeFantasia;
	private String inscEstadual;

	private PessoaJuridica pessoaJuridica;

	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}
	
	public Fornecedor(String razaoSocial, String nomeFantasia, String inscEstadual, PessoaJuridica pessoaJuridica) {
		super();
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.inscEstadual = inscEstadual;
		this.pessoaJuridica = pessoaJuridica;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	
	public static List <Fornecedor> cargaFornecedor(){
		List <Fornecedor> listaFornecedor = new ArrayList<>();
		
		listaFornecedor.add(new Fornecedor());
		listaFornecedor.add(new Fornecedor());
		listaFornecedor.add(new Fornecedor());
		listaFornecedor.add(new Fornecedor());
		
		return listaFornecedor;
	}

}
