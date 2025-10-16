package Modelo;

public class Carrera {
    private String fechaRealizacion;
    private int numeroVueltas;
    private String horaRealizacion;
    private Circuito circuito;
    private Carrera carrera;

    public Carrera(){}

    public Carrera(String fechaRealizacion, int numeroVueltas, String horaRealizacion,Circuito circuito,Carrera carrera) {
        this.fechaRealizacion = fechaRealizacion;
        this.numeroVueltas = numeroVueltas;
        this.horaRealizacion = horaRealizacion;
        this.circuito = circuito;
        this.carrera = carrera;
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
    public Carrera getCarrera() {
        return carrera;
    }

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
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
