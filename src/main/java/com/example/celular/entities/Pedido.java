package com.example.celular.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataPedido;
    private PedidoStatus status;

        //Muitos para Um
    @ManyToOne
    @JoinColumn(columnDefinition = "cliente_id")
    private Usuario cliente;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    @OneToMany(mappedBy = "id.pedido")
    private Set<Estoque> estoque = new HashSet<>();

    public Set<Estoque> getItems() {
        return estoque;
    }

    public List<Produto> getProdutos() {
        return estoque.stream().map(x -> x.getProduto()).toList();
    }

    public Pedido() {
    }

    

    public Pedido(Long id, Instant dataPedido, PedidoStatus status) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.status = status;
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public Instant getDataPedido() {
        return dataPedido;
    }



    public void setDataPedido(Instant dataPedido) {
        this.dataPedido = dataPedido;
    }



    public PedidoStatus getStatus() {
        return status;
    }



    public void setStatus(PedidoStatus status) {
        this.status = status;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pedido pedido = (Pedido) o;

        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
