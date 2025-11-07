package entregas.sanmiguelHector.reto004;

import java.util.Scanner;
import java.util.Random;

public class CarreraDeCamellos {
    public static void main(String[] args) {
        final double PROBABILIDAD_ACIERTO_AGUJERO_1 = 0.6;
        final double PROBABILIDAD_ACIERTO_AGUJERO_2 = 0.4;
        final double PROBABILIDAD_ACIERTO_AGUJERO_3 = 0.3;
        final double PROBABILIDAD_ACIERTO_AGUJERO_4 = 0.1;
        final double PROBABILIDAD_DE_TROPIEZO_CAMELLO = 0.1;

        final int AVANCE_ACIERTO_AGUJERO_1 = 1;
        final int AVANCE_ACIERTO_AGUJERO_2 = 2;
        final int AVANCE_ACIERTO_AGUJERO_3 = 4;
        final int AVANCE_ACIERTO_AGUJERO_4 = 6;

        String avanceCamello;
        final int LINEA_DE_META = 60;
        final String CAMELLO = ";--;'";
        boolean camelloTropezado = false;
        int turno = 1;

        final String PRIMERA_LINEA_DE_PUNTUACION = "---+-----------+---------+---------+---------+---------+-----------+";
        final String SEGUNDA_LINEA_DE_PUNTUACION = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String TERCERA_LINEA_DE_PUNTUACION = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String CUARTA_LINEA_DE_PUNTUACION = "---+-----------+---------+---------+---------+---------+-----------+";
        final String CABECERA_PISTA = "[J]| ";
        final String QUINTA_LINEA_DE_PUNTUACION = "---+-----------+---------+---------+---------+---------+-----------+";

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int posicion = 0;
        int numeroFallos = 0;

        while (posicion < LINEA_DE_META) {
            if (camelloTropezado) {
                System.out.println("El camello ha tropezado, pierdes dos turnos");
                turno++;
                camelloTropezado = false;
            } else {
                if (numeroFallos == 3) {
                    posicion = 0;
                    System.out.println("Has fallado 3 veces seguidas, vuelves a la posición inicial");
                    numeroFallos = 0;
                }
                System.out.println("Estás en el turno " + turno);
                System.out.println("Elige a qué agujero quieres lanzar la pelota (Escribe 1, 2, 3 o 4)");
                int eleccionJugador = scanner.nextInt();

                if (eleccionJugador == 1) {
                    if (Math.random() < PROBABILIDAD_ACIERTO_AGUJERO_1) {
                        if (Math.random() < PROBABILIDAD_DE_TROPIEZO_CAMELLO) {
                            camelloTropezado = true;
                        } else {
                            System.out.println("Acertaste, avanzas " + AVANCE_ACIERTO_AGUJERO_1 + " casillas");
                            posicion = posicion + AVANCE_ACIERTO_AGUJERO_1;
                            numeroFallos = 0;
                        }

                    } else {
                        System.out.println("Fallaste, pierdes turno");
                        numeroFallos++;
                    }
                }
                if (eleccionJugador == 2) {
                    if (Math.random() < PROBABILIDAD_ACIERTO_AGUJERO_2) {
                        if (Math.random() < PROBABILIDAD_DE_TROPIEZO_CAMELLO) {
                            camelloTropezado = true;
                        } else {
                            System.out.println("Acertaste, avanzas " + AVANCE_ACIERTO_AGUJERO_2 + " casillas");
                            posicion = posicion + AVANCE_ACIERTO_AGUJERO_2;
                            numeroFallos = 0;
                        }
                    } else {
                        System.out.println("Fallaste, pierdes turno");
                        numeroFallos++;
                    }
                }
                if (eleccionJugador == 3) {
                    if (Math.random() < PROBABILIDAD_ACIERTO_AGUJERO_3) {
                        if (Math.random() < PROBABILIDAD_DE_TROPIEZO_CAMELLO) {
                            camelloTropezado = true;
                        } else {
                            System.out.println("Acertaste, avanzas " + AVANCE_ACIERTO_AGUJERO_3 + " casillas");
                            posicion = posicion + AVANCE_ACIERTO_AGUJERO_3;
                            numeroFallos = 0;
                        }
                    } else {
                        System.out.println("Fallaste, pierdes turno");
                        numeroFallos++;
                    }
                }
                if (eleccionJugador == 4) {
                    if (Math.random() < PROBABILIDAD_ACIERTO_AGUJERO_4) {
                        if (Math.random() < PROBABILIDAD_DE_TROPIEZO_CAMELLO) {
                            camelloTropezado = true;
                        } else {
                            System.out.println("Acertaste, avanzas " + AVANCE_ACIERTO_AGUJERO_4 + " casillas");
                            posicion = posicion + AVANCE_ACIERTO_AGUJERO_4;
                            numeroFallos = 0;
                        }
                    } else {
                        System.out.println("Fallaste, pierdes turno");
                        numeroFallos++;
                    }
                }
            }
            turno++;
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
            System.out.println();
        }

        System.out.println("Ganaste!!!!!");
        scanner.close();
    }
}