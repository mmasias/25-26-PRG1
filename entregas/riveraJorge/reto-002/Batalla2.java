import java.util.Scanner;

class Batalla2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int DAÑO_ARMA_1 = 7;
        final int DAÑO_ARMA_2 = 15;
        final int DAÑO_ARMA_3 = 30;
        int vidaGuerrero = 150;
        final double PORCENTAJE_EXITO_ARMA_1 = 0.5;
        final double PORCENTAJE_EXITO_ARMA_2 = 0.25;
        final double PORCENTAJE_EXITO_ARMA_3 = 0.12;
        boolean guerreroMuerto = false;

        int vidaVampiro = 60;
        final int DAÑO_ATAQUE_1 = 5;
        final int DAÑO_ATAQUE_2 = 10;
        final int DAÑO_ATAQUE_3 = 20;
        final double PORCENTAJE_EXITO_ATAQUE_1 = 0.9;
        final double PORCENTAJE_EXITO_ATAQUE_2 = 0.6;
        final double PROCENTAJE_EXITO_ATAQUE_3 = 0.4;
        boolean vampiroMuerto = false;

        boolean algunMuerto = false;

        do {
            int armaSeleccionada;
            System.out.println("Selecciona tu arma para atacar.");
            System.out.println("Arma 1: Espada (Daño: 7 / Probabilidad de acierto: 50%)");
            System.out.println("Arma 2: Latigo (Daño: 15 / Probabilidad de acierto: 25%)");
            System.out.println("Arma 3: Hacha  (Daño: 30 / Probabilidad de acierto: 12%)");
            armaSeleccionada = scanner.nextInt();
            if (armaSeleccionada <= 0 || armaSeleccionada > 3) {
                System.out.println("Elige un numero entre 1 y 3.");
            }

            if (armaSeleccionada == 1) {
                if (Math.random() < PORCENTAJE_EXITO_ARMA_1) {
                    vidaVampiro = vidaVampiro - DAÑO_ARMA_1;
                    System.out.println("El vampiro ha recibido " + DAÑO_ARMA_1 + " de daño!");
                } else {
                    System.out.println("El vampiro ha esquivado el ataque!");
                }
            }

            else if (armaSeleccionada == 2) {
                if (Math.random() < PORCENTAJE_EXITO_ARMA_2) {
                    vidaVampiro = vidaVampiro - DAÑO_ARMA_2;
                    System.out.println("El vampiro ha recibido " + DAÑO_ARMA_2 + " de daño!");
                } else {
                    System.out.println("El vampiro ha esquivado el ataque!");
                }
            }

            else if (armaSeleccionada == 3) {
                if (Math.random() < PORCENTAJE_EXITO_ARMA_3)
                    ;
                vidaVampiro = vidaVampiro - DAÑO_ARMA_3;
                System.out.println("El vampiro ha recibido " + DAÑO_ARMA_3 + " de daño!");
            } else {
                System.out.println("El vampiro ha esquivado el ataque!");
            }

            vampiroMuerto = vidaVampiro <= 0;

            int ataqueRandom = (int) (Math.random() * 3);
            if (ataqueRandom == 0) {
                System.out.println("El vampiro usa mordisco! Recibes " + DAÑO_ATAQUE_1 + " de daño!");
                if (Math.random() < PORCENTAJE_EXITO_ATAQUE_1) {
                    vidaGuerrero = vidaGuerrero - DAÑO_ATAQUE_1;
                } else {
                    System.out.println("Has esquivado el ataque!");
                }
            }

            else if (ataqueRandom == 1) {
                System.out.println("El vampiro usa sus garras! Recibes " + DAÑO_ATAQUE_2 + " de daño!");
                if (Math.random() < PORCENTAJE_EXITO_ATAQUE_2) {
                    vidaGuerrero = vidaGuerrero - DAÑO_ATAQUE_2;
                } else {
                    System.out.println("Has esquivado el ataque!");
                }
            } else if (ataqueRandom == 2) {
                System.out.println("El vampiro usa magia negra! Recibes " + DAÑO_ATAQUE_3 + " de daño!");
                if (Math.random() < PROCENTAJE_EXITO_ATAQUE_3) {
                    vidaGuerrero = vidaGuerrero - DAÑO_ATAQUE_3;
                } else {
                    System.out.println("Has esquivado el ataque!");
                }
            }

            guerreroMuerto = vidaGuerrero <= 0;

            algunMuerto = guerreroMuerto || vampiroMuerto;

        } while (!algunMuerto);
        {

            String elGanador = vidaGuerrero <= 0 ? "El vampiro te ha ganado..." : "Has vencido al vampiro!";
            System.out.println("Vida de guerrero: [ " + vidaGuerrero + "]");
            System.out.println("Vida de vampiro: [ " + vidaVampiro + "]");
            System.out.println("La batalla ha acabado. " + elGanador);

        }
    }
}