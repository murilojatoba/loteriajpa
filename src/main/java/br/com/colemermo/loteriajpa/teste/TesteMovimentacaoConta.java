package br.com.colemermo.loteriajpa.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.colemermo.loteriajpa.modelo.Categoria;
import br.com.colemermo.loteriajpa.modelo.Conta;
import br.com.colemermo.loteriajpa.modelo.Movimentacao;
import br.com.colemermo.loteriajpa.modelo.TipoMovimentacao;
import br.com.colemermo.loteriajpa.util.JPAUtil;

public class TesteMovimentacaoConta {
    
    public static void main(String[] args) {
        Categoria cat1 = new Categoria("Viagem");
        Categoria cat2 = new Categoria("Negócios");
        
        Conta conta = new Conta();
        conta.setId(2);
        
        Movimentacao mov1 = new Movimentacao();
        mov1.setData(Calendar.getInstance()); // hoje
        mov1.setDescricao("Viagem à SP");
        mov1.setTipo(TipoMovimentacao.SAIDA);
        mov1.setValor(new BigDecimal("600.0"));
        mov1.setCategorias(Arrays.asList(cat1, cat2));
        mov1.setConta(conta);
        
        Movimentacao mov2 = new Movimentacao();
        mov2.setData(Calendar.getInstance()); // hoje
        mov2.setDescricao("Viagem à RJ");
        mov2.setTipo(TipoMovimentacao.SAIDA);
        mov2.setValor(new BigDecimal("500.0"));
        mov2.setCategorias(Arrays.asList(cat1, cat2));
        mov2.setConta(conta);
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        em.persist(cat1);
        em.persist(cat2);
        
        em.persist(mov1);
        em.persist(mov2);
        
        em.getTransaction().commit();
        em.close();
    }
    
}
