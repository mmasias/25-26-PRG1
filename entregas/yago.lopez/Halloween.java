import java.util.Random;

public class Halloween {
    public static void main(String[] args) {
        Random random = new Random();
        
        int[] nino = new int[3];
        int[] casas = new int[3];
        
        for (int piso = 1; piso <= 5; piso++) {
            for (int casa = 1; casa <= 4; casa++) {
                System.out.println("Piso " + piso + ", Casa " + casa + ":");
                
                if (random.nextDouble() > 0.7) {
                    System.out.println("  Cerrada");
                    continue;
                }
                
                if (random.nextDouble() > 0.8) {
                    System.out.println("  Abierta sin caramelos");
                    continue;
                }
                
                int caramelos = random.nextInt(3) + 1;
                System.out.println("  Da " + caramelos + " caramelos");
                
                for (int i = 0; i < 3; i++) {
                    if (nino[i] < 20) {
                        int espacio = 20 - nino[i];
                        int tomar = Math.min(caramelos, espacio);
                        nino[i] += tomar;
                        casas[i]++;
                        
                        System.out.println("    Niño " + (i + 1) + ": toma " + tomar);
                        
                        if (nino[i] == 20) {
                            System.out.println("    Niño " + (i + 1) + " llena bolsa");
                        }
                    }
                }
            }
        }
        
        System.out.println("\nResultados:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Niño " + (i + 1) + ": " + nino[i] + " caramelos, " + casas[i] + " casas");
        }
    }
}