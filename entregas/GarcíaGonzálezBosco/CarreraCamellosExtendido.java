import java.util.Scanner;

public class CarreraCamellosExtendido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String PISTA_01 = "---+-----------+---------+---------+---------+---------+-----------+";
        final String PISTA_02 = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String PISTA_03 = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String CABECERA_PISTA = "[J]|";
        final String CAMELLO = ";--;'";

        final double ACIERTO_AGUJERO1 = 0.6;
        final int AVANCE1 = 1;
        final double ACIERTO_AGUJERO2 = 0.4;
        final int AVANCE2 = 2;
        final double ACIERTO_AGUJERO3 = 0.3;
        final int AVANCE3 = 4;
        final double ACIERTO_AGUJERO4 = 0.1;
        final int AVANCE4 = 6;
        final double CAMELLO_TROPIEZA = 0.1;
        final String AVANCE = " ";

        int posicion = 0;
        int turnos = 0;
        int fallos = 0;
        final int POSICION_FINAL = 60;
        boolean algunGanador = false;
        

        do {
           
            //posicion = posicion + (int) (Math.random() * 5);

            System.out.println(PISTA_01);
            System.out.println(PISTA_02);
            System.out.println(PISTA_03);
            System.out.println(PISTA_01);
            System.out.println(CABECERA_PISTA + AVANCE.repeat(posicion) + CAMELLO);
            System.out.println(PISTA_01);
            System.out.println();

            System.out.println("Turno: " + turnos );
            System.out.println("Elija un agujero (1,2,3,4): ");
            int agujeroElegido = scanner.nextInt();
            
            if (agujeroElegido == 1) {
                if (Math.random() < ACIERTO_AGUJERO1) {
                    posicion = posicion + AVANCE1;
                    fallos = 0;
                   
                    System.out.println("Avanza "+AVANCE1+" casilla(s)");
                } else {
                    System.out.println("No avanza ninguna casilla");
                    fallos++;
                }
            } else if (agujeroElegido == 2) {
                if (Math.random() < ACIERTO_AGUJERO2) {
                    posicion = posicion + AVANCE2;
                    fallos = 0;
                    System.out.println("Avanza "+AVANCE2+" casilla(s)");
                } else {
                    System.out.println("No avanza ninguna casilla");
                    fallos++;
                }
            } else if (agujeroElegido == 3) {
                if (Math.random() < ACIERTO_AGUJERO3){
                    posicion = posicion + AVANCE3;
                    fallos = 0;
                    System.out.println("Avanza "+AVANCE3+" casilla(s)");
                }
             else {
                System.out.println("No avanza ninguna casilla");
                fallos++;
             }
            } else if (agujeroElegido == 4) {
                if (Math.random() < ACIERTO_AGUJERO4){
                    posicion = posicion + AVANCE4;
                    fallos=0;
                    System.out.println("Avanza "+AVANCE4+" casilla(s)");
                }   
            else{
                System.out.println("No avanza ninguna casilla");
                fallos++;
            }
        }
            if (fallos == 3){
                System.out.println("Has cometido 3 fallos, vuelves a la casilla de salida");
                posicion = 0;
                fallos = 0;
            }

            
            turnos = turnos + 1;
            scanner.nextLine();
            algunGanador = posicion >= POSICION_FINAL;
        } while (!algunGanador);
    }
}
