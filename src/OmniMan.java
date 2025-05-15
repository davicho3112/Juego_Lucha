import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OmniMan implements Personaje {
    private String nombre;
    private int puntosDeVida = 100;
    private EstadoPersonaje estado = EstadoPersonaje.VIVO;
    private List<Observer> observers = new ArrayList<>();
    private final int MAX_DANO = 40;
    private final int MIN_DANO = 20;
    private int victorias = 0;
    private int derrotas = 0;

    public OmniMan(String nombre) {

        this.nombre = nombre;
    }

    @Override
    public void atacar(Personaje oponente) {
        int dano = new Random().nextInt((MAX_DANO - MIN_DANO) + 1) + MIN_DANO;
        oponente.recibirDano(dano);
        System.out.println(nombre + " golpea brutalmente a " + oponente.getNombre() + " causando " + dano + " puntos de daño.");
    }

    @Override
    public void recibirDano(int dano) {
        puntosDeVida -= dano;
        if (puntosDeVida <= 0) {
            puntosDeVida = 0;
            setEstado(EstadoPersonaje.MUERTO);
        }
        notifyObservers();
    }

    @Override
    public boolean estaVivo() {
        return puntosDeVida > 0;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    @Override
    public EstadoPersonaje getEstado() {
        return estado;
    }

    @Override
    public void setEstado(EstadoPersonaje estado) {
        this.estado = estado;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) o.update(this);
    }

    @Override
    public Personaje clone() {
        return new OmniMan(this.nombre);
    }

    @Override
    public void sumarVictoria() {
        victorias++;
    }

    @Override
    public void sumarDerrota() {
        derrotas++;
    }

    @Override
    public int getVictorias() {
        return victorias;
    }

    @Override
    public int getDerrotas() {
        return derrotas;
    }
}