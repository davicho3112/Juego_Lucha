package Observadores.PropiedadesPersonaje.Habilidades;

public class Espada extends Habilidad {
    @Override
    public String ejecutar() {
        return "Ataque con espada";
    }

    @Override
    public String getNombre() {
        return "Espada";
    }
}