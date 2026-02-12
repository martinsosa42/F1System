package com.f1system.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Representa un piloto de Fórmula 1.
 * 
 * @author Escuderías Unidas
 * @version 1.0
 */
public class Piloto {
    private String codigo;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Pais nacionalidad;
    private int numeroPiloto;
    private Escuderia escuderiaActual;
    
    /**
     * Constructor completo de Piloto.
     * 
     * @param codigo Código único del piloto
     * @param nombre Nombre del piloto
     * @param apellido Apellido del piloto
     * @param fechaNacimiento Fecha de nacimiento
     * @param nacionalidad Nacionalidad del piloto
     * @param numeroPiloto Número del piloto en competencia
     */
    public Piloto(String codigo, String nombre, String apellido, LocalDate fechaNacimiento, 
                  Pais nacionalidad, int numeroPiloto) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del piloto no puede estar vacío");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del piloto no puede estar vacío");
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido del piloto no puede estar vacío");
        }
        if (nacionalidad == null) {
            throw new IllegalArgumentException("La nacionalidad no puede ser nula");
        }
        if (numeroPiloto < 0 || numeroPiloto > 99) {
            throw new IllegalArgumentException("El número de piloto debe estar entre 0 y 99");
        }
        
        this.codigo = codigo.toUpperCase();
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.numeroPiloto = numeroPiloto;
    }
    
    /**
     * Obtiene el código del piloto.
     * @return código del piloto
     */
    public String getCodigo() {
        return codigo;
    }
    
    /**
     * Obtiene el nombre del piloto.
     * @return nombre del piloto
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre del piloto.
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del piloto no puede estar vacío");
        }
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el apellido del piloto.
     * @return apellido del piloto
     */
    public String getApellido() {
        return apellido;
    }
    
    /**
     * Establece el apellido del piloto.
     * @param apellido nuevo apellido
     */
    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido del piloto no puede estar vacío");
        }
        this.apellido = apellido;
    }
    
    /**
     * Obtiene el nombre completo del piloto.
     * @return nombre completo
     */
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    /**
     * Obtiene la fecha de nacimiento del piloto.
     * @return fecha de nacimiento
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    /**
     * Establece la fecha de nacimiento del piloto.
     * @param fechaNacimiento nueva fecha de nacimiento
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    /**
     * Obtiene la nacionalidad del piloto.
     * @return nacionalidad
     */
    public Pais getNacionalidad() {
        return nacionalidad;
    }
    
    /**
     * Establece la nacionalidad del piloto.
     * @param nacionalidad nueva nacionalidad
     */
    public void setNacionalidad(Pais nacionalidad) {
        if (nacionalidad == null) {
            throw new IllegalArgumentException("La nacionalidad no puede ser nula");
        }
        this.nacionalidad = nacionalidad;
    }
    
    /**
     * Obtiene el número del piloto.
     * @return número del piloto
     */
    public int getNumeroPiloto() {
        return numeroPiloto;
    }
    
    /**
     * Establece el número del piloto.
     * @param numeroPiloto nuevo número
     */
    public void setNumeroPiloto(int numeroPiloto) {
        if (numeroPiloto < 0 || numeroPiloto > 99) {
            throw new IllegalArgumentException("El número de piloto debe estar entre 0 y 99");
        }
        this.numeroPiloto = numeroPiloto;
    }
    
    /**
     * Obtiene la escudería actual del piloto.
     * @return escudería actual
     */
    public Escuderia getEscuderiaActual() {
        return escuderiaActual;
    }
    
    /**
     * Establece la escudería actual del piloto.
     * @param escuderiaActual nueva escudería
     */
    public void setEscuderiaActual(Escuderia escuderiaActual) {
        this.escuderiaActual = escuderiaActual;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piloto piloto = (Piloto) o;
        return Objects.equals(codigo, piloto.codigo);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
    
    @Override
    public String toString() {
        return "#" + numeroPiloto + " " + getNombreCompleto() + " (" + nacionalidad.getCodigo() + ")";
    }
}
