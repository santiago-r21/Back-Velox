package com.Velox.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class usuario {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    private rol rol;
    private String nombre;
    private String apellido;
    private String pasword;
    private String direccion;

    public usuario() {
    }

    public usuario(int id_usuario, rol rol, String nombre, String apellido, String pasword, String direccion) {
        this.id_usuario = id_usuario;
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pasword = pasword;
        this.direccion = direccion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public rol getRol() {
        return rol;
    }

    public void setRol(rol rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
