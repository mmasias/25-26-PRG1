import java.util.Scanner;

class CarreraCamellosExtendido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int posiciónJugador = 0;
        int turno = 0;
        int fallos = 0;
        final double PROB_1_CASILLA = 0.6;
        final double PROB_2_CASILLAS = 0.4;
        final double PROB_4_CASILLAS = 0.3;
        final double PROB_6_CASILLAS = 0.1;
        final int AVANCE_1 = 1;
        final int AVANCE_2 = 2;
        final int AVANCE_4 = 4;
        final int AVANCE_6 = 6;

        final String SEPARADOR = "---+-----------+---------+---------+---------+---------+-----------+";
        final String NUMERACION = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String ESPACIO_1 = " ";
        final String ESPACIO_2 = "  ";
        final String ESPACIO_4 = "    ";
        final String ESPACIO_6 = "      ";
        final String INICIO_CAMELLO_JUGADOR = "[J]| ";
        final String INICIO_CAMELLO_MAQUINA = "[O]| ";
        String camelloJugador = ";--;'";
        String camelloOrdenador = ";--;'";

        System.out.println("¡Bienvenido a la Carrera de Camellos!");
        System.out.println(
                "Este juego trata de que usted deberá tirar una bola a un agujero, si acierta, dependiendo la dificultad avanzará");
        System.out.println("un numero de casillas u otro.");
        System.out.println("Usted lucha contra la máquina.");
        System.out.println("La probabilidad de acierto son:");
        System.out.println("1. 60%, avanzas 1 casilla.");
        System.out.println("2. 40%, avanzas 2 casillas.");
        System.out.println("3. 30%, avanzas 4 casillas.");
        System.out.println("4. 10%, avanzas 6 casillas.");

        while (posiciónJugador < 60 || turno < 50) {
            turno++;
            double probMovimiento = Math.random();
            double tropiezoCamello = Math.random();
            int camelloTropezadoContador = 0;
            int movimientoMaquina = (int) (Math.random() * 3 + 1);

            System.out.println("Elija un agujero (1-4) :");
            int movimientoJugador = scanner.nextInt();

            while (0 <= movimientoJugador && movimientoJugador >= 5) {
                System.out.println("Su agujero elegido no se encuentra entre los posibles. Elija un movimiento (1-4):");
                movimientoJugador = scanner.nextInt();
            }

            if (tropiezoCamello <= 0.1) {
                System.out.println("Tu camello se a tropezado, pierdes tres turnos!");
                camelloTropezadoContador = 3;
            }

            if (camelloTropezadoContador == 0) {
                if (movimientoJugador == 1) {
                    if (probMovimiento <= PROB_1_CASILLA) {
                        posiciónJugador = posiciónJugador + AVANCE_1;
                        System.out
                                .println("Turno: " + turno + " - Avanza 1 casilla - Está en la casilla "
                                        + posiciónJugador);
                        camelloJugador = ESPACIO_1 + camelloJugador;
                        fallos = 0;

                    } else {
                        System.out
                                .println("Turno: " + turno + " - No has avanzado - Está en la casilla "
                                        + posiciónJugador);
                        fallos++;
                    }

                } else if (movimientoJugador == 2) {
                    if (probMovimiento <= PROB_2_CASILLAS) {
                        posiciónJugador = posiciónJugador + AVANCE_2;
                        System.out
                                .println("Turno: " + turno + " - Avanza 2 casilla - Está en la casilla "
                                        + posiciónJugador);
                        camelloJugador = ESPACIO_2 + camelloJugador;
                        fallos = 0;
                    } else {
                        System.out
                                .println("Turno: " + turno + " - No has avanzado - Está en la casilla "
                                        + posiciónJugador);
                        fallos++;
                    }

                } else if (movimientoJugador == 3) {
                    if (probMovimiento <= PROB_4_CASILLAS) {
                        posiciónJugador = posiciónJugador + AVANCE_4;
                        System.out
                                .println("Turno: " + turno + " - Avanza 4 casilla - Está en la casilla "
                                        + posiciónJugador);
                        camelloJugador = ESPACIO_4 + camelloJugador;
                        fallos = 0;
                    } else {
                        System.out
                                .println("Turno: " + turno + " - No has avanzado - Está en la casilla "
                                        + posiciónJugador);
                        fallos++;
                    }

                } else if (movimientoJugador == 4) {
                    if (probMovimiento <= PROB_6_CASILLAS) {
                        posiciónJugador = posiciónJugador + AVANCE_6;
                        System.out
                                .println("Turno: " + turno + " - Avanza 6 casilla - Está en la casilla "
                                        + posiciónJugador);
                        camelloJugador = ESPACIO_6 + camelloJugador;
                        fallos = 0;
                    } else {
                        System.out
                                .println("Turno: " + turno + " - No has avanzado - Está en la casilla "
                                        + posiciónJugador);
                        fallos++;
                    }
                }

                if (movimientoMaquina == 1) {
                    camelloOrdenador = ESPACIO_1 + camelloOrdenador;
                    System.out.println("Turno: " + turno + "La máquina avanzó 1 casilla");
                } else if (movimientoMaquina == 2) {
                    camelloOrdenador = ESPACIO_2 + camelloOrdenador;
                    System.out.println("Turno: " + turno + "La máquina avanzó 2 casilla");
                } else if (movimientoMaquina == 3) {
                    camelloOrdenador = ESPACIO_4 + camelloOrdenador;
                    System.out.println("Turno: " + turno + "La máquina avanzó 4 casilla");
                } else if (movimientoMaquina == 4) {
                    camelloOrdenador = ESPACIO_6 + camelloOrdenador;
                    System.out.println("Turno: " + turno + "La máquina avanzó 6 casilla");
                }

                System.out.println(SEPARADOR);
                System.out.println(NUMERACION);
                System.out.println(SEPARADOR);
                System.out.print(INICIO_CAMELLO_JUGADOR);
                System.out.println(camelloJugador);
                System.out.println(SEPARADOR);
                System.out.print(INICIO_CAMELLO_MAQUINA);
                System.out.println(camelloOrdenador);
                System.out.println(SEPARADOR);

            } else if (camelloTropezadoContador > 0) {
                camelloTropezadoContador--;
                if (movimientoMaquina == 1) {
                    camelloOrdenador = ESPACIO_1 + camelloOrdenador;
                    System.out.println("La máquina avanzó 1 casilla");
                } else if (movimientoMaquina == 2) {
                    camelloOrdenador = ESPACIO_2 + camelloOrdenador;
                    System.out.println("La máquina avanzó 2 casilla");
                } else if (movimientoMaquina == 3) {
                    camelloOrdenador = ESPACIO_4 + camelloOrdenador;
                    System.out.println("La máquina avanzó 4 casilla");
                } else if (movimientoMaquina == 4) {
                    camelloOrdenador = ESPACIO_6 + camelloOrdenador;
                    System.out.println("La máquina avanzó 6 casilla");
                }

                System.out.println(SEPARADOR);
                System.out.println(NUMERACION);
                System.out.println(SEPARADOR);
                System.out.print(INICIO_CAMELLO_JUGADOR);
                System.out.println(camelloJugador);
                System.out.println(SEPARADOR);
                System.out.print(INICIO_CAMELLO_MAQUINA);
                System.out.println(camelloOrdenador);
                System.out.println(SEPARADOR);
            }

            if (turno == 50) {
                System.out.println("La partida se ha acabado.");
            }
        }
    }

}
