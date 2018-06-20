package br.com.colemermo.loteriajpa.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.colemermo.loteriajpa.modelo.Conta;
import br.com.colemermo.loteriajpa.modelo.Movimentacao;
import br.com.colemermo.loteriajpa.modelo.TipoMovimentacao;
import br.com.colemermo.loteriajpa.util.JPAUtil;

public class TesteJPARelacionamento {
    
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setBanco("Itau");
        conta.setAgencia("0102");
        conta.setNumero("1234");
        conta.setTitular("Murilo");
        
        Movimentacao mov = new Movimentacao();
        mov.setData(Calendar.getInstance());
        mov.setDescricao("Churrascaria");
        mov.setTipo(TipoMovimentacao.SAIDA);
        mov.setValor(new BigDecimal("200.0"));
        mov.setConta(conta);
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        em.persist(conta);
        em.persist(mov);
        
        em.getTransaction().commit();
        em.close();
    }
    
}
