package modelo;

public class PilotoEscuderia {
    private String desdeFecha;
    private String hastaFecha;
    private Escuderia escuderia;
    private Piloto piloto;

    public PilotoEscuderia() {}

    public PilotoEscuderia(String desdeFecha, String hastaFecha,Escuderia escuderia, Piloto piloto) {
        this.desdeFecha = desdeFecha;
        this.hastaFecha = hastaFecha;
        this.escuderia = escuderia;
        this.piloto = piloto;
    }

    public String getDesdeFecha() {
        return desdeFecha;
    }
    public String getHastaFecha() {
        return hastaFecha;
    }
    public Escuderia getEscuderia() {
        return escuderia;
    }
    public Piloto getPiloto() {
        return piloto;
    }

    public void setDesdeFecha(String desdeFecha) {
        this.desdeFecha = desdeFecha;
    }
    public void setHastaFecha(String hastaFecha) {
        this.hastaFecha = hastaFecha;
    }
    public void setEscuderia(Escuderia escuderia) {
        this.escuderia = escuderia;
    }
    public void setPiloto(Piloto piloto) {this.piloto = piloto;}
}
