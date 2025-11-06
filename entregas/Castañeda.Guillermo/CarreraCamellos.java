import java.util.Scanner;

class Reto_de_Camellos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double PROBABILIDAD_AGUJERO_1 = 0.6;
        final double PROBABILIDAD_AGUJERO_2 = 0.4;
        final double PROBABILIDAD_AGUJERO_3 = 0.3;
        final double PROBABILIDAD_AGUJERO_4 = 0.1;

        final int AVANCE_AGUJERO_1 = 1;
        final int AVANCE_AGUJERO_2 = 2;
        final int AVANCE_AGUJERO_3 = 4;
        final int AVANCE_AGUJERO_4 = 6;

        final int META = 60;
        final int MAX_TURNOS = 50;

        int turno = 0;
        int casillaJug = 0;
        int casillaOrd = 0;
        int fallosSeguidos = 0;
        int turnosPerdidos = 0;

        System.out.println("=== CARRERA DE CAMELLOS ===");
        System.out.println("Llega a la casilla 60 antes que el ordenador.");
        System.out.println("Agujeros disponibles:");
        System.out.println("1 - 60% de acierto, avanza 1");
        System.out.println("2 - 40% de acierto, avanza 2");
        System.out.println("3 - 30% de acierto, avanza 4");
        System.out.println("4 - 10% de acierto, avanza 6");

        while (casillaJug < META && casillaOrd < META && turno < MAX_TURNOS) {
            turno++;
            System.out.println("=== Turno " + turno + " ===");
            System.out.println("Jugador en " + casillaJug + ", Ordenador en " + casillaOrd);

            if (turnosPerdidos > 0) {
                System.out.println("Tu camello tropieza y pierde este turno.");
                turnosPerdidos--;
            } else {
                System.out.print("Elige un agujero (1 - 4): ");
                int agujeroElegido = scanner.nextInt();

                System.out.println();

                while (agujeroElegido < 1 || agujeroElegido > 4) {
                    System.out.print("Número inválido. Elige entre 1 y 4: ");
                    agujeroElegido = scanner.nextInt();
                }

                double azarTropiezo = Math.random();
                if (azarTropiezo <= 0.1) {
                    System.out.println("¡Tu camello tropieza! Pierdes 2 turnos.");
                    turnosPerdidos = 2;
                } else {
                    double probabilidad = 0;
                    int avance = 0;

                    if (agujeroElegido == 1) {
                        probabilidad = PROBABILIDAD_AGUJERO_1;
                        avance = AVANCE_AGUJERO_1;
                    } else if (agujeroElegido == 2) {
                        probabilidad = PROBABILIDAD_AGUJERO_2;
                        avance = AVANCE_AGUJERO_2;
                    } else if (agujeroElegido == 3) {
                        probabilidad = PROBABILIDAD_AGUJERO_3;
                        avance = AVANCE_AGUJERO_3;
                    } else if (agujeroElegido == 4) {
                        probabilidad = PROBABILIDAD_AGUJERO_4;
                        avance = AVANCE_AGUJERO_4;
                    }

                    double azar = Math.random();

                    if (azar <= probabilidad) {
                        casillaJug += avance;
                        if (casillaJug > META) casillaJug = META;
                        System.out.println("¡Aciertas! Avanzas " + avance + " casilla(s).");
                        fallosSeguidos = 0;
                    } else {
                        fallosSeguidos++;
                        System.out.println("Fallas. No avanzas. Fallos seguidos: " + fallosSeguidos);
                        if (fallosSeguidos == 3) {
                            casillaJug = 0;
                            fallosSeguidos = 0;
                            System.out.println("Tres fallos seguidos. Vuelves a la casilla 0.");
                        }
                    }
                }
            }

            int avanceOrd = 1 + (int) (Math.random() * 3);
            casillaOrd += avanceOrd;
            if (casillaOrd > META) casillaOrd = META;
            System.out.println("El ordenador avanza " + avanceOrd + " casilla(s).");

            System.out.println("Jugador en la posición " + casillaJug + ", ordenador en la posición " + casillaOrd);
            mostrarTablero(casillaJug, casillaOrd);
        }

        System.out.println("=== RESULTADO FINAL ===");
        if (casillaJug >= META && casillaOrd >= META) {
            System.out.println("Empate: ambos llegaron a la meta");
        } else if (casillaJug >= META) {
            System.out.println("¡Has ganado la carrera!");
        } else if (casillaOrd >= META) {
            System.out.println("El ordenador gana la carrera");
        } else {
            System.out.println("Nadie llegó a la meta. Fin del juego.");
        }

        System.out.println("Turnos jugados: " + turno);
        scanner.close();
    }

    static void mostrarTablero(int posJug, int posOrd) {
        if (posJug > 56) posJug = 56;
        if (posOrd > 56) posOrd = 56;

        System.out.println("---+-----------+---------+---------+---------+---------+-----------+");
        System.out.println("---| 0.........1.........2.........3.........4.........5.........6 |");
        System.out.println("---| 0123456789012345678901234567890123456789012345678901234567890 |");
        System.out.println("---+-----------+---------+---------+---------+---------+-----------+");

        String lineaJug = "[J]| ";
        for (int i = 0; i < posJug; i++) lineaJug += " ";
        lineaJug += ";--;'";
        System.out.println(lineaJug);

        String lineaOrd = "[O]| ";
        for (int i = 0; i < posOrd; i++) lineaOrd += " ";
        lineaOrd += ";--;'";
        System.out.println(lineaOrd);

        System.out.println("---+-----------+---------+---------+---------+---------+-----------+");
    }
}
