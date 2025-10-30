class Edificio {

    public static void main(String[] args) {

        final double PERSIANA_ABIERTA = 0.7;
        final double LUZ_ENCENDIDA = 0.6;

        final String VENTANA_CERRADA = ":[ ]:";
        final String VENTANA_ABIERTA_CON_LUZ = ":[*]:";
        final String VENTANA_ABIERTA_SIN_LUZ = ":[º]:";
        final String SEPARADOR = "[    ]";
        final String TECHO = """
                               __/\\__
                  |    |    |  |####|  |    |    |
                ====================================""";


        final String SUELO_INFERIOR = """
                ------------------------------------
                    ==========================
                  ==============================
                ==================================""";

        boolean abierta, encendida;

        for (int dia = 1; dia <= 7; dia++) {
            for (int hora = 0; hora < 24; hora++) {
                System.out.println("Son las " + hora + " horas del dia" + dia);

                System.out.println(TECHO);

                for (int planta = 1; planta <= 7; planta++) {
                    for (int columna = 1; columna <= 6; columna++) {
                        abierta = Math.random() < PERSIANA_ABIERTA;
                        encendida = Math.random() < LUZ_ENCENDIDA;

                        System.out.print(
                                !abierta ? VENTANA_CERRADA
                                        : encendida ? VENTANA_ABIERTA_CON_LUZ : VENTANA_ABIERTA_SIN_LUZ);
                        if (columna == 3) {
                            System.out.print(SEPARADOR);
                        }
                    }
                    System.out.println(" - P" + planta);
                }
                System.out.println(SUELO_INFERIOR);
                
                System.out.println();
            }
        }

    }

}
