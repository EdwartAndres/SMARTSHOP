package com.example.demo.Entidad;

import jakarta.persistence.*;


@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "RUT")
    private Proveedor proveedor;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private double costo;

    @Column(nullable = false)
    private int cantidad;

    public Producto() {
    }

    public Producto(Integer id, String nombre, String descripcion, Proveedor proveedor, double precio, double costo, int cantidad) {
        this.id = id;
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

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
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