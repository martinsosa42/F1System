package com.f1system.ui.gui;

import com.f1system.model.*;
import com.f1system.service.F1Manager;
import javax.swing.*;
import java.time.LocalDate;

/**
 * Clase principal de la aplicación con interfaz gráfica.
 * 
 * @author Escuderías Unidas
 * @version 1.0
 */
public class F1ApplicationGUI {
    
    /**
     * Punto de entrada de la aplicación.
     */
    public static void main(String[] args) {
        // Configurar Look and Feel del sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Si falla, usar el Look and Feel por defecto
        }
        
        // Ejecutar en el Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Crear manager y cargar datos
            F1Manager manager = new F1Manager();
            cargarDatosEjemplo(manager);
            
            // Crear y mostrar ventana principal
            VentanaPrincipal ventana = new VentanaPrincipal(manager);
            ventana.setVisible(true);
        });
    }
    
    /**
     * Carga datos de ejemplo para demostración.
     */
    private static void cargarDatosEjemplo(F1Manager manager) {
        // Países
        Pais argentina = new Pais("AR", "Argentina", "América del Sur");
        Pais italia = new Pais("IT", "Italia", "Europa");
        Pais uk = new Pais("UK", "Reino Unido", "Europa");
        Pais monaco = new Pais("MC", "Mónaco", "Europa");
        Pais españa = new Pais("ES", "España", "Europa");
        Pais alemania = new Pais("DE", "Alemania", "Europa");
        Pais japon = new Pais("JP", "Japón", "Asia");
        Pais brasil = new Pais("BR", "Brasil", "América del Sur");
        Pais mexico = new Pais("MX", "México", "América del Norte");
        Pais holanda = new Pais("NL", "Holanda", "Europa");
        
        manager.registrarPais(argentina);
        manager.registrarPais(italia);
        manager.registrarPais(uk);
        manager.registrarPais(monaco);
        manager.registrarPais(españa);
        manager.registrarPais(alemania);
        manager.registrarPais(japon);
        manager.registrarPais(brasil);
        manager.registrarPais(mexico);
        manager.registrarPais(holanda);
        
        // Circuitos
        Circuito monza = new Circuito("MON", "Autodromo Nazionale di Monza", italia, 5.793, 11);
        Circuito silverstone = new Circuito("SIL", "Silverstone Circuit", uk, 5.891, 18);
        Circuito monteCarlo = new Circuito("MCR", "Circuit de Monaco", monaco, 3.337, 19);
        Circuito spa = new Circuito("SPA", "Circuit de Spa-Francorchamps", uk, 7.004, 19);
        Circuito suzuka = new Circuito("SUZ", "Suzuka Circuit", japon, 5.807, 18);
        Circuito interlagos = new Circuito("INT", "Autódromo José Carlos Pace", brasil, 4.309, 15);
        
        manager.registrarCircuito(monza);
        manager.registrarCircuito(silverstone);
        manager.registrarCircuito(monteCarlo);
        manager.registrarCircuito(spa);
        manager.registrarCircuito(suzuka);
        manager.registrarCircuito(interlagos);
        
        // Escuderías
        Escuderia ferrari = new Escuderia("FER", "Scuderia Ferrari", italia, 1950);
        Escuderia mercedes = new Escuderia("MER", "Mercedes-AMG Petronas", alemania, 2010);
        Escuderia redBull = new Escuderia("RBR", "Red Bull Racing", uk, 2005);
        Escuderia mclaren = new Escuderia("MCL", "McLaren F1 Team", uk, 1966);
        
        manager.registrarEscuderia(ferrari);
        manager.registrarEscuderia(mercedes);
        manager.registrarEscuderia(redBull);
        manager.registrarEscuderia(mclaren);
        
        // Pilotos
        Piloto hamilton = new Piloto("HAM", "Lewis", "Hamilton", LocalDate.of(1985, 1, 7), uk, 44);
        Piloto verstappen = new Piloto("VER", "Max", "Verstappen", LocalDate.of(1997, 9, 30), holanda, 1);
        Piloto leclerc = new Piloto("LEC", "Charles", "Leclerc", LocalDate.of(1997, 10, 16), monaco, 16);
        Piloto sainz = new Piloto("SAI", "Carlos", "Sainz", LocalDate.of(1994, 9, 1), españa, 55);
        Piloto norris = new Piloto("NOR", "Lando", "Norris", LocalDate.of(1999, 11, 13), uk, 4);
        Piloto perez = new Piloto("PER", "Sergio", "Pérez", LocalDate.of(1990, 1, 26), mexico, 11);
        
        manager.registrarPiloto(hamilton);
        manager.registrarPiloto(verstappen);
        manager.registrarPiloto(leclerc);
        manager.registrarPiloto(sainz);
        manager.registrarPiloto(norris);
        manager.registrarPiloto(perez);
        
        // Asignar pilotos a escuderías
        manager.asignarPilotoEscuderia("HAM", "MER");
        manager.asignarPilotoEscuderia("VER", "RBR");
        manager.asignarPilotoEscuderia("PER", "RBR");
        manager.asignarPilotoEscuderia("LEC", "FER");
        manager.asignarPilotoEscuderia("SAI", "FER");
        manager.asignarPilotoEscuderia("NOR", "MCL");
        
        // Autos
        Auto mercedesW14 = new Auto("MERW14", "W14 E Performance", mercedes, 2023, "Mercedes M14", 1000);
        Auto rbr19 = new Auto("RBR19", "RB19", redBull, 2023, "Honda RBPT", 1000);
        Auto rbr19b = new Auto("RBR19B", "RB19B", redBull, 2023, "Honda RBPT", 1000);
        Auto ferrariSF23 = new Auto("FERSF23", "SF-23", ferrari, 2023, "Ferrari 066/10", 1000);
        Auto ferrariSF23b = new Auto("FERSF23B", "SF-23B", ferrari, 2023, "Ferrari 066/10", 1000);
        Auto mclarenMCL60 = new Auto("MCL60", "MCL60", mclaren, 2023, "Mercedes M14", 1000);
        
        manager.registrarAuto(mercedesW14);
        manager.registrarAuto(rbr19);
        manager.registrarAuto(rbr19b);
        manager.registrarAuto(ferrariSF23);
        manager.registrarAuto(ferrariSF23b);
        manager.registrarAuto(mclarenMCL60);
        
        // Mecánicos
        Mecanico mec1 = new Mecanico("MEC001", "John", "Smith", mercedes, "Motor", 10);
        Mecanico mec2 = new Mecanico("MEC002", "Peter", "Johnson", redBull, "Aerodinámica", 8);
        Mecanico mec3 = new Mecanico("MEC003", "Marco", "Rossi", ferrari, "Suspensión", 12);
        Mecanico mec4 = new Mecanico("MEC004", "Hans", "Müller", mercedes, "Electrónica", 7);
        Mecanico mec5 = new Mecanico("MEC005", "Antonio", "García", ferrari, "Chasis", 15);
        Mecanico mec6 = new Mecanico("MEC006", "James", "Brown", mclaren, "Motor", 9);
        Mecanico mec7 = new Mecanico("MEC007", "Pierre", "Dubois", redBull, "Frenos", 11);
        
        manager.registrarMecanico(mec1);
        manager.registrarMecanico(mec2);
        manager.registrarMecanico(mec3);
        manager.registrarMecanico(mec4);
        manager.registrarMecanico(mec5);
        manager.registrarMecanico(mec6);
        manager.registrarMecanico(mec7);
        
        // Carreras
        Carrera gpItalia = new Carrera("IT2023", "Gran Premio de Italia 2023", monza, 
                                      LocalDate.of(2023, 9, 3).atTime(15, 0), 53);
        manager.registrarCarrera(gpItalia);
        
        manager.registrarParticipacion("IT2023", "VER", "RBR19");
        manager.registrarParticipacion("IT2023", "LEC", "FERSF23");
        manager.registrarParticipacion("IT2023", "HAM", "MERW14");
        manager.registrarParticipacion("IT2023", "PER", "RBR19B");
        manager.registrarParticipacion("IT2023", "SAI", "FERSF23B");
        manager.registrarParticipacion("IT2023", "NOR", "MCL60");
        
        manager.registrarResultado("IT2023", "VER", 1, true);
        manager.registrarResultado("IT2023", "LEC", 2, false);
        manager.registrarResultado("IT2023", "HAM", 3, false);
        manager.registrarResultado("IT2023", "PER", 4, false);
        manager.registrarResultado("IT2023", "SAI", 5, false);
        manager.registrarResultado("IT2023", "NOR", 6, false);
        
        gpItalia.finalizarCarrera();
        
        // Segunda carrera
        Carrera gpMonaco = new Carrera("MC2023", "Gran Premio de Mónaco 2023", monteCarlo,
                                      LocalDate.of(2023, 5, 28).atTime(15, 0), 78);
        manager.registrarCarrera(gpMonaco);
        
        manager.registrarParticipacion("MC2023", "VER", "RBR19");
        manager.registrarParticipacion("MC2023", "LEC", "FERSF23");
        manager.registrarParticipacion("MC2023", "HAM", "MERW14");
        manager.registrarParticipacion("MC2023", "PER", "RBR19B");
        
        manager.registrarResultado("MC2023", "LEC", 1, false);
        manager.registrarResultado("MC2023", "VER", 2, true);
        manager.registrarResultado("MC2023", "PER", 3, false);
        manager.registrarResultado("MC2023", "HAM", 4, false);
        
        gpMonaco.finalizarCarrera();
        
        // Tercera carrera (sin finalizar)
        Carrera gpJapon = new Carrera("JP2023", "Gran Premio de Japón 2023", suzuka,
                                     LocalDate.of(2023, 9, 24).atTime(14, 0), 53);
        manager.registrarCarrera(gpJapon);
        
        manager.registrarParticipacion("JP2023", "VER", "RBR19");
        manager.registrarParticipacion("JP2023", "NOR", "MCL60");
        manager.registrarParticipacion("JP2023", "HAM", "MERW14");
    }
}
