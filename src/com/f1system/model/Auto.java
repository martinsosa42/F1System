package com.f1system.model;

import java.util.Objects;

/**
 * Representa un auto de Fórmula 1.
 *
 * @author Escuderías Unidas
 * @version 1.0
 */
public class Auto {
    private String codigo;
    private String modelo;
    private Escuderia escuderia;
    private int anioFabricacion;
    private String motor;
    private int potenciaHP;

    /**
     * Constructor completo de Auto.
     *
     * @param codigo Código único del auto
     * @param modelo Modelo del auto
     * @param escuderia Escudería a la que pertenece
     * @param anioFabricacion Año de fabricación
     * @param motor Tipo de motor
     * @param potenciaHP Potencia en caballos de fuerza
     */
    public Auto(String codigo, String modelo, Escuderia escuderia, int anioFabricacion,
                String motor, int potenciaHP) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del auto no puede estar vacío");
        }
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo del auto no puede estar vacío");
        }
        if (escuderia == null) {
            throw new IllegalArgumentException("La escudería no puede ser nula");
        }

        this.codigo = codigo.toUpperCase();
        this.modelo = modelo;
        this.escuderia = escuderia;
        this.anioFabricacion = anioFabricacion;
        this.motor = motor;
        this.potenciaHP = potenciaHP;
    }

    /**
     * Obtiene el código del auto.
     * @return código del auto
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtiene el modelo del auto.
     * @return modelo del auto
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del auto.
     * @param modelo nuevo modelo
     */
    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo del auto no puede estar vacío");
        }
        this.modelo = modelo;
    }

    /**
     * Obtiene la escudería del auto.
     * @return escudería
     */
    public Escuderia getEscuderia() {
        return escuderia;
    }

    /**
     * Establece la escudería del auto.
     * @param escuderia nueva escudería
     */
    public void setEscuderia(Escuderia escuderia) {
        if (escuderia == null) {
            throw new IllegalArgumentException("La escudería no puede ser nula");
        }
        this.escuderia = escuderia;
    }

    /**
     * Obtiene el año de fabricación.
     * @return año de fabricación
     */
    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    /**
     * Establece el año de fabricación.
     * @param anioFabricacion nuevo año
     */
    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    /**
     * Obtiene el tipo de motor.
     * @return tipo de motor
     */
    public String getMotor() {
        return motor;
    }

    /**
     * Establece el tipo de motor.
     * @param motor nuevo tipo de motor
     */
    public void setMotor(String motor) {
        this.motor = motor;
    }

    /**
     * Obtiene la potencia en HP.
     * @return potencia en caballos de fuerza
     */
    public int getPotenciaHP() {
        return potenciaHP;
    }

    /**
     * Establece la potencia en HP.
     * @param potenciaHP nueva potencia
     */
    public void setPotenciaHP(int potenciaHP) {
        this.potenciaHP = potenciaHP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Objects.equals(codigo, auto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return escuderia.getNombre() + " " + modelo + " (" + codigo + ")";
    }
}
