
class Edificio {

    public static void main(String[] args) {
        final double PERSIANA_ABIERTA = 0.7;
        final double LUZ_ENCENDIDA = 0.6;

        final String VENTANA_CERRADA = "[ ]";
        final String VENTANA_ABIERTA_CON_LUZ = "[*]";
        final String VENTANA_ABIERTA_SIN_LUZ = "[º]";
        final String SEPARADOR = "[   ]";

        Boolean abierta, encendida;

        for (int dia = 0; dia < 7; dia++) {
            for (int hora = 0; hora < 24; hora++) {
                System.out.println("son las " + hora + " del dia " + dia);
                for (int planta = 1; planta <= 7; planta++) {
                    for (int columna = 1; columna <= 6; columna++) {
                        if (columna == 3) {
                            System.out.print(SEPARADOR);
                        }

                        abierta = Math.random() < PERSIANA_ABIERTA;
                        encendida = Math.random() < LUZ_ENCENDIDA;
                        System.out.print(!abierta ? VENTANA_CERRADA
                                : encendida ? VENTANA_ABIERTA_CON_LUZ : VENTANA_ABIERTA_SIN_LUZ);

                    }
                    System.out.println();
                }
            }
        }
    }
}