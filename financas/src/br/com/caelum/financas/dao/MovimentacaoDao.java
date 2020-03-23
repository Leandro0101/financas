package br.com.caelum.financas.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class MovimentacaoDao {
	private EntityManager manager;

	public MovimentacaoDao(EntityManager manager) {
		this.manager = manager;
	}

	public Double mediaDaContaPeloTipo(Conta conta, TipoMovimentacao tipo) {

		Query query = manager.createQuery("select avg(m.valor) from Movimentacao m where m.conta=:pConta"
				+ " and m.tipoMovimentacao = :pTipo" + " order by m.valor desc");
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);

		Double media = (Double) query.getSingleResult();
		return media;
	}
}
