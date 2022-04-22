package br.unitins.unimacy.controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unimacy.exception.RepositoryException;
import br.unitins.unimacy.model.Produto;
import br.unitins.unimacy.model.UnidadeMedida;
import br.unitins.unimacy.repository.ProdutoRepository;

@Named
@ViewScoped
public class ProdutoController extends Controller<Produto> {

	private static final long serialVersionUID = -1330527356831135672L;
	
	private List<Produto> listaProduto;

	public ProdutoController() {
		super(new ProdutoRepository());
	}

	@Override
	public Produto getEntity() {
		if (entity == null) {
			entity = new Produto();
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
	
	@Override
	public void limpar() {
		super.limpar();
		listaProduto = null;
	}

	public void alterar(Produto produto) {
		entity = produto;

		super.alterar();
	}
	
	public void selecionarItem(Produto produto) {
		this.entity = produto;
	}
	
	public void excluir(Produto produto) {
		entity = produto;
		super.excluir();
	}
}
