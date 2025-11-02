import java.util.Random;

public class edificio {

    public static void main(String[] args) {
        final int PLANTAS = 8;        
        final int HABITACIONES = 6;   
        final int HORAS_DIA = 24;     
        final int DIAS_SEMANA = 7;    

        int[] consumoDiario = new int[DIAS_SEMANA];
        Random rand = new Random();

        for (int dia = 1; dia <= DIAS_SEMANA; dia++) {
            
            Integer rayoColumna = null;
            Integer plantaMantenimiento = null;

            
            if (Math.random() < 0.2) {
                rayoColumna = rand.nextInt(HABITACIONES);
            }

            
            if (Math.random() < 0.05) {
                plantaMantenimiento = 1 + rand.nextInt(7); 
            }

            for (int hora = 1; hora <= HORAS_DIA; hora++) {
                int consumoHora = 0;
                String[][] edificio = new String[8][6]; 

                for (int p = 1; p <= 7; p++) {
                    for (int h = 0; h < HABITACIONES; h++) {

                        
                        if (rayoColumna != null && h == rayoColumna) {
                            edificio[p][h] = "[X]";
                            continue;
                        }

                        
                        if (plantaMantenimiento != null && p == plantaMantenimiento) {
                            edificio[p][h] = "[#]";
                            continue;
                        }

                        
                        boolean persianaAbierta = Math.random() < 0.7;
                        boolean luzEncendida = Math.random() < 0.6;

                        if (luzEncendida) consumoHora++;

                        if (persianaAbierta) edificio[p][h] = "[ ]";
                        else edificio[p][h] = luzEncendida ? "[º]" : "[*]";
                    }
                }

                consumoDiario[dia - 1] += consumoHora;

                System.out.println("              __/\\__");
                System.out.println("  |    |    |  |####|  |    |    |  ");
                System.out.println("====================================");

                for (int p = 7; p >= 1; p--) {
                    System.out.print(":");
                    for (int h = 0; h < HABITACIONES; h++) {
                        System.out.print(edificio[p][h]);
                        if (h < HABITACIONES - 1) System.out.print("::");
                    }
                    System.out.println(": - P" + p);
                }

                System.out.println("------------------------------------");
                System.out.println("     ==========================");
                System.out.println("   ==============================");
                System.out.println(" ==================================");

                System.out.print("\nDía " + dia + " - " + hora + ":00h  ");
                System.out.println("Consumo hora: " + consumoHora);

                if (rayoColumna != null && hora == 1)
                    System.out.println("⚡ Un rayo ha inutilizado la columna " + (rayoColumna + 1));
                if (plantaMantenimiento != null && hora == 1)
                    System.out.println("🔧 Planta " + plantaMantenimiento + " en mantenimiento");

                System.out.println();
            }

            System.out.println("CONSUMO Día " + dia + ": " + consumoDiario[dia - 1]);
            System.out.println("=========================================\n");
        }

        int total = 0;
        System.out.print("CONSUMOS: ");
        for (int i = 0; i < DIAS_SEMANA; i++) {
            System.out.print("D" + (i + 1) + ": " + consumoDiario[i] + " | ");
            total += consumoDiario[i];
        }
        System.out.println();
        System.out.println("Media de consumo semanal: " + (total / DIAS_SEMANA));
    }
}
