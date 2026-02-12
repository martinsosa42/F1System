package com.f1system.model;

import java.util.*;

/**
 * Representa una escudería de Fórmula 1.
 * 
 * @author Escuderías Unidas
 * @version 1.0
 */
public class Escuderia {
    private String codigo;
    private String nombre;
    private Pais paisSede;
    private int anioFundacion;
    private List<Piloto> pilotos;
    private List<Auto> autos;
    private List<Mecanico> mecanicos;
    
    /**
     * Constructor completo de Escudería.
     * 
     * @param codigo Código único de la escudería
     * @param nombre Nombre de la escudería
     * @param paisSede País donde tiene sede la escudería
     * @param anioFundacion Año de fundación
     */
    public Escuderia(String codigo, String nombre, Pais paisSede, int anioFundacion) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de la escudería no puede estar vacío");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la escudería no puede estar vacío");
        }
        if (paisSede == null) {
            throw new IllegalArgumentException("El país de sede no puede ser nulo");
        }
        
        this.codigo = codigo.toUpperCase();
        this.nombre = nombre;
        this.paisSede = paisSede;
        this.anioFundacion = anioFundacion;
        this.pilotos = new ArrayList<>();
        this.autos = new ArrayList<>();
        this.mecanicos = new ArrayList<>();
    }
    
    /**
     * Obtiene el código de la escudería.
     * @return código de la escudería
     */
    public String getCodigo() {
        return codigo;
    }
    
    /**
     * Obtiene el nombre de la escudería.
     * @return nombre de la escudería
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre de la escudería.
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la escudería no puede estar vacío");
        }
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el país de sede.
     * @return país de sede
     */
    public Pais getPaisSede() {
        return paisSede;
    }
    
    /**
     * Establece el país de sede.
     * @param paisSede nuevo país de sede
     */
    public void setPaisSede(Pais paisSede) {
        if (paisSede == null) {
            throw new IllegalArgumentException("El país de sede no puede ser nulo");
        }
        this.paisSede = paisSede;
    }
    
    /**
     * Obtiene el año de fundación.
     * @return año de fundación
     */
    public int getAnioFundacion() {
        return anioFundacion;
    }
    
    /**
     * Establece el año de fundación.
     * @param anioFundacion nuevo año de fundación
     */
    public void setAnioFundacion(int anioFundacion) {
        this.anioFundacion = anioFundacion;
    }
    
    /**
     * Obtiene la lista de pilotos de la escudería.
     * @return lista de pilotos
     */
    public List<Piloto> getPilotos() {
        return new ArrayList<>(pilotos);
    }
    
    /**
     * Agrega un piloto a la escudería.
     * @param piloto piloto a agregar
     */
    public void agregarPiloto(Piloto piloto) {
        if (piloto == null) {
            throw new IllegalArgumentException("El piloto no puede ser nulo");
        }
        if (!pilotos.contains(piloto)) {
            pilotos.add(piloto);
        }
    }
    
    /**
     * Remueve un piloto de la escudería.
     * @param piloto piloto a remover
     */
    public void removerPiloto(Piloto piloto) {
        pilotos.remove(piloto);
    }
    
    /**
     * Obtiene la lista de autos de la escudería.
     * @return lista de autos
     */
    public List<Auto> getAutos() {
        return new ArrayList<>(autos);
    }
    
    /**
     * Agrega un auto a la escudería.
     * @param auto auto a agregar
     */
    public void agregarAuto(Auto auto) {
        if (auto == null) {
            throw new IllegalArgumentException("El auto no puede ser nulo");
        }
        if (!autos.contains(auto)) {
            autos.add(auto);
        }
    }
    
    /**
     * Remueve un auto de la escudería.
     * @param auto auto a remover
     */
    public void removerAuto(Auto auto) {
        autos.remove(auto);
    }
    
    /**
     * Obtiene la lista de mecánicos de la escudería.
     * @return lista de mecánicos
     */
    public List<Mecanico> getMecanicos() {
        return new ArrayList<>(mecanicos);
    }
    
    /**
     * Agrega un mecánico a la escudería.
     * @param mecanico mecánico a agregar
     */
    public void agregarMecanico(Mecanico mecanico) {
        if (mecanico == null) {
            throw new IllegalArgumentException("El mecánico no puede ser nulo");
        }
        if (!mecanicos.contains(mecanico)) {
            mecanicos.add(mecanico);
        }
    }
    
    /**
     * Remueve un mecánico de la escudería.
     * @param mecanico mecánico a remover
     */
    public void removerMecanico(Mecanico mecanico) {
        mecanicos.remove(mecanico);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Escuderia that = (Escuderia) o;
        return Objects.equals(codigo, that.codigo);
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
