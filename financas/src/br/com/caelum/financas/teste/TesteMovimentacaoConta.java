package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes");
		List<Conta> contas = query.getResultList();
		for (Conta conta : contas) {
			System.out.println("Número de movimentações : "+conta.getMovimentacoes().size());
		}
		//Conta conta = manager.find(Conta.class, 1);
		//System.out.println(conta.getMovimentacoes().size());

	}

}
