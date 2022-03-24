package br.unitins.unimacy.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unimacy.model.Cidade;
import br.unitins.unimacy.model.Cliente;
import br.unitins.unimacy.model.Endereco;

@Named
@ViewScoped
public class ClienteController extends Controller{

	private static final long serialVersionUID = -4241679614403123928L;
	
	private Cliente cliente;
	
	public Cliente getCliente() {
		if(cliente ==  null) {
			cliente = new Cliente();
			cliente.setEndereco(new Endereco());
			cliente.getEndereco().setCidade(new Cidade());;
		}
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
