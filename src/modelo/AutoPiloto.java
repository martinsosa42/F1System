package modelo;
import java.util.List;
import java.util.ArrayList;

public class AutoPiloto {
    private String fechaAsignacion;
    private Auto auto;
    private Piloto piloto;
    private List<Carrera>carreras;

    public AutoPiloto(){
        this.carreras = new ArrayList<>();
    }

    public AutoPiloto(String fechaAsignacion,Auto auto,Piloto piloto,List<Carrera>carreras){
        this.fechaAsignacion = fechaAsignacion;
        this.auto = auto;
        this.piloto = piloto;
        this.carreras = carreras;
    }

    public void agregarAutoPiloto(String fechaAsignacion,Auto auto,Piloto piloto){
        agregarAutoPiloto(fechaAsignacion,auto,piloto);
    }

    public void agregarCarrera(Carrera c){
        this.carreras.add(c);
    }

    public String getFechaAsignacion() {
        return fechaAsignacion;
    }
    public Auto getAuto() {
        return auto;
    }
    public Piloto getPiloto() {
        return piloto;
    }
    public List<Carrera> getCarreras() {return carreras;}

    public void setFechaAsignacion(String fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
    public void setAuto(Auto auto) {
        this.auto = auto;
    }
    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }
    public void setCarreras(List<Carrera> carreras) {this.carreras = carreras;}
}
