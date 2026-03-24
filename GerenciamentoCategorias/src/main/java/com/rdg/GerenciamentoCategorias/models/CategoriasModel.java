package com.rdg.GerenciamentoCategorias.models;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_categoria")
public class CategoriasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    public CategoriasModel() { }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id;}

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
