package com.example.demo.Entidad;

import jakarta.persistence.*;

@Entity
@Table(name="detalles")

public class detalles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_Identificacion")

    private Integer cod_Identificacion;
    @Column(nullable = false, length = 80)
    private int cantidad;
    @Column(nullable = false, length = 80)
    private int precio;
    @Column(nullable = false, length = 80)
    private int pago;





    @ManyToOne
    @JoinColumn(name = "cod_Producto", referencedColumnName = "cod_Producto")

    private productos productos;
    @ManyToOne
    @JoinColumn(name = "cod_Compra", referencedColumnName = "cod_Compra")

    private comprar comprar;


    public detalles() {

    }

    public detalles(Integer cod_Identificacion, int cantidad, int precio, int pago, com.example.demo.Entidad.productos productos, com.example.demo.Entidad.comprar comprar) {
        this.cod_Identificacion = cod_Identificacion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.pago = pago;
        this.productos = productos;
        this.comprar = comprar;
    }

    public Integer getCod_Identificacion() {
        return cod_Identificacion;
    }

    public void setCod_Identificacion(Integer cod_Identificacion) {
        this.cod_Identificacion = cod_Identificacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public com.example.demo.Entidad.productos getProductos() {
        return productos;
    }

    public void setProductos(com.example.demo.Entidad.productos productos) {
        this.productos = productos;
    }

    public com.example.demo.Entidad.comprar getComprar() {
        return comprar;
    }

    public void setComprar(com.example.demo.Entidad.comprar comprar) {
        this.comprar = comprar;
    }
}