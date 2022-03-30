package br.unitins.unimacy.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.gtbr.exception.ViaCepException;
import com.gtbr.exception.ViaCepFormatException;

import br.unitins.unimacy.application.CEPUtil;
import br.unitins.unimacy.application.Util;
import br.unitins.unimacy.model.Cidade;
import br.unitins.unimacy.model.Cliente;
import br.unitins.unimacy.model.Endereco;
import br.unitins.unimacy.model.Estado;
import br.unitins.unimacy.model.PessoaFisica;
import br.unitins.unimacy.model.PessoaJuridica;
import br.unitins.unimacy.model.Sexo;
import br.unitins.unimacy.repository.ClienteRepository;

@Named
@ViewScoped
public class ClienteController extends Controller<Cliente> {

	private static final long serialVersionUID = -2587172429280470098L;

	private boolean isPessoaJuridica;

	public ClienteController() {
		super(new ClienteRepository());
	}

	@Override
	public Cliente getEntity() {
		if (entity == null) {
			entity = new Cliente();
			if (isPessoaJuridica) {
				entity.setPessoa(new PessoaJuridica());
			} else {
				entity.setPessoa(new PessoaFisica());
//				if(isFornecedor) {
//					entity = new Fornecedor();
//				}

			}

			entity.setEndereco(new Endereco(new Cidade(new Estado())));
		}

		return entity;
	}

	public Sexo[] getListaSexo() {
		return Sexo.values();
	}

	public boolean getPessoaJuridica() {
		return isPessoaJuridica;
	}

	public void setPessoaJuridica(boolean isPessoaJuridica) {
		this.isPessoaJuridica = isPessoaJuridica;
	}

	public void cadastrar() {
		System.out.println(entity.getPessoa().toString());
	}

	@Override
	public void limpar() {
		super.limpar();
	}

	public void buscarCep() {
		try {
			entity.setEndereco(CEPUtil.findCep(CEPUtil.removeMascaraCep(entity.getEndereco().getCep())));
		} catch (ViaCepException e) {
			Util.addErrorMessage("Informe um CEP válido");
		} catch (ViaCepFormatException e) {
			Util.addErrorMessage("CEP com formato inválido");
		} catch (Exception e) {
			Util.addErrorMessage("Falha ao buscar CEP. Digite os dados");
		}

	}

}
