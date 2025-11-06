import java.util.Scanner;

class Camello {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String PISTA_01 = "---+-----------+---------+---------+---------+---------+-----------+";
        final String PISTA_02 = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String PISTA_03 = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String CABEZERA = "[J]| ";
        final String CAMELLO = ";--;'";

        final double PROB_AGUJERO_1 = 0.6;
        final double PROB_AGUJERO_2 = 0.4;
        final double PROB_AGUJERO_3 = 0.3;
        final double PROB_AGUJERO_4 = 0.1;

        int posicion = 0;
        final int POSICION_FINAL = 60; // Meta: 60 casillas
        boolean meta = false;
        int turno = 0;

        do {
            int agujero_seleccion = -1;
            int avance_casillas = 0;
            double prob_acierto = 0.0;
            
            // --- Presentación del Turno y Selección de Agujero ---
            System.out.println("---");
            System.out.println("Turno " + turno + ". Posición actual: " + posicion + "/" + POSICION_FINAL);
            System.out.println("A que agujero desea lanzar?, coloque el solo el numero del agujero");
            System.out.println("Agujero 1: Probabilidad de acierto 60%, avanze = 1");
            System.out.println("Agujero 2: Probabilidad de acierto 40%, avanze = 2");
            System.out.println("Agujero 3: Probabilidad de acierto 30%, avanze = 4");
            System.out.println("Agujero 4: Probabilidad de acierto 10%, avanze = 6");
            
            // Validación de entrada
            if (scanner.hasNextInt()) {
                agujero_seleccion = scanner.nextInt();
            } else {
                System.out.println("Entrada inválida. Intente de nuevo.");
                scanner.next(); // Limpia la entrada
                continue; // Vuelve al inicio del bucle
            }

            // --- Lógica de Avance usando if-else if-else ---

            if (agujero_seleccion == 1) {
                prob_acierto = PROB_AGUJERO_1;
                avance_casillas = 1;
            } else if (agujero_seleccion == 2) {
                prob_acierto = PROB_AGUJERO_2;
                avance_casillas = 2;
            } else if (agujero_seleccion == 3) {
                prob_acierto = PROB_AGUJERO_3;
                avance_casillas = 4;
            } else if (agujero_seleccion == 4) {
                prob_acierto = PROB_AGUJERO_4;
                avance_casillas = 6;
            } else {
                System.out.println("Agujero no válido. Pierde el turno.");
            }

            // --- Calcular el resultado del lanzamiento ---
            if (avance_casillas > 0) {
                if (Math.random() <= prob_acierto) {
                    posicion = posicion + avance_casillas;
                    // Asegura que no sobrepase la meta
                    if (posicion >= POSICION_FINAL) {
                        posicion = POSICION_FINAL;
                        meta = true;
                    }
                    System.out.println("¡Acierto! El camello avanza " + avance_casillas + " casillas.");
                } else {
                    System.out.println("¡Fallaste! El camello no avanza.");
                }
            }


            // --- Imprimir la Pista con la Posición Actualizada ---
            // **Paso clave para que no se reinicie:** Se crea una cadena de espacios 
            // igual a la 'posicion' acumulada antes de dibujar.
            String avance_actual = "";
            for (int i = 0; i < posicion; i++) {
                avance_actual += " ";
            }

            System.out.println(PISTA_01);
            System.out.println(PISTA_02);
            System.out.println(PISTA_03);
            System.out.println(CABEZERA + avance_actual + CAMELLO);
            System.out.println(PISTA_01);


            // --- Actualizar el Turno y Revisar la Meta ---
            turno = turno + 1;
            
            if (posicion >= POSICION_FINAL) {
                meta = true;
            }

        } while (!meta);

        // --- Fin del Juego ---
        System.out.println("*****************************************************************");
        System.out.println("¡FELICIDADES! ¡El camello ha llegado a la meta (" + POSICION_FINAL + " casillas)!");
        System.out.println("Has completado la carrera en " + (turno - 1) + " turnos.");
        System.out.println("*****************************************************************");
        
        scanner.close(); // Buena práctica: cerrar el scanner
    }
}