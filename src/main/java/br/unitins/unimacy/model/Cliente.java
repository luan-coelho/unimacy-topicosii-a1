package br.unitins.unimacy.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 3809727639444385556L;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="pessoa_id", unique=true)
	private Pessoa pessoa;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(Pessoa pessoa) {
		super();
		this.pessoa = pessoa;
	}
	
	public Cliente(Pessoa pessoa, Endereco endereco) {
		super(endereco);
		this.pessoa = pessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Cliente [pessoa=" + pessoa.toString() + "]";
	}

	public static List <Cliente> cargaCliente(){
		List <Cliente> listaCliente = new ArrayList<>();
		listaCliente.add(new Cliente(new PessoaFisica("Luan", "Coêlho de Souza", Sexo.MASCULINO, "996.664.800-34", LocalDate.now(), false)));
		listaCliente.add(new Cliente(new PessoaFisica("Ana", "Silva Aparecida", Sexo.FEMININO, "299.728.860-69", LocalDate.now(), false)));
		listaCliente.add(new Cliente(new PessoaFisica("Thiago", "Coêlho Fernandes", Sexo.MASCULINO, "411.530.520-75", LocalDate.now(), false)));

		return listaCliente;
	}
}
