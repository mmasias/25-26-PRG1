import java.util.Random;

class SimulacionHotel {
    public static void main(String[] args) {
        Random random = new Random();

        final int PLANTAS = 7;
        final int HABITACIONES = 6;
        final int DIAS = 7;
        final int HORAS = 24;

        final double PROB_PERSIANA = 0.7;
        final double PROB_LUZ = 0.6;
        final double PROB_RAYO = 0.2;
        final double PROB_MANTENIMIENTO = 0.05;

        int dia = 1;
        int consumoTotalSemana = 0;

        while (dia <= DIAS) {
            int consumoDia = 0;
            boolean hayRayo = false;
            int columnaRayo = 0;
            boolean hayMantenimiento = false;
            int plantaMantenimiento = 0;
            int horaMantenimiento = 0;

            if (random.nextDouble() < PROB_MANTENIMIENTO) {
                hayMantenimiento = true;
                plantaMantenimiento = 1 + random.nextInt(PLANTAS);
                horaMantenimiento = random.nextInt(HORAS);
            }

            int hora = 0;
            while (hora < HORAS) {
                if (!hayRayo && random.nextDouble() < PROB_RAYO) {
                    hayRayo = true;
                    columnaRayo = 1 + random.nextInt(HABITACIONES);
                }

                System.out.println("====================================");
                int p = PLANTAS;
                while (p >= 1) {
                    System.out.print(":");
                    int c = 1;
                    while (c <= HABITACIONES) {
                        String celda = "[ ]";
                        boolean persianaAbierta = random.nextDouble() < PROB_PERSIANA;
                        boolean luzEncendida = random.nextDouble() < PROB_LUZ;

                        if (hayRayo && c == columnaRayo) {
                            celda = "[X]";
                        } else if (hayMantenimiento && p == plantaMantenimiento && hora >= horaMantenimiento) {
                            celda = "[#]";
                        } else if (persianaAbierta && luzEncendida) {
                            celda = "[*]";
                            consumoDia++;
                        } else if (persianaAbierta && !luzEncendida) {
                            celda = "[º]";
                        } else {
                            celda = "[ ]";
                        }
                        System.out.print(celda + ":");
                        c++;
                    }
                    System.out.println(" - P" + p);
                    p--;
                }
                System.out.println("------------------------------------");
                System.out.println("Dia " + dia + " - " + hora + ":00  Consumo hora: " + consumoDia);
                if (hayRayo)
                    System.out.println("Un rayo ha inutilizado la columna " + columnaRayo);
                if (hayMantenimiento && hora == horaMantenimiento)
                    System.out.println(plantaMantenimiento + "ª planta en mantenimiento");

                hora++;
            }
            System.out.println("Consumo total del día " + dia + ": " + consumoDia);
            consumoTotalSemana += consumoDia;
            dia++;
        }
        System.out.println("Media semanal: " + (consumoTotalSemana / 7));
    }
}