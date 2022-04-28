package br.unitins.unimacy.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.unimacy.exception.RepositoryException;
import br.unitins.unimacy.model.Fornecedor;

public class FornecedorRepository extends Repository<Fornecedor> {

	@SuppressWarnings("unchecked")
	public List <Fornecedor> findByNome(String nome) throws RepositoryException{
		List <Fornecedor> lista = null;
		
		try {
			Query query = getEntityManager().createQuery("Select o FROM Fornecedor o WHERE o.nomeFantasia LIKE :nome");
			query.setParameter("nome", "%" + nome + "%");

			lista = query.getResultList();

		} catch (Exception e) {
			System.out.println("Erro ao executar o método de find.");
			e.printStackTrace();
			return null;
		}

		return lista;
	}
}
