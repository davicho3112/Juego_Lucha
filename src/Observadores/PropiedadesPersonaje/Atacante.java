package Observadores.PropiedadesPersonaje;

public interface Atacante  {
    void atacar(Personaje oponente);
    void recibirDano(int dano);
    boolean estaVivo();

}
