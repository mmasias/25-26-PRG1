import java.util.Scanner;

class CarreraCamellos {
    public static void main(String[] args) {
        final double PROBABILIDAD_AGUJERO_1 = 0.60;
        final double PROBABILIDAD_AGUJERO_2 = 0.40;
        final double PROBABILIDAD_AGUJERO_3 = 0.30;
        final double PROBABILIDAD_AGUJERO_4 = 0.10;
        final int AVANCE_AGUJERO_1 = 1;         
        final int AVANCE_AGUJERO_2 = 2;
        final int AVANCE_AGUJERO_3 = 4;       
        final int AVANCE_AGUJERO_4 = 6;
        final String CAMELLO = ";--;'";
        final String CERCO_PISTA = "---+-----------+---------+---------+---------+---------+-----------+";
        final String MARCAS_MAYORES_PISTA = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String MARCAS_MENORES_PISTA = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        String avanceCamello = " ";
        int turno = 0;
        int casillaActual = 0;
        int seleccionJugador;
        int casillasAvanzadas = 0;
        boolean acertoTiro  = true;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(CERCO_PISTA);
            System.out.println(MARCAS_MAYORES_PISTA);
            System.out.println(MARCAS_MENORES_PISTA);
            System.out.println(CERCO_PISTA);
            System.out.println("[J]|" + avanceCamello + CAMELLO);
            System.out.println(CERCO_PISTA);
            
            System.out.print("Turno: " + turno);
            if(turno != 0){
                if(acertoTiro)
                    System.out.print(" - Avanza " + casillasAvanzadas);
                else 
                    System.out.print("- No avanza ninguna casilla");
                System.out.print(" - Esta en la casilla "+ casillaActual);
            }
            System.out.println();
            System.out.println("Elija un agujero: ");    
            seleccionJugador = scanner.nextInt();
            
            if (seleccionJugador == 1) {
                acertoTiro = Math.random() < PROBABILIDAD_AGUJERO_1;
                casillasAvanzadas = acertoTiro ? AVANCE_AGUJERO_1 : 0;
            } 
            else if (seleccionJugador == 2) {
                acertoTiro = Math.random() < PROBABILIDAD_AGUJERO_2;
                casillasAvanzadas = acertoTiro ? AVANCE_AGUJERO_2 : 0;
            }
            else if (seleccionJugador == 3) {
                acertoTiro = Math.random() < PROBABILIDAD_AGUJERO_3;
                casillasAvanzadas = acertoTiro ? AVANCE_AGUJERO_3 : 0;
            }
            else if (seleccionJugador == 4){
                acertoTiro = Math.random() < PROBABILIDAD_AGUJERO_4;
                casillasAvanzadas = acertoTiro ? AVANCE_AGUJERO_4 : 0;
            }
            else {
                acertoTiro = false;
                casillasAvanzadas = 0;
            }

            for(int i = 0; i<casillasAvanzadas; i++)
                avanceCamello = avanceCamello + " ";

            casillaActual = casillaActual + casillasAvanzadas;
            turno = turno + 1;
        } while(casillaActual <= 60);
        System.out.println("El juego ha terminado");
        scanner.close();
    }
}