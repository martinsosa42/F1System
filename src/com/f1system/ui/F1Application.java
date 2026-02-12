package com.f1system.ui;

import com.f1system.model.*;
import com.f1system.service.F1Manager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * Interfaz de usuario principal del sistema de gestión de Fórmula 1.
 * 
 * @author Escuderías Unidas
 * @version 1.0
 */
public class F1Application {
    private F1Manager manager;
    private Scanner scanner;
    private DateTimeFormatter dateFormatter;
    private DateTimeFormatter dateTimeFormatter;
    
    /**
     * Constructor de la aplicación.
     */
    public F1Application() {
        this.manager = new F1Manager();
        this.scanner = new Scanner(System.in);
        this.dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        cargarDatosEjemplo();
    }
    
    /**
     * Inicia la aplicación.
     */
    public void iniciar() {
        System.out.println("===========================================");
        System.out.println("   SISTEMA DE GESTIÓN FÓRMULA 1");
        System.out.println("   Escuderías Unidas");
        System.out.println("===========================================\n");
        
        boolean continuar = true;
        while (continuar) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    menuRegistros();
                    break;
                case 2:
                    menuGestion();
                    break;
                case 3:
                    menuCarreras();
                    break;
                case 4:
                    menuInformes();
                    break;
                case 5:
                    listarDatos();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("\n¡Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("\nOpción inválida. Intente nuevamente.");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Muestra el menú principal.
     */
    private void mostrarMenuPrincipal() {
        System.out.println("\n========== MENÚ PRINCIPAL ==========");
        System.out.println("1. Registros");
        System.out.println("2. Gestión");
        System.out.println("3. Carreras");
        System.out.println("4. Informes");
        System.out.println("5. Listar Datos");
        System.out.println("0. Salir");
        System.out.print("\nSeleccione una opción: ");
    }
    
    /**
     * Menú de registros.
     */
    private void menuRegistros() {
        System.out.println("\n===== REGISTROS =====");
        System.out.println("1. Registrar País");
        System.out.println("2. Registrar Circuito");
        System.out.println("3. Registrar Escudería");
        System.out.println("4. Registrar Piloto");
        System.out.println("5. Registrar Auto");
        System.out.println("6. Registrar Mecánico");
        System.out.println("0. Volver");
        System.out.print("\nSeleccione una opción: ");
        
        int opcion = leerOpcion();
        
        switch (opcion) {
            case 1:
                registrarPais();
                break;
            case 2:
                registrarCircuito();
                break;
            case 3:
                registrarEscuderia();
                break;
            case 4:
                registrarPiloto();
                break;
            case 5:
                registrarAuto();
                break;
            case 6:
                registrarMecanico();
                break;
        }
    }
    
    /**
     * Menú de gestión.
     */
    private void menuGestion() {
        System.out.println("\n===== GESTIÓN =====");
        System.out.println("1. Asignar Piloto a Escudería");
        System.out.println("0. Volver");
        System.out.print("\nSeleccione una opción: ");
        
        int opcion = leerOpcion();
        
        if (opcion == 1) {
            asignarPilotoEscuderia();
        }
    }
    
    /**
     * Menú de carreras.
     */
    private void menuCarreras() {
        System.out.println("\n===== CARRERAS =====");
        System.out.println("1. Planificar Carrera");
        System.out.println("2. Registrar Participación");
        System.out.println("3. Registrar Resultados");
        System.out.println("4. Finalizar Carrera");
        System.out.println("0. Volver");
        System.out.print("\nSeleccione una opción: ");
        
        int opcion = leerOpcion();
        
        switch (opcion) {
            case 1:
                planificarCarrera();
                break;
            case 2:
                registrarParticipacion();
                break;
            case 3:
                registrarResultados();
                break;
            case 4:
                finalizarCarrera();
                break;
        }
    }
    
    /**
     * Menú de informes.
     */
    private void menuInformes() {
        System.out.println("\n===== INFORMES =====");
        System.out.println("1. Resultados de Carreras por Rango de Fechas");
        System.out.println("2. Ranking de Pilotos");
        System.out.println("3. Histórico de Podios de un Piloto");
        System.out.println("4. Histórico de Victorias de un Piloto");
        System.out.println("5. Autos Utilizados por Escudería");
        System.out.println("6. Mecánicos por Escudería");
        System.out.println("7. Veces que Piloto Corrió en Circuito");
        System.out.println("8. Carreras en un Circuito");
        System.out.println("0. Volver");
        System.out.print("\nSeleccione una opción: ");
        
        int opcion = leerOpcion();
        
        switch (opcion) {
            case 1:
                informeCarrerasPorFechas();
                break;
            case 2:
                informeRankingPilotos();
                break;
            case 3:
                informePodiosPiloto();
                break;
            case 4:
                informeVictoriasPiloto();
                break;
            case 5:
                informeAutosPorEscuderia();
                break;
            case 6:
                informeMecanicosPorEscuderia();
                break;
            case 7:
                informePilotoEnCircuito();
                break;
            case 8:
                informeCarrerasEnCircuito();
                break;
        }
    }
    
    // ==================== MÉTODOS DE REGISTRO ====================
    
    private void registrarPais() {
        System.out.println("\n--- Registrar País ---");
        System.out.print("Código (ej: AR, ES): ");
        String codigo = scanner.nextLine().toUpperCase();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Continente: ");
        String continente = scanner.nextLine();
        
        try {
            Pais pais = new Pais(codigo, nombre, continente);
            manager.registrarPais(pais);
            System.out.println("✓ País registrado exitosamente!");
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    private void registrarCircuito() {
        System.out.println("\n--- Registrar Circuito ---");
        listarPaises();
        System.out.print("Código del circuito: ");
        String codigo = scanner.nextLine().toUpperCase();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Código del país: ");
        String codigoPais = scanner.nextLine().toUpperCase();
        System.out.print("Longitud (km): ");
        double longitud = Double.parseDouble(scanner.nextLine());
        System.out.print("Número de curvas: ");
        int curvas = Integer.parseInt(scanner.nextLine());
        
        try {
            Pais pais = manager.obtenerPais(codigoPais);
            if (pais == null) {
                System.out.println("✗ País no encontrado");
                return;
            }
            Circuito circuito = new Circuito(codigo, nombre, pais, longitud, curvas);
            manager.registrarCircuito(circuito);
            System.out.println("✓ Circuito registrado exitosamente!");
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    private void registrarEscuderia() {
        System.out.println("\n--- Registrar Escudería ---");
        listarPaises();
        System.out.print("Código: ");
        String codigo = scanner.nextLine().toUpperCase();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Código del país sede: ");
        String codigoPais = scanner.nextLine().toUpperCase();
        System.out.print("Año de fundación: ");
        int anio = Integer.parseInt(scanner.nextLine());
        
        try {
            Pais pais = manager.obtenerPais(codigoPais);
            if (pais == null) {
                System.out.println("✗ País no encontrado");
                return;
            }
            Escuderia escuderia = new Escuderia(codigo, nombre, pais, anio);
            manager.registrarEscuderia(escuderia);
            System.out.println("✓ Escudería registrada exitosamente!");
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    private void registrarPiloto() {
        System.out.println("\n--- Registrar Piloto ---");
        listarPaises();
        System.out.print("Código: ");
        String codigo = scanner.nextLine().toUpperCase();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Fecha de nacimiento (dd/MM/yyyy): ");
        LocalDate fechaNac = null;
        try {
            fechaNac = LocalDate.parse(scanner.nextLine(), dateFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("✗ Formato de fecha inválido");
            return;
        }
        System.out.print("Código del país (nacionalidad): ");
        String codigoPais = scanner.nextLine().toUpperCase();
        System.out.print("Número de piloto (0-99): ");
        int numero = Integer.parseInt(scanner.nextLine());
        
        try {
            Pais nacionalidad = manager.obtenerPais(codigoPais);
            if (nacionalidad == null) {
                System.out.println("✗ País no encontrado");
                return;
            }
            Piloto piloto = new Piloto(codigo, nombre, apellido, fechaNac, nacionalidad, numero);
            manager.registrarPiloto(piloto);
            System.out.println("✓ Piloto registrado exitosamente!");
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    private void registrarAuto() {
        System.out.println("\n--- Registrar Auto ---");
        listarEscuderias();
        System.out.print("Código: ");
        String codigo = scanner.nextLine().toUpperCase();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Código de escudería: ");
        String codigoEsc = scanner.nextLine().toUpperCase();
        System.out.print("Año de fabricación: ");
        int anio = Integer.parseInt(scanner.nextLine());
        System.out.print("Motor: ");
        String motor = scanner.nextLine();
        System.out.print("Potencia (HP): ");
        int potencia = Integer.parseInt(scanner.nextLine());
        
        try {
            Escuderia escuderia = manager.obtenerEscuderia(codigoEsc);
            if (escuderia == null) {
                System.out.println("✗ Escudería no encontrada");
                return;
            }
            Auto auto = new Auto(codigo, modelo, escuderia, anio, motor, potencia);
            manager.registrarAuto(auto);
            System.out.println("✓ Auto registrado exitosamente!");
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    private void registrarMecanico() {
        System.out.println("\n--- Registrar Mecánico ---");
        listarEscuderias();
        System.out.print("Código: ");
        String codigo = scanner.nextLine().toUpperCase();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Código de escudería: ");
        String codigoEsc = scanner.nextLine().toUpperCase();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();
        System.out.print("Años de experiencia: ");
        int experiencia = Integer.parseInt(scanner.nextLine());
        
        try {
            Escuderia escuderia = manager.obtenerEscuderia(codigoEsc);
            if (escuderia == null) {
                System.out.println("✗ Escudería no encontrada");
                return;
            }
            Mecanico mecanico = new Mecanico(codigo, nombre, apellido, escuderia, especialidad, experiencia);
            manager.registrarMecanico(mecanico);
            System.out.println("✓ Mecánico registrado exitosamente!");
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    private void asignarPilotoEscuderia() {
        System.out.println("\n--- Asignar Piloto a Escudería ---");
        listarPilotos();
        System.out.print("Código del piloto: ");
        String codigoPiloto = scanner.nextLine().toUpperCase();
        listarEscuderias();
        System.out.print("Código de escudería: ");
        String codigoEsc = scanner.nextLine().toUpperCase();
        
        try {
            manager.asignarPilotoEscuderia(codigoPiloto, codigoEsc);
            System.out.println("✓ Piloto asignado exitosamente!");
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    private void planificarCarrera() {
        System.out.println("\n--- Planificar Carrera ---");
        listarCircuitos();
        System.out.print("Código de la carrera: ");
        String codigo = scanner.nextLine().toUpperCase();
        System.out.print("Nombre de la carrera: ");
        String nombre = scanner.nextLine();
        System.out.print("Código del circuito: ");
        String codigoCirc = scanner.nextLine().toUpperCase();
        System.out.print("Fecha y hora (dd/MM/yyyy HH:mm): ");
        LocalDateTime fechaHora = null;
        try {
            fechaHora = LocalDateTime.parse(scanner.nextLine(), dateTimeFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("✗ Formato de fecha/hora inválido");
            return;
        }
        System.out.print("Número de vueltas: ");
        int vueltas = Integer.parseInt(scanner.nextLine());
        
        try {
            Circuito circuito = manager.obtenerCircuito(codigoCirc);
            if (circuito == null) {
                System.out.println("✗ Circuito no encontrado");
                return;
            }
            Carrera carrera = new Carrera(codigo, nombre, circuito, fechaHora, vueltas);
            manager.registrarCarrera(carrera);
            System.out.println("✓ Carrera planificada exitosamente!");
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    private void registrarParticipacion() {
        System.out.println("\n--- Registrar Participación ---");
        listarCarreras();
        System.out.print("Código de la carrera: ");
        String codigoCarrera = scanner.nextLine().toUpperCase();
        listarPilotos();
        System.out.print("Código del piloto: ");
        String codigoPiloto = scanner.nextLine().toUpperCase();
        listarAutos();
        System.out.print("Código del auto: ");
        String codigoAuto = scanner.nextLine().toUpperCase();
        
        try {
            manager.registrarParticipacion(codigoCarrera, codigoPiloto, codigoAuto);
            System.out.println("✓ Participación registrada exitosamente!");
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    private void registrarResultados() {
        System.out.println("\n--- Registrar Resultados ---");
        listarCarreras();
        System.out.print("Código de la carrera: ");
        String codigoCarrera = scanner.nextLine().toUpperCase();
        
        Carrera carrera = manager.obtenerCarrera(codigoCarrera);
        if (carrera == null) {
            System.out.println("✗ Carrera no encontrada");
            return;
        }
        
        System.out.println("\nParticipantes de la carrera:");
        for (Participacion p : carrera.getParticipaciones()) {
            System.out.println("  - " + p.getPiloto().getCodigo() + ": " + p.getPiloto().getNombreCompleto());
        }
        
        System.out.print("\nCódigo del piloto: ");
        String codigoPiloto = scanner.nextLine().toUpperCase();
        System.out.print("Posición final: ");
        int posicion = Integer.parseInt(scanner.nextLine());
        System.out.print("¿Vuelta rápida? (S/N): ");
        boolean vueltaRapida = scanner.nextLine().toUpperCase().equals("S");
        
        try {
            manager.registrarResultado(codigoCarrera, codigoPiloto, posicion, vueltaRapida);
            System.out.println("✓ Resultado registrado exitosamente!");
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    private void finalizarCarrera() {
        System.out.println("\n--- Finalizar Carrera ---");
        listarCarreras();
        System.out.print("Código de la carrera: ");
        String codigo = scanner.nextLine().toUpperCase();
        
        Carrera carrera = manager.obtenerCarrera(codigo);
        if (carrera == null) {
            System.out.println("✗ Carrera no encontrada");
            return;
        }
        
        carrera.finalizarCarrera();
        System.out.println("✓ Carrera finalizada exitosamente!");
    }
    
    // ==================== MÉTODOS DE INFORMES ====================
    
    private void informeCarrerasPorFechas() {
        System.out.println("\n--- Carreras por Rango de Fechas ---");
        System.out.print("Fecha inicio (dd/MM/yyyy): ");
        LocalDate fechaInicio = null;
        try {
            fechaInicio = LocalDate.parse(scanner.nextLine(), dateFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("✗ Formato de fecha inválido");
            return;
        }
        System.out.print("Fecha fin (dd/MM/yyyy): ");
        LocalDate fechaFin = null;
        try {
            fechaFin = LocalDate.parse(scanner.nextLine(), dateFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("✗ Formato de fecha inválido");
            return;
        }
        
        List<Carrera> carreras = manager.obtenerCarrerasPorRangoFechas(fechaInicio, fechaFin);
        
        System.out.println("\n========== CARRERAS ENCONTRADAS ==========");
        if (carreras.isEmpty()) {
            System.out.println("No hay carreras en el rango especificado.");
        } else {
            for (Carrera c : carreras) {
                System.out.println("\n" + c.getNombre());
                System.out.println("Circuito: " + c.getCircuito().getNombre());
                System.out.println("Fecha: " + c.getFechaHora().format(dateTimeFormatter));
                System.out.println("Estado: " + (c.isFinalizada() ? "FINALIZADA" : "PENDIENTE"));
                
                if (c.isFinalizada() && !c.getParticipaciones().isEmpty()) {
                    System.out.println("\nResultados:");
                    List<Participacion> participaciones = new ArrayList<>(c.getParticipaciones());
                    participaciones.sort(Comparator.comparing(p -> p.getPosicionFinal() != null ? p.getPosicionFinal() : 999));
                    
                    for (Participacion p : participaciones) {
                        if (p.getPosicionFinal() != null) {
                            System.out.printf("  %2dº - %s - %d puntos%s%s\n",
                                p.getPosicionFinal(),
                                p.getPiloto().getNombreCompleto(),
                                p.getPuntos(),
                                p.isVueltaRapida() ? " [VR]" : "",
                                p.isAbandono() ? " [DNF]" : "");
                        }
                    }
                }
                System.out.println("------------------------------------------");
            }
        }
    }
    
    private void informeRankingPilotos() {
        System.out.println("\n========== RANKING DE PILOTOS ==========");
        List<Map.Entry<Piloto, Integer>> ranking = manager.obtenerRankingPilotos();
        
        if (ranking.isEmpty()) {
            System.out.println("No hay datos de pilotos.");
        } else {
            int posicion = 1;
            for (Map.Entry<Piloto, Integer> entry : ranking) {
                System.out.printf("%2d. %-30s %4d puntos\n",
                    posicion++,
                    entry.getKey().getNombreCompleto(),
                    entry.getValue());
            }
        }
    }
    
    private void informePodiosPiloto() {
        System.out.println("\n--- Histórico de Podios ---");
        listarPilotos();
        System.out.print("Código del piloto: ");
        String codigo = scanner.nextLine().toUpperCase();
        
        try {
            List<Participacion> podios = manager.obtenerPodiosPiloto(codigo);
            
            System.out.println("\n========== PODIOS ==========");
            if (podios.isEmpty()) {
                System.out.println("El piloto no tiene podios registrados.");
            } else {
                for (Participacion p : podios) {
                    System.out.printf("%dº lugar - %s (%s)\n",
                        p.getPosicionFinal(),
                        p.getCarrera().getNombre(),
                        p.getCarrera().getFechaHora().format(dateFormatter));
                }
                System.out.println("\nTotal de podios: " + podios.size());
            }
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    private void informeVictoriasPiloto() {
        System.out.println("\n--- Histórico de Victorias ---");
        listarPilotos();
        System.out.print("Código del piloto: ");
        String codigo = scanner.nextLine().toUpperCase();
        
        try {
            List<Participacion> victorias = manager.obtenerVictoriasPiloto(codigo);
            
            System.out.println("\n========== VICTORIAS ==========");
            if (victorias.isEmpty()) {
                System.out.println("El piloto no tiene victorias registradas.");
            } else {
                for (Participacion p : victorias) {
                    System.out.printf("🏆 %s (%s)\n",
                        p.getCarrera().getNombre(),
                        p.getCarrera().getFechaHora().format(dateFormatter));
                }
                System.out.println("\nTotal de victorias: " + victorias.size());
            }
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    private void informeAutosPorEscuderia() {
        System.out.println("\n--- Autos Utilizados por Escudería ---");
        listarEscuderias();
        System.out.print("Código de escudería: ");
        String codigo = scanner.nextLine().toUpperCase();
        
        try {
            Map<Auto, List<Carrera>> autosCarreras = manager.obtenerAutosUtilizadosPorEscuderia(codigo);
            
            System.out.println("\n========== AUTOS Y CARRERAS ==========");
            if (autosCarreras.isEmpty()) {
                System.out.println("No hay autos registrados para esta escudería.");
            } else {
                for (Map.Entry<Auto, List<Carrera>> entry : autosCarreras.entrySet()) {
                    System.out.println("\n" + entry.getKey().getModelo() + " (" + entry.getKey().getCodigo() + ")");
                    System.out.println("Carreras disputadas: " + entry.getValue().size());
                    for (Carrera c : entry.getValue()) {
                        System.out.println("  - " + c.getNombre() + " (" + c.getFechaHora().format(dateFormatter) + ")");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    private void informeMecanicosPorEscuderia() {
        System.out.println("\n--- Mecánicos por Escudería ---");
        listarEscuderias();
        System.out.print("Código de escudería: ");
        String codigo = scanner.nextLine().toUpperCase();
        
        try {
            List<Mecanico> mecanicos = manager.obtenerMecanicosPorEscuderia(codigo);
            
            System.out.println("\n========== MECÁNICOS ==========");
            if (mecanicos.isEmpty()) {
                System.out.println("No hay mecánicos registrados para esta escudería.");
            } else {
                for (Mecanico m : mecanicos) {
                    System.out.printf("%-30s | Especialidad: %-20s | Experiencia: %d años\n",
                        m.getNombreCompleto(),
                        m.getEspecialidad(),
                        m.getAniosExperiencia());
                }
            }
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    private void informePilotoEnCircuito() {
        System.out.println("\n--- Veces que Piloto Corrió en Circuito ---");
        listarPilotos();
        System.out.print("Código del piloto: ");
        String codigoPiloto = scanner.nextLine().toUpperCase();
        listarCircuitos();
        System.out.print("Código del circuito: ");
        String codigoCircuito = scanner.nextLine().toUpperCase();
        
        try {
            int cantidad = manager.contarCarrerasPilotoEnCircuito(codigoPiloto, codigoCircuito);
            Piloto piloto = manager.obtenerPiloto(codigoPiloto);
            Circuito circuito = manager.obtenerCircuito(codigoCircuito);
            
            System.out.println("\n" + piloto.getNombreCompleto() + " ha corrido " + cantidad + 
                             " veces en " + circuito.getNombre());
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    private void informeCarrerasEnCircuito() {
        System.out.println("\n--- Carreras en un Circuito ---");
        listarCircuitos();
        System.out.print("Código del circuito: ");
        String codigo = scanner.nextLine().toUpperCase();
        
        try {
            int cantidad = manager.contarCarrerasEnCircuito(codigo);
            Circuito circuito = manager.obtenerCircuito(codigo);
            
            System.out.println("\nSe han corrido " + cantidad + " carreras en " + circuito.getNombre());
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    // ==================== MÉTODOS AUXILIARES ====================
    
    private int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private void listarDatos() {
        System.out.println("\n========== DATOS DEL SISTEMA ==========");
        System.out.println("Países: " + manager.obtenerTodosPaises().size());
        System.out.println("Circuitos: " + manager.obtenerTodosCircuitos().size());
        System.out.println("Escuderías: " + manager.obtenerTodasEscuderias().size());
        System.out.println("Pilotos: " + manager.obtenerTodosPilotos().size());
        System.out.println("Autos: " + manager.obtenerTodosAutos().size());
        System.out.println("Mecánicos: " + manager.obtenerTodosMecanicos().size());
        System.out.println("Carreras: " + manager.obtenerTodasCarreras().size());
    }
    
    private void listarPaises() {
        List<Pais> paises = manager.obtenerTodosPaises();
        if (!paises.isEmpty()) {
            System.out.println("\nPaíses disponibles:");
            for (Pais p : paises) {
                System.out.println("  " + p.getCodigo() + " - " + p.getNombre());
            }
        }
    }
    
    private void listarCircuitos() {
        List<Circuito> circuitos = manager.obtenerTodosCircuitos();
        if (!circuitos.isEmpty()) {
            System.out.println("\nCircuitos disponibles:");
            for (Circuito c : circuitos) {
                System.out.println("  " + c.getCodigo() + " - " + c.getNombre());
            }
        }
    }
    
    private void listarEscuderias() {
        List<Escuderia> escuderias = manager.obtenerTodasEscuderias();
        if (!escuderias.isEmpty()) {
            System.out.println("\nEscuderías disponibles:");
            for (Escuderia e : escuderias) {
                System.out.println("  " + e.getCodigo() + " - " + e.getNombre());
            }
        }
    }
    
    private void listarPilotos() {
        List<Piloto> pilotos = manager.obtenerTodosPilotos();
        if (!pilotos.isEmpty()) {
            System.out.println("\nPilotos disponibles:");
            for (Piloto p : pilotos) {
                System.out.println("  " + p.getCodigo() + " - " + p.getNombreCompleto());
            }
        }
    }
    
    private void listarAutos() {
        List<Auto> autos = manager.obtenerTodosAutos();
        if (!autos.isEmpty()) {
            System.out.println("\nAutos disponibles:");
            for (Auto a : autos) {
                System.out.println("  " + a.getCodigo() + " - " + a.getModelo() + " (" + a.getEscuderia().getNombre() + ")");
            }
        }
    }
    
    private void listarCarreras() {
        List<Carrera> carreras = manager.obtenerTodasCarreras();
        if (!carreras.isEmpty()) {
            System.out.println("\nCarreras disponibles:");
            for (Carrera c : carreras) {
                System.out.println("  " + c.getCodigo() + " - " + c.getNombre() + " (" + c.getFechaHora().format(dateFormatter) + ")");
            }
        }
    }
    
    /**
     * Carga datos de ejemplo para facilitar las pruebas.
     */
    private void cargarDatosEjemplo() {
        // Países
        Pais argentina = new Pais("AR", "Argentina", "América del Sur");
        Pais italia = new Pais("IT", "Italia", "Europa");
        Pais uk = new Pais("UK", "Reino Unido", "Europa");
        Pais monaco = new Pais("MC", "Mónaco", "Europa");
        Pais españa = new Pais("ES", "España", "Europa");
        
        manager.registrarPais(argentina);
        manager.registrarPais(italia);
        manager.registrarPais(uk);
        manager.registrarPais(monaco);
        manager.registrarPais(españa);
        
        // Circuitos
        Circuito monza = new Circuito("MON", "Autodromo Nazionale di Monza", italia, 5.793, 11);
        Circuito silverstone = new Circuito("SIL", "Silverstone Circuit", uk, 5.891, 18);
        Circuito monteCarlo = new Circuito("MCR", "Circuit de Monaco", monaco, 3.337, 19);
        
        manager.registrarCircuito(monza);
        manager.registrarCircuito(silverstone);
        manager.registrarCircuito(monteCarlo);
        
        // Escuderías
        Escuderia ferrari = new Escuderia("FER", "Scuderia Ferrari", italia, 1950);
        Escuderia mercedes = new Escuderia("MER", "Mercedes-AMG Petronas", uk, 2010);
        Escuderia redBull = new Escuderia("RBR", "Red Bull Racing", uk, 2005);
        
        manager.registrarEscuderia(ferrari);
        manager.registrarEscuderia(mercedes);
        manager.registrarEscuderia(redBull);
        
        // Pilotos
        Piloto hamilton = new Piloto("HAM", "Lewis", "Hamilton", LocalDate.of(1985, 1, 7), uk, 44);
        Piloto verstappen = new Piloto("VER", "Max", "Verstappen", LocalDate.of(1997, 9, 30), uk, 1);
        Piloto leclerc = new Piloto("LEC", "Charles", "Leclerc", LocalDate.of(1997, 10, 16), monaco, 16);
        
        manager.registrarPiloto(hamilton);
        manager.registrarPiloto(verstappen);
        manager.registrarPiloto(leclerc);
        
        manager.asignarPilotoEscuderia("HAM", "MER");
        manager.asignarPilotoEscuderia("VER", "RBR");
        manager.asignarPilotoEscuderia("LEC", "FER");
        
        // Autos
        Auto mercedesW14 = new Auto("MERW14", "W14 E Performance", mercedes, 2023, "Mercedes M14", 1000);
        Auto rbr19 = new Auto("RBR19", "RB19", redBull, 2023, "Honda RBPT", 1000);
        Auto ferrariSF23 = new Auto("FERSF23", "SF-23", ferrari, 2023, "Ferrari 066/10", 1000);
        
        manager.registrarAuto(mercedesW14);
        manager.registrarAuto(rbr19);
        manager.registrarAuto(ferrariSF23);
        
        // Mecánicos
        Mecanico mec1 = new Mecanico("MEC001", "John", "Smith", mercedes, "Motor", 10);
        Mecanico mec2 = new Mecanico("MEC002", "Peter", "Johnson", redBull, "Aerodinámica", 8);
        Mecanico mec3 = new Mecanico("MEC003", "Marco", "Rossi", ferrari, "Suspensión", 12);
        
        manager.registrarMecanico(mec1);
        manager.registrarMecanico(mec2);
        manager.registrarMecanico(mec3);
        
        // Carrera de ejemplo
        Carrera gpItalia = new Carrera("IT2023", "Gran Premio de Italia 2023", monza, 
                                      LocalDate.of(2023, 9, 3).atTime(15, 0), 53);
        manager.registrarCarrera(gpItalia);
        
        manager.registrarParticipacion("IT2023", "VER", "RBR19");
        manager.registrarParticipacion("IT2023", "LEC", "FERSF23");
        manager.registrarParticipacion("IT2023", "HAM", "MERW14");
        
        manager.registrarResultado("IT2023", "VER", 1, true);
        manager.registrarResultado("IT2023", "LEC", 2, false);
        manager.registrarResultado("IT2023", "HAM", 3, false);
        
        gpItalia.finalizarCarrera();
    }
    
    /**
     * Método principal.
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        F1Application app = new F1Application();
        app.iniciar();
    }
}
