package entregas.aguilarAdriana.retos.Reto003;

public class Edificio {

    public static void main(String[] args) {

        final int PLANTAS_CON_HABITACION = 7;
        final int HABITACIONES_POR_PLANTA = 6;

        final double LUZ_ENCENDIDA = 0.6;
        final double PERCIANA_ABIERTA = 0.7;

        final String CERRADO = "[ ]";
        final String APAGADO = "[º]";
        final String ENCENDIDO = "[*]";
        final String LADRILLO = ":";
        final String ESPACIO = "[    ]";

        for (int dia = 1; dia <= 10; dia++) {
            for (int hora = 0; hora <= 24; hora++) {
                System.out.println("               __/\\__");
                System.out.println("  |    |    |  |####|  |    |    | ");
                System.out.println("====================================");
                for (int columna = 1; columna <= PLANTAS_CON_HABITACION; columna++) {
                    for (int planta = 1; planta <= HABITACIONES_POR_PLANTA; planta++) {

                        boolean abierto, encendido;
                        abierto = Math.random() <= PERCIANA_ABIERTA;
                        encendido = Math.random() <= LUZ_ENCENDIDA;

                        System.out.print(LADRILLO + (abierto ? (encendido ? ENCENDIDO : APAGADO) : CERRADO) + LADRILLO);
                        if (planta == 3) {
                            System.out.print(ESPACIO);

                        }

                    }
                    int numeroPlanta = PLANTAS_CON_HABITACION - columna + 1 ;
                    System.out.print(" - P" + numeroPlanta);
                    
                    System.out.println();

                }
                System.out.println("------------------------------------");
                System.out.println("     ==========================");
                System.out.println("   ==============================");
                System.out.println("==================================");
                System.out.println("Dia " + dia + " --- " + hora + ":00h");
            }
        }

    }
}
