package modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Auto {
    private String numeroAuto;
    private String modelo;
    private String motor;
    private Escuderia escuderia;
    private List<AutoPiloto> autoPiloto;

    public Auto(){
        this.autoPiloto = new ArrayList<AutoPiloto>();
    }

    public Auto(String numeroAuto,String modelo, String motor, Escuderia escuderia,List<AutoPiloto> autoPiloto) {
        this.numeroAuto = numeroAuto;
        this.modelo = modelo;
        this.motor = motor;
        this.escuderia = escuderia;
        this.autoPiloto = autoPiloto;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o ==null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Objects.equals(numeroAuto, auto.numeroAuto);
    }

    @Override
    public int hashCode(){
        return Objects.hash(numeroAuto);
    }

    public void agregarAutoPiloto(AutoPiloto ap){
        autoPiloto.add(ap);
    }

    public String getNumeroAuto() {
        return numeroAuto;
    }
    public String getModelo() {
        return modelo;
    }
    public String getMotor() {
        return motor;
    }
    public Escuderia getEscuderia() {
        return escuderia;
    }
    public List<AutoPiloto> getAutoPilotos() {return autoPiloto;}

    public void setNumeroAuto(String numeroAuto) {
        this.numeroAuto = numeroAuto;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setMotor(String motor) {
        this.motor = motor;
    }
    public void setEscuderia(Escuderia escuderia) {this.escuderia = escuderia;}
    public void setAutoPilotos(List<AutoPiloto> autoPilotos) {this.autoPiloto = autoPilotos; }

    public String toString(){
        return modelo + " ("+ numeroAuto +") - Motor:  " + motor + " (" + escuderia + ")";
    }
}
