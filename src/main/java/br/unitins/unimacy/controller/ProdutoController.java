package br.unitins.unimacy.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unimacy.model.Categoria;
import br.unitins.unimacy.model.Produto;
import br.unitins.unimacy.repository.ProdutoRepository;

@Named
@ViewScoped
public class ProdutoController extends Controller<Produto> {

	private static final long serialVersionUID = -2587172429280470098L;

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
			listaProduto = new ArrayList<>();
			listaProduto.add(new Produto(Arrays.asList(new Categoria("Saúde"))));
		}
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public List <Categoria> getListaCategoria() {
		return Arrays.asList(new Categoria("Genérico"), new Categoria("Saúde"), new Categoria("Medicamentos"), new Categoria("Home Care"));
	}
	
	@Override
	public void limpar() {
		super.limpar();
	}

	public void alterar(Produto Produto) {
		entity = Produto;

		System.out.println(entity);
		// super.alterar();
	}

	public void cadastrar() {
		System.out.println(entity.toString());
		limpar();
	}
	
}
