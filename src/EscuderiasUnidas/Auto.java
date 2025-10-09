package EscuderiasUnidas;
import java.util.ArrayList;
import java.util.List;

public class Auto {
    private String modelo;
    private String motor;
    private Escuderia escuderia;
    private List<Piloto>pilotos;
    private List<AutoPiloto> autoPilotos;

    public Auto(){
        this.pilotos = new ArrayList<>();
        this.autoPilotos = new ArrayList<>();
    }

    public Auto(String modelo, String motor, Escuderia escuderia, ArrayList<Piloto> pilotos) {
        this.modelo = modelo;
        this.motor = motor;
        this.escuderia = escuderia;
        this.pilotos = pilotos;
        this.autoPilotos = autoPilotos;
    }

    public void agregarAutoPilotos(AutoPiloto ap){
        this.autoPilotos.add(ap);
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
    public List<Piloto> getPilotos() {return pilotos;}
    public List<AutoPiloto> getAutoPilotos() {return autoPilotos;}

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setMotor(String motor) {
        this.motor = motor;
    }
    public void setEscuderia(Escuderia escuderia) {this.escuderia = escuderia;}
    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }
    public void setAutoPilotos(List<AutoPiloto> autoPilotos) {this.autoPilotos = autoPilotos; }
}
