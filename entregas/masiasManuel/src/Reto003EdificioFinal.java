import java.util.Random;

public class Reto003EdificioFinal {
    static final int PLANTAS = 7;
    static final int DIAS = 7;
    static final int HORAS = 24;

    static final double PROB_LUZ_ENCENDIDA = 0.6;

    static Random rand = new Random();

    public static void main(String[] args) {
        int[] consumoDiario = new int[DIAS];

        for (int dia = 0; dia < DIAS; dia++) {
            for (int hora = 0; hora < HORAS; hora++) {
                int consumoHora = 0;

                System.out.println("               __/\\__");
                System.out.println("  |    |    |  |####|  |    |    |  ");
                System.out.println("====================================");

                for (int p = PLANTAS - 1; p >= 0; p--) {
                    StringBuilder fila = new StringBuilder(":");
                    for (int d = 0; d < 3; d++) {
                        for (int i = 0; i < 2; i++) {
                            boolean encendida = rand.nextDouble() < PROB_LUZ_ENCENDIDA;
                            fila.append(encendida ? "[*]:" : "[ ]:");
                            if (encendida) consumoHora++;
                        }
                        if (d == 1) fila.append("[9]:"); // Ascensor central
                    }
                    fila.append(" - P").append(p + 1);
                    System.out.println(fila);
                }

              
                System.out.println("------------------------------------");
                System.out.println("     ==========================");
                System.out.println("   ==============================");
                System.out.println(" ==================================\n");

                
                System.out.printf("Dia %d - %02d:00h Consumo hora: %d\n\n", dia + 1, hora, consumoHora);
                consumoDiario[dia] += consumoHora;
            }

      
            System.out.printf("CONSUMO D%d: %d\n\n", dia + 1, consumoDiario[dia]);
        }

    
        int total = 0;
        System.out.print("CONSUMOS: ");
        for (int d = 0; d < DIAS; d++) {
            System.out.printf("D%d: %d | ", d + 1, consumoDiario[d]);
            total += consumoDiario[d];
        }
        System.out.printf("\nMedia de consumo semanal: %d\n", total / DIAS);
    }
}
