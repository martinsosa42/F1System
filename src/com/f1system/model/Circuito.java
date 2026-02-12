package com.f1system.model;

import java.util.Objects;

/**
 * Representa un circuito de Fórmula 1.
 * 
 * @author Escuderías Unidas
 * @version 1.0
 */
public class Circuito {
    private String codigo;
    private String nombre;
    private Pais pais;
    private double longitudKm;
    private int numeroCurvas;
    
    /**
     * Constructor completo de Circuito.
     * 
     * @param codigo Código único del circuito
     * @param nombre Nombre del circuito
     * @param pais País donde se ubica el circuito
     * @param longitudKm Longitud del circuito en kilómetros
     * @param numeroCurvas Número de curvas del circuito
     */
    public Circuito(String codigo, String nombre, Pais pais, double longitudKm, int numeroCurvas) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del circuito no puede estar vacío");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del circuito no puede estar vacío");
        }
        if (pais == null) {
            throw new IllegalArgumentException("El país no puede ser nulo");
        }
        if (longitudKm <= 0) {
            throw new IllegalArgumentException("La longitud del circuito debe ser positiva");
        }
        
        this.codigo = codigo.toUpperCase();
        this.nombre = nombre;
        this.pais = pais;
        this.longitudKm = longitudKm;
        this.numeroCurvas = numeroCurvas;
    }
    
    /**
     * Obtiene el código del circuito.
     * @return código del circuito
     */
    public String getCodigo() {
        return codigo;
    }
    
    /**
     * Obtiene el nombre del circuito.
     * @return nombre del circuito
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre del circuito.
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del circuito no puede estar vacío");
        }
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el país del circuito.
     * @return país del circuito
     */
    public Pais getPais() {
        return pais;
    }
    
    /**
     * Establece el país del circuito.
     * @param pais nuevo país
     */
    public void setPais(Pais pais) {
        if (pais == null) {
            throw new IllegalArgumentException("El país no puede ser nulo");
        }
        this.pais = pais;
    }
    
    /**
     * Obtiene la longitud del circuito.
     * @return longitud en kilómetros
     */
    public double getLongitudKm() {
        return longitudKm;
    }
    
    /**
     * Establece la longitud del circuito.
     * @param longitudKm nueva longitud
     */
    public void setLongitudKm(double longitudKm) {
        if (longitudKm <= 0) {
            throw new IllegalArgumentException("La longitud del circuito debe ser positiva");
        }
        this.longitudKm = longitudKm;
    }
    
    /**
     * Obtiene el número de curvas del circuito.
     * @return número de curvas
     */
    public int getNumeroCurvas() {
        return numeroCurvas;
    }
    
    /**
     * Establece el número de curvas del circuito.
     * @param numeroCurvas nuevo número de curvas
     */
    public void setNumeroCurvas(int numeroCurvas) {
        this.numeroCurvas = numeroCurvas;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circuito circuito = (Circuito) o;
        return Objects.equals(codigo, circuito.codigo);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
    
    @Override
    public String toString() {
        return nombre + " (" + pais.getNombre() + ") - " + longitudKm + " km";
    }
}
