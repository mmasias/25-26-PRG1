

public class Reto3{
    public static void main(String[] args) {
        final double PERSIANA_ABIERTA = 0.7;
        final double LUZ_ENCENDIDA = 0.6;

        final String VENTANA_CERRADA = "[ ]";
        final String VENTANA_ABIERTA_CON_LUZ = "[*]";
        final String VENTANA_ABIERTA_SIN_LUZ = "[º]";
        final String SEPARADOR = "[   ]";
        final String TECHO = "||   |   |###|   |   ||";

        boolean abierta, encendida;

        for (int dia = 1; dia <= 7; dia++) {
            for (int hora = 0; hora < 24; hora++) {
                System.out.println("Son las " + hora + ":00 del día " + dia);
                for (int i = 0; i < 1; i++) {
                    System.out.println(TECHO);

                }

                for (int planta = 1; planta <= 7; planta++) {
                    for (int columna = 1; columna <= 6; columna++) {

                        abierta = Math.random() < PERSIANA_ABIERTA;
                        encendida = Math.random() < LUZ_ENCENDIDA;
                        System.out.print(
                                !abierta ? (encendida ? VENTANA_CERRADA : VENTANA_ABIERTA_CON_LUZ)
                                        : VENTANA_ABIERTA_SIN_LUZ);

                        if (columna == 3) {
                            System.out.print(SEPARADOR);
                        }

                    }
                    System.out.println();
                }

            }
        }
    }
}
