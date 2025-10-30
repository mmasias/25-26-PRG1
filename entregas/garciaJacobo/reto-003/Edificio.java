public class Edificio {
    public static void main(String[] args) {
        final String TECHO_DEL_EDIFICIO = "               __/\\__";
        final String PARTE_DEABJO_DEL_TECHO = "  |    |    |  |####|  |    |    |  ";
        final String BORDE_SUPERIOR_TEJADO = "====================================";
        final String BASE_EDIFICIO = "------------------------------------";
        final String BORDE_INFERIOR_1 = "     ==========================";
        final String BORDE_INFERIOR_2 = "   ==============================";
        final String BORDE_INFERIOR_3 = " ==================================";

        final String VENTANA_CERRADA = ":[ ]:";
        final String VENTANA_LUZ_APAGADA = ":[º]:";
        final String VENTANA_LUZ_ENCENDIDA = ":[*]:";
        final String SEPARADOR = "[    ]";
        final double PROBABILIDAD_PERSIANA_ABIERTA = 0.7;
        final double PROBABILIDAD_LUZ_ENCENDIDA = 0.6;
        final int PLANTA_MAXIMA = 7;
        boolean luzEncencida, persianaAbierta;

        for (int dia = 1; dia <= 7; dia++) {
            for (int horas = 0; horas <= 24; horas++) {
                
                System.out.println(TECHO_DEL_EDIFICIO);
                System.out.println(PARTE_DEABJO_DEL_TECHO);
                System.out.println(BORDE_SUPERIOR_TEJADO);
                for (int planta = 1; planta <= PLANTA_MAXIMA; planta++) {
                    for (int columna = 1; columna <= 6; columna++) {
                        persianaAbierta = Math.random() < PROBABILIDAD_PERSIANA_ABIERTA;
                        luzEncencida = Math.random() < PROBABILIDAD_LUZ_ENCENDIDA;

                        System.out.print(
                                !persianaAbierta ? VENTANA_CERRADA
                                        : luzEncencida ? VENTANA_LUZ_ENCENDIDA : VENTANA_LUZ_APAGADA);
                        if (columna == 3) {
                            System.out.print(SEPARADOR);
                        }
                    }
                    System.out.print("- P" + (PLANTA_MAXIMA + 1 - planta));
                    System.out.println();

                }
                System.out.println(BASE_EDIFICIO);
                System.out.println(BORDE_INFERIOR_1);
                System.out.println(BORDE_INFERIOR_2);
                System.out.println(BORDE_INFERIOR_3);
                System.out.println("Son las " + horas + ":00 del dia " + dia);
            }
        }
    }
}
