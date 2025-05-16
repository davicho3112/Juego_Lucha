package Observadores.PropiedadesPersonaje.Habilidades;

public class Congelar extends Habilidad {
    @Override
    public String ejecutar() {
        return "Congela al enemigo";
    }

    @Override
    public String getNombre() {
        return "Congelar";
    }
}