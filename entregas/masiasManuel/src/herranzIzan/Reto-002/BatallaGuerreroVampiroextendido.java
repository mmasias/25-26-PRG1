import java.util.Scanner;
import java.util.Random;

public class BatallaGuerreroVampiroextendido {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int vidaGuerrero = 150;
        int ataqueGuerrero = {7, 15, 30};
        double probGuerrero = {0.5, 0.25, 0.12};

        int vidaVampiro = 60;
        int ataqueVampiro = {5, 10, 20};
        double probVampiro = {0.9, 0.6, 0.4};

        System.out.println("¡Comienza la batalla entre el Guerrero y el Vampiro!");

        while (vidaGuerrero > 0 && vidaVampiro > 0) {
            System.out.println("Elige tu arma:");
            System.out.println("1. Arma 1, Ataque: 7 | Éxito: 50%");
            System.out.println("2. Arma 2, Ataque: 15 | Éxito: 25%");
            System.out.println("3. Arma 3, Ataque: 30 | Éxito: 12%");
            System.out.print("Tu elección: ");
            int opcion = sc.nextInt();

            if (opcion < 1 || opcion > 3) {
                System.out.println("Opción no válida, pierdes tu turno");
            } else {
                
                if (Math.random() < probGuerrero[opcion - 1]) {
                    vidaVampiro -= ataqueGuerrero[opcion - 1];
                    System.out.println("¡Has golpeado al Vampiro con el arma " + opcion + "! (-" + ataqueGuerrero[opcion - 1] + " HP)");
                } else {
                    System.out.println("Fallaste tu ataque...");
                }
            }

            if (vidaVampiro <= 0) {
                System.out.println("El vampiro ha caído derrotado. ¡Has ganado!");
                break;
            }

            int ataqueElegido = rand.nextInt(3); 
            System.out.println("El vampiro elige su ataque #" + (ataqueElegido + 1));

            if (Math.random() < probVampiro[ataqueElegido]) {
                vidaGuerrero -= ataqueVampiro[ataqueElegido];
                System.out.println("El vampiro te ha mordido con éxito (-" + ataqueVampiro[ataqueElegido] + " HP)");
            } else {
                System.out.println("Falló su ataque. Logras esquivarlo.");
            }

            if (vidaGuerrero <= 0) {
                System.out.println("Has sido derrotado... El vampiro gana esta vez.");
                } else {
            System.out.println("¡Has vencido al vampiro!")
        }
            
            System.out.println("Vida Guerrero: " + vidaGuerrero + " |  Vida Vampiro: " + vidaVampiro);
        }

        System.out.println("La batalla ha terminado");
        sc.close();
    }
}

