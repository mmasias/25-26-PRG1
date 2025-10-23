import java.util.Random;
import java.util.Scanner;

public class extendidoReto {
    public static void main(String[] args) {
        final int VIDA_INICIAL_HEROE = 150;
        final int DANO_ARMA_1 = 7;
        final int DANO_ARMA_2 = 15;
        final int DANO_ARMA_3 = 30;
        final int PROBABILIDAD_ARMA_1 = 50;
        final int PROBABILIDAD_ARMA_2 = 25;
        final int PROBABILIDAD_ARMA_3 = 12;
        
        final int VIDA_INICIAL_VAMPIRO = 60;
        final int DANO_ATAQUE_1 = 5;
        final int DANO_ATAQUE_2 = 10;
        final int DANO_ATAQUE_3 = 20;
        final int PROBABILIDAD_ATAQUE_1 = 90;
        final int PROBABILIDAD_ATAQUE_2 = 60;
        final int PROBABILIDAD_ATAQUE_3 = 40;
        
        int vidaHeroe = VIDA_INICIAL_HEROE;
        int vidaVampiro = VIDA_INICIAL_VAMPIRO;
        
        int turno = 1;
        boolean batallaEnCurso = true;
        boolean ataqueAcertado = false;
        boolean heroeGanador = false;
        boolean vampiroGanador = false;
        boolean entradaValida = false;
        
        int eleccionJugador = 0;
        int eleccionVampiro = 0;
        int danoInfligido = 0;
        int probabilidadActual = 0;
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        

        System.out.println("  BATALLA ÉPICA: HÉROE vs VAMPIRO      ");
        System.out.println("Héroe: " + vidaHeroe + " HP");
        System.out.println("Vampiro: " + vidaVampiro + " HP");
        System.out.println("\n¡Prepárate para la batalla!\n");
        
        while (batallaEnCurso) {
            System.out.println("          TURNO " + turno);
            System.out.println("Héroe: " + vidaHeroe + " HP | Vampiro: " + vidaVampiro + " HP\n");
            
            entradaValida = false;
            
            do {
                System.out.println("--- Tu turno ---");
                System.out.println("Elige tu arma:");
                System.out.println("1. Arma 1 (Daño: " + DANO_ARMA_1 + " | Precision: " + PROBABILIDAD_ARMA_1 + "%)");
                System.out.println("2. Arma 2 (Daño: " + DANO_ARMA_2 + " | Precision: " + PROBABILIDAD_ARMA_2 + "%)");
                System.out.println("3. Arma 3 (Daño: " + DANO_ARMA_3 + " | Precision: " + PROBABILIDAD_ARMA_3 + "%)");
                System.out.print("Tu eleccion: ");
                
                eleccionJugador = scanner.nextInt();
                
                if (eleccionJugador >= 1 && eleccionJugador <= 3) {
                    entradaValida = true;
                } else {
                    System.out.println("Por favor, elige una opción válida (1, 2 o 3)\n");
                }
            } while (!entradaValida);
            
            System.out.println();
            
            if (eleccionJugador == 1) {
                System.out.print("Atacas con el Arma 1... ");
                danoInfligido = DANO_ARMA_1;
                probabilidadActual = PROBABILIDAD_ARMA_1;
            } else if (eleccionJugador == 2) {
                System.out.print("Atacas con el Arma 2... ");
                danoInfligido = DANO_ARMA_2;
                probabilidadActual = PROBABILIDAD_ARMA_2;
            } else {
                System.out.print("Atacas con el Arma 3... ");
                danoInfligido = DANO_ARMA_3;
                probabilidadActual = PROBABILIDAD_ARMA_3;
            }
            
            int probabilidadHeroe = random.nextInt(100) + 1;
            
            if (probabilidadHeroe <= probabilidadActual) {
                ataqueAcertado = true;
            } else {
                ataqueAcertado = false;
            }
            
            if (ataqueAcertado) {
                vidaVampiro = vidaVampiro - danoInfligido;
                System.out.println("¡IMPACTO! Causas " + danoInfligido + " de daño.");
                System.out.println("Vida del Vampiro: " + vidaVampiro + " HP");
            } else {
                System.out.println("¡FALLAS! El vampiro esquiva tu ataque.");
            }
            
            System.out.println();
            
            if (vidaVampiro <= 0) {
                batallaEnCurso = false;
            } else {
                System.out.println("--- Turno del Vampiro ---");
                
                eleccionVampiro = random.nextInt(3) + 1;
                
                if (eleccionVampiro == 1) {
                    System.out.print("El Vampiro usa Ataque 1... ");
                    danoInfligido = DANO_ATAQUE_1;
                    probabilidadActual = PROBABILIDAD_ATAQUE_1;
                } else if (eleccionVampiro == 2) {
                    System.out.print("El Vampiro usa Ataque 2... ");
                    danoInfligido = DANO_ATAQUE_2;
                    probabilidadActual = PROBABILIDAD_ATAQUE_2;
                } else {
                    System.out.print("El Vampiro usa Ataque 3... ");
                    danoInfligido = DANO_ATAQUE_3;
                    probabilidadActual = PROBABILIDAD_ATAQUE_3;
                }
                
                int probabilidadVampiro = random.nextInt(100) + 1;
                
                if (probabilidadVampiro <= probabilidadActual) {
                    ataqueAcertado = true;
                } else {
                    ataqueAcertado = false;
                }
                
                if (ataqueAcertado) {
                    vidaHeroe = vidaHeroe - danoInfligido;
                    System.out.println("Recibes " + danoInfligido + " de daño.");
                    System.out.println("Tu vida: " + vidaHeroe + " HP");
                } else {
                    System.out.println("Te defiendes exitosamente.");
                }
                
                System.out.println();
                
                if (vidaHeroe <= 0) {
                    batallaEnCurso = false;
                }
            }
            
            turno++;
        }
        
        boolean ganadorDeterminado = false;
        
        do {
            if (vidaHeroe > 0 && vidaVampiro <= 0) {
                heroeGanador = true;
                vampiroGanador = false;
                ganadorDeterminado = true;
            } else if (vidaVampiro > 0 && vidaHeroe <= 0) {
                vampiroGanador = true;
                heroeGanador = false;
                ganadorDeterminado = true;
            } else if (vidaHeroe <= 0 && vidaVampiro <= 0) {
                heroeGanador = false;
                vampiroGanador = false;
                ganadorDeterminado = true;
            }
        } while (!ganadorDeterminado);
        
        System.out.println("        FIN DE LA BATALLA               ");
        
        if (heroeGanador) {
            System.out.println(" ¡VICTORIA! ");
            System.out.println("Has derrotado al vampiro con valentía.");
            System.out.println("Tu vida restante: " + vidaHeroe + " HP");
        } else if (vampiroGanador) {
            System.out.println("¡DERROTA! ");
            System.out.println("El vampiro te ha vencido...");
            System.out.println("Vida restante del Vampiro: " + vidaVampiro + " HP");
        } else {
            System.out.println("¡EMPATE ÉPICO! ");
            System.out.println("Ambos luchadores han caído en combate.");
        }
        
        System.out.println("\nTurnos totales: " + turno);
        
        scanner.close();
    }
}