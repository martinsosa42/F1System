package Modelo;
import java.util.ArrayList;
import java.util.List;

public class Pais {
    private int idPais;
    private String descripcion;
    private List<Escuderia>escuderias;
    private List <Persona> personas;
    private List<Circuito>circuitos;
    private List<Carrera>carreras;

    public Pais(){
        this.escuderias = new ArrayList<>();
        this.circuitos = new ArrayList<>();
        this.carreras = new ArrayList<>();
    }

    public Pais(int idPais, String descripcion,List<Escuderia> escuderias,List <Persona> personas,List <Circuito>circuitos,List <Carrera>carreras){
        this.idPais = idPais;
        this.descripcion = descripcion;
        this.escuderias = escuderias;
        this.personas = personas;
        this.circuitos = circuitos;
        this.carreras = carreras;
    }

    public void agregarEscuderias(Escuderia e){
        this.escuderias.add(e);
    }

    public void agregarCircuito(Circuito c){
        this.circuitos.add(c);
    }

    public void agregarCarrera(Carrera c){
        this.carreras.add(c);
    }

    public int getIdPais() {
        return idPais;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public List<Escuderia> getEscuderias() {
        return escuderias;
    }
    public Persona getPersona() {
        return persona;
    }
    public List<Circuito> getCircuitos() {
        return circuitos;
    }
    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setEscuderias(List<Escuderia> escuderias) {
        this.escuderias = escuderias;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public void setCircuitos(List<Circuito> circuitos) {
        this.circuitos = circuitos;
    }
    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }
}
