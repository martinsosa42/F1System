package com.f1system.model;

import java.util.Objects;

/**
 * Representa la participación de un piloto en una carrera específica.
 * 
 * @author Escuderías Unidas
 * @version 1.0
 */
public class Participacion {
    private Piloto piloto;
    private Auto auto;
    private Carrera carrera;
    private Integer posicionFinal;
    private Integer puntos;
    private boolean vueltaRapida;
    private boolean abandono;
    private String motivoAbandono;
    
    /**
     * Constructor de Participación.
     * 
     * @param piloto Piloto que participa
     * @param auto Auto que utiliza
     * @param carrera Carrera en la que participa
     */
    public Participacion(Piloto piloto, Auto auto, Carrera carrera) {
        if (piloto == null) {
            throw new IllegalArgumentException("El piloto no puede ser nulo");
        }
        if (auto == null) {
            throw new IllegalArgumentException("El auto no puede ser nulo");
        }
        if (carrera == null) {
            throw new IllegalArgumentException("La carrera no puede ser nula");
        }
        
        this.piloto = piloto;
        this.auto = auto;
        this.carrera = carrera;
        this.vueltaRapida = false;
        this.abandono = false;
    }
    
    /**
     * Obtiene el piloto de la participación.
     * @return piloto
     */
    public Piloto getPiloto() {
        return piloto;
    }
    
    /**
     * Obtiene el auto de la participación.
     * @return auto
     */
    public Auto getAuto() {
        return auto;
    }
    
    /**
     * Establece el auto de la participación.
     * @param auto nuevo auto
     */
    public void setAuto(Auto auto) {
        if (auto == null) {
            throw new IllegalArgumentException("El auto no puede ser nulo");
        }
        this.auto = auto;
    }
    
    /**
     * Obtiene la carrera de la participación.
     * @return carrera
     */
    public Carrera getCarrera() {
        return carrera;
    }
    
    /**
     * Obtiene la posición final del piloto.
     * @return posición final
     */
    public Integer getPosicionFinal() {
        return posicionFinal;
    }
    
    /**
     * Establece la posición final y calcula los puntos correspondientes.
     * Sistema de puntuación oficial de F1.
     * 
     * @param posicionFinal posición final obtenida
     */
    public void setPosicionFinal(Integer posicionFinal) {
        if (posicionFinal != null && posicionFinal < 1) {
            throw new IllegalArgumentException("La posición final debe ser positiva");
        }
        this.posicionFinal = posicionFinal;
        this.puntos = calcularPuntos(posicionFinal);
    }
    
    /**
     * Calcula los puntos según la posición final.
     * Sistema oficial: 1º=25, 2º=18, 3º=15, 4º=12, 5º=10, 6º=8, 7º=6, 8º=4, 9º=2, 10º=1
     * 
     * @param posicion posición obtenida
     * @return puntos correspondientes
     */
    private int calcularPuntos(Integer posicion) {
        if (posicion == null || abandono) {
            return 0;
        }
        
        switch (posicion) {
            case 1: return 25;
            case 2: return 18;
            case 3: return 15;
            case 4: return 12;
            case 5: return 10;
            case 6: return 8;
            case 7: return 6;
            case 8: return 4;
            case 9: return 2;
            case 10: return 1;
            default: return 0;
        }
    }
    
    /**
     * Obtiene los puntos obtenidos.
     * @return puntos
     */
    public Integer getPuntos() {
        return puntos;
    }
    
    /**
     * Verifica si el piloto obtuvo la vuelta rápida.
     * @return true si obtuvo la vuelta rápida
     */
    public boolean isVueltaRapida() {
        return vueltaRapida;
    }
    
    /**
     * Establece si el piloto obtuvo la vuelta rápida.
     * @param vueltaRapida true si obtuvo la vuelta rápida
     */
    public void setVueltaRapida(boolean vueltaRapida) {
        this.vueltaRapida = vueltaRapida;
    }
    
    /**
     * Verifica si el piloto abandonó la carrera.
     * @return true si abandonó
     */
    public boolean isAbandono() {
        return abandono;
    }
    
    /**
     * Establece si el piloto abandonó la carrera.
     * @param abandono true si abandonó
     * @param motivo motivo del abandono
     */
    public void setAbandono(boolean abandono, String motivo) {
        this.abandono = abandono;
        this.motivoAbandono = motivo;
        if (abandono) {
            this.puntos = 0;
        }
    }
    
    /**
     * Obtiene el motivo del abandono.
     * @return motivo del abandono
     */
    public String getMotivoAbandono() {
        return motivoAbandono;
    }
    
    /**
     * Verifica si la participación resultó en un podio (top 3).
     * @return true si quedó en el podio
     */
    public boolean esPodio() {
        return posicionFinal != null && posicionFinal >= 1 && posicionFinal <= 3 && !abandono;
    }
    
    /**
     * Verifica si ganó la carrera.
     * @return true si quedó primero
     */
    public boolean esVictoria() {
        return posicionFinal != null && posicionFinal == 1 && !abandono;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participacion that = (Participacion) o;
        return Objects.equals(piloto, that.piloto) && 
               Objects.equals(carrera, that.carrera);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(piloto, carrera);
    }
    
    @Override
    public String toString() {
        String resultado = piloto.getNombreCompleto() + " - " + auto.getModelo();
        if (posicionFinal != null) {
            resultado += " - Posición: " + posicionFinal + " (" + puntos + " pts)";
        }
        if (vueltaRapida) {
            resultado += " [VUELTA RÁPIDA]";
        }
        if (abandono) {
            resultado += " [ABANDONO: " + motivoAbandono + "]";
        }
        return resultado;
    }
}
