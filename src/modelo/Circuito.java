package modelo;
import java.util.ArrayList;
import java.util.List;
public class Circuito {
    private String nombre;
    private int longitud;
    private Pais pais;
    private List<Carrera>carreras;

    public Circuito(){
        this.carreras = new ArrayList<>();
    }

    public Circuito(String nombre, int longitud,Pais pais,List<Carrera>carreras) {
        this.nombre = nombre;
        this.longitud = longitud;
        this.pais = pais;
        this.carreras = carreras;
    }

    public void agregarCarrera(Carrera c){
        this.carreras.add(c);
    }

    public String getNombre() {
        return nombre;
    }
    public int getLongitud() {
        return longitud;
    }
    public Pais getPais() {
        return pais;
    }
    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }
}
