import java.util.Random;

public class BatallaHeroeVampirobase {
    public static void main(String[] args) {
        Random random = new Random();

        int hpGuerrero = 20;
        int hpVampiro = 10;
        int ataqueGuerrero = 2;
        int ataqueVampiro = 4;

        System.out.println("=== BATALLA: GUERRERO VS VAMPIRO ===");

        while (hpGuerrero > 0 && hpVampiro > 0) {
            System.out.println("Guerrero HP: " + hpGuerrero + " | Vampiro HP: " + hpVampiro);

            if (random.nextDouble() < 0.5) { 
                hpVampiro -= ataqueGuerrero;
                System.out.println("El guerrero golpea al vampiro con su hacha (-" + ataqueGuerrero + " HP)");
            } else {
                System.out.println("El guerrero falla su ataque...");
            }

            if (hpVampiro <= 0) break;

            if (random.nextDouble() < 0.5) { 
                hpGuerrero -= ataqueVampiro;
                System.out.println("El vampiro muerde al guerrero (-" + ataqueVampiro + " HP)");
            } else {
                System.out.println("El vampiro falla su ataque...");
            }
        }

        System.out.println("=== FIN DE LA BATALLA ===");
        if (hpGuerrero > 0) {
            System.out.println("¡El guerrero ha ganado!");
        } else {
            System.out.println("¡El vampiro ha ganado!");
        }
    }
}