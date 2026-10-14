package br.com.senai.infoa.backend.projeto_empreendedor.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "empreendedor")
public class Empreendedor {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome; 
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "data_nascimento")
    private java.time.LocalDate dataNascimento;

    //Um empreendedor pode ter varios endereços, sendo assim usamos o @Onetomany
    @OneToMany
    @JoinColumn(name = "id_empreendedor")
    private List<Endereco> enderecos;

    //Varios empreendedores podem ter varios produtos, sendo assim usamos o @ManytoMany
    @ManyToMany
    @JoinTable (
        name = "empreendedor_produto",
        joinColumns = @JoinColumn(name = "id_empreendedor"),
        inverseJoinColumns = @JoinColumn(name = "id_produto") // serve para indicar qual é a coluna que vai ser usada para fazer o join com a tabela de produto
    )
    private List<Produto> produtos;
    // essa estrutura representa o join table entre empreendedor e produto, onde cada empreendedor pode ter varios produtos e cada produto pode pertencer a varios empreendedores.
    public Empreendedor() {
    }
    public Empreendedor(Integer id, String nome, String cpf, java.time.LocalDate dataNascimento, List<Endereco>enderecos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.enderecos = enderecos;
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
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    // essa função serve para retornar a lista de endereços do empreendedor, que é uma lista de objetos do tipo Endereco.
    public List<Endereco> getEnderecos() {
        return enderecos;  
    }
}

//
