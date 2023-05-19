/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudcentroeducativo.entidades;

import java.util.Objects;

/**
 *
 * @author pc
 */
public class Unidad {
    private int id;
    private String codigo;
    private String nombre;
    private String Observaciones;
    private int idcurso;
    private int idtutor;
    private int idaula;

    public Unidad() {
    }

    public Unidad(String codigo, String nombre, String Observaciones, int idcurso, int idtutor, int idaula) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.Observaciones = Observaciones;
        this.idcurso = idcurso;
        this.idtutor = idtutor;
        this.idaula = idaula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public int getIdtutor() {
        return idtutor;
    }

    public void setIdtutor(int idtutor) {
        this.idtutor = idtutor;
    }

    public int getIdaula() {
        return idaula;
    }

    public void setIdaula(int idaula) {
        this.idaula = idaula;
    }

    @Override
    public String toString() {
        return "Unidad{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", Observaciones=" + Observaciones + ", idcurso=" + idcurso + ", idtutor=" + idtutor + ", idaula=" + idaula + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Unidad other = (Unidad) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.codigo, other.codigo);
    }
    
    
}
