package br.com.aeroparts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private Long id;
    @Column(name = "produto_nome")
    private String nome;
    @Column(name = "produto_descricao")
    private String descricao;
    @Column(name = "produto_preco")
    private Double preco;


    @JsonIgnore
    @OneToMany(mappedBy = "produto", orphanRemoval = true)
    private List<ItemPedido> itemPedidos;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<ItemPedido> getItemPedidos() {
        return itemPedidos;
    }

    public void setItemPedidos(List<ItemPedido> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}

