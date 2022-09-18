package org.acme.dto;

import java.math.BigDecimal;

public class ProdutoDto {
        

    private String nome;

    private String descricao;

    private String categoria;

    private BigDecimal preco;

    private String modelo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getModel() {
        return modelo;
    }

    public void setModel(String modelo) {
        this.modelo = modelo;
    }

    

    
}
