import java.util.Random;

class SimulacionHotel {

    private static final int PLANTAS = 7;
    private static final int HABITACIONES = 6;
    private static final int DIAS = 7;
    private static final int HORAS = 24;

    private static final double PROB_PERSIANA = 0.7;
    private static final double PROB_LUZ = 0.6;
    private static final double PROB_RAYO = 0.2;
    private static final double PROB_MANTENIMIENTO = 0.05;

    private static final String SIMBOLO_VACIO = "[ ]";
    private static final String SIMBOLO_PERSIANA_LUZ = "[*]";
    private static final String SIMBOLO_PERSIANA = "[º]";
    private static final String SIMBOLO_RAYO = "[X]";
    private static final String SIMBOLO_MANTENIMIENTO = "[#]";

    public static void main(String[] args) {
        Random random = new Random();
        int consumoTotalSemana = 0;

        for (int dia = 1; dia <= DIAS; dia++) {
            boolean hayMantenimiento = false;
            int plantaMantenimiento = -1;
            int horaMantenimiento = -1;
            if (random.nextDouble() < PROB_MANTENIMIENTO) {
                hayMantenimiento = true;
                plantaMantenimiento = 1 + random.nextInt(PLANTAS);
                horaMantenimiento = random.nextInt(HORAS);
            }

            int consumoDia = 0;
            boolean hayRayo = false;
            int columnaRayo = -1;

            for (int hora = 0; hora < HORAS; hora++) {
                if (!hayRayo && random.nextDouble() < PROB_RAYO) {
                    hayRayo = true;
                    columnaRayo = 1 + random.nextInt(HABITACIONES);
                }

                System.out.println("====================================");
                int consumoHora = 0;

                for (int planta = PLANTAS; planta >= 1; planta--) {
                    System.out.print(":");
                    for (int columna = 1; columna <= HABITACIONES; columna++) {
                        String celda;
                        if (hayRayo && columna == columnaRayo) {
                            celda = SIMBOLO_RAYO;
                        } else if (hayMantenimiento && planta == plantaMantenimiento && hora >= horaMantenimiento) {
                            celda = SIMBOLO_MANTENIMIENTO;
                        } else {
                            boolean persianaAbierta = random.nextDouble() < PROB_PERSIANA;
                            boolean luzEncendida = random.nextDouble() < PROB_LUZ;
                            if (persianaAbierta && luzEncendida) {
                                celda = SIMBOLO_PERSIANA_LUZ;
                            } else if (persianaAbierta) {
                                celda = SIMBOLO_PERSIANA;
                            } else {
                                celda = SIMBOLO_VACIO;
                            }
                        }

                        if (SIMBOLO_PERSIANA_LUZ.equals(celda)) {
                            consumoHora++;
                        }
                        System.out.print(celda + ":");
                    }
                    System.out.println(" - P" + planta);
                }

                consumoDia += consumoHora;

                System.out.println("------------------------------------");
                System.out.println("Dia " + dia + " - " + hora + ":00  Consumo hora: " + consumoHora);
                if (hayRayo)
                    System.out.println("Un rayo ha inutilizado la columna " + columnaRayo);
                if (hayMantenimiento && hora == horaMantenimiento)
                    System.out.println(plantaMantenimiento + "ª planta en mantenimiento");
            }

            System.out.println("Consumo total del día " + dia + ": " + consumoDia);
            consumoTotalSemana += consumoDia;
        }

        double mediaSemanal = consumoTotalSemana / (double) DIAS;
        System.out.printf("Media semanal: %.2f%n", mediaSemanal);
    }
}