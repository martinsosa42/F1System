package Modelo;
import java.util.ArrayList;
import java.util.List;

public class Piloto extends Persona{
    private int numeroCompetencia;
    private int victorias;
    private int polePosition;
    private int vueltasRapidas;
    private int podios;
    private List<AutoPiloto>autoPilotos;


    public Piloto(){
        this.autoPilotos = new ArrayList<>();
    }

    public Piloto(String dni,String nombre,String apellido,int numeroCompetencia, int victorias, int polePosition, int vueltasRapidas, int podios,List<Pais>paises){
        super(dni, nombre, apellido,paises);
        this.numeroCompetencia = numeroCompetencia;
        this.victorias = victorias;
        this.polePosition = polePosition;
        this.vueltasRapidas = vueltasRapidas;
        this.podios = podios;
        this.autoPilotos = autoPilotos;
    }

    //Metodos para agregar Escuderias y Autos a las listas.
    public void agregarAutoPilotos(AutoPiloto ap){
        this.autoPilotos.add(ap);
    }


    public int getNumeroCompetencia() {
        return numeroCompetencia;
    }
    public int getVictorias() {
        return victorias;
    }
    public int getPolePosition() {return polePosition;}
    public int getVueltasRapidas() {
      return vueltasRapidas;
    }
    public int getPodios() {
        return podios;
    }
    public List<AutoPiloto> getAutoPilotos() {return autoPilotos;}

    public void setNumeroCompetencia(int numeroCompetencia) {
        this.numeroCompetencia = numeroCompetencia;
    }
    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }
    public void setPolePosition(int polePosition) {
        this.polePosition = polePosition;
    }
    public void setVueltasRapidas(int vueltasRapidas) {
        this.vueltasRapidas = vueltasRapidas;
    }
    public void setPodios(int podios) {
        this.podios = podios;
    }
    public void setAutoPilotos(List<AutoPiloto> autoPilotos) {this.autoPilotos = autoPilotos;}
}
