package EscuderiasUnidas;
import java.util.ArrayList;

public class Escuderia {
    private String nombre;
    private ArrayList<Auto>autos;//Asociacion 1..* con Auto.
    private Pais pais;
    private ArrayList<Mecanico>mecanicos;
    private ArrayList<Piloto>pilotos;

    public Escuderia(){}

    public Escuderia(String nombre){
        this.nombre = nombre;
        this.autos = new ArrayList<>(); //Inicio de la lista.
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarAuto(Auto auto){
        autos.add(auto);
    }

    public void quitarAuto(Auto auto){
        autos.remove(auto);
    }
}
