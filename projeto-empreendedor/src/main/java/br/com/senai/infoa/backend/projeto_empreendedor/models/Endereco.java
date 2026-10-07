package br.com.senai.infoa.backend.projeto_empreendedor.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity 
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cep")
    private Integer cep;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "logradouro")
    private String logradouro;

    //Varios endereços podem pertencer a um empreendedor, sendo assim usamos o @ManytoOne

    @ManyToOne 
    @JoinColumn (name = "id_empreendedor")
    private Empreendedor empreendedor; // essa estrutura representa o join table entre empreendedor e endereço, onde cada empreendedor pode ter varios endereços e cada endereço pertence a um empreendedor.


    public Endereco() {
    }
    public Endereco(Integer id, Integer cep, Integer numero, String logradouro, Empreendedor empreendedor) {
        this.id = id;
        this.cep = cep;
        this.numero = numero;
        this.logradouro = logradouro;
        this.empreendedor = empreendedor;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCep() {
        return cep;
    }
    public void setCep(Integer cep) {
        this.cep = cep;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro; // serve para indicar o logradouro do endereço, que é o nome da rua, avenida, etc. onde o empreendedor reside.
    }
    public Empreendedor getEmpreendedor() {
        return empreendedor;
    }
    public void setEmpreendedor(Empreendedor empreendedor) {
        this.empreendedor = empreendedor;
    }
}

