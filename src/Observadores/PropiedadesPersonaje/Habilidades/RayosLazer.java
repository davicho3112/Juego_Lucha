package Observadores.PropiedadesPersonaje.Habilidades;

public class RayosLazer extends Habilidad {
    @Override
    public String ejecutar() {
        return "Dispara rayos láser";
    }

    @Override
    public String getNombre() {
        return "Rayos Lazer";
    }
}