package br.unitins.unimacy.repository;

import javax.persistence.Query;

import br.unitins.unimacy.model.Cliente;

public class ClienteRepository extends Repository<Cliente> {
	
	public Cliente findByNome(String nome) {
		Cliente cliente = null;

		try {
			Query query = getEntityManager().createQuery("Select c FROM PessoaFisica c WHERE c.nome LIKE :nome");
			query.setParameter("nome", "%" + nome + "%");

			cliente = (Cliente) query.getResultList();

		} catch (Exception e) {
			System.out.println("Erro ao executar o método de find.");
			e.printStackTrace();
			return null;
		}

		return cliente;
	}
	
	public Cliente findByCpf(String cpf) {
		Cliente cliente = null;

		try {
			Query query = getEntityManager().createQuery("Select c FROM PessoaFisica c WHERE c.cpf LIKE :cpf");
			query.setParameter("cpf", "%" + cpf + "%");

			cliente = (Cliente) query.getResultList();

		} catch (Exception e) {
			System.out.println("Erro ao executar o método de find.");
			e.printStackTrace();
		}

		return cliente;
	}
}
