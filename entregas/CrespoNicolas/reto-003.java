public class HotelDeLaAgonia {
    public static void main(String[] args) {
        final int PLANTAS = 7;

        final double PERSIANA_ABIERTA = 0.7;
        final double LUZ_ENCENDIDA = 0.6;

        final String VENTANA_CERRADA = "[ ]";
        final String VENTANA_ABIERTA_CON_LUZ = "[*]";
        final String VENTANA_ABIERTA_SIN_LUZ = "[º]";
        final String SEPARADOR = "[   ]";
        final String LADRILLOS = ":";
        boolean abierta, encendida;
        for (int dia = 1; dia <= 7; dia++) {
            for (int hora = 0; hora < 24; hora++) {
                System.out.print("Son las " + hora + "del dia " + dia);
                System.out.println();
                System.out.println("               __/\\__\n" + //
                        "  |    |    |  |####|  |    |    |  \n" + //
                        "====================================");
                for (int planta = 1; planta <= 7; planta++) {
                    for (int columna = 1; columna <= 6; columna++) {
                        abierta = Math.random() < PERSIANA_ABIERTA;
                        encendida = Math.random() < LUZ_ENCENDIDA;
                        if (columna == 3) {
                            System.out.print(SEPARADOR);
                        }else {System.out.print(LADRILLOS+(!abierta ? VENTANA_CERRADA: (encendida ? VENTANA_ABIERTA_CON_LUZ : VENTANA_ABIERTA_SIN_LUZ))+LADRILLOS);}
                    }

                    System.out.println();
                    
                }
            }
        }System.out.println("------------------------------------\n" + //
                                                "     ==========================\n" + //
                                                "   ==============================\n" + //
                                                " ==================================");

    }
}
