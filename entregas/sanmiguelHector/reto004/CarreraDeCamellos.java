package entregas.sanmiguelHector.reto004;
import java.util.Scanner;
import java.util.Random;

public class CarreraDeCamellos {
    public static void main(String[] args) {
        final double PROBABILIDAD_ACIERTO_AGUJERO_1 = 0.6;
        final double PROBABILIDAD_ACIERTO_AGUJERO_2 = 0.4;
        final double PROBABILIDAD_ACIERTO_AGUJERO_3 = 0.3;
        final double PROBABILIDAD_ACIERTO_AGUJERO_4 = 0.1;

        final int AVANCE_ACIERTO_AGUJERO_1 = 1;
        final int AVANCE_ACIERTO_AGUJERO_2 = 2;
        final int AVANCE_ACIERTO_AGUJERO_3 = 4;
        final int AVANCE_ACIERTO_AGUJERO_4 = 6;

        String avanceCamello = " ";
        final int LINEA_DE_META = 60;
        final String CAMELLO = ";--;'";

        final String PRIMERA_LINEA_DE_PUNTUACION = "---+-----------+---------+---------+---------+---------+-----------+";
        final String SEGUNDA_LINEA_DE_PUNTUACION = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String TERCERA_LINEA_DE_PUNTUACION = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String CUARTA_LINEA_DE_PUNTUACION = "---+-----------+---------+---------+---------+---------+-----------+";
        final String CABECERA_PISTA = "[J]| ";
        final String QUINTA_LINEA_DE_PUNTUACION = "---+-----------+---------+---------+---------+---------+-----------+";
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int posicion = 0;

        while (posicion < LINEA_DE_META) {
            System.out.println("Elige a qué agujero quieres lanzar la pelota");
            int eleccionJugador = scanner.nextInt();

            if (eleccionJugador == 1) {
                if (Math.random() < PROBABILIDAD_ACIERTO_AGUJERO_1) {
                    System.out.println("Acertaste, avanzas " + AVANCE_ACIERTO_AGUJERO_1 + " casillas");
                    posicion = posicion + AVANCE_ACIERTO_AGUJERO_1;
                } else {
                    System.out.println("Fallaste, pierdes turno");
                }
            }
            if (eleccionJugador == 2) {
                if (Math.random() < PROBABILIDAD_ACIERTO_AGUJERO_2) {
                    System.out.println("Acertaste, avanzas " + AVANCE_ACIERTO_AGUJERO_2 + " casillas");
                    posicion = posicion + AVANCE_ACIERTO_AGUJERO_2;
                } else {
                    System.out.println("Fallaste, pierdes turno");
                }
            }
            if (eleccionJugador == 3) {
                if (Math.random() < PROBABILIDAD_ACIERTO_AGUJERO_3) {
                    System.out.println("Acertaste, avanzas " + AVANCE_ACIERTO_AGUJERO_3 + " casillas");
                    posicion = posicion + AVANCE_ACIERTO_AGUJERO_3;
                } else {
                    System.out.println("Fallaste, pierdes turno");
                }
            }
            if (eleccionJugador == 4) {
                if (Math.random() < PROBABILIDAD_ACIERTO_AGUJERO_4) {
                    System.out.println("Acertaste, avanzas " + AVANCE_ACIERTO_AGUJERO_4 + " casillas");
                    posicion = posicion + AVANCE_ACIERTO_AGUJERO_4;
                } else {
                    System.out.println("Fallaste, pierdes turno");
                }
            }
            avanceCamello = "";
            for (int i = 0; i < posicion; i++) {
                avanceCamello += " ";
            }

            System.out.println(PRIMERA_LINEA_DE_PUNTUACION);
            System.out.println(SEGUNDA_LINEA_DE_PUNTUACION);
            System.out.println(TERCERA_LINEA_DE_PUNTUACION);
            System.out.println(CUARTA_LINEA_DE_PUNTUACION);
            System.out.println(CABECERA_PISTA + avanceCamello + CAMELLO);
            System.out.println(QUINTA_LINEA_DE_PUNTUACION);
        }
        System.out.println("Ganaste!!!!!");
        scanner.close();
    }
}
