

package entregas.AznarCarlos.Reto004;

import java.util.Scanner;

public class CarreraDeCamello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String CAMELLO = ";--;'";
        final String PISTA_1 = "---+-----------+---------+---------+---------+---------+-----------+";
        final String PISTA_2 = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String PISTA_3 = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String PISTA_INICIO = "[J]|";
        Double PROBABILIDAD_EXITO_AGUJERO_1 = 0.6;
        Double PROBABILIDAD_EXITO_AGUJERO_2 = 0.4;
        Double PROBABILIDAD_EXITO_AGUJERO_3 = 0.3;
        Double PROBABILIDAD_EXITO_AGUJERO_4 = 0.1;
        final int AVANCE_CASILLAS_AGUJERO_1 = 1;
        final int AVANCE_CASILLAS_AGUJERO_2 = 2;
        final int AVANCE_CASILLAS_AGUJERO_3 = 4;
        final int AVANCE_CASILLAS_AGUJERO_4 = 6;
        final int POSICION_FINAL = 60;
        int numeroDeCasillasInicialYAvance = 0;
        int numeroDeIntentos = 0;


         String avance = " ";
        
        while (numeroDeCasillasInicialYAvance <= POSICION_FINAL) {
            numeroDeIntentos++;
            System.out.println("Que bolas Quieres Lanzar la 1, la 2, la 3, la 4");
            int eleccionDeBola = scanner.nextInt();

            if (eleccionDeBola == 1) {
                if (PROBABILIDAD_EXITO_AGUJERO_1 >= Math.random()) {
                    numeroDeCasillasInicialYAvance = numeroDeCasillasInicialYAvance + AVANCE_CASILLAS_AGUJERO_1;
                    System.out.println("El jugador acerto con la bola esta en " +numeroDeCasillasInicialYAvance + " actualmente\"");
                } else {
                    System.out.println("El Jugador fallo la bola se ubica en" + numeroDeCasillasInicialYAvance);
                }
            } else if (eleccionDeBola == 2) {
                if (PROBABILIDAD_EXITO_AGUJERO_2 >= Math.random()) {
                    numeroDeCasillasInicialYAvance = numeroDeCasillasInicialYAvance + AVANCE_CASILLAS_AGUJERO_2;
                    System.out.println("El jugador acerto con la bola esta en la posicion2 " +numeroDeCasillasInicialYAvance +  " actualmente\"");
                } else {
                    System.out.println("El Jugador fallo la bola se ubica en " + numeroDeCasillasInicialYAvance );
                }
            } else if (eleccionDeBola == 3) {
                if (PROBABILIDAD_EXITO_AGUJERO_3 >= Math.random()) {
                    numeroDeCasillasInicialYAvance = numeroDeCasillasInicialYAvance + AVANCE_CASILLAS_AGUJERO_3;
                    System.out.println("El jugador acerto la bola esta en la posicion " +numeroDeCasillasInicialYAvance +  " actualmente\" ");
                } else {
                    System.out.println("El jugador fallo la bola se ubica en " + numeroDeCasillasInicialYAvance);
                }
            } else if (eleccionDeBola == 4) {
                if (PROBABILIDAD_EXITO_AGUJERO_4 >= Math.random()) {
                    numeroDeCasillasInicialYAvance = numeroDeCasillasInicialYAvance + AVANCE_CASILLAS_AGUJERO_4;
                    System.out.println("El jugador acerto la bola esta en la posicion "+numeroDeCasillasInicialYAvance +  " actualmente");
                } else {
                    System.out.println("El jugador fallo la bola se ubica en " + numeroDeCasillasInicialYAvance);
                }
            } else {
                System.out.println("Elija bien");
        }
    
        System.out.println(PISTA_1);
        System.out.println(PISTA_2);
        System.out.println(PISTA_3);
        System.out.println(PISTA_1);
        System.out.println(PISTA_INICIO + avance.repeat(numeroDeCasillasInicialYAvance) + CAMELLO);
        System.out.println(PISTA_1);
        System.out.println("llevas un total de "+ numeroDeIntentos);
        }
         
        
        if (numeroDeCasillasInicialYAvance <= 60) {
            System.out.println(" El Camello ha ganado.");
        }
        scanner.close();
    }
  
}
