package reto003;

import java.util.Random;

class Edificio {
    public static void main(String[] args) {
        Random random = new Random();
        int hora = 0;
        int horasTotales = 24 * 7;
        int dia = 0;

        final String VENTANA_CERRADA = "[ ]";
        final String LUZ_APAGADA = "[º]";
        final String LUZ_ENCENDIDA = "[*]";

        final double PERSIANA_ABIERTA = 0.7;
        final double PERSIANA_CERRADA = 0.6;

        boolean encendida;
        boolean abierta;

        for (int i = 0; i <= horasTotales; i++) {

            abierta = Math.random() < PERSIANA_ABIERTA;
            encendida = Math.random() < PERSIANA_CERRADA;

            hora++;

            if (hora == 24) {
                hora = 1;
                dia = dia + 1;
                System.out.println("               __/\\__\r\n" +
                                   "  |    |    |  |####|  |    |    |  \r\n" +
                                   "====================================\r\n");
    
                for (int piso = 1; piso < 7; piso++) {
                    for (int columna = 1; columna < piso; columna++) {
                        System.out.print(!abierta ? VENTANA_CERRADA : encendida ? LUZ_ENCENDIDA : LUZ_APAGADA );
    
                    }
                    ;
                }
                ;
    
                System.out.println(
    
                               "------------------------------------\r\n" +
                                "     ==========================\r\n" +
                                "   ==============================\r\n" +
                                " ==================================\r\n" +
    
                                "Dia " + dia + " - " + hora + ":00h ");
    
            }
        };
            };

}
