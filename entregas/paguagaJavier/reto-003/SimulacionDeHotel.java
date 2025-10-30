class SimulacionDeHotel {
    public static void main(String[] args) {

    final String TECHO_3 = ("              _|===|_              ");
    final String TECHO_2 = ("  |    |    | |#####| |    |    |  ");
    final String TECHO_1 = ("===================================");

    final String VENTANA_CERRADA = ":[ ]:";
    final String VENTANA_ABIERTA_LUZ_APAGADO = ":[o]:";
    final String VENTANA_ABIERTA_LUZ_ENCENDIDA = ":[*]:";
    final String SEPARADOR = "[   ]";

    final String SUELO_4 = ("-----------------------------------");
    final String SUELO_3 = ("    ===========================    ");
    final String SUELO_2 = ("  ===============================  ");
    final String SUELO_1 = ("===================================");

    final double PROBABILIDAD_VENTANA_ABIERTA = 0.7;
    final double PROBABILIDAD_LUZ_Encendido = 0.6;

    boolean abierto, encendida;

    for(int dia=1;dia<=7;dia++) {
        for(int hora=0;hora<=24;hora++) {
            System.out.println (TECHO_3);
            System.out.println (TECHO_2);
            System.out.println (TECHO_1);
            for(int planta=1;planta<=7;planta++){
                for(int columna=1;columna<=6;columna++) {
                abierto = Math.random() < PROBABILIDAD_VENTANA_ABIERTA;
                encendida = Math.random() < PROBABILIDAD_LUZ_Encendido;
                System.out.print (!abierto ? VENTANA_CERRADA : encendida ? VENTANA_ABIERTA_LUZ_ENCENDIDA : VENTANA_ABIERTA_LUZ_APAGADO);
                    if (columna == 3) {
                        System.out.print(SEPARADOR);
                        }
                    }
                    System.out.println ();
                }
            System.out.println (SUELO_4);
            System.out.println (SUELO_3);
            System.out.println (SUELO_2);
            System.out.println (SUELO_1);
            System.out.println();
            System.out.println("Día " + dia + ", Hora " + hora + ":00h");
            System.out.println();
        }
    }

    }
    }