package br.com.aeroparts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
@Entity
@Table(name = "cotacao")
public class Cotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cotacao_id")
    private Long id;
    @Column(name = "cotacao_data")
    private Date data;
    @Column(name = "preco_unitario")
    private Double preco;


    @JsonIgnore
    @OneToMany(mappedBy = "cotacao", orphanRemoval = true)
    private List<Pedido> pedidos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}