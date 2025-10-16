package Modelo;
import java.util.ArrayList;
import java.util.List;

public class Escuderia {
    private String nombre;
    private Pais pais;
    //Asociacion 1..* con Auto, Mecanico y Piloto.
    private List<Auto>autos;
    private List<Mecanico>mecanicos;
    private List<PilotoEscuderia>pilotosEscuderia;

    public Escuderia(){
        this.mecanicos = new ArrayList<Mecanico>();
        this.autos = new ArrayList<>();
        this.pilotosEscuderia = new ArrayList<>();
    }

    public Escuderia(String nombre, Pais pais,List<Mecanico>mecanicos,List <Auto> autos,List <Piloto> pilotos){
        this.nombre = nombre;
        this.pais = pais;
        this.autos = new ArrayList<>(); //Inicio de las listas.
        this.mecanicos = mecanicos;
        this.autos = autos;
        this.pilotosEscuderia = pilotosEscuderia;
    }

    public void agregarMecanico(Mecanico m){
        this.mecanicos.add(m);
    }
    public void agregarAuto(Auto a){
        this.autos.add(a);
    }
    public void agregarPilotoEscuderia(PilotoEscuderia pe){
        this.pilotosEscuderia.add(pe);
    }

    public String getNombre() {return nombre;}
    public Pais getPais() {return pais;}
    public List<Mecanico> getMecanicos() {return mecanicos;}
    public List<Auto> getAutos() {return autos;}
    public List<PilotoEscuderia> getPilotosEscuderia() {return pilotosEscuderia;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    public void setMecanicos(List<Mecanico> mecanicos) {
        this.mecanicos = mecanicos;
    }
    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }
    public void setPilotosEscuderia(List<PilotoEscuderia> pilotosEscuderia) {
        this.pilotosEscuderia = pilotosEscuderia;
    }
}
