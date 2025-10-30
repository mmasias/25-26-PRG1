class RetoEdificio {
    public static void main(String[] args) {
        final String TECHO = "               __/\\__";
        final String TECHO_BAJO = "  |    |    |  |####|  |    |    |  ";
        final String SOPORTE_TECHO = "====================================";
        final String SEPARADOR = "[    ]";

        final String VENTANA = ":[]:";
        final String VENTANA_CERRADA = ":[-]:";
        final String LUZ_APAGADA = ":[x]:";
        final String LUZ_ENCENDIDA = ":[*]:";

        final double PROB_VENTANA_ABIERTA = 0.7;
        final double PROB_LUZ_ENCENDIDA = 0.6;
        boolean abierta, encendida;

        final String BASE = "------------------------------------";
        final String CALLE = " ==================================";

        final int PLANTAS = 8;

        for (int dia = 1; dia <= 7; dia++) {
            for (int hora = 0; hora <= 24; hora++) {
                System.out.println();
                System.out.println("dia: " + dia + " hora: " + hora);
                System.out.println(TECHO);
                System.out.println(TECHO_BAJO);
                System.out.println(SOPORTE_TECHO);
                for (int columna = 1; columna <= 8; columna++) {
                    for (int habitacion = 1; habitacion <= 6; habitacion++) {
                        abierta = Math.random() < PROB_VENTANA_ABIERTA;
                        encendida = Math.random() < PROB_LUZ_ENCENDIDA;
                        if (!abierta) {
                            System.out.print(VENTANA_CERRADA);
                        } else if (encendida) {
                            System.out.print(LUZ_ENCENDIDA);
                        } else {
                            System.out.print(LUZ_APAGADA);
                        }

                        if (habitacion == 3) {
                            System.out.print(SEPARADOR);
                        }
                        

                    }
                    System.out.println();
                }
            }
        }
        System.out.println(BASE);
        System.out.println(CALLE);
    }

}
