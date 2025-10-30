class EdificioEnLaSemana {
    public static void main(String[] args) {
        final int DIAS_EN_SEMANA = 7;
        final int HORAS_EN_DIA = 24;
        final double PROBABILIDAD_ABIERTA = 0.70;
        final double PROBABILIDAD_LUZ_ENCENDIDA = 0.60;
        final int PLANTAS_HABITACIONES = 7;
        final int HABITACIONES_POR_PLANTA = 6;
        final String LUZ_APAGADA = ":[º]:";
        final String LUZ_ENCENDIDA = ":[*]:";
        final String PERSIANA_CERRADA = ":[ ]:";
        final String COLUMNA_CENTRAL = "[   ]";
        boolean estaAbierta = false;
        boolean luzEstaEncendida = false;
        int numeroDia;
        int numeroHora;
        for(int i = 1; i < DIAS_EN_SEMANA*HORAS_EN_DIA; i++) {
            System.out.println(" ______________//^\\\\_____________");
            System.out.println("/   |   |   | |[###]| |   |   |   \\");
            System.out.println("===================================");
            for(int planta = PLANTAS_HABITACIONES; planta>= 1; planta-- ){
                for(int habitacion = 1; habitacion <= HABITACIONES_POR_PLANTA; habitacion++) {
                    estaAbierta = Math.random() < PROBABILIDAD_ABIERTA;
                    luzEstaEncendida = Math.random() < PROBABILIDAD_LUZ_ENCENDIDA;
                    if(!estaAbierta) {
                        System.out.print(PERSIANA_CERRADA);
                    }
                    else {
                        System.out.print(luzEstaEncendida ? LUZ_ENCENDIDA : LUZ_APAGADA);
                    }                     
                    System.out.print(habitacion == 3 ? COLUMNA_CENTRAL: "");
                }
                System.out.print(" - Planta " + planta);
                System.out.println();
            }
            System.out.println("===================================");
            System.out.println("|               /~\\               |");
            System.out.println("   [< Agonia]   | |[Mortificacion>]");
            System.out.println("----------------| |-----------------");
            System.out.println("||     /====================\\    ||");
            System.out.println("||    /======================\\   ||");
            System.out.println("||   /========================\\  ||");

            
            numeroDia = (int) (i / HORAS_EN_DIA) + 1;
            numeroHora = (i % HORAS_EN_DIA);
            System.out.println("Dia: " + numeroDia + " hora: " + numeroHora+ ":00");
            System.out.println();
            System.out.println();
        }
    }
}
