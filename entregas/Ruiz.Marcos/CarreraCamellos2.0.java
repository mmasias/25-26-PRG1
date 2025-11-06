
import java.util.Scanner;

class CarreraDeCamellos {

    public static void main(String[] args) {
        final int META = 60;

        final double PROBABILIDAD_1 = 0.6;
        final double PROBABILIDAD_2 = 0.4;
        final double PROBABILIDAD_3 = 0.3;
        final double PROBABILIDAD_4 = 0.1;

        final int AVANCE_1 = 1;
        final int AVANCE_2 = 2;
        final int AVANCE_3 = 4;
        final int AVANCE_4 = 6;

        final String PISTA = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String NUMEROS = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String BORDE = "---+-----------+---------+---------+---------+---------+-----------+";

        int posicion = 0;
        int turno = 0;
        int agujero;
        boolean acierto;

        Scanner entrada = new Scanner(System.in);

        System.out.println(" Comienza la carrera de camellos");
        mostrarTablero(posicion, PISTA, NUMEROS, BORDE);

        while (posicion < META) {
            System.out.print("Turno " + turno + " Elija un agujero (1 a 4): ");
            agujero = entrada.nextInt();
            acierto = false;

            if (agujero == 1 && Math.random() < PROBABILIDAD_1) {
                posicion += AVANCE_1;
                acierto = true;
            } else if (agujero == 2 && Math.random() < PROBABILIDAD_2) {
                posicion += AVANCE_2;
                acierto = true;
            } else if (agujero == 3 && Math.random() < PROBABILIDAD_3) {
                posicion += AVANCE_3;
                acierto = true;
            } else if (agujero == 4 && Math.random() < PROBABILIDAD_4) {
                posicion += AVANCE_4;
                acierto = true;
            }

            if (posicion > META) {
                posicion = META;
            }

            turno++;

            if (acierto) {
                System.out.println(" Turno " + turno + " Acertaste, está en la casilla " + posicion);
            } else {
                System.out.println(" Turno " + turno + " Fallo, sigue en la casilla " + posicion);
            }

            mostrarTablero(posicion, PISTA, NUMEROS, BORDE);
        }

        System.out.println(" ¡El juego ha terminado en " + turno + " turnos!");
        entrada.close();
    }

    public static void mostrarTablero(int posicion, String pista, String numeros, String borde) {
        StringBuilder linea = new StringBuilder();
        for (int i = 0; i <= 60; i++) {
            if (i == posicion) {
                linea.append(";--;'");
            } else {
                linea.append(".");
            }
        }
        System.out.println(borde);
        System.out.println(pista);
        System.out.println(numeros);
        System.out.println(borde);
        System.out.println("[J]| " + linea);
        System.out.println(borde);
    }
}

