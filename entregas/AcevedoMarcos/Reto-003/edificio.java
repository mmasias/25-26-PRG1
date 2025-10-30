import java.util.Scanner;

class Edificio {

    public static void main(String[] args) {

        final double PERSIANA_ABIERTA = 0.7;
        final double LUZ_ENCENCIDA = 0.6;

        final String TECHO_ESPACIO_ARRIBA = "              __/\\__               ";
        final String TECHO_ESPACIO_MEDIO = "  |    |    |  |####|  |    |    |  ";
        final String TECHO_ESPACIO_BAJO = " ==================================== ";
        final String BASE = "------------------------------------ ";
        final String VENTANA_CERRADA = "[ ]";
        final String VENTANA_ABIERTA_CON_LUZ = "[*]";
        final String VENTANA_ABIERTA_SIN_LUZ = "[º]";
        final String SEPARADOR = " [    ] ";

        boolean abierta, encendida;
        for (int dia=1; dia<=7;dia++) {
            for (int hora=0; hora<=24; hora++) {
                System.out.println(TECHO_ESPACIO_ARRIBA);
                System.out.println(TECHO_ESPACIO_MEDIO);
                System.out.println(TECHO_ESPACIO_BAJO);
                System.out.println("Son las " +  hora + " del dia " + dia);
                for (int planta=1; planta<=7; planta++) {
                    for (int columna=1; columna<=6; columna++) {
                        abierta = Math.random() < PERSIANA_ABIERTA;
                        encendida = Math.random() < LUZ_ENCENCIDA;
                        System.out.println(!abierta ? VENTANA_CERRADA : encendida ? VENTANA_ABIERTA_CON_LUZ : VENTANA_ABIERTA_SIN_LUZ);
                        if (columna == 3 ) {
                            System.out.print( SEPARADOR );
                        }
                    }
                }
            }
        }
        System.out.println(BASE);
    }
}