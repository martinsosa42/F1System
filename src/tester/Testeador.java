package tester;
import modelo.*;
import gestion.*;

import java.util.ArrayList;
import java.util.List;

public class Testeador {
    public static void main (String [] args){
        List<Carrera> listaCarrera = new ArrayList<>();
        List<Piloto>pilotos = new ArrayList<>();
        List<Mecanico>mecanicos = new ArrayList<>();
        List<Auto>autos = new ArrayList<>();
        List<Escuderia>escuderias = new ArrayList<>();
        List<Circuito>circuitos = new ArrayList<>();
        List<Pais> paises = new ArrayList<>();
        List<Carrera>carreras = new ArrayList<>();
        List<PilotoEscuderia> pilotoEscuderia = new ArrayList<>();
        List<AutoPiloto>autoPiloto = new ArrayList<>();

        Pais pa1 = new Pais(1,"Argentina",escuderias,circuitos,carreras);
        Piloto p1 = new Piloto("46467175","Martin","Sosa",0,0,0,0,0,pa1,autoPiloto,pilotoEscuderia);
        Escuderia e1 = new Escuderia("Ferrari",pa1,mecanicos,autos,pilotoEscuderia);
        Mecanico m1 = new Mecanico("25344545", "Juan","Perez",Especialidad.MOTOR,8,escuderias);
        Escuderia e1 = new Escuderia("Ferrari",pa1,mecanicos,autos,pilotoEscuderia);
    }
}
