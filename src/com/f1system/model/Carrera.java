package com.f1system.model;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Representa una carrera de Fórmula 1.
 *
 * @author Escuderías Unidas
 * @version 1.0
 */
public class Carrera {
    private String codigo;
    private String nombre;
    private Circuito circuito;
    private LocalDateTime fechaHora;
    private int numeroVueltas;
    private List<Participacion> participaciones;
    private boolean finalizada;

    /**
     * Constructor completo de Carrera.
     *
     * @param codigo Código único de la carrera
     * @param nombre Nombre de la carrera
     * @param circuito Circuito donde se disputa
     * @param fechaHora Fecha y hora de la carrera
     * @param numeroVueltas Número de vueltas de la carrera
     */
    public Carrera(String codigo, String nombre, Circuito circuito, LocalDateTime fechaHora,
                   int numeroVueltas) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de la carrera no puede estar vacío");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la carrera no puede estar vacío");
        }
        if (circuito == null) {
            throw new IllegalArgumentException("El circuito no puede ser nulo");
        }
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora no pueden ser nulas");
        }
        if (numeroVueltas <= 0) {
            throw new IllegalArgumentException("El número de vueltas debe ser positivo");
        }

        this.codigo = codigo.toUpperCase();
        this.nombre = nombre;
        this.circuito = circuito;
        this.fechaHora = fechaHora;
        this.numeroVueltas = numeroVueltas;
        this.participaciones = new ArrayList<>();
        this.finalizada = false;
    }

    /**
     * Obtiene el código de la carrera.
     * @return código de la carrera
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtiene el nombre de la carrera.
     * @return nombre de la carrera
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la carrera.
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la carrera no puede estar vacío");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene el circuito de la carrera.
     * @return circuito
     */
    public Circuito getCircuito() {
        return circuito;
    }

    /**
     * Establece el circuito de la carrera.
     * @param circuito nuevo circuito
     */
    public void setCircuito(Circuito circuito) {
        if (circuito == null) {
            throw new IllegalArgumentException("El circuito no puede ser nulo");
        }
        this.circuito = circuito;
    }

    /**
     * Obtiene la fecha y hora de la carrera.
     * @return fecha y hora
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la carrera.
     * @param fechaHora nueva fecha y hora
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora no pueden ser nulas");
        }
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el número de vueltas de la carrera.
     * @return número de vueltas
     */
    public int getNumeroVueltas() {
        return numeroVueltas;
    }

    /**
     * Establece el número de vueltas de la carrera.
     * @param numeroVueltas nuevo número de vueltas
     */
    public void setNumeroVueltas(int numeroVueltas) {
        if (numeroVueltas <= 0) {
            throw new IllegalArgumentException("El número de vueltas debe ser positivo");
        }
        this.numeroVueltas = numeroVueltas;
    }

    /**
     * Obtiene la lista de participaciones en la carrera.
     * @return lista de participaciones
     */
    public List<Participacion> getParticipaciones() {
        return new ArrayList<>(participaciones);
    }

    /**
     * Agrega una participación a la carrera.
     * Valida que el piloto no esté asignado a más de un auto en esta carrera.
     *
     * @param participacion participación a agregar
     * @throws IllegalStateException si el piloto ya tiene una participación en esta carrera
     */
    public void agregarParticipacion(Participacion participacion) {
        if (participacion == null) {
            throw new IllegalArgumentException("La participación no puede ser nula");
        }

        // Validar que el piloto no esté ya participando con otro auto
        for (Participacion p : participaciones) {
            if (p.getPiloto().equals(participacion.getPiloto())) {
                throw new IllegalStateException("El piloto " + participacion.getPiloto().getNombreCompleto() +
                        " ya tiene una participación en esta carrera");
            }
            // Validar que el auto no esté asignado a otro piloto
            if (p.getAuto().equals(participacion.getAuto())) {
                throw new IllegalStateException("El auto " + participacion.getAuto().getCodigo() +
                        " ya está asignado a otro piloto en esta carrera");
            }
        }

        participaciones.add(participacion);
    }

    /**
     * Remueve una participación de la carrera.
     * @param participacion participación a remover
     */
    public void removerParticipacion(Participacion participacion) {
        participaciones.remove(participacion);
    }

    /**
     * Verifica si la carrera está finalizada.
     * @return true si la carrera está finalizada
     */
    public boolean isFinalizada() {
        return finalizada;
    }

    /**
     * Marca la carrera como finalizada.
     */
    public void finalizarCarrera() {
        this.finalizada = true;
    }

    /**
     * Obtiene la participación de un piloto específico en esta carrera.
     *
     * @param piloto piloto a buscar
     * @return participación del piloto o null si no participa
     */
    public Participacion getParticipacionPiloto(Piloto piloto) {
        for (Participacion p : participaciones) {
            if (p.getPiloto().equals(piloto)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrera carrera = (Carrera) o;
        return Objects.equals(codigo, carrera.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return nombre + " - " + circuito.getNombre() + " (" + fechaHora.toLocalDate() + ")";
    }
}


