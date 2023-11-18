package com.example.demo.Entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(nullable = false, length = 100)
    private String codigo;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, length = 100)
    private String descripcion;
    @Column(nullable = false, length = 100)
    private String proveedor;
    @Column(nullable = false, length = 100)
    private double precio;
    @Column(nullable = false, length = 100)
    private double costo;
    @Column(nullable = false, length = 100)
    private int cantidad;

    public Producto(Integer id, String codigo, String nombre, String descripcion, String proveedor, double precio, double costo, int cantidad) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.precio = precio;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}