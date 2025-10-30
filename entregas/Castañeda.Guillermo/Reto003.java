import java.util.Scanner;

class Reto003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int PLANTAS = 8;
        final int HABITACIONES = 6;
        final int HORAS_DIA = 24;
        final int DIAS_SEMANA = 7;

        final double PROB_PERSIANA_ABIERTA = 0.7;
        final double PROB_LUZ_ENCENDIDA = 0.6;
        final double PROB_RAYO = 0.2;
        final double PROB_MANTENIMIENTO = 0.05;

        String ABIERTA = "[ ]";
        String CERRADA_APAGADA = "[º]";
        String CERRADA_ENCENDIDA = "[*]";
        String AVERIA = "[X]";
        String MANTENIMIENTO = "[#]";
        String ESPACIO = ":[    ]:";

        String[][] edificio = new String[7][HABITACIONES];
        int[] consumos = new int[DIAS_SEMANA];
        int consumoDia = 0;

        System.out.println("Simulación del hotel en la esquina de Agonía con Mortificación");
        System.out.println("Ventana cerrada - Luz apagada - Luz encendida - Avería - Mantenimiento");
        System.out.println("[ ] - [º] - [*] - [X] -[#]");

        for (int dia = 1; dia <= DIAS_SEMANA; dia++) {
            consumoDia = 0;

            boolean rayoCaido = false;
            int columnaAveriada = -1;
            int plantaMantenimiento = -1;

            if (Math.random() < PROB_MANTENIMIENTO) {
                plantaMantenimiento = (int) (Math.random() * 7);
            }

            for (int hora = 1; hora <= HORAS_DIA; hora++) {

                if (!rayoCaido && Math.random() < PROB_RAYO) {
                    columnaAveriada = (int) (Math.random() * HABITACIONES);
                    rayoCaido = true;
                }

                int consumoHora = 0;

                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < HABITACIONES; j++) {
                        if (i == plantaMantenimiento) {
                            edificio[i][j] = MANTENIMIENTO;
                        } else if (j == columnaAveriada) {
                            edificio[i][j] = AVERIA;
                        } else {
                            double rPersiana = Math.random();
                            double rLuz = Math.random();

                            if (rPersiana < PROB_PERSIANA_ABIERTA) {
                                edificio[i][j] = ABIERTA;
                            } else {
                                if (rLuz < PROB_LUZ_ENCENDIDA) {
                                    edificio[i][j] = CERRADA_ENCENDIDA;
                                    consumoHora++;
                                } else {
                                    edificio[i][j] = CERRADA_APAGADA;
                                }
                            }
                        }
                    }
                }

                consumoDia += consumoHora;

                System.out.println("               __/\__");
                System.out.println("  |    |    |  |####|  |    |    |  ");
                System.out.println("====================================");
                for (int i = 6; i >= 0; i--) {
                    System.out.print(":");
                    for (int j = 0; j < HABITACIONES; j++) {
                        if (j == 3) System.out.print(ESPACIO);
                        System.out.print(edificio[i][j] + ":");
                    }
                    System.out.println(" - P" + (i + 1));
                }
                System.out.println("------------------------------------");
                System.out.println("     ==========================");
                System.out.println("   ==============================");
                System.out.println(" ==================================");
                System.out.println();

                System.out.println("Día " + dia + " - " + hora + ":00h  Consumo hora: " + consumoHora);
                if (columnaAveriada != -1 && hora == 8) {
                    System.out.println(" Un rayo ha inutilizado la columna " + (columnaAveriada + 1));
                }
                if (plantaMantenimiento != -1 && hora == 8) {
                    System.out.println(" Planta " + (plantaMantenimiento + 1) + " en mantenimiento");
                }
                System.out.println();
            }

            consumos[dia - 1] = consumoDia;

            System.out.print("CONSUMOS: ");
            for (int i = 0; i < dia; i++) {
                System.out.print("D" + (i + 1) + ": " + consumos[i] + " | ");
            }
            System.out.println("\n");
        }

        int suma = 0;
        for (int i = 0; i < DIAS_SEMANA; i++) {
            suma += consumos[i];
        }
        int media = suma / DIAS_SEMANA;

        System.out.print("CONSUMOS: ");
        for (int i = 0; i < DIAS_SEMANA; i++) {
            System.out.print("D" + (i + 1) + ": " + consumos[i] + " | ");
        }
        System.out.println();
        System.out.println("Media de consumo semanal: " + media);
    }
}
