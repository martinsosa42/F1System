package EscuderiasUnidas;
import java.util.ArrayList;
import java.util.List;

public class Piloto extends Persona{
    private int numeroCompetencia;
    private int victorias;
    private int polePosition;
    private int vueltasRapidas;
    private int podios;
    private List<Escuderia> escuderias;
    private List<Auto>autos;
    private List<AutoPiloto>autoPilotos;


    public Piloto(){
        this.escuderias = new ArrayList<>();
        this.autos = new ArrayList<>();
        this.autoPilotos = new ArrayList<>();
    }

    public Piloto(String dni,String nombre,String apellido,int numeroCompetencia, int victorias, int polePosition, int vueltasRapidas, int podios,List <Escuderia>escuderias,List <Auto> autos,List<Pais>paises){
        super(dni, nombre, apellido,paises);
        this.numeroCompetencia = numeroCompetencia;
        this.victorias = victorias;
        this.polePosition = polePosition;
        this.vueltasRapidas = vueltasRapidas;
        this.podios = podios;
        this.escuderias = escuderias;
        this.autos = autos;
        this.autoPilotos = autoPilotos;
    }

    //Metodos para agregar Escuderias y Autos a las listas.
    public void agregarEscuderia(Escuderia e){
        this.escuderias.add(e);
    }
    public void agregarAuto(Auto a){
        this.autos.add(a);
    }
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
    public List<Escuderia> getEscuderias() {
        return escuderias;
    }
    public List<Auto> getAutos() {
        return autos;
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
    public void setEscuderias(List<Escuderia> escuderias) {
        this.escuderias = escuderias;
    }
    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }
    public void setAutoPilotos(List<AutoPiloto> autoPilotos) {this.autoPilotos = autoPilotos;}
}
