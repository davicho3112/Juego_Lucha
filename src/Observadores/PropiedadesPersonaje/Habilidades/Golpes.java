package Observadores.PropiedadesPersonaje.Habilidades;

public class Golpes extends Habilidad {
    @Override
    public String ejecutar() {
        return "Ataque cuerpo a cuerpo";
    }

    @Override
    public String getNombre() {
        return "Golpes";
    }
}
