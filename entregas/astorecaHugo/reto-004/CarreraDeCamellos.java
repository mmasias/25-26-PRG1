import java.util.Scanner;

public class CarreraDeCamellos {
    public static void main(String[] args) {
        final String PISTA_01 ="---+-----------+---------+---------+---------+---------+-----------+";
        final String PISTA_02 = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String PISTA_03 ="---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String CABECERA_PISTA ="[J]|" ;
        final String CAMELLO = ";--;'";
        Scanner scanner = new Scanner(System.in);

        final String AVANCE = " ";
        int posicion = 0;
        final int POSICION_FINAL = 60; 
        final double PROBABILIDAD_AGUJERO_1 = 0.6;
        final double PROBABILIDAD_AGUJERO_2 = 0.4;
        final double PROBABILIDAD_AGUJERO_3 = 0.3;
        final double PROBABILIDAD_AGUJERO_4 = 0.1;
        

        System.out.println ( "Elije un agujero al cual lanzar la bola (1, 2, 3 o 4):");

        for (posicion= 0; posicion <= POSICION_FINAL; posicion++) {
            int agujero = scanner.nextInt();

            if (agujero == 1 && Math.random() < PROBABILIDAD_AGUJERO_1) {
                posicion +=1;
            } else if (agujero == 2 && Math.random() < PROBABILIDAD_AGUJERO_2) {
                posicion += 2;
            } else if (agujero == 3 && Math.random() < PROBABILIDAD_AGUJERO_3) {
                posicion += 4;
            } else if (agujero == 4 && Math.random() < PROBABILIDAD_AGUJERO_4) {
                posicion += 6;
                if (posicion < 0) {
                    posicion = 0;
                }
            }

            System.out.println( PISTA_01 );
            System.out.println( PISTA_02 );
            System.out.println( PISTA_03 );
            System.out.println( PISTA_01);
            System.out.println( CABECERA_PISTA + AVANCE.repeat(posicion) + CAMELLO );
            System.out.println( PISTA_01 );

            if (posicion >= POSICION_FINAL) {
                System.out.println("¡El camello ha llegado a la meta!");
    
        }



    }
}
}
