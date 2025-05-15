public class Jugador implements Observer {
    private String nombre;
    private Personaje personaje;
    private int puntaje = 0;

    public Jugador(String nombre) { this.nombre = nombre; }

    public void seleccionarPersonaje(Personaje prototipo) {
        this.personaje = prototipo.clone();
        this.personaje.addObserver(this);
        System.out.printf("%s ha seleccionado a %s\n", nombre, personaje.getNombre());
    }

    public int getPuntaje() { return puntaje; }
    public String getNombre() { return nombre; }
    public Personaje getPersonaje() { return personaje; }

    @Override
    public void update(Subject subject) {
        if (subject instanceof Personaje) {
            Personaje personaje = (Personaje) subject;
            int vida = personaje.getPuntosDeVida();
            String estadoSalud;
            if (vida >= 70) {
                estadoSalud = "Salud Máxima";
            } else if (vida >= 40) {
                estadoSalud = "Salud Estable";
            } else if (vida >= 1) {
                estadoSalud = "Salud Crítico";
            } else {
                estadoSalud = "Muerto";
            }
            System.out.printf("Estado de %s: %s (%d%% de vida)\n", personaje.getNombre(), estadoSalud, vida);
        }
    }

    public void sumarPunto() {
        puntaje++;
        System.out.printf("%s gana un punto! Nuevo puntaje: %d\n", nombre, puntaje);
    }
}