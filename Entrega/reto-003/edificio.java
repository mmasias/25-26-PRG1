public class edificio {

    public static void main(String[] args) {
        final double PERSIANA_ABIERTA = 0.7;
        final double PERSIANA_CERRADA = 0.6;

        final String VENTANA_CERRADA = "[ ]";
        final String VENTANA_CON_LUZ_APAGADA = "[º]";
        final String VENTANA_CON_LUZ_ENCENDIDA = "[*]";
        final String separador = "[    ]";
        boolean abierta, encendida;

        for (int dia = 1; dia <= 7; dia++) {
            for (int hora = 0; hora <= 24; hora++) {
                System.out.println(" Son las " + hora + " del dia " + dia);
                for (int fila = 1; fila <= 7; fila++) {
                    for (int columna = 1; columna <= 6; columna++) {
                        abierta = Math.random() < PERSIANA_ABIERTA;
                        encendida = Math.random() < PERSIANA_CERRADA;
                        System.out.print(!abierta ? VENTANA_CERRADA: encendida ? VENTANA_CON_LUZ_ENCENDIDA : VENTANA_CON_LUZ_APAGADA);
                        if (columna == 3) {
                            System.out.print(separador);
                        }
                    }
                    System.out.println();
                }
            }
        }

    }
}