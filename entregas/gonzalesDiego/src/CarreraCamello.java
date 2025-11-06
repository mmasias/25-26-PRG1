import java.util.Scanner;

class CarreraCamello {
    public static void main(String[] args) {
        Scanner jugador = new Scanner(System.in);

        final String LINEA_1 = "---+-----------+---------+---------+---------+---------+-----------+";
        final String LINEA_2 = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String LINEA_3 = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String CABECERA = "[J]|";
        final String CAMELLO = ";--;'";
        final String ESPACIO = "  ";
        final int META = 60;
        final int MAX_TURNOS = 50;

        int posicion = 0;
        int turno = 1;
        int fallosSeguidos = 0;
        int turnosPerdidos = 0;
        boolean alcanzoLaMeta = false;

        System.out.println("Carrera de Camellos");

        while (turno <= MAX_TURNOS && !alcanzoLaMeta) {

            System.out.println(LINEA_1);
            System.out.println(LINEA_2);
            System.out.println(LINEA_3);

            System.out.print(CABECERA);
            for (int i = 0; i < posicion; i++) {
                System.out.print(ESPACIO);
            }
            System.out.print(CAMELLO);
            for (int i = posicion + 1; i <= META; i++) {
                System.out.print(ESPACIO);
            }
            System.out.println("|");

            if (turnosPerdidos > 0) {
                System.out.println("Turno " + turno + ": el camello se esta recuperando. No avanza.");
                turnosPerdidos--;
                turno++;
                continue;
            }

            System.out.print("Turno " + turno + " - Elige un agujero (1-4): ");

            int agujero = 0;

            while (agujero < 1 || agujero > 4) {
                
                agujero = jugador.nextInt();

                if (agujero < 1 || agujero > 4) {
                    System.out.println("Número inválido, elige entre 1 y 4.");
                }
            }
            jugador.nextLine();

            double suerte = Math.random();
            if (suerte < 0.1) {
                System.out.println("¡Tropiezo! Pierdes este turno y los dos siguientes.");
                turnosPerdidos = 2;
                turno++;
                continue;
            }

            double probabilidad = 0.0;
            int avance = 0;

            if (agujero == 1) {
                probabilidad = 0.6;
                avance = 1;
            } else if (agujero == 2) {
                probabilidad = 0.4;
                avance = 2;
            } else if (agujero == 3) {
                probabilidad = 0.3;
                avance = 4;
            } else if (agujero == 4) {
                probabilidad = 0.1;
                avance = 6;
            }

            double azar = Math.random();
            if (azar < probabilidad) {
                posicion = posicion + avance;
                if (posicion > META)
                    posicion = META;
                System.out.println("Avanzas " + avance + " casillas. Ahora estas en " + posicion);
                fallosSeguidos = 0;
            } else {
                System.out.println("No avanza. Sigue en " + posicion);
                fallosSeguidos++;
                if (fallosSeguidos == 3) {
                    System.out.println("Tres fallos seguidos, Vuelves a la posición 0.");
                    posicion = 0;
                    fallosSeguidos = 0;
                }
            }

            if (posicion == META) {
                alcanzoLaMeta = true;
                System.out.println("¡Felicidades! Llegaste a la meta en " + turno + " turnos.");
            }

            turno++;
        }

        if (!alcanzoLaMeta) {
            System.out.println("El juego terminó. No llegaste a la meta en " + MAX_TURNOS + " turnos.");
        }

        jugador.close();
    }
}
