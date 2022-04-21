package br.unitins.unimacy.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unimacy.model.Categoria;
import br.unitins.unimacy.repository.CategoriaRepository;

@Named
@ViewScoped
public class CategoriaController extends Controller<Categoria> {

	private static final long serialVersionUID = -2587172429280470098L;

	public CategoriaController() {
		super(new CategoriaRepository());
	}

	@Override
	public Categoria getEntity() {
		if (entity == null) {
			entity = new Categoria();
		}

		return entity;
	}

	@Override
	public void limpar() {
		super.limpar();
	}

	public void cadastrar() {
		System.out.println(entity.toString());
		limpar();
	}

}
