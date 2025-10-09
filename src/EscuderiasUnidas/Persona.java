package EscuderiasUnidas;
import java.util.List;
import java.util.ArrayList;

public abstract class Persona {
    protected String dni;
    protected String nombre;
    protected String apellido;
    private List<Pais>paises;

    public Persona(){
        this.paises = new ArrayList<>();
    }

    public Persona(String dni, String nombre, String apellido,List<Pais>paises){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.paises = paises;
    }

    public void agregarPais(Pais p){
        this.paises.add(p);
    }

    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
