import java.util.Random;

public class Hotel {
    public static void main(String[] args) {
        Random random = new Random();
        final String TECHO = "               __/\\__";
        final String TECHO_BAJO = "  |    |    |  |####|  |    |    |  ";
        final String ENTRETECHO = "====================================";
        final String SUELO = "------------------------------------";
        final String BASE1 = "     ==========================";
        final String BASE2 = "   ==============================";
        final String BASE3 = " ==================================";
        final String VENTANA_CERRADA = "[ ]";
        final String LUZ_APAGADA = "[º]";
        final String LUZ_ENCENDIDA = "[*]";
        final String AVERIADA = "[X]";
        final String MANTENIMIENTO = "[#]";
        final String PASILLO = "[    ]";
        final String SEPARADOR = " - ";
        int[] consumosDiarios = new int[7];
        int totalConsumoSemanal = 0;

        for (int dia = 1; dia <= 7; dia++) {
            int consumoDia = 0;
            boolean rayoDia = false;
            int columnaRayo = -1;
            boolean mantenimientoDia = random.nextDouble() < 0.05;
            int plantaMantenimiento = mantenimientoDia ? random.nextInt(7) + 1 : -1;

            for (int hora = 0; hora < 24; hora++) {
                int consumoHora = 0;
                boolean rayoHora = !rayoDia && random.nextDouble() < 0.2;
                if (rayoHora) {
                    rayoDia = true;
                    columnaRayo = random.nextInt(6) + 1;
                }

                System.out.println(TECHO);
                System.out.println(TECHO_BAJO);
                System.out.println(ENTRETECHO);

                for (int planta = 7; planta >= 1; planta--) {
                    for (int habitacion = 1; habitacion <= 7; habitacion++) {
                        if (habitacion == 4) {
                            System.out.print(PASILLO);
                            continue;
                        }
                        String estado;
                        if (mantenimientoDia && planta == plantaMantenimiento) {
                            estado = MANTENIMIENTO;
                        } else if (rayoDia && habitacion == columnaRayo) {
                            estado = AVERIADA;
                        } else {
                            boolean persianaAbierta = random.nextDouble() < 0.7;
                            boolean luzEncendida = random.nextDouble() < 0.6;
                            if (persianaAbierta) {
                                estado = luzEncendida ? LUZ_ENCENDIDA : LUZ_APAGADA;
                            } else {
                                estado = VENTANA_CERRADA;
                                if (luzEncendida) {
                                    consumoHora++;
                                }
                            }
                        }
                        System.out.print(":" + estado + ":");
                    }
                    System.out.print(SEPARADOR + "P" + planta);
                    System.out.println();
                }

                System.out.println(SUELO);
                System.out.println(BASE1);
                System.out.println(BASE2);
                System.out.println(BASE3);
                System.out.println("Dia " + dia + " - " + hora + ":00h Consumo hora: " + consumoHora);
                if (rayoDia) {
                    System.out.println("Un rayo ha inutilizado la columna " + columnaRayo);
                }
                if (mantenimientoDia) {
                    System.out.println(plantaMantenimiento + "º planta en mantenimiento");
                }
                StringBuilder consumosStr = new StringBuilder("CONSUMOS:");
                for (int d = 1; d <= dia; d++) {
                    consumosStr.append(" D").append(d).append(": ").append(consumosDiarios[d - 1]);
                    if (d < dia) {
                        consumosStr.append(" |");
                    }
                }
                System.out.println(consumosStr.toString());
                consumoDia += consumoHora;
            }
            consumosDiarios[dia - 1] = consumoDia;
            totalConsumoSemanal += consumoDia;
        }
        System.out.println("Media de consumo semanal: " + (totalConsumoSemanal / 7));
    }
}