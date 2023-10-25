package com.example.demo.Entidad;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="comprar")

public class comprar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_Compra")

    private Integer cod_Compra;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalDateTime fecha;
    @Column(nullable = false, length = 80)
    private int total_compra;
    @Column(nullable = false, length = 80)
    private String iva;
    @Column(nullable = false, length = 80)
    private int pago;
    @Column(nullable = false, length = 80)
    private int vueltas;
    @Column(nullable = false, length = 80)
    private String dEstablecimiento;
    @Column(nullable = false, length = 80)
    private String metodoPago;
    @ManyToOne
    @JoinColumn(name = "cc_clientes", referencedColumnName = "cc_clientes")

    private clientes clientes;

    @ManyToOne
    @JoinColumn(name = "cc_Empleado", referencedColumnName = "cc_Empleado")

    private empleados empleados;

    public comprar() {

    }

    public comprar(Integer cod_Compra, LocalDateTime fecha, int total_compra, String iva, int pago, int vueltas, String dEstablecimiento, String metodoPago, com.example.demo.Entidad.clientes clientes, com.example.demo.Entidad.empleados empleados) {
        this.cod_Compra = cod_Compra;
        this.fecha = fecha;
        this.total_compra = total_compra;
        this.iva = iva;
        this.pago = pago;
        this.vueltas = vueltas;
        this.dEstablecimiento = dEstablecimiento;
        this.metodoPago = metodoPago;
        this.clientes = clientes;
        this.empleados = empleados;
    }

    public Integer getCod_Compra() {
        return cod_Compra;
    }

    public void setCod_Compra(Integer cod_Compra) {
        this.cod_Compra = cod_Compra;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getTotal_compra() {
        return total_compra;
    }

    public void setTotal_compra(int total_compra) {
        this.total_compra = total_compra;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public int getVueltas() {
        return vueltas;
    }

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }

    public String getdEstablecimiento() {
        return dEstablecimiento;
    }

    public void setdEstablecimiento(String dEstablecimiento) {
        this.dEstablecimiento = dEstablecimiento;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public com.example.demo.Entidad.clientes getClientes() {
        return clientes;
    }

    public void setClientes(com.example.demo.Entidad.clientes clientes) {
        this.clientes = clientes;
    }

    public com.example.demo.Entidad.empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(com.example.demo.Entidad.empleados empleados) {
        this.empleados = empleados;
    }
}