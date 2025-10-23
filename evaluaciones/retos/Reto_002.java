
import java.util.Scanner;

public class Reto_002 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int DAÑO_ESPADA = 2;
        int vidaGuerrero = 20;
        final double PORCENTAJE_EXITO_GUERRERO = 0.5;
        final int ARMA_1_ATAQUE = 7;
        final double ARMA_1_PROBABILIDAD = 0.5;
        final int ARMA_2_ATAQUE = 15;
        final double ARMA_2_PROBABILIDAD = 0.25;
        final int ARMA_3_ATAQUE = 30;
        final double ARMA_3_PROBABILIDAD = 0.12;

        final int DAÑO_MORDIDA = 4;
        int vidaVampiro = 10;
        final double PORCENTAJE_EXITO_VAMPIRO = 0.5;
        final int ATAQUE_1 = 7;
        final double ATAQUE_PROBABILIDAD_1 = 0.5;
        final int ATAQUE_2 = 15;
        final double ATAQUE_PROBABILIDAD_2 = 0.25;
        final int ATAQUE_3 = 30;
        final double ATAQUE_PROBABILIDAD_3 = 0.12;

        boolean algunMuerto = false;
        boolean guerreroVivo = true;
        boolean vampiroVivo = true;

        do {
            System.out.println("--- Nueva Ronda ---");
            System.out.println("¿Que ataque usará el guerrero?(1,2,3)");
            int ataqueGuerrero = scanner.nextInt();
            if (ataqueGuerrero == 1) {
                if (Math.random() < ARMA_1_PROBABILIDAD) {
                    vidaVampiro = vidaVampiro - ARMA_1_ATAQUE;
                    System.out.println("El vampiro recibe daño");
                } else {
                    System.out.println("El vampiro esquiva el ataque");
                }
            } else if (ataqueGuerrero == 2) {
                if (Math.random() < ARMA_2_PROBABILIDAD) {
                    vidaVampiro = vidaVampiro - ARMA_2_ATAQUE;
                    System.out.println("El vampiro recibe daño");
                } else {
                    System.out.println("El vampiro esquiva el ataque");
                }
            } else if (ataqueGuerrero == 3) {
                if (Math.random() < ARMA_3_PROBABILIDAD) {
                    vidaVampiro = vidaVampiro - ARMA_3_ATAQUE;
                    System.out.println("El vampiro recibe daño");
                } else {
                    System.out.println("El vampiro esquiva el ataque");
                }
            } else {
                System.out.println("Ataque no válido, pierde el turno");
            }

            vampiroVivo = vidaVampiro <= 0;

            if (vampiroVivo) {

                int ataque = (int) (Math.random() * 3) + 1;
                if (ataque == 1) {
                    if (Math.random() < ATAQUE_PROBABILIDAD_1) {
                        vidaVampiro = vidaVampiro - ATAQUE_1;
                        System.out.println("El vampiro recibe daño");
                    } else {
                        System.out.println("El vampiro esquiva el ataque");
                    }
                } else if (ataque == 2) {
                    if (Math.random() < ATAQUE_PROBABILIDAD_2) {
                        vidaVampiro = vidaVampiro - ATAQUE_2;
                        System.out.println("El vampiro recibe daño");
                    } else {
                        System.out.println("El vampiro esquiva el ataque");
                    }
                } else if (ataque == 3) {
                    if (Math.random() < ATAQUE_PROBABILIDAD_3) {
                        vidaVampiro = vidaVampiro - ATAQUE_3;
                        System.out.println("El vampiro recibe daño");
                    } else {
                        System.out.println("El vampiro esquiva el ataque");
                    }
                } else {
                    System.out.println("Ataque no válido, pierde el turno");
                }

            }

            System.out.println("Vida Guerrero [" + vidaGuerrero + "]/Vida Vampiro[" + vidaVampiro + "]");

            guerreroVivo = vidaGuerrero <= 0;

            algunMuerto = guerreroVivo || vampiroVivo;

        } while (!algunMuerto);
        String elGanador = vidaGuerrero > 0 ? "Guerrero" : "Vampiro";
        System.out.println("Ganó el " + elGanador);
    }
}
