package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaConsulta {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = new Conta();
		conta.setId(1);
		
		Query query = manager.createQuery("select m from Movimentacao m where m.conta=:pConta"
		+ " and m.tipoMovimentacao = :pTipo"
		+ " order by m.valor desc");
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
		List<Movimentacao> movimentacoes = query.getResultList();
		for(Movimentacao m : movimentacoes) {
			System.out.println("\nDescricão..:"+m.getDescricao());
			System.out.println("\nValor ..: R$ "+m.getValor());
		}
	}
}
