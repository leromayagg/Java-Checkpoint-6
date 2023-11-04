package com.example.celular.entities;

import java.util.Objects;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_estoque")
public class Estoque {

    @EmbeddedId
    private EstoquePK id = new EstoquePK();

    private Integer quantidade;
    private double preco;

    
    /*@OneToMany(mappedBy = "id.estoque")
    public Set<Estoque> estoque = new HashSet<>();*/

    public Pedido getPedido() {
        return id.getPedido();
    }

    public void setPedido(Pedido pedido){
        id.setPedido(pedido);
    }
    
    public Produto getProduto() {
        return id.getProduto();
    }

    public void setProduto(Produto produto){
        id.setProduto(produto);
    }
    
    public Estoque() {
    }


    public Estoque(Pedido pedido, Produto produto, Integer quantidade, double preco){
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;

    }


    public EstoquePK getId() {
        return id;
    }


    public void setId(EstoquePK id) {
        this.id = id;
    }


    public Integer getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }


    public double getPreco() {
        return preco;
    }


    public void setPreco(double preco) {
        this.preco = preco;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estoque estoque = (Estoque) o;

        return Objects.equals(id, estoque.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
