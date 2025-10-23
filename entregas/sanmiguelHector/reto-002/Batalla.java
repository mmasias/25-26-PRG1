import java.util.Scanner;

class Batalla {
    public static void main(String[] args) {
        final int ARMA_1 = 7;
        final int ARMA_2 = 15;
        final int ARMA_3 = 30;
        final double PORCENTAJE_EXITO_ARMA_1 = 0.5;
        final double PORCENTAJE_EXITO_ARMA_2 = 0.25;
        final double PORCENTAJE_EXITO_ARMA_3 = 0.12;
        int vidaGuerrero = 150;

        final int ATAQUE_1 = 7;
        final int ATAQUE_2 = 15;
        final int ATAQUE_3 = 30;
        final double PORCENTAJE_EXITO_ATAQUE_1 = 0.9;
        final double PORCENTAJE_EXITO_ATAQUE_2 = 0.6;
        final double PORCENTAJE_EXITO_ATAQUE_3 = 0.4;
        int vidaVampiro = 60;

        boolean algunMuerto = false;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Escoge el arma de tu héroe:");
            System.out.println("1. Arma 1: 7 puntos de daño y 50% de éxito");
            System.out.println("2. Arma 2: 15 puntos de daño y 25% de éxito");
            System.out.println("3. Arma 3: 30 puntos de daño y 12% de éxito");
            int eleccion = scanner.nextInt();

            int dañoGuerrero = 0;
            double probExitoGuerrero = 0;

            if (eleccion == 1) {
                dañoGuerrero = ARMA_1;
                probExitoGuerrero = PORCENTAJE_EXITO_ARMA_1;
            } else if (eleccion == 2) {
                dañoGuerrero = ARMA_2;
                probExitoGuerrero = PORCENTAJE_EXITO_ARMA_2;
            } else if (eleccion == 3) {
                dañoGuerrero = ARMA_3;
                probExitoGuerrero = PORCENTAJE_EXITO_ARMA_3;
            } else {
                System.out.println("Elección inválida, pierdes el turno.");
            }

            if (Math.random() < probExitoGuerrero) {
                vidaVampiro -= dañoGuerrero;
                System.out.println("El vampiro recibe una ostia (-" + dañoGuerrero + " vida)");
            } else {
                System.out.println("El vampiro esquiva la hostia");
            }

            if (vidaVampiro <= 0) {
                System.out.println("¡El vampiro ha muerto!");
                algunMuerto = true;
                break;
            }

            int ataqueVampiro = (int)(Math.random() * 3) + 1;
            int dañoVampiro = 0;
            double probExitoVampiro = 0;

            if (ataqueVampiro == 1) {
                dañoVampiro = ATAQUE_1;
                probExitoVampiro = PORCENTAJE_EXITO_ATAQUE_1;
            } else if (ataqueVampiro == 2) {
                dañoVampiro = ATAQUE_2;
                probExitoVampiro = PORCENTAJE_EXITO_ATAQUE_2;
            } else {
                dañoVampiro = ATAQUE_3;
                probExitoVampiro = PORCENTAJE_EXITO_ATAQUE_3;
            }

            if (Math.random() < probExitoVampiro) {
                vidaGuerrero -= dañoVampiro;
                System.out.println("El guerrero recibe una mordida (-" + dañoVampiro + " vida)");
            } else {
                System.out.println("El guerrero esquiva la mordida");
            }

            if (vidaGuerrero <= 0) {
                System.out.println("¡El guerrero ha muerto!");
                algunMuerto = true;
                break;
            }

            System.out.println("Vida del guerrero: " + vidaGuerrero);
            System.out.println("Vida del vampiro: " + vidaVampiro);
            System.out.println("---------------------------");

        } while (!algunMuerto);

        System.out.println("Fin de la batalla.");
        scanner.close();
    }
}