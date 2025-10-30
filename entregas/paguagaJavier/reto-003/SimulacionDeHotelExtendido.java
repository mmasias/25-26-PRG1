class SimulacionDeHotelExtendido {
    public static void main(String[] args) {

    final String TECHO_3 = ("              _|===|_              ");
    final String TECHO_2 = ("  |    |    | |#####| |    |    |  ");
    final String TECHO_1 = ("===================================");

    final String VENTANA_CERRADA = ":[ ]:";
    final String VENTANA_ABIERTA_LUZ_APAGADO = ":[o]:";
    final String VENTANA_ABIERTA_LUZ_ENCENDIDA = ":[*]:";
    final String SEPARADOR = "[   ]";
    final String VENTANA_MANTENIMIENTO = ":[#]:";

    final String SUELO_4 = ("-----------------------------------");
    final String SUELO_3 = ("    ===========================    ");
    final String SUELO_2 = ("  ===============================  ");
    final String SUELO_1 = ("===================================");

    final double PROBABILIDAD_VENTANA_ABIERTA = 0.7;
    final double PROBABILIDAD_LUZ_ENCENDIDA = 0.6;
    final double PROBABILIDAD_MANTENIMIENTO = 0.05;
    int D1 = 0, D2 = 0, D3 = 0, D4 = 0, D5 = 0, D6 = 0, D7 = 0;
    int Comsumo = 0;

    boolean yaPasoMantenimiento = false;
    boolean enMantenimiento;
    boolean abierto, encendida;

    for(int dia=1;dia<=7;dia++) {
        for(int hora=1;hora<=24;hora++) {
            enMantenimiento = false;
            if (!yaPasoMantenimiento) {enMantenimiento = Math.random() < PROBABILIDAD_MANTENIMIENTO;}
            System.out.println (TECHO_3);
            System.out.println (TECHO_2);
            System.out.println (TECHO_1);
            for(int planta=1;planta<=7;planta++){
                for(int columna=1;columna<=6;columna++) {
                abierto = Math.random() < PROBABILIDAD_VENTANA_ABIERTA;
                encendida = Math.random() < PROBABILIDAD_LUZ_ENCENDIDA;
                if (!enMantenimiento) {
                    System.out.print (!abierto ? VENTANA_CERRADA : encendida ? VENTANA_ABIERTA_LUZ_ENCENDIDA : VENTANA_ABIERTA_LUZ_APAGADO);
                    Comsumo = Comsumo + (encendida ? 1 : 0);
                } else {
                        System.out.print (VENTANA_MANTENIMIENTO);
                    }
                    if (columna == 3) {
                        System.out.print(SEPARADOR);
                            }
                        }
                        System.out.println ();
                    if (enMantenimiento){
                        yaPasoMantenimiento = true;
                        enMantenimiento = false;
                    }
                }
            
            System.out.println (SUELO_4);
            System.out.println (SUELO_3);
            System.out.println (SUELO_2);
            System.out.println (SUELO_1);
            System.out.println();
            System.out.println("Dia " + dia + ", Hora " + hora + ":00h");
            System.out.println("D" + dia + ": " + Comsumo);
            System.out.println();
        }
        yaPasoMantenimiento = false;
        switch (dia) {
            case 1 -> D1 = Comsumo;
            case 2 -> D2 = Comsumo;
            case 3 -> D3 = Comsumo;
            case 4 -> D4 = Comsumo;
            case 5 -> D5 = Comsumo;
            case 6 -> D6 = Comsumo;
            case 7 -> D7 = Comsumo;
        }
        Comsumo = 0;
    }
    
    System.out.println("Consumo total de la semana:");
    System.out.print("D1: " + D1 + "| ");
    System.out.print("D2: " + D2 + "| ");
    System.out.print("D3: " + D3 + "| ");
    System.out.print("D4: " + D4 + "| ");
    System.out.print("D5: " + D5 + "| ");
    System.out.print("D6: " + D6 + "| ");
    System.out.println("D7: " + D7);
    int comsumaSemanal = (D1 + D2 + D3 + D4 + D5 + D6 + D7);
    System.out.println("Media de consumo semanal: " + (comsumaSemanal /7));

    }
    }