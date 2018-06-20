package br.com.colemermo.loteriajpa.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private BigDecimal valor;
    
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipo;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data;
    
    private String descricao;
    
    @ManyToOne
    private Conta conta;
    
    @ManyToMany
    private List<Categoria> categorias;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public BigDecimal getValor() {
        return this.valor;
    }
    
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    public TipoMovimentacao getTipo() {
        return this.tipo;
    }
    
    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }
    
    public Calendar getData() {
        return this.data;
    }
    
    public void setData(Calendar data) {
        this.data = data;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Conta getConta() {
        return this.conta;
    }
    
    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    public List<Categoria> getCategorias() {
        return this.categorias;
    }
    
    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    
}
