package GestorSistema;
import Modelo.*;
import java.util.ArrayList;
import java.util.List;

public class metodo {
    List<Escuderia>escuderias = new ArrayList<>();
    List<Pais>paises = new ArrayList<>();
    List<AutoPiloto>autoPilotos = new ArrayList<>();
    List<PilotoEscuderia>pilotosEscuderia = new ArrayList<>();
    List<Mecanico>mecanicos = new ArrayList<>();
    List<Piloto>pilotos = new ArrayList<>();
    List<Auto>autos = new ArrayList<>();
    List<Carrera>carreras = new ArrayList<>();
    List<Circuito>circuitos = new ArrayList<>();

    public void agregarAutoPiloto(String fechaAsignacion,Auto auto, Piloto piloto){
        AutoPiloto nuevoAutoPiloto = new AutoPiloto(fechaAsignacion,auto,piloto);
        autoPilotos.add(nuevoAutoPiloto);
    }

    public void agregarEscuderia(String nombre, Pais pais,List<Mecanico>mecanicos,List <Auto> autos,List <Piloto> pilotos){
        Escuderia nuevaEscuderia = new Escuderia(nombre,pais,mecanicos,autos,pilotos);
        escuderias.add(nuevaEscuderia);
    }

    public void agregarPais(int idPais, String descripcion,List<Escuderia> escuderias,List <Persona> personas,List <Circuito>circuitos,List <Carrera>carreras){
        Pais nuevoPais = new Pais(idPais,descripcion,escuderias,personas,circuitos,carreras);
        paises.add(nuevoPais);
    }

    public void agregarCircuito(String nombre, int longitud,Pais pais,List<Carrera>carreras){
        Circuito nuevoCircuito = new Circuito(nombre,longitud,pais,carreras);
        circuitos.add(nuevoCircuito);
    }

    public void agregarCarreras(String fechaRealizacion, int numeroVueltas, String horaRealizacion,Circuito circuito,Carrera carrera){
        Carrera nuevaCarrera = new Carrera(fechaRealizacion,numeroVueltas,horaRealizacion,circuito,carrera);
        carreras.add(nuevaCarrera);
    }

    public void agregarPilotosEscuderia(String desdeFecha, String hastaFecha,Escuderia escuderia, Piloto piloto){
        PilotoEscuderia nuevoPilotoEscuderia = new PilotoEscuderia(desdeFecha,hastaFecha,escuderia,piloto);
        pilotosEscuderia.add(nuevoPilotoEscuderia);
    }

    public void agregarMecanico(String dni, String nombre, String apellido,List<Pais>paises, Especialidad especialidad, int aniosExperiencia,List<Escuderia> escuderias){
        Mecanico nuevoMecanico = new Mecanico(dni, nombre, apellido, paises, especialidad, aniosExperiencia, escuderias);
        mecanicos.add(nuevoMecanico);
    }

    public void agregarPiloto(String dni,String nombre,String apellido,int numeroCompetencia, int victorias, int polePosition, int vueltasRapidas, int podios,List<Pais>paises){
        Piloto nuevoPiloto = new Piloto(dni,nombre,apellido,numeroCompetencia,victorias,polePosition,vueltasRapidas,podios,paises);
        pilotos.add(nuevoPiloto);
    }

    public void agregarAuto(String modelo, String motor, Escuderia escuderia){
        Auto nuevoAuto = new Auto(modelo,motor,escuderia);
        autos.add(nuevoAuto);
    }
}
