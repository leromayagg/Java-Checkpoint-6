package com.example.celular.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import jakarta.persistence.*;
@Entity
@Table(name = "tb_usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String pais;
    private String telefone;
    private LocalDate datadenascimento;

    
        //Um para Muitos
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();


    public Usuario() {
    }


    public Usuario(Long id, String nome, String sobrenome, String email, String senha, String pais, String telefone,
            LocalDate datadenascimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.pais = pais;
        this.telefone = telefone;
        this.datadenascimento = datadenascimento;
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


    public String getSobrenome() {
        return sobrenome;
    }


    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getPais() {
        return pais;
    }


    public void setPais(String pais) {
        this.pais = pais;
    }


    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public LocalDate getDatadenascimento() {
        return datadenascimento;
    }


    public void setDatadenascimento(LocalDate datadenascimento) {
        this.datadenascimento = datadenascimento;
    }


    public List<Pedido> getPedidos(){
        return pedidos;
    }

    @Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
}
