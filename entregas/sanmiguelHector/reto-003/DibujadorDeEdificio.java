public class DibujadorDeEdificio {
    public static void main(String[] args) {
        final String TECHO_EDIFICIO_ARRIBA= "               __/\\__";
        final String TECHO_EDIFICIO_MEDIO = "  |    |    |  |####|  |    |    |  ";
        final String TECHO_EDIFICIO_ABAJO = "====================================";
        final String BASE = "-----------------------";


        final double PERSIANA_ABIERTA = 0.7;
        final double LUZ_ENCENDIDA = 0.6;

        final String VENTANA_CERRADA = ":[ ]:";
        final String VENTANA_ABIERTA_LUZ_APAGADA = ":[º]:";
        final String VENTANA_ABIERTA_LUZ_ENCENDIDA = ":[*]:";
        final String SEPARADOR = ":[   ]:";
        final int NUMERO_DE_PLANTAS = 7;
        final int NUMERO_DE_VENTANAS = 6;

        

        boolean abierta, encendida;

        for (int dia = 1; dia <= 7; dia++) {
            for (int hora = 0; hora < 24; hora++) {
                System.out.println(TECHO_EDIFICIO_ARRIBA);
                System.out.println(TECHO_EDIFICIO_MEDIO);
                System.out.println(TECHO_EDIFICIO_ABAJO);
                for (int planta = 1; planta <= NUMERO_DE_PLANTAS; planta++) {
                    for (int ventana = 1; ventana <= NUMERO_DE_VENTANAS; ventana++) {

                        abierta = Math.random() < PERSIANA_ABIERTA;
                        encendida = Math.random() < LUZ_ENCENDIDA;
                        System.out.print(!abierta ? VENTANA_CERRADA
                                : encendida ? VENTANA_ABIERTA_LUZ_ENCENDIDA : VENTANA_ABIERTA_LUZ_APAGADA);
                        if (ventana == 3) {
                            System.out.print(SEPARADOR);
                        }
                    }

                    System.out.print("---P" + (NUMERO_DE_PLANTAS + 1 - planta));
                    System.out.println();
                    
                }
                System.out.println(BASE);
            }
        }

        
    }
}
