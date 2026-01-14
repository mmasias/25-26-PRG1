import java.util.Random;
import java.util.Scanner;

public class CarreraCamellos {
    static final int META = 60;
    static final int MAX_TURNOS = 50;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int jugadorPos = 0;
        int caballoPos = 0;
        int turnos = 0;
        int fallosConsecutivos = 0;
        int penalizacion = 0; 

        System.out.println("🏁 Carrera de Camellos 🏁");
        System.out.println("Llega a la casilla " + META + " antes que el caballo.\n");

        while (jugadorPos < META && caballoPos < META && turnos < MAX_TURNOS) {
            turnos++;
            System.out.println("Turno " + turnos);

            if (penalizacion > 0) {
                System.out.println("El camello está penalizado y pierde este turno.");
                penalizacion--;
            } else {
                System.out.print("Elige agujero (1-4): ");
                int agujero = sc.nextInt();

                boolean acierto = comprobarAcierto(agujero, rand);
                if (acierto) {
                    int avance = calcularAvance(agujero);
                
                    if (rand.nextInt(100) < 10) {
                        System.out.println("¡El camello tropieza! Pierde 2 turnos.");
                        penalizacion = 2;
                    } else {
                        jugadorPos += avance;
                        System.out.println("Avanzas " + avance + " casillas. Posición: " + jugadorPos);
                    }
                    fallosConsecutivos = 0;
                } else {
                    System.out.println("Fallaste el lanzamiento.");
                    fallosConsecutivos++;
                    if (fallosConsecutivos == 3) {
                        System.out.println("¡Tres fallos seguidos! Vuelves a la casilla 0.");
                        jugadorPos = 0;
                        fallosConsecutivos = 0;
                    }
                }
            }

           
            int avanceCaballo = rand.nextInt(3) + 1; 
            caballoPos += avanceCaballo;
            System.out.println("El caballo avanza " + avanceCaballo + " casillas. Posición: " + caballoPos);

            
            mostrarTablero(jugadorPos, caballoPos);

            System.out.println("-----------------------------------");
        }

        
        if (jugadorPos >= META && caballoPos >= META) {
            System.out.println("¡Empate! Ambos llegaron a la meta.");
        } else if (jugadorPos >= META) {
            System.out.println("🎉 ¡Has ganado la carrera en " + turnos + " turnos!");
        } else if (caballoPos >= META) {
            System.out.println("🐎 El caballo gana la carrera.");
        } else {
            System.out.println("⏳ Se acabaron los turnos. Nadie llegó a la meta.");
        }

        sc.close();
    }

    static boolean comprobarAcierto(int agujero, Random rand) {
        int prob = rand.nextInt(100);
        return switch (agujero) {
            case 1 -> prob < 60;
            case 2 -> prob < 40;
            case 3 -> prob < 30;
            case 4 -> prob < 10;
            default -> false;
        };
    }

    static int calcularAvance(int agujero) {
        return switch (agujero) {
            case 1 -> 1;
            case 2 -> 2;
            case 3 -> 4;
            case 4 -> 6;
            default -> 0;
        };
    }

    static void mostrarTablero(int jugador, int caballo) {
        for (int i = 0; i <= META; i++) {
            if (i != jugador || i != caballo) if (i == jugador) {
                System.out.print("[J]");
            } else if (i == caballo) {
                System.out.print("[C]");
            } else {
                System.out.print("-");
            } else {
                System.out.print("[JC]"); 
            }
        }
        System.out.println();
    }
}
