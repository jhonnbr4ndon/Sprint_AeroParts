package br.com.aeroparts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private Long id;
    @Column(name = "pedido_data")
    private Date data;
    @Column(name = "pedido_status")
    private String status;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    @JsonIgnore
    @OneToMany(mappedBy = "pedido", orphanRemoval = true)
    private  List<ItemPedido> itemPedidos;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cotacao_id")
    private Cotacao cotacao;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemPedido> getItemPedidos() {
        return itemPedidos;
    }

    public void setItemPedidos(List<ItemPedido> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    public Cotacao getCotacao() {
        return cotacao;
    }

    public void setCotacao(Cotacao cotacao) {
        this.cotacao = cotacao;
    }
}