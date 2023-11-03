package com.example.celular.entities;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tb_produto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Produto {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String modelo;
    private double preco;
    @Column(name = "TEXT")
    private String descricao;
    private String cor;

    //Muito para Muitos
    @ManyToMany
    @JoinTable(name = "tb_produto_categoria",
                joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    public Set<Categoria> categorias = new HashSet<>();

    public Set<Categoria> getCategorias(){
        return categorias;
    }

    @OneToMany(mappedBy = "id.produto")
    public Set<Produto> produtos = new HashSet<>();
}
