
import java.util.Scanner;

public class Reto_002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int DAÑO_ARMA_1 = 7;
        int vidaGuerrero = 150;
        final double PORCENTAJE_EXITO_ARMA_1 = 0.5;
        final int DAÑO_ARMA_2 = 15;
        final double PORCENTAJE_EXITO_GUERRERO = 0.25;
        final int DAÑO_ARMA_3 = 30;
        final double PORCENTAJE_EXITO_ARMA_3 = 0.12;



        final int DAÑO_ATAQUE_1 = 5;
        int vidaVampiro = 60;
        final double PORCENTAJE_EXITO_ATAQUE_1 = 0.9;
        final int DAÑO_ATAQUE_2 = 10;
        final double PORCENTAJE_EXITO_ATAQUE_2 = 0.6;
        final int DAÑO_ATAQUE_3 = 20;
        final double PORCENTAJE_EXITO_ATAQUE_3 = 0.4;
        boolean algunMuerto = false;
        boolean guerreroVivo = true;
        boolean vampiroVivo = true;

        do {

            System.out.println("¿Arma 1, arma 2 o arma 3?");
            int arma = scanner.nextInt();
            if (arma ==1) {
                if (Math.random() < PORCENTAJE_EXITO_ARMA_1) {
                    vidaVampiro = vidaVampiro - DAÑO_ARMA_1;
                    System.out.println("El vampiro recibe " + DAÑO_ARMA_1+ " de daño");
                } else {
                    System.out.println("El vampiro esquiva la espada");
                }
            } else if (arma ==2) {
                if (Math.random() < PORCENTAJE_EXITO_GUERRERO) {
                    vidaVampiro = vidaVampiro - DAÑO_ARMA_2;
                    System.out.println("El vampiro recibe " + DAÑO_ARMA_2 +  " de daño");
                } else {
                    System.out.println("El vampiro esquiva la espada");
                }
            } else if (arma ==3) {
                if (Math.random() < PORCENTAJE_EXITO_ARMA_3) {
                    vidaVampiro = vidaVampiro - DAÑO_ARMA_3;
                    System.out.println("El vampiro recibe " + DAÑO_ARMA_3 + " de daño");
                } else {
                    System.out.println("El vampiro esquiva la espada");
                }
            } else {
                System.out.println("Arma no válida, pierdes el turno");
            }
           

            vampiroVivo = vidaVampiro > 0;

            if (vampiroVivo) {
                int ataque = ((int) (Math.random() * 100)) % 3;
                if (ataque == 0) {
                    if (Math.random() < PORCENTAJE_EXITO_ATAQUE_1) {
                        vidaGuerrero = vidaGuerrero - DAÑO_ATAQUE_1;
                        System.out.println("El héroe recibe " + DAÑO_ATAQUE_1 + " de daño");
                    } else {
                        System.out.println("El héroe esquiva el ataque");
                    }
                } else if (ataque == 1) {
                    if (Math.random() < PORCENTAJE_EXITO_ATAQUE_2) {
                        vidaGuerrero = vidaGuerrero - DAÑO_ATAQUE_2;
                        System.out.println("El héroe recibe " + DAÑO_ATAQUE_2 + " de daño");
                    } else {
                        System.out.println("El héroe esquiva el ataque");
                    }
                } else if (ataque == 2) {
                    if (Math.random() < PORCENTAJE_EXITO_ATAQUE_3) {
                        vidaGuerrero = vidaGuerrero - DAÑO_ATAQUE_3;
                        System.out.println("El héroe recibe " + DAÑO_ATAQUE_3 + " de daño");
                    } else {
                        System.out.println("El héroe esquiva el ataque");
                    }
                }
            }

            System.out.println("Vida Guerrero [" + vidaGuerrero + "]/Vida Vampiro[" + vidaVampiro + "]");

            guerreroVivo = vidaGuerrero > 0;

            algunMuerto = !guerreroVivo || !vampiroVivo;

        } while (!algunMuerto);
        String elGanador = vidaGuerrero > 0 ? "Guerrero" : "Vampiro";
        System.out.println("Ganó el " + elGanador);
    }
}