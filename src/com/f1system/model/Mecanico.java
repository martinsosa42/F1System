package com.f1system.model;

import java.util.Objects;

/**
 * Representa un mecánico especializado de Fórmula 1.
 * 
 * @author Escuderías Unidas
 * @version 1.0
 */
public class Mecanico {
    private String codigo;
    private String nombre;
    private String apellido;
    private Escuderia escuderia;
    private String especialidad;
    private int aniosExperiencia;
    
    /**
     * Constructor completo de Mecánico.
     * 
     * @param codigo Código único del mecánico
     * @param nombre Nombre del mecánico
     * @param apellido Apellido del mecánico
     * @param escuderia Escudería a la que pertenece
     * @param especialidad Especialidad del mecánico
     * @param aniosExperiencia Años de experiencia
     */
    public Mecanico(String codigo, String nombre, String apellido, Escuderia escuderia,
                    String especialidad, int aniosExperiencia) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del mecánico no puede estar vacío");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del mecánico no puede estar vacío");
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido del mecánico no puede estar vacío");
        }
        if (escuderia == null) {
            throw new IllegalArgumentException("La escudería no puede ser nula");
        }
        
        this.codigo = codigo.toUpperCase();
        this.nombre = nombre;
        this.apellido = apellido;
        this.escuderia = escuderia;
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
    }
    
    /**
     * Obtiene el código del mecánico.
     * @return código del mecánico
     */
    public String getCodigo() {
        return codigo;
    }
    
    /**
     * Obtiene el nombre del mecánico.
     * @return nombre del mecánico
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre del mecánico.
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del mecánico no puede estar vacío");
        }
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el apellido del mecánico.
     * @return apellido del mecánico
     */
    public String getApellido() {
        return apellido;
    }
    
    /**
     * Establece el apellido del mecánico.
     * @param apellido nuevo apellido
     */
    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido del mecánico no puede estar vacío");
        }
        this.apellido = apellido;
    }
    
    /**
     * Obtiene el nombre completo del mecánico.
     * @return nombre completo
     */
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    /**
     * Obtiene la escudería del mecánico.
     * @return escudería
     */
    public Escuderia getEscuderia() {
        return escuderia;
    }
    
    /**
     * Establece la escudería del mecánico.
     * @param escuderia nueva escudería
     */
    public void setEscuderia(Escuderia escuderia) {
        if (escuderia == null) {
            throw new IllegalArgumentException("La escudería no puede ser nula");
        }
        this.escuderia = escuderia;
    }
    
    /**
     * Obtiene la especialidad del mecánico.
     * @return especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }
    
    /**
     * Establece la especialidad del mecánico.
     * @param especialidad nueva especialidad
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    /**
     * Obtiene los años de experiencia del mecánico.
     * @return años de experiencia
     */
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }
    
    /**
     * Establece los años de experiencia del mecánico.
     * @param aniosExperiencia nuevos años de experiencia
     */
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mecanico mecanico = (Mecanico) o;
        return Objects.equals(codigo, mecanico.codigo);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
    
    @Override
    public String toString() {
        return getNombreCompleto() + " - " + especialidad + " (" + aniosExperiencia + " años)";
    }
}
