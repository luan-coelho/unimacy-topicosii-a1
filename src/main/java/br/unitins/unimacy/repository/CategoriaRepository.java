package br.unitins.unimacy.repository;

import javax.persistence.Query;

import br.unitins.unimacy.model.Categoria;

public class CategoriaRepository extends Repository<Categoria> {

	public Categoria findByNome(String nome) {
		Categoria categoria = null;

		try {
			Query query = getEntityManager().createQuery("Select o FROM Categoria o WHERE O.nome LIKE :nome");

			query.setParameter("nome", "%" + nome + "%");

			categoria = (Categoria) query.getResultList();

		} catch (Exception e) {
			System.out.println("Erro ao executar o método de find.");
			e.printStackTrace();
		}

		return categoria;
	}
}
