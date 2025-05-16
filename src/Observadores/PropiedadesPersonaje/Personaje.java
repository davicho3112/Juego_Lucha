package Observadores.PropiedadesPersonaje;

import Observadores.PropiedadesPersonaje.Habilidades.Habilidad;

import java.util.List;

/**
 * Esta interfaz es el observador principal
 */

public interface Personaje extends Atacante , Estadistica {
    String getNombre();
    int getPuntosDeVida();
    Personaje clone();
    void actualizarEstado(String estadoSaludPersonaje);
    List<Habilidad> getHabilidades();
    void actualizarHabilidad(String habilidad);

}

