package com.example.demo.Entidad;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDVenta")
    private Integer idVenta;

    @Column(name = "Fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "Empleado", referencedColumnName = "cc_Empleado")
    private empleados empleado;

    @ManyToOne
    @JoinColumn(name = "Cliente", referencedColumnName = "cc_clientes")
    private clientes cliente;

    @Lob
    @Column(name = "PDF", columnDefinition = "bytea")
    private byte[] pdf;

    // Resto de tu entidad...

    public Venta() {
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(empleados empleado) {
        this.empleado = empleado;
    }

    public clientes getCliente() {
        return cliente;
    }

    public void setCliente(clientes cliente) {
        this.cliente = cliente;
    }

    public Venta(Integer idVenta, Date fecha, empleados empleado, clientes cliente) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.empleado = empleado;
        this.cliente = cliente;
    }

    // Getters y setters para el nuevo campo 'pdf'

    public byte[] getPdf() {
        return pdf;
    }

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }
}
