package com.example.celular.entities;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_estoque")
@NoArgsConstructor
@Getter
@Setter
public class Estoque {

    @EmbeddedId
    private EstoquePK id = new EstoquePK();

    private Integer quantidade;
    private double preco;

    public Estoque(Pedido pedido, Produto produto, Integer quantidade, double preco){
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;

    }

    @OneToMany(mappedBy = "id.estoque")
    public Set<Estoque> itens = new HashSet<>();

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
}
