import java.util.Scanner;

public class CarreraCamelloRetoExtendido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double PROBABILIDAD_AGUJERO_UNO = 0.6;
        final double PROBABILIDAD_AGUJERO_DOS = 0.4;
        final double PROBABILIDAD_AGUJERO_TRES = 0.3;
        final double PROBABILIDAD_AGUJERO_CUATRO = 0.1;

        final int CAMELLO_AVANZA_UNO = 1;
        final int CAMELLO_AVANZA_DOS = 2;
        final int CAMELLO_AVANZA_CUATRO = 4;
        final int CAMELLO_AVANZA_SEIS = 6;

        final String VALLA = "---+-----------+---------+---------+---------+---------+-----------+";
        final String VALLA_POSICION = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String VALLA_NUMEROS = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String SALIDA_CAMELLO = "[J]| ";
        final String CAMELLO = ";--;'";
        final String ESPACIO = " ";

        final int META = 60;

        
        System.out.println();
        System.out.println("===================================");
        System.out.println("    CARRERA DE CAMELLOS  ;--;'    ");
        System.out.println("===================================");
        System.out.println();
        System.out.println("COMO JUGAR:");
        System.out.println("- Llega a la casilla 60 para ganar");
        System.out.println("- Cada turno elige un agujero (1, 2, 3 o 4)");
        System.out.println();
        System.out.println("PROBABILIDADES:");
        System.out.println("  Agujero 1: 60% -> avanza 1 casilla");
        System.out.println("  Agujero 2: 40% -> avanza 2 casillas");
        System.out.println("  Agujero 3: 30% -> avanza 4 casillas");
        System.out.println("  Agujero 4: 10% -> avanza 6 casillas");
        System.out.println();
        System.out.println("===================================");
        System.out.println();

        System.out.println(VALLA);
        System.out.println(VALLA_NUMEROS);
        System.out.println(VALLA_POSICION);
        System.out.println(VALLA);
        System.out.println(SALIDA_CAMELLO + CAMELLO);
        System.out.println(VALLA);

        int casillaPosicion = 0;
        int turno = 0;
        int intentosFallidos = 0; 
        int turnosPerdidos = 0; 
        
        final int TURNO_MAXIMO = 50;
        final int NUMERO_FALLIDO_DE_INTENTOS_TRES = 3;
        final double PROBABILIDAD_DE_TROPIEZO = 0.1;

        while (casillaPosicion < META && turno < TURNO_MAXIMO) {
            turno = turno + 1;
            
            if (turnosPerdidos > 0) {
                System.out.println();
                System.out.println("Turno " + turno + " - PERDIDO (tropiezo anterior)");
                System.out.println("===================================");
                turnosPerdidos--;
            } else {
                System.out.println();
                System.out.println("Turno " + turno);
                System.out.println("===================================");
                System.out.print("Elija un agujero: ");

                int agujeroElegido = scanner.nextInt();
                
                
                int avance = 0;
                double probabilidad = Math.random();
                double tropiezo = Math.random();
                
                if (tropiezo < PROBABILIDAD_DE_TROPIEZO) {
                    System.out.println("¡El camello TROPIEZA! Pierde 2 turnos.");
                    avance = 0;
                    turnosPerdidos = 2;
                    intentosFallidos++; 
                } else {
                    boolean acierta = false;
                    
                    if (agujeroElegido == 1) {
                        if (probabilidad < PROBABILIDAD_AGUJERO_UNO) {
                            avance = CAMELLO_AVANZA_UNO;
                            acierta = true;
                        }
                    } else if (agujeroElegido == 2) {
                        if (probabilidad < PROBABILIDAD_AGUJERO_DOS) {
                            avance = CAMELLO_AVANZA_DOS;
                            acierta = true;
                        }
                    } else if (agujeroElegido == 3) {
                        if (probabilidad < PROBABILIDAD_AGUJERO_TRES) {
                            avance = CAMELLO_AVANZA_CUATRO;
                            acierta = true;
                        }
                    } else if (agujeroElegido == 4) {
                        if (probabilidad < PROBABILIDAD_AGUJERO_CUATRO) {
                            avance = CAMELLO_AVANZA_SEIS;
                            acierta = true;
                        }
                    }
                    
                    if (acierta) {
                        intentosFallidos = 0; 
                    } else {
                        intentosFallidos = intentosFallidos + 1;
                        if (intentosFallidos >= NUMERO_FALLIDO_DE_INTENTOS_TRES) {
                            System.out.println("¡3 FALLOS CONSECUTIVOS! Vuelves a la casilla 0.");
                            casillaPosicion = 0;
                            intentosFallidos = 0; 
                        }
                    }
                }

                casillaPosicion = casillaPosicion + avance;

                System.out.println();
                System.out.println(VALLA);
                System.out.println(VALLA_NUMEROS);
                System.out.println(VALLA_POSICION);
                System.out.println(VALLA);
                System.out.println(SALIDA_CAMELLO + ESPACIO.repeat(casillaPosicion) + CAMELLO);
                System.out.println(VALLA);
                System.out.println();

                if (avance > 0) {
                    System.out.println(
                            "Turno " + turno + " - Avanza " + avance + " casillas - Esta en la casilla " + casillaPosicion);
                } else {
                    System.out.println(
                            "Turno " + turno + " - No avanza ninguna casilla - Esta en la casilla " + casillaPosicion);
                }
            }
        }

        System.out.println();
        if (casillaPosicion >= META) {
            System.out.println("¡FELICIDADES! El camello llegó a la meta en la casilla " + casillaPosicion + " en " + turno + " turnos.");
        } else {
            System.out.println("GAME OVER - Alcanzaste el límite de " + TURNO_MAXIMO + " turnos. Posición final: " + casillaPosicion);
        }

        scanner.close();
    }
}
