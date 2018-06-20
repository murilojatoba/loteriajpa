package br.com.colemermo.loteriajpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.colemermo.loteriajpa.modelo.Conta;
import br.com.colemermo.loteriajpa.modelo.Movimentacao;
import br.com.colemermo.loteriajpa.modelo.TipoMovimentacao;
import br.com.colemermo.loteriajpa.util.JPAUtil;

public class TesteJPQL {
    
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        Conta conta = new Conta();
        conta.setId(2);
        
        String jpql = "select m from Movimentacao m where m.conta = :pConta " + "and m.tipo = :pTipo "
                + "order by m.valor";
        Query query = em.createQuery(jpql);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);
        query.setParameter("pConta", conta);
        
        List<Movimentacao> resultados = query.getResultList();
        
        for (Movimentacao movimentacao : resultados) {
            System.out.println("Conta: " + movimentacao.getConta().getId() + " Tipo: " + movimentacao.getTipo()
                    + " Valor: " + movimentacao.getValor() + " Descrição: " + movimentacao.getDescricao());
        }
        
        em.getTransaction().commit();
        em.close();
        
    }
    
}
