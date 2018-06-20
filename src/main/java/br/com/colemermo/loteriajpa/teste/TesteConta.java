package br.com.colemermo.loteriajpa.teste;

import javax.persistence.EntityManager;

import br.com.colemermo.loteriajpa.modelo.Conta;
import br.com.colemermo.loteriajpa.util.JPAUtil;

public class TesteConta {
    
    public static void main(String[] args) {
        
        Conta conta = new Conta();
        conta.setTitular("Danilo");
        conta.setBanco("Banco do Brasil");
        conta.setAgencia("123");
        conta.setNumero("456");
        
        EntityManager em = new JPAUtil().getEntityManager();
        
        em.getTransaction().begin();
        em.persist(conta);
        
        conta.setBanco("Bradesco");
        
        em.getTransaction().commit();
        
        em.close();
    }
    
}
