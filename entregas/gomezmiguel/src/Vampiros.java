

import java.util.Scanner

public class Vampiros {
    private static final int VIDA_INICIAL_HEROE = 150;
    private static final int UMBRAL_DESMAYO_HEROE = 30;
    private static final int RECUPERACION_DESMAYO = 2;
    private static final int DANIO_ARMA_1 = 7;
    private static final double PROB_ARMA_1 = 0.5;
    private static final int DANIO_ARMA_2 = 15;
    private static final double PROB_ARMA_2 = 0.25;
    private static final int DANIO_ARMA_3 = 30;
    private static final double PROB_ARMA_3 = 0.12;
    private static final double PROB_DEFENSA = 0.8;
    private static final int REDUCCION_DEFENSA = 5;
    private static final int VIDA_INICIAL_VAMPIRO = 60;
    private static final int UMBRAL_DESMAYO_VAMPIRO = 20;
    private static final int NUM_ATAQUES_VAMPIRO = 3;
    private static final int DANIO_ATAQUE_1 = 5;
    private static final double PROB_ATAQUE_1 = 0.9;
    private static final int DANIO_ATAQUE_2 = 10;
    private static final double PROB_ATAQUE_2 = 0.6;
    private static final int DANIO_ATAQUE_3 = 20;
    private static final double PROB_ATAQUE_3 = 0.4;
    private static final int TURNO_DESBLOQUEO_POCION = 3;
    private static final int DURACION_POCION = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vidaHeroe = VIDA_INICIAL_HEROE;
        boolean desmayoHeroe = false;
        boolean pocionDisponible = false;
        boolean turnoBloqueado = false;
        int turnoInicioBloqueo = 0;
        int vidaVampiro = VIDA_INICIAL_VAMPIRO;
        boolean desmayoVampiro = false;
        int turno = 0;
        boolean batallaActiva = true;

        while (batallaActiva) {
            turno++;
            System.out.println("TURNO " + turno + ":");

            if (turno == TURNO_DESBLOQUEO_POCION) {
                pocionDisponible = true;
                System.out.println("Se ha desbloqueado la poción mística.");
            }

            if (turnoBloqueado && turno == turnoInicioBloqueo + DURACION_POCION) {
                turnoBloqueado = false;
                vidaHeroe = VIDA_INICIAL_HEROE;
                System.out.println("La vida del héroe se regeneró por completo!!");
            }

            int opcionHeroe = 0;
            if (!turnoBloqueado) {
                String opcionesPocion = pocionDisponible ? "\n5: (Poción mística // Bloquea 3 turnos // Regenera vida completa)" : "";
                System.out.println("Elige una acción:\n1: Arma 1 (" + DANIO_ARMA_1 + " dmg / " + (int)(PROB_ARMA_1 * 100) + "% prob)\n2: Arma 2 (" + DANIO_ARMA_2 + " dmg / " + (int)(PROB_ARMA_2 * 100) + "% prob)\n3: Arma 3 (" + DANIO_ARMA_3 + " dmg / " + (int)(PROB_ARMA_3 * 100) + "% prob)\n4: Defenderse (0 dmg / " + (int)(PROB_DEFENSA * 100) + "% prob / Reduce " + REDUCCION_DEFENSA + " dmg vampiro)" + opcionesPocion);
                
                opcionHeroe = scanner.nextInt();
                if (opcionHeroe < 1 || opcionHeroe > (pocionDisponible ? 5 : 4)) {
                    System.out.println("Opción inválida. Atacas con un plátano (0 dmg / 0% prob).");
                    opcionHeroe = 0;
                }
            }

            if (opcionHeroe == 5 && pocionDisponible) {
                turnoBloqueado = true;
                turnoInicioBloqueo = turno;
                pocionDisponible = false;
                System.out.println("Usas la poción. Tu turno queda bloqueado por " + DURACION_POCION + " turnos.");
            }

            if (!turnoBloqueado && !desmayoHeroe) {
                procesarAtaqueHeroe(opcionHeroe, vidaVampiro);
            } else if (turnoBloqueado) {
                System.out.println("Tu turno está bloqueado por la poción.");
            } else {
                System.out.println("El héroe está desmayado y no puede atacar.");
            }

            if (vidaVampiro <= 0) {
                System.out.println("El héroe mató al vampiro!!");
                batallaActiva = false;
            } else if (vidaVampiro < UMBRAL_DESMAYO_VAMPIRO) {
                desmayoVampiro = true;
                vidaVampiro += RECUPERACION_DESMAYO;
                System.out.println("El vampiro se ha desmayado. Recupera " + RECUPERACION_DESMAYO + " puntos de vida.");
            } else {
                desmayoVampiro = false;
            }

            if (batallaActiva && !desmayoVampiro) {
                procesarAtaqueVampiro(vidaHeroe);
            } else if (batallaActiva) {
                System.out.println("El vampiro está desmayado y no puede atacar.");
            }

            if (vidaHeroe <= 0) {
                System.out.println("El vampiro mató al héroe!!");
                batallaActiva = false;
            } else if (vidaHeroe < UMBRAL_DESMAYO_HEROE) {
                desmayoHeroe = true;
                vidaHeroe += RECUPERACION_DESMAYO;
                System.out.println("El héroe se ha desmayado. Recupera " + RECUPERACION_DESMAYO + " puntos de vida.");
            } else {
                desmayoHeroe = false;
            }

            System.out.println("Vida del héroe: [" + vidaHeroe + "/" + VIDA_INICIAL_HEROE + "] | Vida del vampiro: [" + vidaVampiro + "/" + VIDA_INICIAL_VAMPIRO + "]");
            System.out.println("-----------------------------");
        }

        scanner.close();
    }

    private static int procesarAtaqueHeroe(int opcion, int vidaVampiro) {
        double prob = 0.0;
        int danio = 0;
        boolean esDefensa = false;

        if (opcion == 1) {
            prob = PROB_ARMA_1;
            danio = DANIO_ARMA_1;
        } else if (opcion == 2) {
            prob = PROB_ARMA_2;
            danio = DANIO_ARMA_2;
        } else if (opcion == 3) {
            prob = PROB_ARMA_3;
            danio = DANIO_ARMA_3;
        } else if (opcion == 4) {
            prob = PROB_DEFENSA;
            esDefensa = true;
        } else {
            prob = 0.0;
        }

        if (Math.random() < prob) {
            if (esDefensa) {
                System.out.println("Te defiendes exitosamente del vampiro.");
                return REDUCCION_DEFENSA;
            } else {
                System.out.println("El vampiro recibe un tajo!!");
                vidaVampiro -= danio;
            }
        } else {
            if (esDefensa) {
                System.out.println("No logras defenderte del vampiro.");
            } else {
                System.out.println("El vampiro esquiva el ataque.");
            }
        }
        return 0;
    }

    private static void procesarAtaqueVampiro(int vidaHeroe) {
        int ataque = (int) (Math.random() * NUM_ATAQUES_VAMPIRO) + 1;
        double prob = 0.0;
        int danio = 0;

        if (ataque == 1) {
            prob = PROB_ATAQUE_1;
            danio = DANIO_ATAQUE_1;
        } else if (ataque == 2) {
            prob = PROB_ATAQUE_2;
            danio = DANIO_ATAQUE_2;
        } else if (ataque == 3) {
            prob = PROB_ATAQUE_3;
            danio = DANIO_ATAQUE_3;
        }

        if (Math.random() < prob) {
            System.out.println("El héroe recibe un mordisco!!");
            vidaHeroe -= danio;
        } else {
            System.out.println("El héroe esquiva el mordisco.");
        }
    }
}