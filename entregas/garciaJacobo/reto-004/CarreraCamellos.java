import java.util.Scanner;

public class CarreraCamellos {
    public static void main(String[] args) {
        int posicion = 0;
        int turno = 0;
        final int AVANZE_CAMELLO_AGUJERO_1 = 1;
        final int AVANZE_CAMELLO_AGUJERO_2 = 2;
        final int AVANZE_CAMELLO_AGUJERO_3 = 4;
        final int AVANZE_CAMELLO_AGUJERO_4 = 6;

        final double PROBABILIDAD_AVANZE_CAMELLO_AGUJERO_1 = 0.6;
        final double PROBABILIDAD_AVANZE_CAMELLO_AGUJERO_2 = 0.4;
        final double PROBABILIDAD_AVANZE_CAMELLO_AGUJERO_3 = 0.3;
        final double PROBABILIDAD_AVANZE_CAMELLO_AGUJERO_4 = 0.1;

        final int AGUJERO_MINIMO = 1;
        final int AGUJERO_MAXIMO = 4;
        final int POSICION_MAXIMA = 60;
        Scanner scanner = new Scanner(System.in);
        int agujeroElegido;
        final int POSICION_MINIMA = 0;
        String mensaje_1 = "Has acertado avanzas ";
        String mensaje_2 = "Has fallado no avanzaste quedaste  en tu posicion ";
        final String LINEA_SUPERIOR = "---+-----------+---------+---------+---------+---------+-----------+";
        final String LINEA_NUMEROS_1 = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String LINEA_NUMEROS_2 = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String CAMELLO = ";--;'";
        System.out.println(LINEA_SUPERIOR);
        System.out.println(LINEA_NUMEROS_1);
        System.out.println(LINEA_NUMEROS_2);
        System.out.println(LINEA_SUPERIOR);

        System.out.print("[J]|" + CAMELLO);
        System.out.println();
        System.out.println(LINEA_SUPERIOR);
        System.out.println("turno " + turno);

        String resultadoTurno = "";

        while (posicion < POSICION_MAXIMA) {
            do {
                System.out.println();
                System.out.println("Que agujero eliges entre(1-4)?");
                agujeroElegido = scanner.nextInt();

            } while (agujeroElegido < AGUJERO_MINIMO || agujeroElegido > AGUJERO_MAXIMO);
            int avanzeCamello = 0;
            double numeroAleatorio = Math.random();
            if (agujeroElegido == 1) {
                if (numeroAleatorio < PROBABILIDAD_AVANZE_CAMELLO_AGUJERO_1) {
                    posicion = posicion + AVANZE_CAMELLO_AGUJERO_1;
                    avanzeCamello = AVANZE_CAMELLO_AGUJERO_1;
                    if (posicion > POSICION_MAXIMA) {
                        posicion = POSICION_MAXIMA;
                    }
                }
            } else if (agujeroElegido == 2) {
                if (numeroAleatorio < PROBABILIDAD_AVANZE_CAMELLO_AGUJERO_2) {
                    posicion = posicion + AVANZE_CAMELLO_AGUJERO_2;
                    avanzeCamello = AVANZE_CAMELLO_AGUJERO_2;
                    if (posicion > POSICION_MAXIMA) {
                        posicion = POSICION_MAXIMA;
                    }
                }

            } else if (agujeroElegido == 3) {
                if (numeroAleatorio < PROBABILIDAD_AVANZE_CAMELLO_AGUJERO_3) {
                    posicion = posicion + AVANZE_CAMELLO_AGUJERO_3;
                    avanzeCamello = AVANZE_CAMELLO_AGUJERO_3;
                    if (posicion > POSICION_MAXIMA) {
                        posicion = POSICION_MAXIMA;
                    }
                }
            } else if (agujeroElegido == 4) {
                if (numeroAleatorio < PROBABILIDAD_AVANZE_CAMELLO_AGUJERO_4) {
                    posicion = posicion + AVANZE_CAMELLO_AGUJERO_4;
                    avanzeCamello = AVANZE_CAMELLO_AGUJERO_4;
                    if (posicion > POSICION_MAXIMA) {
                        posicion = POSICION_MAXIMA;
                    }
                }
            }
            if (avanzeCamello > POSICION_MINIMA) {
                System.out.println(mensaje_1 + avanzeCamello + " casillas");

            } else
                System.out.println(mensaje_2 + avanzeCamello + " casillas");

            if (posicion > 0) {

                resultadoTurno = "- Está en la casilla " + avanzeCamello;

            } else {
                resultadoTurno = " - No avanza - Se queda en la casilla " + posicion;

            }

            turno++;

            System.out.println(LINEA_SUPERIOR);
            System.out.println(LINEA_NUMEROS_1);
            System.out.println(LINEA_NUMEROS_2);
            System.out.println(LINEA_SUPERIOR);

            System.out.print("[J]| ");
            for (int i = 0; i < posicion; i++) {
                System.out.print(" ");
            }
            System.out.print(CAMELLO);
            System.out.println();
            System.out.println(LINEA_SUPERIOR);
            System.out.println(resultadoTurno);

            System.out.print(" Turno " + turno + " - Estás en la casilla " + posicion);

        }
        System.out.println("Felicidades has llegado a la meta en " + turno + " turnos");
    }
   
}

