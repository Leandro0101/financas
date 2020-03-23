package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {
		
		
//		Conta conta = new Conta();
//		conta.setId(2);
//		conta.setTitular("Francisca Vanesca");
//		conta.setBanco("AWT");
//		conta.setNumero("2004");
//		conta.setAgencia("8108");
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Conta removerConta = em.find(Conta.class, 9);
		em.remove(removerConta);
		//System.out.println(conta.getId());
		em.getTransaction().commit();
		
		em.close();

	}

}
