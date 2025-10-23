package WhacAMole;
import java.util.Scanner;

public class WhacAMolePrueba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       
        int numeroAgujeros = 16;
        int totalTurnos = 15;
        int aciertos = 0;
        
        System.out.println("=== WHAC-A-MOLE ===");
        System.out.println("¡Golpea al monigote cuando aparezca!");
        System.out.println("Tienes " + totalTurnos + " turnos.");
        System.out.println("Agujeros numerados del 1 al " + numeroAgujeros);
        System.out.println();
        
        
        for (int turno = 1; turno <= totalTurnos; turno++) {
            System.out.println("--- TURNO " + turno + " ---");
            
            
            int posicionMonigote = (int) (Math.random() * numeroAgujeros) + 1;
            
            
            System.out.println("Elige un agujero para golpear (1-" + numeroAgujeros + "):");
            mostrarTablero(numeroAgujeros, 0, 0, false);
            
            System.out.print("Tu elección: ");
            int eleccionJugador = scanner.nextInt();
            
            // Verificar si acertó
            boolean acerto = (eleccionJugador == posicionMonigote);
            if (acerto) {
                aciertos++;
            }
            
            // Mostrar resultado del turno
            System.out.println();
            if (acerto) {
                System.out.println("¡ACIERTO! Golpeaste al monigote.");
            } else {
                System.out.println("¡FALLO! El monigote estaba en el agujero " + posicionMonigote);
            }
            
            // Mostrar tablero con resultado
            mostrarTablero(numeroAgujeros, posicionMonigote, eleccionJugador, acerto);
            
            System.out.println("Aciertos hasta ahora: " + aciertos);
            System.out.println();
        }
        
        // Resultado final
        System.out.println("=== JUEGO TERMINADO ===");
        System.out.println("Total de aciertos: " + aciertos + "/" + totalTurnos);
        
        if (aciertos >= 10) {
            System.out.println("¡Excelente puntería!");
        } else if (aciertos >= 5) {
            System.out.println("¡Buen trabajo!");
        } else {
            System.out.println("¡Sigue practicando!");
        }
        
        scanner.close();
    }
    
    
    public static void mostrarTablero(int numeroAgujeros, int posicionMonigote, int eleccionJugador, boolean acerto) {
        for (int i = 1; i <= numeroAgujeros; i++) {
            
            if (i == posicionMonigote && i == eleccionJugador) {
                
                System.out.print("[**] ");
            } else if (i == eleccionJugador) {
                
                System.out.print("[[]] ");
            } else if (i == posicionMonigote) {
                // Monigote no golpeado
                System.out.print("('') ");
            } else {
                // Agujero vacío
                System.out.print("(  ) ");
            }
            
            // Nueva línea cada 4 agujeros para mejor visualización
            if (i % 4 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
