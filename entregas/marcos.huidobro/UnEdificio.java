

class UnEdificio {

    public static void main(String[] args) {

        final String TEJADO = "               __/\\__\n" + "  |    |    |  |####|  |    |    |  \n" + "====================================";

        final String SUELO = "------------------------------------\n" + "     ==========================\n" + "   ==============================\n" + " ==================================\n";

        final String PERSIANA_ABIERTA = "[ ]";
        final String LUZ_APAGADA = "[º]";
        final String LUZ_ENCENDIDA = "[*]";
        final String ESPACIO_CENTRAL = "[    ]";

        final double PROBABILIDAD_PERSIANA_ABIERTA = 0.7;
        final double PROBABILIDAD_LUZ_ENCENDIDA = 0.6;

        final int PLANTAS = 7;
        final int HABITACIONES = 6;

        final int HORAS_POR_DIA = 24;
        final int DIAS = 7;

        for (int dia = 1; dia <= DIAS; dia++) {
            for (int hora = 0; hora < HORAS_POR_DIA; hora++) {


                System.out.println(TEJADO);


                for (int numero_planta = PLANTAS; numero_planta >= 1; numero_planta--) {
                    String fila = ":";
                    int lado = HABITACIONES / 2;


                    for (int i = 0; i < lado; i++) {
                        boolean persiana_abierta = Math.random() < PROBABILIDAD_PERSIANA_ABIERTA;
                        boolean luz_encendida = Math.random() < PROBABILIDAD_LUZ_ENCENDIDA;

                        if (persiana_abierta) {
                            fila += PERSIANA_ABIERTA + ":";
                        } else {
                            fila += (luz_encendida ? LUZ_ENCENDIDA : LUZ_APAGADA) + ":";
                        }
                    }

                    fila += ESPACIO_CENTRAL + ":";


                    for (int i = 0; i < lado; i++) {
                        boolean persiana_abierta = Math.random() < PROBABILIDAD_PERSIANA_ABIERTA;
                        boolean luz_encendida = Math.random() < PROBABILIDAD_LUZ_ENCENDIDA;

                        if (persiana_abierta) {
                            fila += PERSIANA_ABIERTA;
                        } else {
                            fila += (luz_encendida ? LUZ_ENCENDIDA : LUZ_APAGADA);
                        }

                        if (i < lado - 1) fila += ":";
                    }

                    fila += " - P" + numero_planta;
                    System.out.println(fila);
                }


                System.out.println(SUELO);
                System.out.println();
                System.out.println("Día " + dia + " - " + (hora < 10 ? "0" + hora : hora) + ":00h\n");

            }
        }
    }
}

