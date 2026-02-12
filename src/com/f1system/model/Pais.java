package com.f1system.model;

import java.util.Objects;

/**
 * Representa un país que puede albergar circuitos de Fórmula 1.
 * 
 * @author Escuderías Unidas
 * @version 1.0
 */
public class Pais {
    private String codigo;
    private String nombre;
    private String continente;
    
    /**
     * Constructor completo de País.
     * 
     * @param codigo Código ISO del país (ej: "AR", "ES")
     * @param nombre Nombre del país
     * @param continente Continente al que pertenece
     */
    public Pais(String codigo, String nombre, String continente) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del país no puede estar vacío");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del país no puede estar vacío");
        }
        this.codigo = codigo.toUpperCase();
        this.nombre = nombre;
        this.continente = continente;
    }
    
    /**
     * Obtiene el código del país.
     * @return código del país
     */
    public String getCodigo() {
        return codigo;
    }
    
    /**
     * Obtiene el nombre del país.
     * @return nombre del país
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre del país.
     * @param nombre nuevo nombre del país
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del país no puede estar vacío");
        }
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el continente del país.
     * @return continente del país
     */
    public String getContinente() {
        return continente;
    }
    
    /**
     * Establece el continente del país.
     * @param continente nuevo continente
     */
    public void setContinente(String continente) {
        this.continente = continente;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(codigo, pais.codigo);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
    
    @Override
    public String toString() {
        return nombre + " (" + codigo + ")";
    }
}
