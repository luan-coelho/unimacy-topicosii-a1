package br.unitins.unimacy.controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.unimacy.application.Util;
import br.unitins.unimacy.controller.listing.FornecedorListing;
import br.unitins.unimacy.exception.RepositoryException;
import br.unitins.unimacy.model.Fornecedor;
import br.unitins.unimacy.model.PessoaJuridica;
import br.unitins.unimacy.model.Produto;
import br.unitins.unimacy.model.UnidadeMedida;
import br.unitins.unimacy.repository.ProdutoRepository;

@Named
@ViewScoped
public class ProdutoController extends Controller<Produto> {

	private static final long serialVersionUID = -1330527356831135672L;

	private List<Produto> listaProduto;

	private String pesquisa;

	public ProdutoController() {
		super(new ProdutoRepository());
	}

	@Override
	public Produto getEntity() {
		if (entity == null) {
			entity = new Produto();
			entity.setFornecedor(new Fornecedor(new PessoaJuridica()));
		}

		return entity;
	}

	public List<Produto> getListaProduto() {
		if (listaProduto == null) {
			try {
				listaProduto = getRepository().findAll();
			} catch (RepositoryException e) {
				e.printStackTrace();
			}
		}
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public UnidadeMedida[] getUnidadeMedida() {
		return UnidadeMedida.values();
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	@Override
	public void limpar() {
		super.limpar();
		listaProduto = null;
	}

	public void alterar(Produto produto) {
		entity = produto;

		super.alterar();
	}

	public void excluir(Produto produto) {
		entity = produto;
		super.excluir();
	}

	public void pesquisar() {
		List<Produto> listaProdutoAux = null;

		try {
			listaProdutoAux = getRepository().findByNome(this.pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (listaProdutoAux.isEmpty()) {
			Util.addInfoMessage("Nenhum produto encontrado");
			return;
		}

		listaProduto = listaProdutoAux;
	}

	public void abrirFornecedorListing() {
		FornecedorListing listing = new FornecedorListing();
		listing.open();
	}

	public void obterFornecedorListing(SelectEvent<Fornecedor> event) {
		getEntity().setFornecedor(event.getObject());
	}

}
