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
        int turno = 0;
        int casillaActual = 0;
        int seleccionJugador;

        Scanner scanner = new Scanner(System.in);
        System.out.println();

        do {
            System.out.println("---+-----------+---------+---------+---------+---------+-----------+");
            System.out.println("---| 0.........1.........2.........3.........4.........5.........6 |");
            System.out.println("---| 0123456789012345678901234567890123456789012345678901234567890 |");
            System.out.println("---+-----------+---------+---------+---------+---------+-----------+");
            
            System.out.println("---+-----------+---------+---------+---------+---------+-----------+");
            System.out.println("Turno: " + turno);
            System.out.prin    
            turno = turno + 1;
        } while(casillaActual <= 60);
    }
}