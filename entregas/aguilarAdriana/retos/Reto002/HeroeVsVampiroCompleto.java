import java.util.Scanner;

class HeroeVsVampiroCompleto {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== CABALLERO VS VAMPIRO =====");
        System.out.println("");
        System.out.println("¡Valiente caballero! Te enfrentas a un temible vampiro.");
        System.out.println("Tienes 150 HP, el vampiro tiene 60 HP.");
        System.out.println("");
        System.out.println("Puedes elegir entre 3 armas diferentes:");
        System.out.println("Arma 1: 7 de daño - 50% de probabilidad de éxito");
        System.out.println("Arma 2: 15 de daño - 25% de probabilidad de éxito");
        System.out.println("Arma 3: 30 de daño - 12% de probabilidad de éxito");
        System.out.println("");
        System.out.println("El vampiro atacará aleatoriamente después de tu turno.");
        System.out.println("¡La batalla continuará hasta que uno de los dos caiga!");
        System.out.println("");
        System.out.println("¡COMIENZA LA BATALLA!");
        System.out.println("");

        int vidaHeroe = 150;
        int vidaVampiro = 60;

        final int ARMA_UNO_HEROE = 7;
        final double PROB_ARMA_UNO_HEROE = 0;
        final int ARMA_DOS_HEROE = 15;
        final double PROB_ARMA_DOS_HEROE = 0.25;
        final int ARMA_TRES_HEROE = 30;
        final double PROB_ARMA_TRES_HEROE = 0.12;

        final int ARMA_UNO_VAMPIRO = 2;
        final double PROB_ARMA_UNO_VAMPIRO = 0.9;
        final int ARMA_DOS_VAMPIRO = 10;
        final double PROB_ARMA_DOS_VAMPIRO = 0.6;
        final int ARMA_TRES_VAMPIRO = 20;
        final double PROB_ARMA_TRES_VAMPIRO = 0.4;

        while (vidaHeroe > 0 && vidaVampiro > 0) {
            System.out.println("Caballero: " + vidaHeroe + " HP | Vampiro: " + vidaVampiro + " HP");
            System.out.println("Elige tu arma (1, 2 o 3):");
            int ataqueElegidoCaballero = scanner.nextInt();
            
            
            if (ataqueElegidoCaballero == 1) {
                if (Math.random() <= PROB_ARMA_UNO_HEROE) {
                    vidaVampiro = vidaVampiro - ARMA_UNO_HEROE;
                    System.out.println("¡Tu Arma 1 golpea al vampiro! -" + ARMA_UNO_HEROE + " HP");
                } else {
                    System.out.println("¡Tu Arma 1 falló!");
                }
            }
            if (ataqueElegidoCaballero == 2) {
                if (Math.random() <= PROB_ARMA_DOS_HEROE) {
                    vidaVampiro = vidaVampiro - ARMA_DOS_HEROE;
                    System.out.println("¡Tu Arma 2 golpea al vampiro! -" + ARMA_DOS_HEROE + " HP");
                } else {
                    System.out.println("¡Tu Arma 2 falló!");
                }
            }
            if (ataqueElegidoCaballero == 3) {
                if (Math.random() <= PROB_ARMA_TRES_HEROE) {
                    vidaVampiro = vidaVampiro - ARMA_TRES_HEROE;
                    System.out.println("¡Tu Arma 3 golpea al vampiro! -" + ARMA_TRES_HEROE + " HP");
                } else {
                    System.out.println("¡Tu Arma 3 falló!");
                }
            }
            
            
            if (vidaVampiro > 0) {
                int ataqueAleatorio = (int)(Math.random()*3) + 1;
                if (ataqueAleatorio == 1) {
                    if (Math.random() <= PROB_ARMA_UNO_VAMPIRO) {
                        vidaHeroe = vidaHeroe - ARMA_UNO_VAMPIRO;
                        System.out.println("¡El vampiro te ataca con su garra! -" + ARMA_UNO_VAMPIRO + " HP");
                    } else {
                        System.out.println("¡El vampiro falló su ataque con garra!");
                    }
                }
                if (ataqueAleatorio == 2) {
                    if (Math.random() <= PROB_ARMA_DOS_VAMPIRO) {
                        vidaHeroe = vidaHeroe - ARMA_DOS_VAMPIRO;
                        System.out.println("¡El vampiro te muerde! -" + ARMA_DOS_VAMPIRO + " HP");
                    } else {
                        System.out.println("¡El vampiro falló su mordida!");
                    }
                }
                if (ataqueAleatorio == 3) {
                    if (Math.random() <= PROB_ARMA_TRES_VAMPIRO) {
                        vidaHeroe = vidaHeroe - ARMA_TRES_VAMPIRO;
                        System.out.println("¡El vampiro usa magia oscura! -" + ARMA_TRES_VAMPIRO + " HP");
                    } else {
                        System.out.println("¡El vampiro falló su magia oscura!");
                    }
                }
            }
            System.out.println("");
        }

        
        if (vidaHeroe > 0) {
            System.out.println("¡GANASTE! ¡El vampiro ha sido derrotado!");
        } else {
            System.out.println("¡PERDISTE! El vampiro te ha vencido...");
        }
    }
}