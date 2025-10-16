package Modelo;
import java.util.ArrayList;
import java.util.List;

public class Mecanico extends Persona{
    private Especialidad especialidad;
    private int aniosExperiencia;
    private List<Escuderia>escuderias;

    public Mecanico(){
        this.escuderias = new ArrayList<>();
    }

    public Mecanico(String dni, String nombre, String apellido,List<Pais>paises, Especialidad especialidad, int aniosExperiencia,List<Escuderia> escuderias){
        super(dni, nombre, apellido,paises);
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
        this.escuderias = escuderias;
    }

    //Metodos para agregar Escuderias a la lista.
    public void agregarEscuderia(Escuderia e){
        this.escuderias.add(e);
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }
    public List<Escuderia> getEscuderias() {
        return escuderias;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }
    public void setEscuderias(List<Escuderia> escuderias) {
        this.escuderias = escuderias;
    }
}

