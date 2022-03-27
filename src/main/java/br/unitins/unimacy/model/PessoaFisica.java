package br.unitins.unimacy.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 2489138959144990316L;

	private String nome;
	private String sobreNome;
	
	private Sexo sexo;

	@CPF(message = "Informe um CPF válido")
	private String cpf;
	private String rg;
	private LocalDate dataNascimento;

	public PessoaFisica() {
		// TODO Auto-generated constructor stub
	}

	public PessoaFisica(String nome, String sobreNome, Sexo sexo, @CPF(message = "Informe um CPF válido") String cpf,
			String rg, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

}
