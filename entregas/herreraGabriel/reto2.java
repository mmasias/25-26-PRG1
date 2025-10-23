import java.util.Random;

public class reto2
{

    public static void main(String[] args) {
        final int VIDA_INICIAL_GUERRERO = 20;
        final int VIDA_INICIAL_VAMPIRO = 10;
        final int ATAQUE_GUERRERO = 2;
        final int ATAQUE_VAMPIRO = 4;
        final int PROBABILIDAD_ACIERTO = 50;

        int vidaGuerrero = VIDA_INICIAL_GUERRERO;
        int vidaVampiro = VIDA_INICIAL_VAMPIRO;

        int turno = 1;
        boolean batallaEnCurso = true;
        boolean turnoGuerrero = true;
        boolean ataqueAcertado = false;
        boolean guerreroGanador = false;
        boolean vampiroGanador = false;

        Random random = new Random();

        System.out.println("=== BATALLA: GUERRERO vs VAMPIRO ===\n");
        System.out.println("Guerrero: " + vidaGuerrero + " HP | Ataque: " + ATAQUE_GUERRERO);
        System.out.println("Vampiro: " + vidaVampiro + " HP | Ataque: " + ATAQUE_VAMPIRO);

        while (batallaEnCurso) {
            System.out.println("--- TURNO " + turno + " ---");

            if (turnoGuerrero) {
                System.out.print("El Guerrero ataca... ");

                int probabilidad = random.nextInt(100) + 1;

                if (probabilidad <= PROBABILIDAD_ACIERTO) {
                    ataqueAcertado = true;
                } else {
                    ataqueAcertado = false;
                }

                if (ataqueAcertado) {
                    vidaVampiro = vidaVampiro - ATAQUE_GUERRERO;
                    System.out.println(" Causa " + ATAQUE_GUERRERO + " de daño.");
                    System.out.println("Vida del Vampiro: " + vidaVampiro + " HP");
                } else {
                    System.out.println("El vampiro esquiva el ataque...");
                }

                turnoGuerrero = false;
            } else {
                System.out.print("El Vampiro ataca con sus colmillos... ");

                int probabilidad = random.nextInt(100) + 1;

                if (probabilidad <= PROBABILIDAD_ACIERTO) {
                    ataqueAcertado = true;
                } else {
                    ataqueAcertado = false;
                }

                if (ataqueAcertado) {
                    vidaGuerrero = vidaGuerrero - ATAQUE_VAMPIRO;
                    System.out.println("Causa " + ATAQUE_VAMPIRO + " de daño.");
                    System.out.println("Vida del Guerrero: " + vidaGuerrero + " HP");
                } else {
                    System.out.println("El guerrero esquiva el mordisco...");
                }

                turnoGuerrero = true;
                turno++;
            }

            System.out.println();

            if (vidaGuerrero <= 0 || vidaVampiro <= 0) {
                batallaEnCurso = false;
            }
        }

        boolean ganadorDeterminado = false;

        do {
            if (vidaGuerrero > 0 && vidaVampiro <= 0) {
                guerreroGanador = true;
                vampiroGanador = false;
                ganadorDeterminado = true;
            } else if (vidaVampiro > 0 && vidaGuerrero <= 0) {
                vampiroGanador = true;
                guerreroGanador = false;
                ganadorDeterminado = true;
            } else if (vidaGuerrero <= 0 && vidaVampiro <= 0) {
                // Empate (ambos caen simultáneamente)
                guerreroGanador = false;
                vampiroGanador = false;
                ganadorDeterminado = true;
            }
        } while (!ganadorDeterminado);

        System.out.println("=== FIN DE LA BATALLA ===\n");

        if (guerreroGanador) {
            System.out.println("¡VICTORIA DEL GUERRERO!");
            System.out.println("El guerrero ha derrotado al vampiro con honor.");
            System.out.println("Vida restante del Guerrero: " + vidaGuerrero + " HP");
        } else if (vampiroGanador) {
            System.out.println("¡VICTORIA DEL VAMPIRO!");
            System.out.println("El vampiro ha drenado la vida del guerrero.");
            System.out.println("Vida restante del Vampiro: " + vidaVampiro + " HP");
        } else {
            System.out.println("¡EMPATE MORTAL!");
            System.out.println("Ambos  han caído en combate.");
        }

        System.out.println("\nTurnos totales: " + turno);
    }
}