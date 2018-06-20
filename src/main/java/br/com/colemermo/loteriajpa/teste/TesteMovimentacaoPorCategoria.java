package br.com.colemermo.loteriajpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.colemermo.loteriajpa.modelo.Categoria;
import br.com.colemermo.loteriajpa.modelo.Movimentacao;
import br.com.colemermo.loteriajpa.util.JPAUtil;

public class TesteMovimentacaoPorCategoria {
    
    public static void main(String[] args) {
        Categoria cat = new Categoria();
        cat.setId(1);
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        String jpql = "select m from Movimentacao m join m.categorias c " + " where c = :pCategoria";
        Query query = em.createQuery(jpql);
        query.setParameter("pCategoria", cat);
        
        List<Movimentacao> resultado = query.getResultList();
        
        for (Movimentacao m : resultado) {
            System.out.println("Conta: " + m.getConta().getId() + " Tipo: " + m.getTipo() + " Valor: " + m.getValor()
                    + " Descrição: " + m.getDescricao());
        }
        
        em.getTransaction().commit();
        em.close();
        
    }
    
}
