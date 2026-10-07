package br.com.senai.infoa.backend.projeto_empreendedor.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name = "produto")
public class Produto {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "data_fabricacao")
    private java.time.LocalDate dataFabricacao;
    @Column(name = "preco")
    private Double preco; //Usamos o Double para representar o preço, pois ele permite valores decimais, o que é importante para representar preços de produtos de forma precisa.

    //Varios produtos podem pertencer a varios empreendedores, sendo assim usamos o @Manytomany
    @ManyToMany 
    @JoinTable (
        name = "empreendedor_produto", 
        joinColumns = @JoinColumn(name = "id_produto"),
        inverseJoinColumns = @JoinColumn(name = "id_empreendedor") 
    )
    private List<Empreendedor> empreendedores; // essa estrutura representa o join table entre empreendedor e produto, onde cada empreendedor pode ter varios produtos e cada produto pode pertencer a varios empreendedores.

    public Produto() {
    }
    public Produto(Integer id, String nome, java.time.LocalDate dataFabricacao, Double preco, List<Empreendedor> empreendedores) {
        this.id = id;
        this.nome = nome;
        this.dataFabricacao = dataFabricacao;
        this.preco = preco;
        this.empreendedores = empreendedores;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public java.time.LocalDate getDataFabricacao() {
        return dataFabricacao;
    }
    public void setDataFabricacao(java.time.LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public List<Empreendedor> getEmpreendedores() {
        return empreendedores;
    }
    public void setEmpreendedores(List<Empreendedor> empreendedores) {
        this.empreendedores = empreendedores;
    }
}
