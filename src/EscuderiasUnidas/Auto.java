package EscuderiasUnidas;
import java.util.ArrayList;

public class Auto {
    private String modelo;
    private String motor;
    private Escuderia escuderia;
    private ArrayList<Piloto>pilotos;

    public Auto(){}

    public Auto(String modelo, String motor) {
        this.modelo = modelo;
        this.motor = motor;
        this.pilotos = new ArrayList<>();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Escuderia getEscuderia() {
        return escuderia;
    }
}
