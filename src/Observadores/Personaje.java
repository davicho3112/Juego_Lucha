package Observadores;

/**
 * Esta interfaz es el observador principal
 */

public interface Personaje {
    void atacar(Personaje oponente);
    void recibirDano(int dano);
    boolean estaVivo();
    String getNombre();
    int getPuntosDeVida();
    Personaje clone();
    void actualizarEstado(String estadoSaludPersonaje);

    // Métodos para estadísticas
    void sumarVictoria();
    void sumarDerrota();
    int getVictorias();
    int getDerrotas();
}

