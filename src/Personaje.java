public interface Personaje extends Subject, Cloneable {
    void atacar(Personaje oponente);
    void recibirDano(int dano);
    boolean estaVivo();
    String getNombre();
    int getPuntosDeVida();
    EstadoPersonaje getEstado();
    void setEstado(EstadoPersonaje estado);
    Personaje clone();

    // Métodos para estadísticas
    void sumarVictoria();
    void sumarDerrota();
    int getVictorias();
    int getDerrotas();
}