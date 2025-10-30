package entregas.bolivarMarcos;

public class UnEdificio {

    public static void main(String[] args) {

        final double PROBABILIDAD_PERSIANA_ABIERTA = 0.7;
        final double PROBABILIDAD_LUZ_ENCENDIDA = 0.5;
        boolean abierta, encendida;

        final String VENTANA_CERRADA = "[ ]";
        final String LUZ_APAGADA = "[º]";
        final String LUZ_ENCENDIDA = "[*]";
        final String LADRILLOS = ":";
        final String ASCENSOR = "[   ]";
        int numeroEncendidas=0;
        int totalGastodia=0;

        for (int dia = 1; dia <= 7; dia++) {
            totalGastodia=0;
            for (int hora = 0; hora <= 24; hora++) {
                numeroEncendidas=0;
                System.out.println("               __/\\__\r\n" + //
                        "  |    |    |  |####|  |    |    |  \r\n" + //
                        "====================================");

                for (int columna = 1; columna <= 7; columna++) {
                    for (int fila = 1; fila <= 7; fila++) {

                        abierta = Math.random() < PROBABILIDAD_PERSIANA_ABIERTA;
                        encendida = Math.random() < PROBABILIDAD_LUZ_ENCENDIDA;
                        if (fila == 4) {
                            System.out.print(ASCENSOR);
                        } else {
                            System.out.print(
                                    LADRILLOS + (!abierta ? VENTANA_CERRADA : encendida ? LUZ_ENCENDIDA : LUZ_APAGADA)
                                            + LADRILLOS);
                            if(abierta && encendida){
                                numeroEncendidas++;
                                totalGastodia++;
                            }
                        }
                    }
                    System.out.println();


                }
                System.out.println("------------------------------------\r\n" + //
                        "     ==========================\r\n" + //
                        "   ==============================\r\n" + //
                        " ==================================\r\n" + //
                        "");
                System.out.println("Dia "+dia+", Hora: "+hora+":00h");    
                System.out.println("Gasto de luz: "+numeroEncendidas);
 

            }
            System.out.println("El gasto total fue de: "+totalGastodia);
            
        }
        

    }

}
