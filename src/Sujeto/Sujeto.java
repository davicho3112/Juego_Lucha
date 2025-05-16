package Sujeto;

import Observadores.PropiedadesPersonaje.Personaje;

public interface Sujeto {
    void agregarPersonaje(Personaje o);
    void establecerEstadoPersonaje();
    void notificarEstadoPersonaje();
}