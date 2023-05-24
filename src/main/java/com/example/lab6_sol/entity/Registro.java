package com.example.lab6_sol.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Registro {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "usuarioid")
    private int usuarioid;
    @Basic
    @Column(name = "cursoid")
    private int cursoid;
    @Basic
    @Column(name = "fecharegistro")
    private Date fecharegistro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public int getCursoid() {
        return cursoid;
    }

    public void setCursoid(int cursoid) {
        this.cursoid = cursoid;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

}
