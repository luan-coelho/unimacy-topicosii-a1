package br.unitins.unimacy.model;

public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 5775140670357351776L;

	// @CNPJ(message = "Informe um CNPJ válido")
	private String cnpj;

	public PessoaJuridica() {
		// TODO Auto-generated constructor stub
	}

	public PessoaJuridica(String cnpj) {
		super();
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
