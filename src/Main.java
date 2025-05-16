import Observadores.Kratos;
import Observadores.OmniMan;
import Observadores.Personaje;
import Observadores.SubZero;
import Sujeto.Jugador;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Combate> historialCombates = new ArrayList<>();
        Jugador jugador1, jugador2;

        while (true) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Iniciar una partida");
            System.out.println("2. Ver tablas de lucha");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int opcion = pedirOpcionMenu(scanner);

            if (opcion == 1) {
                System.out.print("Introduce el nombre del jugador 1: ");
                String nombre1 = scanner.nextLine();
                jugador1 = new Jugador(nombre1);

                System.out.print("Introduce el nombre del jugador 2: ");
                String nombre2 = scanner.nextLine();
                jugador2 = new Jugador(nombre2);

                boolean repetir = true;
                while (repetir) {
                    System.out.println("Personajes disponibles: ");
                    System.out.println("1. Observadores.Kratos");
                    System.out.println("2. Observadores.OmniMan");
                    System.out.println("3. Observadores.SubZero");

                    int opcion1 = pedirOpcionPersonaje(scanner, nombre1);
                    int opcion2 = pedirOpcionPersonaje(scanner, nombre2);

                    //En los argumentos de la funcion se le pasa el personaje que elige el jugador
                    jugador1.seleccionarPersonaje(crearPersonajePorOpcion(opcion1));
                    jugador2.seleccionarPersonaje(crearPersonajePorOpcion(opcion2));

                    JuegoLucha juego = new JuegoLucha(jugador1, jugador2, historialCombates);
                    juego.iniciarPelea();

                    System.out.print("¿Desean repetir la pelea? (s/n): ");
                    String resp = scanner.next();
                    scanner.nextLine();
                    repetir = resp.equalsIgnoreCase("s");
                }
            } else if (opcion == 2) {
                if (historialCombates.isEmpty()) {
                    System.out.println("No hay peleas registradas.");
                    continue;
                }
                System.out.print("Introduce el nombre del jugador para ver estadísticas: ");
                String nombre = scanner.nextLine();
                JuegoLucha.mostrarEstadisticas(historialCombates, nombre);
                JuegoLucha.mostrarTabla(historialCombates);
            } else if (opcion == 3) {
                System.out.println("¡Hasta luego!");
                break;
            }
        }
    }

    //Metodo para validar la opcion del jugador cuando interactua en el menu
    private static int pedirOpcionMenu(Scanner scanner) {
        int opcion = -1;
        while (true) {
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion >= 1 && opcion <= 3) {
                    break;
                } else {
                    System.out.print("Opción inválida. Elige 1, 2 o 3: ");
                }
            } else {
                System.out.print("Entrada no válida. Debes ingresar un número: ");
                scanner.next();
            }
        }
        return opcion;
    }

    //Metodo para validar la opcion del jugador cuando escoge el personaje
    private static int pedirOpcionPersonaje(Scanner scanner, String nombreJugador) {
        int opcion;
        while (true) {
            System.out.print(nombreJugador + ", elige tu personaje (1-3): ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion >= 1 && opcion <= 3) {
                    break;
                } else {
                    System.out.println("Opción inválida. Elige un número entre 1 y 3.");
                }
            } else {
                System.out.println("Entrada no válida. Debes ingresar un número.");
                scanner.next();
            }
        }
        return opcion;
    }

    //Metodo para escoger correctamente el personaje
    private static Personaje crearPersonajePorOpcion(int opcion) {
        switch (opcion) {
            case 1: return new Kratos("Observadores.Kratos");
            case 2: return new OmniMan("Observadores.OmniMan");
            case 3: return new SubZero("Observadores.SubZero");
            default: throw new IllegalArgumentException("Opción de personaje inválida.");
        }
    }
}

