package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setId(1);
		conta.setTitular("Leandro Vieira Lima");
		conta.setBanco("CAIXA");
		conta.setNumero("391");
		conta.setAgencia("8123");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Pagamento de dívida");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal("90.50"));
		movimentacao.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
//		Conta removerConta = em.find(Conta.class, 9);
		em.merge(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		
		em.close();

	}

}
