package gestion;
import modelo.*;
import java.util.ArrayList;
import java.util.List;
//*
public class metodo {
    private List<Mecanico>mecanicos = new ArrayList<>();
    private List<Auto>autos = new ArrayList<>();
    private List<Escuderia>escuderias = new ArrayList<>();
    private List<Circuito>circuitos = new ArrayList<>();
    private List<Pais> paises = new ArrayList<>();
    private List<Carrera>carreras = new ArrayList<>();
    private List<PilotoEscuderia> pilotoEscuderia = new ArrayList<>();
    private List<AutoPiloto>autoPiloto = new ArrayList<>();

    //Registro.
    public void agregarAutoPiloto(AutoPiloto ap){
        autoPiloto.add(ap);
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
}
