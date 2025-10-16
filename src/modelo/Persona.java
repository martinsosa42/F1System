package modelo;

public abstract class Persona {
    protected String dni;
    protected String nombre;
    protected String apellido;

    public Persona(){}

    public Persona(String dni, String nombre, String apellido){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public String toString(){
        return nombre + " " + apellido + " (DNI:" + dni + ")";
    }
}
