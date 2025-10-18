package modelo;

public abstract class Persona {
    protected String dni;
    protected String nombre;
    protected String apellido;
    protected Pais pais;

    public Persona(){}

    public Persona(String dni, String nombre, String apellido,Pais pais){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
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
    public Pais getPais() {
        return pais;
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
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String toString(){
        return nombre + " " + apellido + " (DNI:" + dni + ")";
    }
}
