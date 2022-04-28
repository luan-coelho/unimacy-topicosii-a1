package br.unitins.unimacy.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Query;

import br.unitins.unimacy.model.Cidade;

public class CidadeRepository extends Repository<Cidade> {

	@SuppressWarnings("unchecked")
	public Cidade findOneResultByNome(String nomeCidade, String nomeEstado) {
		List<Cidade> cidades = null;

		try {
			StringBuffer jpsql = new StringBuffer();
			jpsql.append("SELECT ");
			jpsql.append("c ");
			jpsql.append("FROM ");
			jpsql.append("Cidade c ");
			jpsql.append("WHERE ");
			jpsql.append("c.nome LIKE :cidade ");

			Query query = getEntityManager().createQuery(jpsql.toString());
			query.setParameter("cidade", "%" + nomeCidade + "%");

			cidades = (List<Cidade>) query.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao executar o método de find.");
			e.printStackTrace();
		}

		if (!cidades.isEmpty()) {
			List<Cidade> cidadesAux = cidades.stream()
					.filter(cidade -> cidade.getEstado().getNome().equalsIgnoreCase(nomeEstado)).limit(1)
					.collect(Collectors.toList());

			if(!cidadesAux.isEmpty())
				return cidades.get(0);
		}

		return null;
	}
}
