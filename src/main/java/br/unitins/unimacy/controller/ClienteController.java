package br.unitins.unimacy.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unimacy.model.Cliente;
import br.unitins.unimacy.model.PessoaFisica;
import br.unitins.unimacy.model.PessoaJuridica;
import br.unitins.unimacy.repository.ClienteRepository;

@Named
@ViewScoped
public class ClienteController extends Controller<Cliente> {

	private static final long serialVersionUID = -2587172429280470098L;
	
	private boolean isPessoaJuridica;
	private boolean isFornecedor;

	public ClienteController() {
		super(new ClienteRepository());
	}

	@Override
	public Cliente getEntity() {
		if (entity == null) {
			entity = new Cliente();
			if (isPessoaJuridica) {
				entity.setPessoa(new PessoaJuridica());
			}else {
				entity.setPessoa(new PessoaFisica());
			}
		}

		return entity;
	}

	public boolean getPessoaJuridica() {
		return isPessoaJuridica;
	}

	public void setPessoaJuridica(boolean isPessoaJuridica) {
		this.isPessoaJuridica = isPessoaJuridica;
	}

	public boolean getIsFornecedor() {
		return isFornecedor;
	}

	public void setIsFornecedor(boolean isFornecedor) {
		this.isFornecedor = isFornecedor;
	}

	public void cadastrar() {

	}

	@Override
	public void limpar() {
		if(isPessoaJuridica == false) {
			isFornecedor = false;
		}
		super.limpar();
	}

}
