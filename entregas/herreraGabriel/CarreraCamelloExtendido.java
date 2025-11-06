import java.util.Scanner;
import java.util.Random;

public class CarreraCamelloExtendido {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Random random = new Random();
        
        final int META = 60;
        final int POSICION_INICIAL = 0;
        final int MAXIMO_TURNOS = 50;
        final int MAXIMO_FALLOS_CONSECUTIVOS = 3;
        final int TURNOS_PERDIDOS_TROPIEZO = 2;
        final int PROBABILIDAD_TROPIEZO = 10;
        
        final int AGUJERO_1 = 1;
        final int AGUJERO_2 = 2;
        final int AGUJERO_3 = 3;
        final int AGUJERO_4 = 4;
        
        final int PROBABILIDAD_AGUJERO_1 = 60;
        final int PROBABILIDAD_AGUJERO_2 = 40;
        final int PROBABILIDAD_AGUJERO_3 = 30;
        final int PROBABILIDAD_AGUJERO_4 = 10;
        
        final int AVANCE_AGUJERO_1 = 1;
        final int AVANCE_AGUJERO_2 = 2;
        final int AVANCE_AGUJERO_3 = 4;
        final int AVANCE_AGUJERO_4 = 6;
        
        final String LINEA_SUPERIOR = "---+-----------+---------+---------+---------+---------+-----------+";
        final String LINEA_NUMERO_1 = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String LINEA_NUMERO_2 = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String PREFIJO_JUGADOR = "[J]| ";
        final String CAMELLO = ";--;'";
        
        final int LIMITE_PROBABILIDAD = 100;
        
        int posicion = POSICION_INICIAL;
        int turno = 0;
        int fallosConsecutivos = 0;
        int turnosBloqueados = 0;
        
        mostrarTablero(posicion, turno, LINEA_SUPERIOR, LINEA_NUMERO_1, LINEA_NUMERO_2, PREFIJO_JUGADOR, CAMELLO, META);
        
        do {
            if (turnosBloqueados > 0) {
                turnosBloqueados--;
                turno++;
                System.out.println("Turno " + turno + " - Camello bloqueado - Esta en la casilla " + posicion);
                mostrarTablero(posicion, turno, LINEA_SUPERIOR, LINEA_NUMERO_1, LINEA_NUMERO_2, PREFIJO_JUGADOR, CAMELLO, META);
            } else {
                System.out.print("Elija un agujero: ");
                final int agujero = scanner.nextInt();
                
                int probabilidad = 0;
                int avance = 0;
                
                if (agujero == AGUJERO_1) {
                    probabilidad = PROBABILIDAD_AGUJERO_1;
                    avance = AVANCE_AGUJERO_1;
                } else if (agujero == AGUJERO_2) {
                    probabilidad = PROBABILIDAD_AGUJERO_2;
                    avance = AVANCE_AGUJERO_2;
                } else if (agujero == AGUJERO_3) {
                    probabilidad = PROBABILIDAD_AGUJERO_3;
                    avance = AVANCE_AGUJERO_3;
                } else if (agujero == AGUJERO_4) {
                    probabilidad = PROBABILIDAD_AGUJERO_4;
                    avance = AVANCE_AGUJERO_4;
                }
                
                final int numeroAleatorio = random.nextInt(LIMITE_PROBABILIDAD) + 1;
                final boolean acierta = numeroAleatorio <= probabilidad;
                
                final int numeroTropiezo = random.nextInt(LIMITE_PROBABILIDAD) + 1;
                final boolean tropieza = numeroTropiezo <= PROBABILIDAD_TROPIEZO;
                
                turno++;
                
                if (tropieza) {
                    turnosBloqueados = TURNOS_PERDIDOS_TROPIEZO;
                    System.out.println("El camello ha tropezado!");
                    mostrarTablero(posicion, turno, LINEA_SUPERIOR, LINEA_NUMERO_1, LINEA_NUMERO_2, PREFIJO_JUGADOR, CAMELLO, META);
                    System.out.println("Turno " + turno + " - Camello tropieza - Esta en la casilla " + posicion);
                } else {
                    if (acierta) {
                        posicion += avance;
                        if (posicion > META) {
                            posicion = META;
                        }
                        fallosConsecutivos = 0;
                        mostrarTablero(posicion, turno, LINEA_SUPERIOR, LINEA_NUMERO_1, LINEA_NUMERO_2, PREFIJO_JUGADOR, CAMELLO, META);
                        System.out.println("Turno " + turno + " - Avanza " + avance + " casillas - Esta en la casilla " + posicion);
                    } else {
                        fallosConsecutivos++;
                        if (fallosConsecutivos >= MAXIMO_FALLOS_CONSECUTIVOS) {
                            posicion = POSICION_INICIAL;
                            fallosConsecutivos = 0;
                            System.out.println("Has fallado 3 veces seguidas! Vuelves a la posicion 0");
                        }
                        mostrarTablero(posicion, turno, LINEA_SUPERIOR, LINEA_NUMERO_1, LINEA_NUMERO_2, PREFIJO_JUGADOR, CAMELLO, META);
                        System.out.println("Turno " + turno + " - No avanza ninguna casilla - Esta en la casilla " + posicion);
                    }
                }
            }
            
        } while (posicion < META && turno < MAXIMO_TURNOS);
        
        if (posicion >= META) {
            System.out.println("El juego ha terminado - Has ganado!");
        } else {
            System.out.println("El juego ha terminado - Has alcanzado el maximo de turnos");
        }
        
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