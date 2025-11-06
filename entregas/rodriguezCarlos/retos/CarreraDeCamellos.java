import java.util.Scanner;

public class CarreraDeCamellos {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int turno = 0;
        int casilla = 0;
        int avance = 0;
        boolean acierto = false;

        while (casilla < 60) {
            System.out.println("Turno " + turno);
            System.out.println("Elija un agujero:");
            int agujero = scanner.nextInt();

            if (agujero < 1 || agujero > 4) {
                System.out.println("Agujero no válido.");
                continue;
            }

            double probabilidad = Math.random();
            acierto = false;
            avance = 0;

            if (agujero == 1) {
                if (probabilidad <= 0.60) {
                    acierto = true;
                    avance = 1;
                }
            } else if (agujero == 2) {
                if (probabilidad <= 0.40) {
                    acierto = true;
                    avance = 2;
                }
            } else if (agujero == 3) {
                if (probabilidad <= 0.30) {
                    acierto = true;
                    avance = 4;
                }
            } else if (agujero == 4) {
                if (probabilidad <= 0.10) {
                    acierto = true;
                    avance = 6;
                }
            }

            if (acierto) {
                casilla += avance;
                if (casilla > 60) {
                    casilla = 60;
                }
                System.out.println("Turno " + turno + " - Avanza " + avance + " casillas - Esta en la casilla " + casilla);
            } else {
                System.out.println("Turno " + turno + " - No avanza ninguna casilla - Esta en la casilla " + casilla);
            }

        }

        System.out.println("El juego ha terminado en la casilla 60");
        scanner.close();
    }
}