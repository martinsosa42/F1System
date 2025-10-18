package modelo;
import java.util.ArrayList;
import java.util.List;

public class Auto {
    private String modelo;
    private String motor;
    private Escuderia escuderia;
    private List<AutoPiloto> autoPiloto;

    public Auto(){
        this.autoPiloto = new ArrayList<AutoPiloto>();
    }

    public Auto(String modelo, String motor, Escuderia escuderia,List<AutoPiloto> autoPiloto) {
        this.modelo = modelo;
        this.motor = motor;
        this.escuderia = escuderia;
        this.autoPiloto = autoPiloto;
    }

    public void agregarAutoPiloto(AutoPiloto ap){
        autoPiloto.add(ap);
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

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setMotor(String motor) {
        this.motor = motor;
    }
    public void setEscuderia(Escuderia escuderia) {this.escuderia = escuderia;}
    public void setAutoPilotos(List<AutoPiloto> autoPilotos) {this.autoPiloto = autoPilotos; }
}
