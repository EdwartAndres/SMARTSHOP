package com.example.demo.Entidad;
import jakarta.persistence.*;
@Entity
@Table(name = "Proveedores")

public class Proveedor {
    @Id
    @Column(name = "RUT")
    private Integer rut;

    @Column(name = "Nombre", length = 255)
    private String nombre;

    @Column(name = "Direccion", length = 255)
    private String direccion;

    @Column(name = "Telefono", length = 20)
    private String telefono;

    @Column(name = "CorreoElectronico", length = 255)
    private String correoElectronico;

    @Column(name = "NombreContacto", length = 255)
    private String nombreContacto;

    public Proveedor(Integer rut, String nombre, String direccion, String telefono, String correoElectronico, String nombreContacto) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.nombreContacto = nombreContacto;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
}