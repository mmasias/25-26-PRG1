
import java.util.Scanner;

public class GuerreroVsVampiroExtendido {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

    
        int vidaVampiro = 60;
        final int ATAQUE1 = 5;
        final double PROBABILIDAD_DE_ATAQUE1 = 0.9;
        final int ATAQUE2 = 10;
        final double PROBABILIDAD_DE_ATAQUE2 = 0.6;
        final int ATAQUE3 = 20;
        final double PROBABILIDAD_DE_ATAQUE3 = 0.4;

        int vidaGuerrero = 150;
        final int DAÑO_ARMA1 = 7;
        final double PROBABILIDAD_DE_ARMA1 = 0.5;
        final int DAÑO_ARMA2 = 15;
        final double PROBABILIDAD_DE_ARMA2 = 0.25;
        final int DAÑO_ARMA3 = 30;
        final double PROBABILIDAD_DE_ARMA3 = 0.12;

        boolean algunMuerto = false;
        boolean viveGuerrero = true;
        boolean viveVampiro = true;

        do {
            System.out.println("¿Qué arma usas?(1,2,3)");
            int arma = teclado.nextInt();

            if (arma == 1) {
                if (Math.random() < PROBABILIDAD_DE_ARMA1) {
                    vidaVampiro = vidaVampiro - DAÑO_ARMA1;
                    System.out.println("El vampiro recibe daño ");
                } else {
                    System.out.println("El vampiro esquiva ");
                }

            } else if (arma == 2) {
                if (Math.random() < PROBABILIDAD_DE_ARMA2) {
                    vidaVampiro = vidaVampiro - DAÑO_ARMA2;
                    System.out.println("El vampiro recibe  ");
                } else {
                    System.out.println("El vampiro esquiva");
                }
            } else if (arma == 3) {
                if (Math.random() < PROBABILIDAD_DE_ARMA3) {
                    vidaVampiro = vidaVampiro - DAÑO_ARMA3;
                    System.out.println("El vampiro recibe ");
                } else {
                    System.out.println("El vampiro esquiva ");
                }
            }

            viveVampiro = vidaVampiro > 0;

            if (viveVampiro) {
                int ataque = ((int) (Math.random() * 100)) % 3 + 1;
                System.out.println("Arma elegida por el vampiro: " + ataque);

                if (ataque == 1) {
                    if (Math.random() < PROBABILIDAD_DE_ATAQUE1) {
                        vidaGuerrero = vidaGuerrero - ATAQUE1;
                        System.out.println("El guerrero recibe daño");
                    } else {
                        System.out.println("El guerrero esquiva ");
                    }

                } else if (ataque == 2) {
                    if (Math.random() < PROBABILIDAD_DE_ATAQUE2) {
                        vidaGuerrero = vidaGuerrero - ATAQUE2;
                        System.out.println("El guerrero recibe daño");
                    } else {
                        System.out.println("El guerrero esquiva");
                    }
                } else if (ataque == 3) {
                    if (Math.random() < PROBABILIDAD_DE_ATAQUE3) {
                        vidaGuerrero = vidaGuerrero - ATAQUE3;
                        System.out.println("El guerrero recibe daño ");
                    } else {
                        System.out.println("El guerrero esquiva ");
                    }
                }
            }
            System.out.println("Vida Guerrero [" + vidaGuerrero + "]/Vida Vampiro[" + vidaVampiro + "]");

            viveGuerrero = vidaGuerrero > 0;

            algunMuerto = !viveGuerrero || !viveVampiro;

        } while (!algunMuerto);

        String elGanador = vidaGuerrero > 0 ? "Guerrero" : "Vampiro";
        System.out.println("Ganó el " + elGanador);
    }
}
