package com.example.demo.Entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @Column(name = "IDProducto")
    private Integer idProducto;

    @Column(name = "Nombre", length = 255)
    private String nombre;

    @Column(name = "Descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "Categoria", length = 50)
    private String categoria;

    @Column(name = "Marca", length = 50)
    private String marca;

    @Column(name = "Imagen", length = 255)
    private String imagen;

    public Producto(Integer idProducto, String nombre, String descripcion, String categoria, String marca, String imagen) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.marca = marca;
        this.imagen = imagen;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}