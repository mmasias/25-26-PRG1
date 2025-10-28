import java.util.Random;

public class Vampiro{
    public static void main(String[] args) throws InterruptedException {
        
        int hpGuerrero = 20;
        int hpVampiro = 10;
        int ataqueGuerrero = 2;
        int ataqueVampiro = 4;

        double probExitoGuerrero = 0.5;
        double probExitoVampiro = 0.5;

        int turno = 1;
        Random random = new Random();

        System.out.println("⚔️ Comienza la batalla entre el Guerrero y el Vampiro!\n");

        while (hpGuerrero > 0 && hpVampiro > 0) {
            System.out.println("--- Turno " + turno + " ---");

            
            System.out.println("➡️ El Guerrero ataca...");
            if (random.nextDouble() < probExitoGuerrero) {
                hpVampiro -= ataqueGuerrero;
                if (hpVampiro < 0) hpVampiro = 0;
                System.out.println("💥 El golpe acierta. El Vampiro pierde " + ataqueGuerrero + " HP (queda con " + hpVampiro + ").");
            } else {
                System.out.println("❌ El Guerrero falla su ataque.");
            }

            
            if (hpVampiro <= 0) {
                break;
            }


        
            System.out.println("🦇 El Vampiro ataca...");
            if (random.nextDouble() < probExitoVampiro) {
                hpGuerrero -= ataqueVampiro;
                if (hpGuerrero < 0) hpGuerrero = 0;
                System.out.println("💀 El ataque acierta. El Guerrero pierde " + ataqueVampiro + " HP (queda con " + hpGuerrero + ").");
            } else {
                System.out.println("❌ El Vampiro falla su ataque.");
            }

            turno++;
            System.out.println();
            Thread.sleep(1000);
        }

        System.out.println("\n⚔️ La batalla ha terminado ⚔️");
        if (hpGuerrero > 0) {
            System.out.println("🏆 El Guerrero ha ganado con " + hpGuerrero + " HP restantes.");
        } else {
            System.out.println("🧛‍♂️ El Vampiro ha ganado con " + hpVampiro + " HP restantes.");
        }
    }
}
