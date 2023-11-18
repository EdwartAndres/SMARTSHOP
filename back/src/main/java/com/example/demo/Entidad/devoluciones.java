package com.example.demo.Entidad;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Devoluciones")
public class devoluciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDDevolucion")
    private Long idDevolucion;

    @Column(name = "FechaDevolucion")
    private Date fechaDevolucion;

    @ManyToOne
    @JoinColumn(name = "Cliente", referencedColumnName = "cc_clientes")
    private clientes cliente;

    @ManyToOne
    @JoinColumn(name = "Producto", referencedColumnName = "id")
    private Producto producto;

    @Column(name = "Cantidad")
    private int cantidad;

    @Column(name = "MotivoDevolucion", columnDefinition = "TEXT")
    private String motivoDevolucion;

    public devoluciones() {
    }

    public Long getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(Long idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public clientes getCliente() {
        return cliente;
    }

    public void setCliente(clientes cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMotivoDevolucion() {
        return motivoDevolucion;
    }

    public void setMotivoDevolucion(String motivoDevolucion) {
        this.motivoDevolucion = motivoDevolucion;
    }
}
