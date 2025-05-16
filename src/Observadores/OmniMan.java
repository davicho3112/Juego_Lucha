package Observadores;

import Observadores.PropiedadesPersonaje.Personaje;
import Observadores.PropiedadesPersonaje.Habilidades.*;

import java.util.List;
import java.util.Random;

public class OmniMan   implements Personaje   {
    private String nombre;
    private int puntosDeVida;
    private String estadoPersonaje;
    private final int MAX_DANO;
    private final int MIN_DANO;
    private int victorias;
    private int derrotas;
    private List<Habilidad> habilidades;


    public OmniMan(String nombre) {

        this.nombre = nombre;
        puntosDeVida = 100;
        estadoPersonaje = "Salud Máxima";
        MAX_DANO = 40;
        MIN_DANO = 20;
        victorias = 0;
        derrotas = 0;
        habilidades = List.of(new Golpes(), new RayosLazer());// Creamos una lista inmutible que contendra las habilidades. En ella no se puede añadir ni remover.

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
    }

    @Override
    public List<Habilidad> getHabilidades() {
        return habilidades;
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
        System.out.println("OmniMan: " + estadoPersonaje);

    }

    public void actualizarHabilidad(String habilidad) {
        System.out.println("OmniMan: " + habilidad);
    }

        /**
         * Metodo para realizar la clonacion del objeto Kratos
         * @return
         */
    @Override
    public Personaje clone() {
        return new OmniMan(this.nombre);
    }


}