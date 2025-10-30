public class HotelLuces {
    public static void main(String[] args) {
        final String TECHO = "               __/\\__";
        final String TECHO_BAJO = "  |    |    |  |####|  |    |    |  ";
        final String ENTRETECHO = "====================================";
        final String VENTANA_CERRADA = ":[ ]:";
        final String LUZ_APAGADA = ":[º]:";
        final String LUZ_ENCENDIDA = ":[*]:";
        final String SUELO = "------------------------------------";
        final String PASILLO = "[    ]";
        final String SEPARADOR = " - ";
        int plantas = 7;
        int PLANTA_BAJA = 1;
        int dia = 0;
        int horas = 0;
        int numeroHabitaciones;

        int horasLuzEncendida = 0;

        for (dia = 1; dia <= 6; dia++) {
            int consumoPorDía = 0;
            for (horas = 0; horas < 24; horas++) {

                System.out.println(TECHO);
                System.out.println(TECHO_BAJO);
                System.out.println(ENTRETECHO);
                for (plantas = 7; plantas >= PLANTA_BAJA; plantas--) {

                    for (numeroHabitaciones = 1; numeroHabitaciones <= 7; numeroHabitaciones++) {
                        double probVentanaAbierta = Math.random();
                        double probLuzEncendida = Math.random();

                        if (numeroHabitaciones == 4) {
                            System.out.print(PASILLO);
                        }

                        if (probVentanaAbierta >= 0.7) {
                            if (numeroHabitaciones != 4) {
                                System.out.print(VENTANA_CERRADA);
                            }
                        } else if (probVentanaAbierta < 0.7 && probLuzEncendida >= 0.6) {
                            if (numeroHabitaciones != 4) {
                                System.out.print(LUZ_APAGADA);
                            }
                        } else if (probVentanaAbierta < 0.7 && probLuzEncendida < 0.6) {
                            if (numeroHabitaciones != 4) {
                                System.out.print(LUZ_ENCENDIDA);
                            }

                        }

                    }
                    System.out.print(SEPARADOR + "P" + plantas);
                    System.out.println();

                }
                System.out.println(SUELO);
                System.out.println("Día: " + dia + ". Hora: " + horas);
            }

        }
    }

}
