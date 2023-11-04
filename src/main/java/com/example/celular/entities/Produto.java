package com.example.celular.entities;



import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_produto")
public class Produto {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String modelo;
    private double preco;

    @Column(columnDefinition = "TEXT", name = "DESCRICAO")
    private String descricao;
    private String cor;

    
    //Muito para Muitos
    @ManyToMany
    @JoinTable(name = "tb_produto_categoria",
                joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    public Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "id.produto")
    public Set<Estoque> estoques = new HashSet<>();
    
    public Set<Categoria> getCategorias(){
        return categorias;
    }

    public Set<Estoque> getEstoques() {
        return estoques;
    }

    public List<Pedido> getPedidos() {
        return estoques.stream().map(x -> x.getPedido()).toList();
    }

    public Produto() {
    }
    
    
    public Produto(Long id, String nome, String modelo, double preco, String descricao, String cor) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
        this.preco = preco;
        this.descricao = descricao;
        this.cor = cor;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }    
}
