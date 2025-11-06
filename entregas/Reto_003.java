
public class Reto_003 {
    public static void main(String[] args) {

        final double PERSIANA_ABIERTA = 0.7;
        final double LUZ_ENCENDIDA = 0.6;

        boolean abierta, encendida;

        final String TEJADO_UNO = "               __/\\__";
        final String TEJADO_DOS = "  |    |    |  |####|  |    |    |  ";
        final String TEJADO_TRES = "====================================";
        final String SUELO = "------------------------------------";
        final String SEPARADOR = ":[    ]:";
        final String VENTANA_CERRADA = ":[ ]:";
        final String VENTANA_ABIERTA_SIN_LUZ = ":[º]:";
        final String VENTANA_ABIERTA_CON_LUZ = ":   [*]:";

        for (int dia = 1; dia < 7; dia++) {
            for (int hora = 0; hora < 24; hora++) {
                System.out.println("Son las " + hora + " del día " + dia);  
                System.out.println(TEJADO_UNO);
                System.out.println(TEJADO_DOS);
                System.out.println(TEJADO_TRES);                      
                for (int planta = 1; planta <= 7; planta++) {
                    for (int columna = 1; columna <= 6; columna++) {
                        abierta = Math.random() < PERSIANA_ABIERTA;
                        encendida = Math.random() < LUZ_ENCENDIDA; 
                              
                        System.out.print(!abierta ? VENTANA_CERRADA : encendida ? VENTANA_ABIERTA_CON_LUZ : VENTANA_ABIERTA_SIN_LUZ);
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
