package gestion;
import modelo.*;
import java.util.ArrayList;
import java.util.List;
import excepciones.AsignacionInvalidaException;

public class sistemaEscuderias {
    private List<Mecanico>mecanicos = new ArrayList<>();
    private List<Auto>autos = new ArrayList<>();
    private List<Escuderia>escuderias = new ArrayList<>();
    private List<Circuito>circuitos = new ArrayList<>();
    private List<Pais> paises = new ArrayList<>();
    private List<Carrera>carreras = new ArrayList<>();
    private List<PilotoEscuderia> pilotoEscuderia = new ArrayList<>();
    private List<AutoPiloto>autoPiloto = new ArrayList<>();

    //Registro.
    public void agregarAutoPiloto(AutoPiloto ap)throws AsignacionInvalidaException{
        if (!validarAsignacionUnica(ap.getAuto(), ap.getCarrera())) {
            throw new IllegalArgumentException("Asignacion invalida!");
        }
        autoPiloto.add(ap);
        ap.getAuto().agregarAutoPiloto(ap);
        ap.getPiloto().agregarAutoPilotos(ap);
        ap.getCarrera().agregarAutoPiloto(ap);
    }

    private Boolean validarAsignacionUnica(Auto auto, Carrera carrera){
        for (AutoPiloto apExistente : autoPiloto){
            if (apExistente.getAuto().equals(auto) && apExistente.getCarrera().equals(carrera)){
                return false;
            }
        }
        return true;
    }
    public void agregarMecanico(Mecanico m){
        mecanicos.add(m);
    }
    public void agregarAuto(Auto a){
        autos.add(a);
    }
    public void agregarPilotoEscuderia(PilotoEscuderia pe){
        pilotoEscuderia.add(pe);
    }
    public void agregarCarrera(Carrera c){
        carreras.add(c);
    }
    public void agregarPais(Pais p){
        paises.add(p);
    }
    public void agregarCircuito(Circuito c){
        circuitos.add(c);
    }

    public List<AutoPiloto>getAutoPiloto(){
        return autoPiloto;
    }
}
