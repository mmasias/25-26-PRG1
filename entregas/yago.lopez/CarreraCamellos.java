import java.util.Scanner;
import java.util.Random;

class CarrerraCamellos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final String PISTA_01 = "---+-----------+---------+---------+---------+---------+-----------+";
        final String PISTA_02 = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String PISTA_03 = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String PISTA_04 = "---+-----------+---------+---------+---------+---------+-----------+";
        final String CABECERA_PISTA = "[J]| ";
        final String CAMELLO = ";--;'";
        final String AVANCE = " ";

        int posicion = 0;
        final int POSICION_FINAL = 60;
        int turnos = 0;
        boolean alcanzoLaMeta = false;
        
        System.out.println("¡Bienvenido a la Carrera de Camellos!");
        System.out.println("Elige un agujero (1-4) en cada turno:");
        System.out.println("Agujero 1: 60% probabilidad - 1 casilla");
        System.out.println("Agujero 2: 40% probabilidad - 2 casillas");
        System.out.println("Agujero 3: 30% probabilidad - 4 casillas");
        System.out.println("Agujero 4: 10% probabilidad - 6 casillas");

        System.out.println("Jugador al inicio");
        mostrarTablero(PISTA_01, PISTA_02, PISTA_03, PISTA_04, CABECERA_PISTA, CAMELLO, AVANCE, posicion);
        System.out.println("Turno 0");
        
        do {
            turnos++;
            System.out.print("Elija un agujero: ");
            int agujeroElegido = scanner.nextInt();

            if (agujeroElegido < 1 || agujeroElegido > 4) {
                System.out.println("Agujero no válido. Elija entre 1 y 4.");
                turnos--; 
                continue;
            }

            double probabilidad = 0;
            int avance = 0;
            boolean acerto = false;
            
            if (agujeroElegido == 1) {
                probabilidad = 0.6;
                avance = 1;
            } else if (agujeroElegido == 2) {
                probabilidad = 0.4;
                avance = 2;
            } else if (agujeroElegido == 3) {
                probabilidad = 0.3;
                avance = 4;
            } else if (agujeroElegido == 4) {
                probabilidad = 0.1;
                avance = 6;
            }

            double resultado = Math.random();
            if (resultado <= probabilidad) {
                int posicionAnterior = posicion;
                posicion += avance;
                acerto = true;
                
                System.out.printf("Turno %d - Avanza %d casillas - Esta en la casilla %d\n", 
                                turnos, avance, posicion);
                System.out.printf("Jugador en la posición %d\n", posicion);
            } else {
                System.out.printf("Turno %d - No avanza ninguna casilla - Esta en la casilla %d\n", 
                                turnos, posicion);
                System.out.printf("Jugador en la posición %d y sin acertar\n", posicion);
            }

            mostrarTablero(PISTA_01, PISTA_02, PISTA_03, PISTA_04, CABECERA_PISTA, CAMELLO, AVANCE, posicion);
            alcanzoLaMeta = posicion >= POSICION_FINAL;
            
        } while (!alcanzoLaMeta);

        System.out.println("Jugador al final");
        mostrarTablero(PISTA_01, PISTA_02, PISTA_03, PISTA_04, CABECERA_PISTA, CAMELLO, AVANCE, posicion);
        System.out.printf("Turno %d - Avanza %d casillas - Esta en la casilla %d\n", 
                        turnos, Math.min(6, posicion - (posicion - 6)), posicion);
        System.out.println("El juego ha terminado");
        System.out.printf("Total de turnos empleados: %d\n", turnos);
        
        scanner.close();
    }

    public static void mostrarTablero(String pista1, String pista2, String pista3, String pista4, 
                                     String cabecera, String camello, String avance, int posicion) {
        System.out.println(pista1);
        System.out.println(pista2);
        System.out.println(pista3);
        System.out.println(pista4);
        System.out.println(cabecera + avance.repeat(posicion) + camello);
        System.out.println(pista4);
    }
}