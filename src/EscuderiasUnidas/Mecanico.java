package EscuderiasUnidas;
import java.lang.Enum;

public class Mecanico extends Persona{
    private Especialidad especialidad;
    private int aniosExperiencia;

    public Mecanico(String dni, String nombre, String apellido, Especialidad especialidad, int aniosExperiencia){
        super(dni, nombre, apellido);
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public enum Especialidad{
        MOTOR,
        NEUMATICOS,
        CHASIS,
        ELECTRONICA
    }

}

