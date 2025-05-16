import Observadores.Personaje;
import Sujeto.Jugador;

import java.util.*;
import java.time.format.DateTimeFormatter;

public class JuegoLucha {
    private List<Combate> combates;
    private Jugador jugador1;
    private Jugador jugador2;

    public JuegoLucha(Jugador jugador1, Jugador jugador2, List<Combate> combates) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.combates = combates;
    }

    public void iniciarPelea() {
        System.out.println("La pelea comienza entre " +
                jugador1.getPersonaje().getNombre() + " y " + jugador2.getPersonaje().getNombre() + "...");

        while (jugador1.getPersonaje().estaVivo() && jugador2.getPersonaje().estaVivo()) {
            turno(jugador1.getPersonaje(), jugador2.getPersonaje());
            if (jugador2.getPersonaje().estaVivo()) {
                turno(jugador2.getPersonaje(), jugador1.getPersonaje());
            }

        }

        String ganador;
        Personaje personajeGanador, personajePerdedor;
        if (jugador1.getPersonaje().estaVivo()) {
            ganador = jugador1.getNombre();
            jugador1.sumarPunto();
            personajeGanador = jugador1.getPersonaje();
            personajePerdedor = jugador2.getPersonaje();
        } else {
            ganador = jugador2.getNombre();
            jugador2.sumarPunto();
            personajeGanador = jugador2.getPersonaje();
            personajePerdedor = jugador1.getPersonaje();
        }
        personajeGanador.sumarVictoria();
        personajePerdedor.sumarDerrota();

        Combate combate = new Combate(
                jugador1.getNombre(), jugador1.getPersonaje().getNombre(),
                jugador2.getNombre(), jugador2.getPersonaje().getNombre(),
                ganador
        );
        combates.add(combate);

        String resultado = String.format(
                "Ganador: %s\n" +
                        "%s (%s) - Vida: %d, Puntaje: %d\n" +
                        "%s (%s) - Vida: %d, Puntaje: %d\n",
                ganador,
                jugador1.getNombre(), jugador1.getPersonaje().getNombre(), jugador1.getPersonaje().getPuntosDeVida(), jugador1.getPuntaje(),
                jugador2.getNombre(), jugador2.getPersonaje().getNombre(), jugador2.getPersonaje().getPuntosDeVida(), jugador2.getPuntaje()
        );
        System.out.println(resultado);
    }

    /**
     * En el metodo turno podemos ver que se realiza el ataque de un personaje a otro y sus cambios
     * de estado de salud.
     * @param atacante
     * @param defensor
     */
    private void turno(Personaje atacante, Personaje defensor) {

        System.out.println("Turno de " + atacante.getNombre() +
                ". Puntos de vida de " + defensor.getNombre() +
                ": " + defensor.getPuntosDeVida());
        atacante.atacar(defensor);

        if (defensor == jugador1.getPersonaje()) {
            jugador1.establecerEstadoPersonaje();
        } else {
            jugador2.establecerEstadoPersonaje();
        }
        System.out.println(defensor.getNombre() + " ahora tiene " +
                defensor.getPuntosDeVida() + " puntos de vida.");
    }

    // Métodos estáticos para mostrar historial y estadísticas
    public static void mostrarTabla(List<Combate> combates) {
        System.out.println("=== Tabla de peleas ===");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (Combate c : combates) {
            System.out.printf("Fecha: %s | %s (%s) vs %s (%s) | Ganador: %s\n",
                    c.getFecha().format(formatter),
                    c.getJugador1(), c.getPersonaje1(),
                    c.getJugador2(), c.getPersonaje2(),
                    c.getGanador());
        }
    }

    public static void mostrarEstadisticas(List<Combate> combates, String nombreJugador) {
        System.out.println("=== Estadísticas de " + nombreJugador + " ===");
        int victorias = 0, derrotas = 0;
        for (Combate c : combates) {
            if (c.getJugador1().equals(nombreJugador)) {
                if (c.getGanador().equals(nombreJugador)) victorias++;
                else derrotas++;
            } else if (c.getJugador2().equals(nombreJugador)) {
                if (c.getGanador().equals(nombreJugador)) victorias++;
                else derrotas++;
            }
        }
        System.out.printf("Victorias: %d\nDerrotas: %d\n", victorias, derrotas);
    }

}

