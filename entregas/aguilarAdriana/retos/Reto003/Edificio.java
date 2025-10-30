package entregas.aguilarAdriana.retos.Reto003;

public class Edificio {
    public static void main(String[] args) {

        final int PLANTAS_CON_HABITACION = 7;
        final int HABITACIONES_POR_PLANTA = 6;

        final double PERSIANA_ABIERTA = 0.7;
        final double LUZ_ENCENDIDA = 0.6;

        final String VENTANA_CERRADA = "[ ]";
        final String VENTANA_ABIERTA_SIN_LUZ = "[º]";
        final String VENTANA_ABIERTA_CON_LUZ = "[*]";
        final String SEPARADOR = "[    ]";
        final String LADRILLO = ":";

       

        for (int dia = 1; dia <= 10; dia++) {
            for (int hora = 1; hora <= 24; hora++) {
                 System.out.println("               __/\\__");
        System.out.println("  |    |    |  |####|  |    |    |  ");
        System.out.println("====================================");
                for (int planta = 1; planta <= 7; planta++) {
                    for (int columna = 1; columna <= 7; columna++) {
                        
                        boolean abierta, encendida;
                        abierta = Math.random() < PERSIANA_ABIERTA;
                        encendida = Math.random() < LUZ_ENCENDIDA;

                        if (columna == 4) {
                            System.out.print(SEPARADOR);
                        } else {
                            System.out.print(LADRILLO+(!abierta ? VENTANA_CERRADA
                                    : encendida ? VENTANA_ABIERTA_CON_LUZ : VENTANA_ABIERTA_SIN_LUZ)+LADRILLO);
                        }

                    }
                    System.out.println();
                }
                 System.out.println("------------------------------------");
        System.out.println("     ==========================");
        System.out.println("   ==============================");
        System.out.println(" ==================================");
                System.out.println("Dia " + dia + " - " + hora + ":00h");
            }
        }

       

    }

}
