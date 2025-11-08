import java.util.Scanner;
import java.util.Random;

public class CarreraCamello {
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

        final int AVANCE_MINIMO_ORDENADOR = 1;
        final int AVANCE_MAXIMO_ORDENADOR = 3;

        final String LINEA_SUPERIOR = "---+-----------+---------+---------+---------+---------+-----------+";
        final String LINEA_NUMERO_1 = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String LINEA_NUMERO_2 = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String PREFIJO_JUGADOR = "[J]| ";
        final String PREFIJO_ORDENADOR = "[O]| ";
        final String CAMELLO = ";--;'";

        final int LIMITE_PROBABILIDAD = 100;

        int posicionJugador = POSICION_INICIAL;
        int posicionOrdenador = POSICION_INICIAL;
        int turno = 0;
        int fallosConsecutivos = 0;
        int turnosBloqueados = 0;

        mostrarTablero(posicionJugador, posicionOrdenador, turno, LINEA_SUPERIOR, LINEA_NUMERO_1, LINEA_NUMERO_2, PREFIJO_JUGADOR, PREFIJO_ORDENADOR, CAMELLO, META);

        do {
            if (turnosBloqueados > 0) {
                turnosBloqueados--;
                turno++;

                final int avanceOrdenador = random.nextInt(AVANCE_MAXIMO_ORDENADOR) + AVANCE_MINIMO_ORDENADOR;
                posicionOrdenador += avanceOrdenador;
                if (posicionOrdenador > META) {
                    posicionOrdenador = META;
                }

                mostrarTablero(posicionJugador, posicionOrdenador, turno, LINEA_SUPERIOR, LINEA_NUMERO_1, LINEA_NUMERO_2, PREFIJO_JUGADOR, PREFIJO_ORDENADOR, CAMELLO, META);
                System.out.println("Turno " + turno + " - Camello bloqueado - Esta en la casilla " + posicionJugador);
                System.out.println("El ordenador avanza " + avanceOrdenador + " casillas - Esta en la casilla " + posicionOrdenador);
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

                final int avanceOrdenador = random.nextInt(AVANCE_MAXIMO_ORDENADOR) + AVANCE_MINIMO_ORDENADOR;
                posicionOrdenador += avanceOrdenador;
                if (posicionOrdenador > META) {
                    posicionOrdenador = META;
                }

                if (tropieza) {
                    turnosBloqueados = TURNOS_PERDIDOS_TROPIEZO;
                    System.out.println("El camello ha tropezado!");
                    mostrarTablero(posicionJugador, posicionOrdenador, turno, LINEA_SUPERIOR, LINEA_NUMERO_1, LINEA_NUMERO_2, PREFIJO_JUGADOR, PREFIJO_ORDENADOR, CAMELLO, META);
                    System.out.println("Turno " + turno + " - Camello tropieza - Esta en la casilla " + posicionJugador);
                    System.out.println("El ordenador avanza " + avanceOrdenador + " casillas - Esta en la casilla " + posicionOrdenador);
                } else {
                    if (acierta) {
                        posicionJugador += avance;
                        if (posicionJugador > META) {
                            posicionJugador = META;
                        }
                        fallosConsecutivos = 0;
                        mostrarTablero(posicionJugador, posicionOrdenador, turno, LINEA_SUPERIOR, LINEA_NUMERO_1, LINEA_NUMERO_2, PREFIJO_JUGADOR, PREFIJO_ORDENADOR, CAMELLO, META);
                        System.out.println("Turno " + turno + " - Avanza " + avance + " casillas - Esta en la casilla " + posicionJugador);
                        System.out.println("El ordenador avanza " + avanceOrdenador + " casillas - Esta en la casilla " + posicionOrdenador);
                    } else {
                        fallosConsecutivos++;
                        if (fallosConsecutivos >= MAXIMO_FALLOS_CONSECUTIVOS) {
                            posicionJugador = POSICION_INICIAL;
                            fallosConsecutivos = 0;
                            System.out.println("Has fallado 3 veces seguidas! Vuelves a la posicion 0");
                        }
                        mostrarTablero(posicionJugador, posicionOrdenador, turno, LINEA_SUPERIOR, LINEA_NUMERO_1, LINEA_NUMERO_2, PREFIJO_JUGADOR, PREFIJO_ORDENADOR, CAMELLO, META);
                        System.out.println("Turno " + turno + " - No avanza ninguna casilla - Esta en la casilla " + posicionJugador);
                        System.out.println("El ordenador avanza " + avanceOrdenador + " casillas - Esta en la casilla " + posicionOrdenador);
                    }
                }
            }

        } while (posicionJugador < META && posicionOrdenador < META && turno < MAXIMO_TURNOS);

        if (posicionJugador >= META && posicionOrdenador >= META) {
            System.out.println("El juego ha terminado - Empate!");
        } else if (posicionJugador >= META) {
            System.out.println("El juego ha terminado - Has ganado!");
        } else if (posicionOrdenador >= META) {
            System.out.println("El juego ha terminado - Ha ganado el ordenador!");
        } else {
            System.out.println("El juego ha terminado - Se han agotado los turnos");
        }

        scanner.close();
    }

    public static void mostrarTablero(final int posicionJugador, final int posicionOrdenador, final int turno, 
                                      final String lineaSup, final String lineaNum1, final String lineaNum2, 
                                      final String prefijoJugador, final String prefijoOrdenador, 
                                      final String camello, final int meta) {
        System.out.println("Jugador en la posicion " + posicionJugador + ", ordenador en la posicion " + posicionOrdenador);
        System.out.println(lineaSup);
        System.out.println(lineaNum1);
        System.out.println(lineaNum2);
        System.out.println(lineaSup);

        String lineaJugador = prefijoJugador;
        int i = 0;
        do {
            if (i == posicionJugador) {
                lineaJugador = lineaJugador + camello;
                i += camello.length();
            } else {
                lineaJugador = lineaJugador + " ";
                i++;
            }
        } while (i <= meta);

        System.out.println(lineaJugador);
        System.out.println(lineaSup);

        String lineaOrdenador = prefijoOrdenador;
        int j = 0;
        do {
            if (j == posicionOrdenador) {
                lineaOrdenador = lineaOrdenador + camello;
                j += camello.length();
            } else {
                lineaOrdenador = lineaOrdenador + " ";
                j++;
            }
        } while (j <= meta);

        System.out.println(lineaOrdenador);
        System.out.println(lineaSup);
        System.out.println("Turno " + turno);
    }
}
