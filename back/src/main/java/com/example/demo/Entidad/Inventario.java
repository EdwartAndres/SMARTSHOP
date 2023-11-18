package com.example.demo.Entidad;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Inventario")
public class Inventario {
    @Id
    @Column(name = "id")
    private Integer idProducto;

    @Column(name = "CantidadStock")
    private Integer cantidadStock;

    @Column(name = "PrecioCompra")
    private Double precioCompra;

    @Column(name = "PrecioVenta")
    private Double precioVenta;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @JsonIgnore
    private Producto producto;

    public Inventario(Integer id, Integer cantidadStock, Double precioCompra, Double precioVenta, Producto producto) {
        this.idProducto = id;
        this.cantidadStock = cantidadStock;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.producto = producto;
    }

    public Integer getId() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}