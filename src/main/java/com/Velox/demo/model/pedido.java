package com.Velox.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;


@Entity
public class pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido;
    private LocalDateTime fecha;
    private estado_pedido estadoPedido;
    private double total;
    private int id_usuario;

    public pedido() {
    }

    public pedido(int id_pedido, LocalDateTime fecha, estado_pedido estadoPedido, double total, int id_usuario) {
        this.id_pedido = id_pedido;
        this.fecha = fecha;
        this.estadoPedido = estadoPedido;
        this.total = total;
        this.id_usuario = id_usuario;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public estado_pedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(estado_pedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
