import java.time.LocalDateTime;

public class Combate {
    private String jugador1;
    private String personaje1;
    private String jugador2;
    private String personaje2;
    private String ganador;
    private LocalDateTime fecha;

    public Combate(String jugador1, String personaje1, String jugador2, String personaje2, String ganador) {
        this.jugador1 = jugador1;
        this.personaje1 = personaje1;
        this.jugador2 = jugador2;
        this.personaje2 = personaje2;
        this.ganador = ganador;
        this.fecha = LocalDateTime.now();
    }

    public String getJugador1() {
        return jugador1;
    }

    public String getPersonaje1() {
        return personaje1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public String getPersonaje2() {
        return personaje2;
    }

    public String getGanador() {
        return ganador;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

}



