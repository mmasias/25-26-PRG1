import java.util.Scanner;
import java.util.Random;

public class CarreraCamellos {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        int posJugador = 0;
        int turno = 0;
        boolean fin = false;
        
        System.out.println("CARRERA DE CAMELLOS");
        System.out.println("Llega a la casilla 60 para ganar.");
        
        while (!fin) {
            System.out.println("------------------------------------------");
            System.out.println("Turno " + turno);
            System.out.println("Jugador en la posición " + posJugador);
            System.out.print("Elija un agujero (1-4): ");
            
            int agujero = sc.nextInt();
            
            int probAcierto = 0;
            int avance = 0;
            
            switch (agujero) {
                case 1:
                    probAcierto = 60;
                    avance = 1;
                    break;
                case 2:
                    probAcierto = 40;
                    avance = 2;
                    break;
                case 3:
                    probAcierto = 30;
                    avance = 4;
                    break;
                case 4:
                    probAcierto = 10;
                    avance = 6;
                    break;
                default:
                    System.out.println("Opción no válida. Pierdes el turno.");
                    turno++;
                    continue;
            }
            
            int prob = rand.nextInt(100);
            
            if (prob < probAcierto) {
                posJugador = posJugador + avance;
                System.out.println("Aciertas. Avanzas " + avance + " casillas.");
            } else {
                System.out.println("Fallaste. No avanzas.");
            }
            
            System.out.print("[J]");
            for (int i = 0; i < posJugador; i++) {
                System.out.print("-");
            }
            System.out.println();
            
            turno++;
            
            if (posJugador >= 60) {
                System.out.println("Has llegado a la meta en " + turno + " turnos.");
                fin = true;
            }
        }
        
        sc.close();
    }
}