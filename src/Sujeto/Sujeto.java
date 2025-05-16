package Sujeto;

import Observadores.Personaje;

public interface Sujeto {
    void agregarPersonaje(Personaje o);
    void establecerEstadoPersonaje();
    void notificarEstadoPersonaje();
}