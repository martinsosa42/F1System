package modelo;
import java.util.List;
import java.util.ArrayList;

public class AutoPiloto {
    //Atributo de la asociacion.
    private String fechaAsignacion;

    //Entidades asociadas.
    private Auto auto;
    private Piloto piloto;
    private Carrera carrera;

    public AutoPiloto(){
    }

    public AutoPiloto(String fechaAsignacion,Auto auto,Piloto piloto,Carrera carrera){
        this.fechaAsignacion = fechaAsignacion;
        this.auto = auto;
        this.piloto = piloto;
        this.carrera = carrera;
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
    public Carrera getCarrera() {
        return carrera;
    }

    public void setFechaAsignacion(String fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
    public void setAuto(Auto auto) {
        this.auto = auto;
    }
    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
