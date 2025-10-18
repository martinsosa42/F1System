package modelo;
import java.util.ArrayList;
import java.util.List;

public class Piloto extends Persona{
    private int numeroCompetencia;
    private int victorias;
    private int polePosition;
    private int vueltasRapidas;
    private int podios;
    private List<AutoPiloto>autoPiloto;
    private List<PilotoEscuderia>pilotoEscuderia;


    public Piloto(){
        this.autoPiloto = new ArrayList<>();
        this.pilotoEscuderia = new ArrayList<>();
    }

    public Piloto(String dni,String nombre,String apellido,Pais pais,int numeroCompetencia, int victorias, int polePosition, int vueltasRapidas, int podios,List<AutoPiloto> autoPiloto,List<PilotoEscuderia>pilotoEscuderia){
        super(dni, nombre, apellido,pais);
        this.numeroCompetencia = numeroCompetencia;
        this.victorias = victorias;
        this.polePosition = polePosition;
        this.vueltasRapidas = vueltasRapidas;
        this.podios = podios;
        this.autoPiloto = autoPiloto;
        this.pilotoEscuderia = pilotoEscuderia;
    }

    public void agregarAutoPilotos(AutoPiloto ap){
        this.autoPiloto.add(ap);
    }

    public void agregegarEscuderia(PilotoEscuderia pe ){
        this.pilotoEscuderia.add(pe);
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
    public List<AutoPiloto> getAutoPiloto() {return autoPiloto;}

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
    public void setAutoPiloto(List<AutoPiloto> autoPiloto) {this.autoPiloto = autoPiloto;}

    @Override
    public String toString() {
        return super.toString() + " [#"+numeroCompetencia+"]";
    }
}
