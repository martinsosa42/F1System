package com.f1system.service;

import com.f1system.model.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Gestor principal del sistema de Fórmula 1.
 * Centraliza todas las operaciones de registro, gestión y consulta.
 * 
 * @author Escuderías Unidas
 * @version 1.0
 */
public class F1Manager {
    private Map<String, Pais> paises;
    private Map<String, Circuito> circuitos;
    private Map<String, Escuderia> escuderias;
    private Map<String, Piloto> pilotos;
    private Map<String, Auto> autos;
    private Map<String, Mecanico> mecanicos;
    private Map<String, Carrera> carreras;
    
    /**
     * Constructor del gestor F1.
     */
    public F1Manager() {
        this.paises = new HashMap<>();
        this.circuitos = new HashMap<>();
        this.escuderias = new HashMap<>();
        this.pilotos = new HashMap<>();
        this.autos = new HashMap<>();
        this.mecanicos = new HashMap<>();
        this.carreras = new HashMap<>();
    }
    
    // ==================== GESTIÓN DE PAÍSES ====================
    
    /**
     * Registra un nuevo país.
     * @param pais país a registrar
     */
    public void registrarPais(Pais pais) {
        if (paises.containsKey(pais.getCodigo())) {
            throw new IllegalStateException("Ya existe un país con el código " + pais.getCodigo());
        }
        paises.put(pais.getCodigo(), pais);
    }
    
    /**
     * Obtiene un país por su código.
     * @param codigo código del país
     * @return país encontrado o null
     */
    public Pais obtenerPais(String codigo) {
        return paises.get(codigo.toUpperCase());
    }
    
    /**
     * Obtiene todos los países registrados.
     * @return lista de países
     */
    public List<Pais> obtenerTodosPaises() {
        return new ArrayList<>(paises.values());
    }
    
    // ==================== GESTIÓN DE CIRCUITOS ====================
    
    /**
     * Registra un nuevo circuito.
     * @param circuito circuito a registrar
     */
    public void registrarCircuito(Circuito circuito) {
        if (circuitos.containsKey(circuito.getCodigo())) {
            throw new IllegalStateException("Ya existe un circuito con el código " + circuito.getCodigo());
        }
        circuitos.put(circuito.getCodigo(), circuito);
    }
    
    /**
     * Obtiene un circuito por su código.
     * @param codigo código del circuito
     * @return circuito encontrado o null
     */
    public Circuito obtenerCircuito(String codigo) {
        return circuitos.get(codigo.toUpperCase());
    }
    
    /**
     * Obtiene todos los circuitos registrados.
     * @return lista de circuitos
     */
    public List<Circuito> obtenerTodosCircuitos() {
        return new ArrayList<>(circuitos.values());
    }
    
    // ==================== GESTIÓN DE ESCUDERÍAS ====================
    
    /**
     * Registra una nueva escudería.
     * @param escuderia escudería a registrar
     */
    public void registrarEscuderia(Escuderia escuderia) {
        if (escuderias.containsKey(escuderia.getCodigo())) {
            throw new IllegalStateException("Ya existe una escudería con el código " + escuderia.getCodigo());
        }
        escuderias.put(escuderia.getCodigo(), escuderia);
    }
    
    /**
     * Obtiene una escudería por su código.
     * @param codigo código de la escudería
     * @return escudería encontrada o null
     */
    public Escuderia obtenerEscuderia(String codigo) {
        return escuderias.get(codigo.toUpperCase());
    }
    
    /**
     * Obtiene todas las escuderías registradas.
     * @return lista de escuderías
     */
    public List<Escuderia> obtenerTodasEscuderias() {
        return new ArrayList<>(escuderias.values());
    }
    
    // ==================== GESTIÓN DE PILOTOS ====================
    
    /**
     * Registra un nuevo piloto.
     * @param piloto piloto a registrar
     */
    public void registrarPiloto(Piloto piloto) {
        if (pilotos.containsKey(piloto.getCodigo())) {
            throw new IllegalStateException("Ya existe un piloto con el código " + piloto.getCodigo());
        }
        pilotos.put(piloto.getCodigo(), piloto);
    }
    
    /**
     * Obtiene un piloto por su código.
     * @param codigo código del piloto
     * @return piloto encontrado o null
     */
    public Piloto obtenerPiloto(String codigo) {
        return pilotos.get(codigo.toUpperCase());
    }
    
    /**
     * Obtiene todos los pilotos registrados.
     * @return lista de pilotos
     */
    public List<Piloto> obtenerTodosPilotos() {
        return new ArrayList<>(pilotos.values());
    }
    
    /**
     * Asigna un piloto a una escudería.
     * @param codigoPiloto código del piloto
     * @param codigoEscuderia código de la escudería
     */
    public void asignarPilotoEscuderia(String codigoPiloto, String codigoEscuderia) {
        Piloto piloto = obtenerPiloto(codigoPiloto);
        Escuderia escuderia = obtenerEscuderia(codigoEscuderia);
        
        if (piloto == null) {
            throw new IllegalArgumentException("No existe el piloto con código " + codigoPiloto);
        }
        if (escuderia == null) {
            throw new IllegalArgumentException("No existe la escudería con código " + codigoEscuderia);
        }
        
        // Remover de escudería anterior si existe
        if (piloto.getEscuderiaActual() != null) {
            piloto.getEscuderiaActual().removerPiloto(piloto);
        }
        
        piloto.setEscuderiaActual(escuderia);
        escuderia.agregarPiloto(piloto);
    }
    
    // ==================== GESTIÓN DE AUTOS ====================
    
    /**
     * Registra un nuevo auto.
     * @param auto auto a registrar
     */
    public void registrarAuto(Auto auto) {
        if (autos.containsKey(auto.getCodigo())) {
            throw new IllegalStateException("Ya existe un auto con el código " + auto.getCodigo());
        }
        autos.put(auto.getCodigo(), auto);
        auto.getEscuderia().agregarAuto(auto);
    }
    
    /**
     * Obtiene un auto por su código.
     * @param codigo código del auto
     * @return auto encontrado o null
     */
    public Auto obtenerAuto(String codigo) {
        return autos.get(codigo.toUpperCase());
    }
    
    /**
     * Obtiene todos los autos registrados.
     * @return lista de autos
     */
    public List<Auto> obtenerTodosAutos() {
        return new ArrayList<>(autos.values());
    }
    
    // ==================== GESTIÓN DE MECÁNICOS ====================
    
    /**
     * Registra un nuevo mecánico.
     * @param mecanico mecánico a registrar
     */
    public void registrarMecanico(Mecanico mecanico) {
        if (mecanicos.containsKey(mecanico.getCodigo())) {
            throw new IllegalStateException("Ya existe un mecánico con el código " + mecanico.getCodigo());
        }
        mecanicos.put(mecanico.getCodigo(), mecanico);
        mecanico.getEscuderia().agregarMecanico(mecanico);
    }
    
    /**
     * Obtiene un mecánico por su código.
     * @param codigo código del mecánico
     * @return mecánico encontrado o null
     */
    public Mecanico obtenerMecanico(String codigo) {
        return mecanicos.get(codigo.toUpperCase());
    }
    
    /**
     * Obtiene todos los mecánicos registrados.
     * @return lista de mecánicos
     */
    public List<Mecanico> obtenerTodosMecanicos() {
        return new ArrayList<>(mecanicos.values());
    }
    
    // ==================== GESTIÓN DE CARRERAS ====================
    
    /**
     * Registra una nueva carrera.
     * @param carrera carrera a registrar
     */
    public void registrarCarrera(Carrera carrera) {
        if (carreras.containsKey(carrera.getCodigo())) {
            throw new IllegalStateException("Ya existe una carrera con el código " + carrera.getCodigo());
        }
        carreras.put(carrera.getCodigo(), carrera);
    }
    
    /**
     * Obtiene una carrera por su código.
     * @param codigo código de la carrera
     * @return carrera encontrada o null
     */
    public Carrera obtenerCarrera(String codigo) {
        return carreras.get(codigo.toUpperCase());
    }
    
    /**
     * Obtiene todas las carreras registradas.
     * @return lista de carreras
     */
    public List<Carrera> obtenerTodasCarreras() {
        return new ArrayList<>(carreras.values());
    }
    
    /**
     * Registra la participación de un piloto en una carrera.
     * @param codigoCarrera código de la carrera
     * @param codigoPiloto código del piloto
     * @param codigoAuto código del auto
     */
    public void registrarParticipacion(String codigoCarrera, String codigoPiloto, String codigoAuto) {
        Carrera carrera = obtenerCarrera(codigoCarrera);
        Piloto piloto = obtenerPiloto(codigoPiloto);
        Auto auto = obtenerAuto(codigoAuto);
        
        if (carrera == null) {
            throw new IllegalArgumentException("No existe la carrera con código " + codigoCarrera);
        }
        if (piloto == null) {
            throw new IllegalArgumentException("No existe el piloto con código " + codigoPiloto);
        }
        if (auto == null) {
            throw new IllegalArgumentException("No existe el auto con código " + codigoAuto);
        }
        
        Participacion participacion = new Participacion(piloto, auto, carrera);
        carrera.agregarParticipacion(participacion);
    }
    
    /**
     * Registra el resultado de una participación en una carrera.
     * @param codigoCarrera código de la carrera
     * @param codigoPiloto código del piloto
     * @param posicion posición final obtenida
     * @param vueltaRapida si obtuvo la vuelta rápida
     */
    public void registrarResultado(String codigoCarrera, String codigoPiloto, int posicion, boolean vueltaRapida) {
        Carrera carrera = obtenerCarrera(codigoCarrera);
        Piloto piloto = obtenerPiloto(codigoPiloto);
        
        if (carrera == null) {
            throw new IllegalArgumentException("No existe la carrera con código " + codigoCarrera);
        }
        if (piloto == null) {
            throw new IllegalArgumentException("No existe el piloto con código " + codigoPiloto);
        }
        
        Participacion participacion = carrera.getParticipacionPiloto(piloto);
        if (participacion == null) {
            throw new IllegalStateException("El piloto no está participando en esta carrera");
        }
        
        participacion.setPosicionFinal(posicion);
        participacion.setVueltaRapida(vueltaRapida);
    }
    
    // ==================== INFORMES ====================
    
    /**
     * Obtiene las carreras en un rango de fechas.
     * @param fechaInicio fecha de inicio
     * @param fechaFin fecha de fin
     * @return lista de carreras en el rango
     */
    public List<Carrera> obtenerCarrerasPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return carreras.values().stream()
            .filter(c -> {
                LocalDate fechaCarrera = c.getFechaHora().toLocalDate();
                return !fechaCarrera.isBefore(fechaInicio) && !fechaCarrera.isAfter(fechaFin);
            })
            .sorted(Comparator.comparing(Carrera::getFechaHora))
            .collect(Collectors.toList());
    }
    
    /**
     * Obtiene el ranking de pilotos por puntos acumulados.
     * @return lista de pilotos ordenados por puntos (mayor a menor)
     */
    public List<Map.Entry<Piloto, Integer>> obtenerRankingPilotos() {
        Map<Piloto, Integer> puntajesPilotos = new HashMap<>();
        
        for (Carrera carrera : carreras.values()) {
            if (carrera.isFinalizada()) {
                for (Participacion p : carrera.getParticipaciones()) {
                    Piloto piloto = p.getPiloto();
                    int puntos = p.getPuntos() != null ? p.getPuntos() : 0;
                    puntajesPilotos.put(piloto, puntajesPilotos.getOrDefault(piloto, 0) + puntos);
                }
            }
        }
        
        return puntajesPilotos.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .collect(Collectors.toList());
    }
    
    /**
     * Obtiene el histórico de podios de un piloto.
     * @param codigoPiloto código del piloto
     * @return lista de participaciones que resultaron en podio
     */
    public List<Participacion> obtenerPodiosPiloto(String codigoPiloto) {
        Piloto piloto = obtenerPiloto(codigoPiloto);
        if (piloto == null) {
            throw new IllegalArgumentException("No existe el piloto con código " + codigoPiloto);
        }
        
        List<Participacion> podios = new ArrayList<>();
        for (Carrera carrera : carreras.values()) {
            Participacion p = carrera.getParticipacionPiloto(piloto);
            if (p != null && p.esPodio()) {
                podios.add(p);
            }
        }
        
        return podios;
    }
    
    /**
     * Obtiene el histórico de victorias de un piloto.
     * @param codigoPiloto código del piloto
     * @return lista de participaciones que resultaron en victoria
     */
    public List<Participacion> obtenerVictoriasPiloto(String codigoPiloto) {
        Piloto piloto = obtenerPiloto(codigoPiloto);
        if (piloto == null) {
            throw new IllegalArgumentException("No existe el piloto con código " + codigoPiloto);
        }
        
        List<Participacion> victorias = new ArrayList<>();
        for (Carrera carrera : carreras.values()) {
            Participacion p = carrera.getParticipacionPiloto(piloto);
            if (p != null && p.esVictoria()) {
                victorias.add(p);
            }
        }
        
        return victorias;
    }
    
    /**
     * Cuenta las veces que un piloto corrió en un circuito específico.
     * @param codigoPiloto código del piloto
     * @param codigoCircuito código del circuito
     * @return cantidad de veces que corrió
     */
    public int contarCarrerasPilotoEnCircuito(String codigoPiloto, String codigoCircuito) {
        Piloto piloto = obtenerPiloto(codigoPiloto);
        Circuito circuito = obtenerCircuito(codigoCircuito);
        
        if (piloto == null) {
            throw new IllegalArgumentException("No existe el piloto con código " + codigoPiloto);
        }
        if (circuito == null) {
            throw new IllegalArgumentException("No existe el circuito con código " + codigoCircuito);
        }
        
        int contador = 0;
        for (Carrera carrera : carreras.values()) {
            if (carrera.getCircuito().equals(circuito)) {
                Participacion p = carrera.getParticipacionPiloto(piloto);
                if (p != null) {
                    contador++;
                }
            }
        }
        
        return contador;
    }
    
    /**
     * Cuenta las carreras realizadas en un circuito específico.
     * @param codigoCircuito código del circuito
     * @return cantidad de carreras
     */
    public int contarCarrerasEnCircuito(String codigoCircuito) {
        Circuito circuito = obtenerCircuito(codigoCircuito);
        
        if (circuito == null) {
            throw new IllegalArgumentException("No existe el circuito con código " + codigoCircuito);
        }
        
        return (int) carreras.values().stream()
            .filter(c -> c.getCircuito().equals(circuito))
            .count();
    }
    
    /**
     * Obtiene los autos utilizados por una escudería en diferentes carreras.
     * @param codigoEscuderia código de la escudería
     * @return mapa de auto y lista de carreras donde fue utilizado
     */
    public Map<Auto, List<Carrera>> obtenerAutosUtilizadosPorEscuderia(String codigoEscuderia) {
        Escuderia escuderia = obtenerEscuderia(codigoEscuderia);
        
        if (escuderia == null) {
            throw new IllegalArgumentException("No existe la escudería con código " + codigoEscuderia);
        }
        
        Map<Auto, List<Carrera>> autosCarreras = new HashMap<>();
        
        for (Auto auto : escuderia.getAutos()) {
            List<Carrera> carrerasAuto = new ArrayList<>();
            for (Carrera carrera : carreras.values()) {
                for (Participacion p : carrera.getParticipaciones()) {
                    if (p.getAuto().equals(auto)) {
                        carrerasAuto.add(carrera);
                        break;
                    }
                }
            }
            if (!carrerasAuto.isEmpty()) {
                autosCarreras.put(auto, carrerasAuto);
            }
        }
        
        return autosCarreras;
    }
    
    /**
     * Obtiene información de mecánicos por escudería.
     * @param codigoEscuderia código de la escudería
     * @return lista de mecánicos con su información
     */
    public List<Mecanico> obtenerMecanicosPorEscuderia(String codigoEscuderia) {
        Escuderia escuderia = obtenerEscuderia(codigoEscuderia);
        
        if (escuderia == null) {
            throw new IllegalArgumentException("No existe la escudería con código " + codigoEscuderia);
        }
        
        return new ArrayList<>(escuderia.getMecanicos());
    }
}
