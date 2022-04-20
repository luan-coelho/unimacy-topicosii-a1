package br.unitins.unimacy.controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.gtbr.exception.ViaCepException;
import com.gtbr.exception.ViaCepFormatException;

import br.unitins.unimacy.application.ApiCep;
import br.unitins.unimacy.application.Session;
import br.unitins.unimacy.application.Util;
import br.unitins.unimacy.model.Cidade;
import br.unitins.unimacy.model.Endereco;
import br.unitins.unimacy.model.Estado;
import br.unitins.unimacy.model.Fornecedor;
import br.unitins.unimacy.model.PessoaJuridica;
import br.unitins.unimacy.repository.FornecedorRepository;

@Named
@ViewScoped
public class FornecedorController extends Controller<Fornecedor> {

	private static final long serialVersionUID = -2587172429280470098L;

	private List<Fornecedor> listaFornecedor;

	public FornecedorController() {
		super(new FornecedorRepository());
	}

	@Override
	public Fornecedor getEntity() {
		if (entity == null) {
			entity = new Fornecedor(new PessoaJuridica());
			entity.getPessoaJuridica().setEndereco(new Endereco(new Cidade(new Estado())));
		}

		return entity;
	}

	public List<Fornecedor> getListaFornecedor() {
		if (listaFornecedor == null) {
			listaFornecedor = Fornecedor.cargaFornecedor();
		}
		return listaFornecedor;
	}

	public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
	}

	@Override
	public void limpar() {
		super.limpar();
	}

	public void buscarCep() {
		try {
			entity.getPessoaJuridica().setEndereco(ApiCep.findCep(entity.getPessoaJuridica().getEndereco().getCep()));
		} catch (ViaCepException e) {
			Util.addErrorMessage("Informe um CEP válido");
		} catch (ViaCepFormatException e) {
			Util.addErrorMessage("CEP com formato inválido");
		} catch (Exception e) {
			Util.addErrorMessage("Falha ao buscar CEP. Digite os dados");
		}

	}
	
	public void onItemSelect() {
		String nomeEstado = entity.getPessoaJuridica().getEndereco().getCidade().getEstado().getNome();

		Session.getInstance().set("nome-estado", nomeEstado);
	}

	
	public void alterar(Fornecedor Fornecedor) {
		entity = Fornecedor;

		System.out.println(entity);
		// super.alterar();
	}

	public void cadastrar() {
		System.out.println(entity.toString());
		limpar();
	}
	
}
