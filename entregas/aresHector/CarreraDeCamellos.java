import java.util.Scanner;
import java.util.Random;

public class CarreraDeCamellos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random dado = new Random();

        final String LINEA_SUP = "---+==========+==========+==========+==========+==========+==========+";
        final String MARCA_NUM = "---| 0....10....20....30....40....50....60 |";
        final String LINEA_INF = "---+==========+==========+==========+==========+==========+==========+";
        final String CABECERA = "[C] ";
        final String FIGURA_CAMELLO = ";--;'";

        final int META = 60;
        int posicion = 0;
        int turno = 1;
        int fallosSeguidos = 0;
        boolean terminado = false;

        System.out.println("=== BIENVENIDO A LA CARRERA DE CAMELLOS ===\n");

        while (!terminado && turno <= 50) {
            
            System.out.println(LINEA_SUP);
            System.out.println(MARCA_NUM);
            System.out.println(LINEA_INF);
            System.out.println(CABECERA + " ".repeat(posicion) + FIGURA_CAMELLO);
            System.out.println(LINEA_INF);

            
            System.out.println("\nTurno #" + turno);
            System.out.println("Posición actual: " + posicion);
            System.out.print("Elige un agujero (1-4): ");
            int opcion = entrada.nextInt();

            int probAcierto;
            int avance;

            switch (opcion) {
                case 1 -> { probAcierto = 60; avance = 1; }
                case 2 -> { probAcierto = 40; avance = 2; }
                case 3 -> { probAcierto = 30; avance = 4; }
                case 4 -> { probAcierto = 10; avance = 6; }
                default -> {
                    System.out.println("Opción inválida, pierdes el turno.");
                    probAcierto = 0;
                    avance = 0;
                }
            }

            int tiro = dado.nextInt(100) + 1;
            if (tiro <= probAcierto) {
                posicion += avance;
                if (posicion > META) posicion = META;
                System.out.println("¡Acertaste! Avanzas " + avance + " casilla(s).");
                fallosSeguidos = 0;
            } else {
                System.out.println("Fallaste, no avanzas.");
                fallosSeguidos++;
                if (fallosSeguidos == 3) {
                    posicion = 0;
                    System.out.println("Tres fallos seguidos: vuelves al inicio.");
                    fallosSeguidos = 0;
                }
            }

            if (posicion >= META) terminado = true;
            turno++;
            System.out.println();
        }

        
        System.out.println("=== RESULTADO FINAL ===");
        System.out.println(LINEA_SUP);
        System.out.println(MARCA_NUM);
        System.out.println(LINEA_INF);
        System.out.println(CABECERA + " ".repeat(posicion) + FIGURA_CAMELLO);
        System.out.println(LINEA_INF);
        System.out.println("Meta alcanzada en " + turno + " turnos.");
        entrada.close();
    }
}
