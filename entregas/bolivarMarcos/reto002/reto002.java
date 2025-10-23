package entregas.bolivarMarcos.reto002;

import java.util.Scanner;

public class reto002 {
    public static void main(String[] args) {

        int numeroArmaEscogida = 0;
        int numeroAtaqueVampiro;
        final int MAX_VIDA_HEROE = 160;
        int vidaHeroe = MAX_VIDA_HEROE;
        final int DAÑO_HEROE_ARMA_1 = 7;
        final int DAÑO_HEROE_ARMA_2 = 15;
        final int DAÑO_HEROE_ARMA_3 = 30;
        final int DEFENSA_HEROE = 0;
        int dañoHeroe = 0;
        double probabilidadExitoHeroe = 0;
        final int VIDA_MINIMA_DESMAYO_HEROE = 20;
        boolean desmayoHeroe = false;

        final int MAX_VIDA_VAMPIRO = 60;
        final int CANTIDAD_ATAQUES_VAMPIRO = 3;
        final int DAÑO_VAMPIRO_ATAQUE_1 = 5;
        final int DAÑO_VAMPIRO_ATAQUE_2 = 10;
        final int DAÑO_VAMPIRO_ATAQUE_3 = 20;
        int vidaVampiro = MAX_VIDA_VAMPIRO;
        double probabilidadExitoVampiro = 0;
        int dañoVampiro = 0;
        final int VIDA_MINIMA_DESMAYO_VAMPIRO = 20;
        boolean alguienVivo = true;
        boolean vampiroVivo = true;
        boolean desmayoVampiro = false;
        int turno = 0;
        boolean pocion = false;
        boolean turnoBloqueado = false;
        int turnoActual = 0;

        Scanner input = new Scanner(System.in);

        while (alguienVivo) {

            turno++;
            System.out.println("TURNO " + turno + ":");

            if (turno == 3) {
                pocion = true;
                System.out.println("Se ha desbloqueado la poción mística");
            }
            if (!turnoBloqueado) {
                String pocionDisponible = (pocion)
                        ? "\n5 (Poción mística // 3 turnos sin atacar ni defenderte // +100% hp)"
                        : " ";
                System.out.println(
                        "Con que arma quieres atacar al vampiro?\n1: (7 dmg/50% prob)\n2: (15 dmg/25% prob)\n3: (30 dmg/12% prob)\n4 (Defenderse // 0 dmg/80% prob/-5 dmg vampiro)"
                                + pocionDisponible);
                numeroArmaEscogida = input.nextInt();
            }

            if (numeroArmaEscogida == 5 && pocion) {
                turnoBloqueado = true;
                turnoActual = turno;
                pocion = false;
            }
            if (turno == turnoActual + 3) {
                turnoBloqueado = false;
                vidaHeroe = MAX_VIDA_HEROE;
                System.out.println("La vida del heroe se regeneró por completo!!");
            }

            numeroAtaqueVampiro = (int) (Math.random() * CANTIDAD_ATAQUES_VAMPIRO) + 1;
            if (numeroAtaqueVampiro == 1) {
                probabilidadExitoVampiro = 0.9;
                dañoVampiro = DAÑO_VAMPIRO_ATAQUE_1;
            } else if (numeroAtaqueVampiro == 2) {
                probabilidadExitoVampiro = 0.6;
                dañoVampiro = DAÑO_VAMPIRO_ATAQUE_2;
            } else if (numeroAtaqueVampiro == 3) {
                probabilidadExitoVampiro = 0.4;
                dañoVampiro = DAÑO_VAMPIRO_ATAQUE_3;
            }

            if (numeroArmaEscogida == 1) {
                probabilidadExitoHeroe = 0.5;
                dañoHeroe = DAÑO_HEROE_ARMA_1;
            } else if (numeroArmaEscogida == 2) {
                probabilidadExitoHeroe = 0.25;
                dañoHeroe = DAÑO_HEROE_ARMA_2;
            } else if (numeroArmaEscogida == 3) {
                probabilidadExitoHeroe = 0.12;
                dañoHeroe = DAÑO_HEROE_ARMA_3;
            } else if (numeroArmaEscogida == 4) {
                probabilidadExitoHeroe = 0.8;
                dañoHeroe = DEFENSA_HEROE;
                dañoVampiro = dañoVampiro - 5;
                probabilidadExitoVampiro = 1;
            } else if (numeroArmaEscogida != 5) {
                System.out.println("Te equivocas e intentas pegar al vampiro con un plátano!!");
                probabilidadExitoHeroe = 0;
                dañoHeroe = 0;
                dañoVampiro = vidaHeroe;
                probabilidadExitoVampiro = 1;

            }
            if (!turnoBloqueado) {
                if (!desmayoHeroe) {
                    if (Math.random() < probabilidadExitoHeroe && numeroArmaEscogida != 4) {
                        System.out.println("El vampiro se lleva un tajo!!");
                        vidaVampiro = vidaVampiro - dañoHeroe;
                    } else if (Math.random() < probabilidadExitoHeroe && numeroArmaEscogida == 4) {
                        System.out.println("Te defiendes a duras penas del vampiro!!");
                    } else if (Math.random() > probabilidadExitoHeroe && numeroArmaEscogida == 4) {
                        System.out.println("No logras defenderte del vampiro!!");
                    } else {
                        System.out.println("El vampiro ha esquivado el ataque!!");
                    }

                } else {
                    System.out.println("El heroe está desmayado y no puede atacar!!");
                }
            } else {
                System.out.println("Tu turno está bloqueado por la poción");
            }

            if (vidaVampiro <= 0) {
                vampiroVivo = false;
            }
            if (vidaVampiro < VIDA_MINIMA_DESMAYO_VAMPIRO && vampiroVivo) {
                desmayoVampiro = true;
                System.out.println(
                        "El vampiro se ha desmayado del dolor!! // Al descansar ha recuperado 2 puntos de vida");
                vidaVampiro = vidaVampiro + 2;
            } else {
                desmayoVampiro = false;
            }

            if (vampiroVivo && !desmayoVampiro) {
                if (Math.random() < probabilidadExitoVampiro) {
                    System.out.println("El heroe se lleva un mordisco!!");
                    vidaHeroe = vidaHeroe - dañoVampiro;
                } else {
                    System.out.println("El heroe ha esquivado el mordisco!!");
                }
            } else {
                System.out.println("El vampiro está desamyado y no puede atacar!!");
            }
            if (vidaHeroe < VIDA_MINIMA_DESMAYO_HEROE && vidaHeroe > 0) {
                desmayoHeroe = true;
                System.out
                        .println("El héroe se ha desmayado del dolor!! // Al descansar ha recuperado 2 puntos de vida");
                vidaHeroe += 2;
            } else {
                desmayoHeroe = false;
            }
            System.out.println("La vida del heroe es [" + vidaHeroe + "]/La vida del vampiro es [" + vidaVampiro + "]");
            if (vidaHeroe <= 0 || !vampiroVivo) {
                if (vampiroVivo) {
                    System.out.println("El vampiro mató al heroe!!");

                } else {
                    System.out.println("El heroe mató al vampiro!!");
                }
                alguienVivo = false;
            }
            System.out.println("-----------------------------");

        }

    }
}