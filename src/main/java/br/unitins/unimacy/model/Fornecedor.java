package br.unitins.unimacy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Fornecedor extends DefaultEntity {

	private static final long serialVersionUID = 5302778775042634051L;

	private PessoaJuridica pessoaJuridica;

	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}
	
	public Fornecedor(PessoaJuridica pessoaJuridica) {
		super();
		this.pessoaJuridica = pessoaJuridica;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	
	
	@Override
	public String toString() {
		return "Fornecedor [pessoaJuridica=" + pessoaJuridica.toString() + "]";
	}

	public static List <Fornecedor> cargaFornecedor(){
		List <Fornecedor> listaFornecedor = new ArrayList<>();
		
		listaFornecedor.add(new Fornecedor(new PessoaJuridica("33333333334", "Coca-cola","cocacola", "23256")));
		listaFornecedor.add(new Fornecedor(new PessoaJuridica("33333333334", "Unitins","Unitins", "23256")));
		
		return listaFornecedor;
	}
}
