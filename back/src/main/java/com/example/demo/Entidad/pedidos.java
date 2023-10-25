package com.example.demo.Entidad;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="pedidos")

public class pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_Pedido")

    private Integer cod_Pedido;

    private LocalDateTime fechapedido;
    @Column(nullable = false, length = 50)

    private int can_Total;
    @Column(nullable = false, length = 80)
    private int costoNeto;
    @ManyToOne
    @JoinColumn(name = "Nit_Distribuidor", referencedColumnName = "Nit_Distribuidor")
    private distribuidores distribuidoresA;

    public pedidos() {

    }

    public pedidos(LocalDateTime fechapedido, int can_Total, int costoNeto, distribuidores distribuidoresA) {
        this.fechapedido = fechapedido;
        this.can_Total = can_Total;
        this.costoNeto = costoNeto;
        this.distribuidoresA = distribuidoresA;
    }

    public Integer getCod_Pedido() {
        return cod_Pedido;
    }

    public void setCod_Pedido(Integer cod_Pedido) {
        this.cod_Pedido = cod_Pedido;
    }

    public LocalDateTime getFechapedido() {
        return fechapedido;
    }

    public void setFechapedido(LocalDateTime fechapedido) {
        this.fechapedido = fechapedido;
    }

    public int getCan_Total() {
        return can_Total;
    }

    public void setCan_Total(int can_Total) {
        this.can_Total = can_Total;
    }

    public int getCostoNeto() {
        return costoNeto;
    }

    public void setCostoNeto(int costoNeto) {
        this.costoNeto = costoNeto;
    }

    public distribuidores getDistribuidoresA() {
        return distribuidoresA;
    }

    public void setDistribuidoresA(distribuidores distribuidoresA) {
        this.distribuidoresA = distribuidoresA;
    }
}