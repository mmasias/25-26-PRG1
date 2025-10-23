package entregas.bolivarMarcos.reto002;

import java.util.Scanner;

public class reto002 {
    public static void main(String[] args) {

        int numeroArmaEscogida;
        int numeroAtaqueVampiro;
        int vidaheroe = 160;
        final int DAÑO_HEROE_ARMA_1 = 7;
        final int DAÑO_HEROE_ARMA_2 = 15;
        final int DAÑO_HEROE_ARMA_3 = 30;
        final int DEFENSA_HEROE = 0;
        int dañoHeroe = 0;
        double probabilidadExitoHeroe = 0;

        final int CANTIDAD_ATAQUES_VAMPIRO = 3;
        final int DAÑO_VAMPIRO_ATAQUE_1 = 5;
        final int DAÑO_VAMPIRO_ATAQUE_2 = 10;
        final int DAÑO_VAMPIRO_ATAQUE_3 = 20;
        int vidaVampiro = 60;
        double probabilidadExitoVampiro = 0;
        int dañoVampiro = 0;
        boolean alguienVivo = true;
        boolean vampiroVivo = true;
        Scanner input = new Scanner(System.in);

        while (alguienVivo) {
            System.out.println(
                    "Con que arma quieres atacar al vampiro?\n1: (7 dmg/50% prob)\n2: (15 dmg/25% prob)\n3: (30 dmg/12% prob)\n4 (Defenderse // 0 dmg/80% prob/-5 dmg vampiro)");
            numeroArmaEscogida = input.nextInt();

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
            } else {
                System.out.println("Te equivocas e intentas pegar al vampiro con un plátano!!");
                probabilidadExitoHeroe = 0;
                dañoHeroe = 0;
                dañoVampiro = vidaheroe;
                probabilidadExitoVampiro = 1;

            }

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

            if (vidaVampiro <= 0) {
                vampiroVivo = false;
            }

            if (vampiroVivo) {
                if (Math.random() < probabilidadExitoVampiro) {
                    System.out.println("El heroe se lleva un mordisco!!");
                    vidaheroe = vidaheroe - dañoVampiro;
                } else {
                    System.out.println("El heroe ha esquivado el mordisco!!");
                }
            }
            System.out.println("La vida del heroe es [" + vidaheroe + "]/La vida del vampiro es [" + vidaVampiro + "]");
            if (vidaheroe <= 0 || !vampiroVivo) {
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