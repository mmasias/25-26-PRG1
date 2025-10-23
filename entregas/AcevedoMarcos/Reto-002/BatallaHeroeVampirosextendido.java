import java.util.Random;
import java.util.Scanner;

public class BatallaHeroeVampirosextendido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int energiaHeroe = 150;
        int energiaVampiro = 60;

        System.out.println("=== BATALLA: HÉROE vs VAMPIRO ===");

        while (energiaHeroe > 0 && energiaVampiro > 0) {
            System.out.println("\n--- Nuevo turno ---");
            System.out.println("Energía Héroe: " + energiaHeroe);
            System.out.println("Energía Vampiro: " + energiaVampiro);

            System.out.println("Elige tu arma:");
            System.out.println("1. Arma 1 (Ataque 7, 50% éxito)");
            System.out.println("2. Arma 2 (Ataque 15, 25% éxito)");
            System.out.println("3. Arma 3 (Ataque 30, 12% éxito)");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();
            int ataqueHeroe = 0;
            double probExitoHeroe = 0.0;

            if (opcion == 1) {
                ataqueHeroe = 7;
                probExitoHeroe = 0.5;
            } else if (opcion == 2) {
                ataqueHeroe = 15;
                probExitoHeroe = 0.25;
            } else if (opcion == 3) {
                ataqueHeroe = 30;
                probExitoHeroe = 0.12;
            } else {
                System.out.println("Opción no válida. Pierdes el turno.");
            }

            if (Math.random() < probExitoHeroe) {
                energiaVampiro -= ataqueHeroe;
                System.out.println("¡El héroe golpea al vampiro con " + ataqueHeroe + " puntos de daño!");
            } else if (ataqueHeroe > 0) {
                System.out.println("El héroe falla su ataque...");
            }

            if (energiaVampiro <= 0) break;

            int ataqueElegido = random.nextInt(3) + 1;
            int ataqueVampiro = 0;
            double probExitoVampiro = 0.0;

            if (ataqueElegido == 1) {
                ataqueVampiro = 5;
                probExitoVampiro = 0.9;
            } else if (ataqueElegido == 2) {
                ataqueVampiro = 10;
                probExitoVampiro = 0.6;
            } else {
                ataqueVampiro = 20;
                probExitoVampiro = 0.4;
            }

            System.out.println("El vampiro elige su ataque " + ataqueElegido + "...");

            if (Math.random() < probExitoVampiro) {
                energiaHeroe -= ataqueVampiro;
                System.out.println("¡El vampiro muerde al héroe y causa " + ataqueVampiro + " puntos de daño!");
            } else {
                System.out.println("El vampiro falla su ataque...");
            }
        }

        System.out.println("\n=== FIN DE LA BATALLA ===");
        if (energiaHeroe > 0) {
            System.out.println("¡El héroe ha vencido al vampiro!");
        } else {
            System.out.println("El vampiro ha derrotado al héroe...");
        }

        scanner.close();
    }
}
