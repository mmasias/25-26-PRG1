import java.util.Random;

public class RetoEdificioExtendido {

    public static void main(String[] args) {
        Random random = new Random();

        final int PLANTAS = 8;
        final int HABITACIONES = 6;

        int[] consumoPorDia = new int[8];

        for (int dia = 1; dia <= 7; dia++) {

            boolean llueve = random.nextDouble() < 0.3;
            boolean rayoCayo = false;
            int columnaAveriada = -1;

            boolean hayMantenimiento = random.nextDouble() < 0.05;
            int plantaMantenimiento = hayMantenimiento ? (1 + random.nextInt(7)) : -1;

            System.out.println("\n\n=====================");
            System.out.println("Día " + dia + (llueve ? "  (Lluvia)" : "  (Seco)"));
            System.out.println("=====================");

            for (int hora = 1; hora <= 24; hora++) {
                int consumoHora = 0;

                
                if (llueve && !rayoCayo && random.nextDouble() < 0.2) {
                    columnaAveriada = 1 + random.nextInt(HABITACIONES);
                    rayoCayo = true;
                }

                System.out.println("\nDía " + dia + " - " + hora + ":00h");

                
                for (int planta = PLANTAS - 1; planta >= 0; planta--) {

                    if (planta == 0) {
                        System.out.println("------------------------------------");
                        System.out.println("     ==========================");
                        System.out.println("   ==============================");
                        System.out.println(" ==================================");
                        continue;
                    }

                    System.out.print(":");

                    for (int habitacion = 1; habitacion <= HABITACIONES; habitacion++) {
                        String ventana;

                        if (planta == plantaMantenimiento) {
                            ventana = "[#]";
                        } else if (habitacion == columnaAveriada) {
                            ventana = "[X]";
                        } else {
                            boolean persianaAbierta = random.nextDouble() < 0.7;
                            boolean luzEncendida = random.nextDouble() < 0.6;

                            if (persianaAbierta) ventana = "[ ]";
                            else if (luzEncendida) {
                                ventana = "[*]";
                                consumoHora++;
                            } else ventana = "[º]";
                        }

                        System.out.print(ventana + ":");
                    }

                    System.out.println(" - P" + planta);
                }

                consumoPorDia[dia] += consumoHora;

                System.out.println("Consumo hora: " + consumoHora);

                if (rayoCayo && hora == 8) {
                    System.out.println(" Un rayo ha inutilizado la columna " + columnaAveriada);
                }
                if (hayMantenimiento && hora == 8) {
                    System.out.println(" Planta " + plantaMantenimiento + " en mantenimiento");
                }

                System.out.println("CONSUMOS: ");
                for (int d = 1; d <= dia; d++) {
                    System.out.print("D" + d + ": " + consumoPorDia[d] + " | ");
                }
                System.out.println();
            }
        }

        System.out.println("\nFin de la simulación semanal ");
    }
}

