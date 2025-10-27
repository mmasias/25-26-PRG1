import java.util.Scanner;

public class UnGuerrero2 {
    public static void main(String[] args) {
        int energiaHeroe = 150;
        int energiaVampiro = 60;

        Scanner scanner = new Scanner(System.in);

        System.out.println("¡COMIENZA EL RETO EXTENDIDO!");
        System.out.println("Héroe: " + energiaHeroe + " HP");
        System.out.println("Vampiro: " + energiaVampiro + " HP");
        System.out.println();

        while (energiaHeroe > 0 && energiaVampiro > 0) {
            // TURNO DEL HÉROE
            System.out.println("=== TURNO DEL HÉROE ===");
            System.out.println("Elige tu arma:");
            System.out.println("1. Arma 1 → 7 daño (60% éxito)");
            System.out.println("2. Arma 2 → 15 daño (25% éxito)");
            System.out.println("3. Arma 3 → 30 daño (10% éxito)");
            System.out.print("Tu elección: ");
            int opcion = scanner.nextInt();

            double probabilidadHeroe = 0;
            int dañoHeroe = 0;
            String nombreArma = "";

            if (opcion == 1) {
                probabilidadHeroe = 0.60;
                dañoHeroe = 7;
                nombreArma = "Arma 1";
            } else if (opcion == 2) {
                probabilidadHeroe = 0.25;
                dañoHeroe = 15;
                nombreArma = "Arma 2";
            } else if (opcion == 3) {
                probabilidadHeroe = 0.10;
                dañoHeroe = 30;
                nombreArma = "Arma 3";
            } else {
                System.out.println("Opción inválida. Pierdes el turno.");
                probabilidadHeroe = 0;
                dañoHeroe = 0;
                nombreArma = "ninguna";
            }

            System.out.println("El Héroe intenta atacar con " + nombreArma + "...");
            if (Math.random() < probabilidadHeroe) {
                energiaVampiro -= dañoHeroe;
                System.out.println("✅ ¡Golpe exitoso! El Héroe causa " + dañoHeroe + " de daño.");
            } else {
                System.out.println("❌ El Héroe falló el ataque.");
            }

            // Mostrar estado después del turno del Héroe
            System.out.println("Estado actual:");
            System.out.println("Héroe: " + energiaHeroe + " HP");
            System.out.println("Vampiro: " + energiaVampiro + " HP");
            System.out.println("-----------------------------");
            

            // TURNO DEL VAMPIRO (automático)
            if (energiaVampiro > 0) {
                System.out.println("=== TURNO DEL VAMPIRO ===");
                int ataqueVampiro = (int)(Math.random() * 3) + 1;
                int dañoVampiro = 0;
                double probabilidadVampiro = 0;
                String nombreAtaque = "";

                if (ataqueVampiro == 1) {
                    probabilidadVampiro = 0.90;
                    dañoVampiro = 5;
                    nombreAtaque = "Ataque 1";
                } else if (ataqueVampiro == 2) {
                    probabilidadVampiro = 0.60;
                    dañoVampiro = 10;
                    nombreAtaque = "Ataque 2";
                } else {
                    probabilidadVampiro = 0.30;
                    dañoVampiro = 20;
                    nombreAtaque = "Ataque 3";
                }

                System.out.println("El Vampiro intenta usar " + nombreAtaque + "...");
                if (Math.random() < probabilidadVampiro) {
                    energiaHeroe -= dañoVampiro;
                    System.out.println("✅ ¡Golpe exitoso! El Vampiro causa " + dañoVampiro + " de daño.");
                } else {
                    System.out.println("❌ El Vampiro falló el ataque.");
                }

                // Mostrar estado después del turno del Vampiro
                System.out.println("Estado actual:");
                System.out.println("Héroe: " + energiaHeroe + " HP");
                System.out.println("Vampiro: " + energiaVampiro + " HP");
                System.out.println("-----------------------------");
                
            }
        }


        if (energiaHeroe > 0) {
            System.out.println("🎉 ¡GANÓ EL HÉROE!");
        } else {
            System.out.println("💀 ¡GANÓ EL VAMPIRO!");
        }

        scanner.close();
    }
}
