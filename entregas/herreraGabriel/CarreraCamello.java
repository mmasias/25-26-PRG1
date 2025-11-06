import java.util.Scanner;
import java.util.Random;

public class CarreraCamello {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Random random = new Random();
        
        final int META = 60;
        final int POSICION_INICIAL = 0;
        
        final int AGUJERO_1 = 1;
        final int AGUJERO_2 = 2;
        final int AGUJERO_3 = 3;
        final int AGUJERO_4 = 4;
        
        final int PROB_AGUJERO_1 = 60;
        final int PROB_AGUJERO_2 = 40;
        final int PROB_AGUJERO_3 = 30;
        final int PROB_AGUJERO_4 = 10;
        
        final int AVANCE_AGUJERO_1 = 1;
        final int AVANCE_AGUJERO_2 = 2;
        final int AVANCE_AGUJERO_3 = 4;
        final int AVANCE_AGUJERO_4 = 6;
        
        final String LINEA_SUP = "---+-----------+---------+---------+---------+---------+-----------+";
        final String LINEA_NUM_1 = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String LINEA_NUM_2 = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String PREFIJO_JUGADOR = "[J]| ";
        final String CAMELLO = ";--;'";
        
        final int LIMITE_PROB = 100;
        
        int posicion = POSICION_INICIAL;
        int turno = 0;
        
        mostrarTablero(posicion, turno, LINEA_SUP, LINEA_NUM_1, LINEA_NUM_2, PREFIJO_JUGADOR, CAMELLO, META);
        
        do {
            System.out.print("Elija un agujero: ");
            final int agujero = scanner.nextInt();
            
            int probabilidad = 0;
            int avance = 0;
            
            if (agujero == AGUJERO_1) {
                probabilidad = PROB_AGUJERO_1;
                avance = AVANCE_AGUJERO_1;
            } else if (agujero == AGUJERO_2) {
                probabilidad = PROB_AGUJERO_2;
                avance = AVANCE_AGUJERO_2;
            } else if (agujero == AGUJERO_3) {
                probabilidad = PROB_AGUJERO_3;
                avance = AVANCE_AGUJERO_3;
            } else if (agujero == AGUJERO_4) {
                probabilidad = PROB_AGUJERO_4;
                avance = AVANCE_AGUJERO_4;
            }
            
            final int numeroAleatorio = random.nextInt(LIMITE_PROB) + 1;
            final boolean acierta = numeroAleatorio <= probabilidad;
            
            if (acierta) {
                posicion += avance;
                if (posicion > META) {
                    posicion = META;
                }
            }
            
            turno++;
            
            mostrarTablero(posicion, turno, LINEA_SUP, LINEA_NUM_1, LINEA_NUM_2, PREFIJO_JUGADOR, CAMELLO, META);
            
            if (acierta) {
                System.out.println("Turno " + turno + " - Avanza " + avance + " casillas - Esta en la casilla " + posicion);
            } else {
                System.out.println("Turno " + turno + " - No avanza ninguna casilla - Esta en la casilla " + posicion);
            }
            
        } while (posicion < META);
        
        System.out.println("El juego ha terminado");
        
        scanner.close();
    }
    
    public static void mostrarTablero(final int posicion, final int turno, final String lineaSup, 
                                      final String lineaNum1, final String lineaNum2, 
                                      final String prefijoJugador, final String camello, final int meta) {
        System.out.println("Jugador en la posicion " + posicion);
        System.out.println(lineaSup);
        System.out.println(lineaNum1);
        System.out.println(lineaNum2);
        System.out.println(lineaSup);
        
        String lineaJugador = prefijoJugador;
        int i = 0;
        do {
            if (i == posicion) {
                lineaJugador = lineaJugador + camello;
                i += camello.length();
            } else {
                lineaJugador = lineaJugador + " ";
                i++;
            }
        } while (i <= meta);
        
        System.out.println(lineaJugador);
        System.out.println(lineaSup);
        System.out.println("Turno " + turno);
    }
}