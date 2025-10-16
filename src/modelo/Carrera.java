package modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private String fechaRealizacion;
    private int numeroVueltas;
    private String horaRealizacion;
    private Circuito circuito;
    private List<AutoPiloto> autoPiloto;

    public Carrera(){
        this.autoPiloto = new ArrayList<AutoPiloto>();
    }

    public Carrera(String fechaRealizacion, int numeroVueltas, String horaRealizacion,Circuito circuito,List<AutoPiloto> autoPiloto) {
        this.fechaRealizacion = fechaRealizacion;
        this.numeroVueltas = numeroVueltas;
        this.horaRealizacion = horaRealizacion;
        this.circuito = circuito;
        this.autoPiloto = autoPiloto;
    }

    public void agregarAutoPiloto(AutoPiloto ap){
        this.autoPiloto.add(ap);
    }

    public String getFechaRealizacion() {
        return fechaRealizacion;
    }
    public int getNumeroVueltas() {
        return numeroVueltas;
    }
    public String getHoraRealizacion() {
        return horaRealizacion;
    }
    public Circuito getCircuito() {
        return circuito;
    }
    public List<AutoPiloto> getAutoPiloto() {return autoPiloto;}

    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }
    public void setNumeroVueltas(int numeroVueltas) {
        this.numeroVueltas = numeroVueltas;
    }
    public void setHoraRealizacion(String horaRealizacion) {
        this.horaRealizacion = horaRealizacion;
    }
    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }
    public void setAutoPiloto(List<AutoPiloto> autoPiloto) {this.autoPiloto = autoPiloto;}
}
