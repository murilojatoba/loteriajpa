package br.com.colemermo.loteriajpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String profissao;
    private String endereco;
    
    @JoinColumn(unique = true)
    @OneToOne
    private Conta conta;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getProfissao() {
        return this.profissao;
    }
    
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    
    public String getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public Conta getConta() {
        return this.conta;
    }
    
    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
}
