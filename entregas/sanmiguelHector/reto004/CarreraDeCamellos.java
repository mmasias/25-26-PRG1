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

        final int AVANCE_CAMELLO_ORDENADOR_1 = 1;
        final int AVANCE_CAMELLO_ORDENADOR_2 = 2;
        final int AVANCE_CAMELLO_ORDENADOR_3 = 3;

        String avanceCamelloJugador;
        String avanceCamelloOrdenador;
        final int LINEA_DE_META = 60;
        final String CAMELLO = ";--;'";
        boolean camelloTropezado = false;

        final int NUMERO_DE_TURNOS_MAXIMO = 50;

        final String PRIMERA_LINEA_DE_PUNTUACION = "---+-----------+---------+---------+---------+---------+-----------+";
        final String SEGUNDA_LINEA_DE_PUNTUACION = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String TERCERA_LINEA_DE_PUNTUACION = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String CUARTA_LINEA_DE_PUNTUACION = "---+-----------+---------+---------+---------+---------+-----------+";
        final String CABECERA_PISTA_JUGADOR = "[J]| ";
        final String CABECERA_PISTA_ORDENADOR = "[O]| ";
        final String QUINTA_LINEA_DE_PUNTUACION = "---+-----------+---------+---------+---------+---------+-----------+";

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int posicionJugador = 0;
        int posicionOrdenador = 0;
        int numeroFallos = 0;
        boolean juegoTerminado = false;

        for (int turno = 1; turno <= NUMERO_DE_TURNOS_MAXIMO && !juegoTerminado; turno++) {
            if (posicionJugador >= LINEA_DE_META || posicionOrdenador >= LINEA_DE_META) {
                juegoTerminado = true;
            } else {
                if (camelloTropezado) {
                    System.out.println("El camello ha tropezado, pierdes dos turnos");
                    turno++;
                    camelloTropezado = false;
                } else {
                    if (numeroFallos == 3) {
                        posicionJugador = 0;
                        System.out.println("Has fallado 3 veces seguidas, vuelves a la posición inicial");
                        numeroFallos = 0;
                    }

                    System.out.println("Estás en el turno " + turno);
                    System.out.println("Elige a qué agujero quieres lanzar la pelota (Escribe 1, 2, 3 o 4)");
                    System.out.println("1: 60% de acertar y avanzas 1 casilla");
                    System.out.println("2: 40% de acertar y avanzas 2 casilla");
                    System.out.println("3: 30% de acertar y avanzas 4 casilla");
                    System.out.println("4: 10% de acertar y avanzas 6 casilla");
                    int eleccionJugador = scanner.nextInt();

                    if (eleccionJugador == 1) {
                        if (Math.random() < PROBABILIDAD_ACIERTO_AGUJERO_1) {
                            if (Math.random() < PROBABILIDAD_DE_TROPIEZO_CAMELLO) {
                                camelloTropezado = true;
                            } else {
                                System.out.println("Acertaste, avanzas " + AVANCE_ACIERTO_AGUJERO_1 + " casillas");
                                posicionJugador = posicionJugador + AVANCE_ACIERTO_AGUJERO_1;
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
                                posicionJugador = posicionJugador + AVANCE_ACIERTO_AGUJERO_2;
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
                                posicionJugador = posicionJugador + AVANCE_ACIERTO_AGUJERO_3;
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
                                posicionJugador = posicionJugador + AVANCE_ACIERTO_AGUJERO_4;
                                numeroFallos = 0;
                            }
                        } else {
                            System.out.println("Fallaste, pierdes turno");
                            numeroFallos++;
                        }
                    }
                }
                double movimientoOrdenador = Math.random();
                int avanceOrdenador = 0;

                if (movimientoOrdenador < 1/3) {
                    avanceOrdenador = AVANCE_CAMELLO_ORDENADOR_1;
                } else if (movimientoOrdenador < 2/3) {
                    avanceOrdenador = AVANCE_CAMELLO_ORDENADOR_2;
                } else {
                    avanceOrdenador = AVANCE_CAMELLO_ORDENADOR_3;
                }

                posicionOrdenador = posicionOrdenador + avanceOrdenador;
                System.out.println("El camello del ordenador avanza " + avanceOrdenador + " casillas");
                if (!juegoTerminado) {
                    avanceCamelloJugador = "";
                    avanceCamelloOrdenador = "";
                    for (int i = 0; i < posicionJugador; i++) {
                        avanceCamelloJugador += " ";
                    }
                    for (int j = 0; j < posicionOrdenador; j++) {
                        avanceCamelloOrdenador += " ";
                    }

                    System.out.println(PRIMERA_LINEA_DE_PUNTUACION);
                    System.out.println(SEGUNDA_LINEA_DE_PUNTUACION);
                    System.out.println(TERCERA_LINEA_DE_PUNTUACION);
                    System.out.println(CUARTA_LINEA_DE_PUNTUACION);
                    System.out.println(CABECERA_PISTA_JUGADOR + avanceCamelloJugador + CAMELLO);
                    System.out.println(CABECERA_PISTA_ORDENADOR + avanceCamelloOrdenador + CAMELLO);
                    System.out.println(QUINTA_LINEA_DE_PUNTUACION);
                    System.out.println();
                }

                if (posicionJugador >= LINEA_DE_META || posicionOrdenador >= LINEA_DE_META) {
                    juegoTerminado = true;
                }
            }
        }

        if (posicionJugador >= LINEA_DE_META && posicionOrdenador >= LINEA_DE_META) {
            System.out.println("¡Empate! Ambos llegaron a la meta");
        } else if (posicionJugador >= LINEA_DE_META) {
            System.out.println("Ganaste!!!!!");
        } else if (posicionOrdenador >= LINEA_DE_META) {
            System.out.println("Perdiste, el camello del ordenador llegó primero");
        } else {
            System.out.println("Perdiste, se te acabaron los turnos");
        }
        scanner.close();
    }
}