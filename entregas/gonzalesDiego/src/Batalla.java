import java.util.Scanner;

class Batalla {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vidaGuerrero = 20;

        final int arma1 = 7;
        final int arma2 = 15;
        final int arma3 = 30;

        final double porcentajeExitoArma1 = 0.5;
        final double porcentajeExitoArma2 = 0.25;
        final double porcentajeExitoArma3 = 0.12;

        int vidaVampiro = 10;

        final int mordida1 = 5;
        final int mordida2 = 10;
        final int mordida3 = 20;

        final double porcentajeExitoMordida1 = 0.9;
        final double porcentajeExitoMordida2 = 0.6;
        final double porcentajeExitoMordida3 = 0.4;

        boolean algunMuerto = false;

        do {
            System.out.println("\nElige tu arma:");
            System.out.println("1. Arma 1 (7 de daño, 50%)");
            System.out.println("2. Arma 2 (15 de daño, 25%)");
            System.out.println("3. Arma 3 (30 de daño, 12%)");
            System.out.print("Tu elección: ");

            int eleccion = scanner.nextInt();

            int daño;
            double porcentaje;

            if (eleccion == 1) {
                daño = arma1;
                porcentaje = porcentajeExitoArma1;
            } else if (eleccion == 2) {
                daño = arma2;
                porcentaje = porcentajeExitoArma2;
            } else if (eleccion == 3) {
                daño = arma3;
                porcentaje = porcentajeExitoArma3;
            } else {
                System.out.println("Elección inválida, se usa la espada por defecto");
                daño = arma1;
                porcentaje = porcentajeExitoArma1;
            }
            // Vampiro Recibe Daño?
            if (Math.random() < porcentaje) {
                vidaVampiro = vidaVampiro - daño;
                System.out.println("El Vampiro recibe daño");
            } else {
                System.out.println("El Vampiro esquiva el ataque");
            }

            int ataqueVampiro = (int) (Math.random() * 3) + 1;

            int dañoMordida;
            double porcentajeExitoMordida;

            if (ataqueVampiro == 1) {
                dañoMordida = mordida1;
                porcentajeExitoMordida = porcentajeExitoMordida1;
                System.out.println("El vampiro usa Mordida 1 (" + dañoMordida + " de daño, 90%)");
            } else if (ataqueVampiro == 2) {
                dañoMordida = mordida2;
                porcentajeExitoMordida = porcentajeExitoMordida2;
                System.out.println("El vampiro usa Mordida 2 (" + dañoMordida + " de daño, 60%)");
            } else {
                dañoMordida = mordida3;
                porcentajeExitoMordida = porcentajeExitoMordida3;
                System.out.println("El vampiro usa Mordida 3 (" + dañoMordida + " de daño, 40%)");
            }
            // Guerrero Recibe Daño?
            if (Math.random() < porcentajeExitoMordida) {
                vidaGuerrero = vidaGuerrero - dañoMordida;
                System.out.println("El Guerrero recibe daño");
            } else {
                System.out.println("El Guerrero esquiva el ataque");
            }

            System.out.println("--------------------------------------------------");
            System.out.println("Vida Guerrero: [" + vidaGuerrero + "] / Vida Vampiro: [" + vidaVampiro + "]");

            algunMuerto = vidaGuerrero <= 0 || vidaVampiro <= 0;

            if (vidaGuerrero <= 0 && vidaVampiro <= 0) {
                System.out.println("Ambos murieron, ninguno ganó");
                break;
            } else if (vidaGuerrero <= 0) {
                System.out.println("El Vampiro ha ganado la batalla");
                break;
            } else if (vidaVampiro <= 0) {
                System.out.println("El Guerrero ha ganado la batalla");
                break;
            }

        } while (!algunMuerto);
        scanner.close();
    }
}
