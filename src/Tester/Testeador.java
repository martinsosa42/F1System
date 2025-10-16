package Tester;
import Modelo.*;
import GestorSistema.*;

import java.util.ArrayList;
import java.util.List;

public class Testeador {
    public static void main (String [] args){
        List<Escuderia> escuderias = new ArrayList<>();
        List<Pais>paises = new ArrayList<>();
        List<AutoPiloto>autoPilotos = new ArrayList<>();
        List<PilotoEscuderia>pilotosEscuderia = new ArrayList<>();
        List<Mecanico>mecanicos = new ArrayList<>();
        List<Piloto>pilotos = new ArrayList<>();
        List<Auto>autos = new ArrayList<>();

        metodo.agregarPais(1,"Argentina",new ArrayList<Escuderia>(),new ArrayList<Persona>(),new ArrayList<Circuito>(),new ArrayList<Carrera>());
        metodo.agregarPais(2,"España",new ArrayList<Escuderia>(),new ArrayList<Persona>(),new ArrayList<Circuito>(),new ArrayList<Carrera>());

        metodo.agregarPiloto("46467175","Martin","Sosa",0,0,0,0,new ArrayList<Pais>());
        metodo.agregarEscuderia("Ferrari","Italia",new ArrayList<Mecanico>(),new ArrayList<Auto>(),new ArrayList<Piloto>());

        metodo.agregarAutoPiloto("06/06/2005","");
        metodo.agregarAuto("Scuderia Ferrari","Ferrari 066/12 (híbrido V6 turbo)",new ArrayList<Escuderia>());

        metodo.agregarAutoPiloto("16/10/2025",);

    }
}
