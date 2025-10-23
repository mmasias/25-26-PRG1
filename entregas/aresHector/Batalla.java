import java.util.Scanner;

public class Batalla {
    public static void main(String[] args) {
        final int DAÑO_HACHA = 7;
        final double PROBABILIDAD_HACHA = 0.5;
        final int DAÑO_LANZA = 15;
        final double PROBABILIDAD_LANZA = 0.25;
        final int DAÑO_MAZO = 30;
        final double PROBABILIDAD_MAZO = 0.12;
        int energiaGuerrero = 150;

        final int DAÑO_MORDIDA = 5;
        final double PROBABILIDAD_MORDIDA = 0.9;
        final int DAÑO_GARRA = 10;
        final double PROBABILIDAD_GARRA = 0.6;
        final int DAÑO_VENENO = 20;
        final double PROBABILIDAD_VENENO = 0.4;
        int energiaVampiro = 60;

        boolean algunMuerto = false;
        Scanner scanner = new Scanner(System.in);

        do {
            
            if (!algunMuerto) {
                System.out.println("\nEnergía del Héroe: " + energiaGuerrero);
                System.out.println("Elige tu arma:");
                System.out.println("1. Hacha (Daño: 7, Probabilidad: 50%)");
                System.out.println("2. Lanza (Daño: 15, Probabilidad: 25%)");
                System.out.println("3. Mazo (Daño: 30, Probabilidad: 12%)");
                
                int opcion = scanner.nextInt();
                double probabilidad = 0;
                int daño = 0;

                if (opcion == 1) {
                    probabilidad = PROBABILIDAD_HACHA;
                    daño = DAÑO_HACHA;
                }
                if (opcion == 2) {
                    probabilidad = PROBABILIDAD_LANZA;
                    daño = DAÑO_LANZA;
                }
                if (opcion == 3) {
                    probabilidad = PROBABILIDAD_MAZO;
                    daño = DAÑO_MAZO;
                }
                if (opcion < 1 || opcion > 3) {
                    System.out.println("Opción inválida, usando hacha");
                    probabilidad = PROBABILIDAD_HACHA;
                    daño = DAÑO_HACHA;
                }

                if (Math.random() < probabilidad) {
                    energiaVampiro -= daño;
                    System.out.println("¡El vampiro recibe " + daño + " de daño!");
                    System.out.println("Energía del vampiro: " + energiaVampiro);
                    if (energiaVampiro <= 0) {
                        algunMuerto = true;
                    }
                } else {
                    System.out.println("El héroe ha fallado el ataque");
                }
            }

            
            if (!algunMuerto) {
                double ataqueAleatorio = Math.random();
                double probabilidad = 0;
                int daño = 0;
                String tipoAtaque = "";

                if (ataqueAleatorio < 0.33) {
                    probabilidad = PROBABILIDAD_MORDIDA;
                    daño = DAÑO_MORDIDA;
                    tipoAtaque = "morder";
                }
                if (ataqueAleatorio >= 0.33 && ataqueAleatorio < 0.66) {
                    probabilidad = PROBABILIDAD_GARRA;
                    daño = DAÑO_GARRA;
                    tipoAtaque = "usar sus garras";
                }
                if (ataqueAleatorio >= 0.66) {
                    probabilidad = PROBABILIDAD_VENENO;
                    daño = DAÑO_VENENO;
                    tipoAtaque = "usar su veneno";
                }

                System.out.println("El vampiro intenta " + tipoAtaque);

                if (Math.random() < probabilidad) {
                    energiaGuerrero -= daño;
                    System.out.println("¡El héroe recibe " + daño + " de daño!");
                    System.out.println("Energía del héroe: " + energiaGuerrero);
                    if (energiaGuerrero <= 0) {
                        algunMuerto = true;
                    }
                } else {
                    System.out.println("El vampiro ha fallado el ataque");
                }
            }
        } while (!algunMuerto);

        if (energiaVampiro <= 0) {
            System.out.println("¡El héroe ha ganado!");
        } else {
            System.out.println("¡El vampiro ha ganado!");
        }
        scanner.close();
    }
}
