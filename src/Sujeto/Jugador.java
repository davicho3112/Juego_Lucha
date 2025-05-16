package Sujeto;

import Observadores.Personaje;

import java.util.ArrayList;
import java.util.List;

/**
 * En la clase Sujeto.Jugador se realizara las clonaciones de personajes y
 * el cambio de estado de salud de los personajes
 */
public class Jugador implements Sujeto,Cloneable {
    private String nombre;
    private Personaje personaje;
    private List<Personaje> estadoPersonaje = new ArrayList<>(); // Se agregan los observadores ( que serian los personajes )
    private int puntaje = 0;
    private String estadoSalud;

    public Jugador(String nombre) { this.nombre = nombre; }

    /**
     * Metodo que se encarga de clonar los objetos personaje.
     * @param prototipo
     */
    public void seleccionarPersonaje(Personaje prototipo) {
        this.personaje = prototipo.clone(); // Clonamos el personaje que escogio el jugador
        agregarPersonaje(this.personaje);
        System.out.printf("%s ha seleccionado a %s\n", nombre, personaje.getNombre());
    }

    public int getPuntaje() { return puntaje; }
    public String getNombre() { return nombre; }
    public Personaje getPersonaje() { return personaje; }

    /**
     * Metodo que se encarga de sumar puntos de cada jugador
     */
    public void sumarPunto() {
        puntaje++;
        System.out.printf("%s gana un punto! Nuevo puntaje: %d\n", nombre, puntaje);
    }

    /**
     * Metodo que se encarga de agregar a los observadores
     * @param p
     */
    public void agregarPersonaje(Personaje p){

        estadoPersonaje.add(p);

    }

    //Analiza como en el Main se esta llamando este metodo y se realizen correctamente los cambios de estado

    /**
     * Metodo que se encarga de asignar el estado de salud correspondiente al personaje.
     * Si sus puntos de vida esta entre 70 - 100 su salud es maxima.
     * Si sus puntos de vida esta entre 40 - 70 su salud es estable.
     * Si sus puntos de vida esta entre 1 - 40 su salud es critico.
     */
    public void establecerEstadoPersonaje(){

        int vida = personaje.getPuntosDeVida();

        if (vida >= 70) {
            this.estadoSalud = "Salud Máxima";
        } else if (vida >= 40) {
            this.estadoSalud = "Salud Estable";
        } else if (vida >= 1) {
            this.estadoSalud = "Salud Crítico";
        } else {
            this.estadoSalud = "Muerto";
        }
        System.out.printf("Estado de %s: %s (%d%% de vida)\n", personaje.getNombre(), estadoSalud, vida);
        notificarEstadoPersonaje();

    }

    /**
     * Metodo se encarga de encontrar al personaje y actualizar su estado de salud.
     */
    public void notificarEstadoPersonaje(){

        for(Personaje p : estadoPersonaje){
            p.actualizarEstado( estadoSalud);
        }
    }


}