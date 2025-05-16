package Observadores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SubZero implements Personaje {
    private String nombre;
    private int puntosDeVida;
    private String estadoPersonaje;
    private final int MAX_DANO;
    private final int MIN_DANO;
    private int victorias;
    private int derrotas;

    public SubZero(String nombre) {

        this.nombre = nombre;
        puntosDeVida = 100;
        estadoPersonaje = "Salud Máxima";
        MAX_DANO = 30;
        MIN_DANO = 10;
        victorias = 0;
        derrotas = 0;
    }

    @Override
    public void atacar(Personaje oponente) {
        int dano = new Random().nextInt((MAX_DANO - MIN_DANO) + 1) + MIN_DANO;
        oponente.recibirDano(dano);
        System.out.println(nombre + " lanza una bola de hielo a " + oponente.getNombre() + " causando " + dano + " puntos de daño.");
    }

    @Override
    public void recibirDano(int dano) {
        puntosDeVida -= dano;
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

    public void actualizarEstado(String estadoSaludPersonaje){
        this.estadoPersonaje = estadoSaludPersonaje;
        System.out.println("SubZero: " + estadoPersonaje);

    }

    /**
     * Metodo para realizar la clonacion del objeto Kratos
     * @return
     */
    @Override
    public Personaje clone() {
        return new SubZero(this.nombre);
    }

}