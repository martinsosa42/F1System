package modelo;
import java.util.List;
import java.util.ArrayList;

public class AutoPiloto {
    private String fechaAsignacion;
    private Auto auto;
    private Piloto piloto;

    public AutoPiloto(){
    }

    public AutoPiloto(String fechaAsignacion,Auto auto,Piloto piloto){
        this.fechaAsignacion = fechaAsignacion;
        this.auto = auto;
        this.piloto = piloto;
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

    public void setFechaAsignacion(String fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
    public void setAuto(Auto auto) {
        this.auto = auto;
    }
    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }
}
